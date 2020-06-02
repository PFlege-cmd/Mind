import java.io.File; // Imports file-reading class
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

class DecisionTree {

	File rawdata = new File("decision-tree-data.txt");

	//long filelength = rawdata.length();

	//int integer_filelength = (int) filelength;

	private ArrayList<ArrayList<String>> Nodes = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> Edges = new ArrayList<ArrayList<String>>();
	
	private Node [] Nodes_in_tree;
	private Edge [] Edges_in_tree;
	
	
	public ArrayList<ArrayList<String>> get_Nodes(){
		
		return Nodes;
		
	}
	
	public ArrayList<ArrayList<String>> get_Edges(){
		
		return Edges;
		
	}
	
	
	public void get_tree_data_from_file(){
	//int number_of_lines = 0;
	try {
		Scanner myReader = new Scanner(rawdata); // Uses the scanner object to read input from file!
		ArrayList<String> raw_tree = new ArrayList<String>();
		
		while (myReader.hasNextLine()){ // Has a boolean value!
				int comma_counter = 0;  // Counter to decide if a line is a node or an edge! If one comma, a Node!
			
				String read_string = myReader.nextLine();
				
				for (int j = 0; j < read_string.length(); j++){
					
					if (read_string.charAt(j) == ','){
						
						comma_counter++;
						
					}
					
				}
				
				if (comma_counter == 1){ // This branch adds an Node-ArrayList to the Nodes ArrayList of ArrayLists
					
					String [] Help_Nodes = read_string.split(",",2);
					ArrayList<String> Add_Nodes = new ArrayList<String>();
					
					Add_Nodes.add(Help_Nodes[0]);
					Add_Nodes.add(Help_Nodes[1]);
					
					Nodes.add(Add_Nodes);
					
					
					
				} else { // This branch adds an Edge-ArrayList to the Edges ArrayList of ArrayLists
					
					String [] Help_Edges = read_string.split(",", 3);
					ArrayList<String> Add_Edges = new ArrayList<String>();
					
					Add_Edges.add(Help_Edges[0]);
					Add_Edges.add(Help_Edges[1]);
					Add_Edges.add(Help_Edges[2]);
					
					Edges.add(Add_Edges);
				}
				
				//System.out.println(read_string);
				//System.out.println(comma_counter);
				//number_of_lines++;
		}
	
	} catch (FileNotFoundException e){
				System.out.println("Error occurred!");
				e.printStackTrace();
		}
		

	}
	
	public void setup_tree(){
		
		int size_of_nodes = Nodes.size();
		int size_of_edges = Edges.size();
		
		Nodes_in_tree = new Node[size_of_nodes];	
		Edges_in_tree = new Edge[size_of_edges];
		
		for (int e = 0; e < size_of_edges; e++){
		
		ArrayList<String> help_to_setup_edges = Edges.get(e);
		Edges_in_tree[e] = new Edge();
		Edges_in_tree[e].set_origin(help_to_setup_edges.get(0));
		Edges_in_tree[e].set_destination(help_to_setup_edges.get(1));
		if (help_to_setup_edges.get(2).equals(" Ja")){
			
			Edges_in_tree[e].set_answer(true);
			//System.out.println("Het lukt!");
			
		} else {
			
			Edges_in_tree[e].set_answer(false);
		}
		
	}
	
	for (int n = 0; n < size_of_nodes; n++){ // Initializes the nodes!
		
		ArrayList<String> help_to_setup_nodes = Nodes.get(n);
		Nodes_in_tree[n] = new Node();
		Nodes_in_tree[n].set_name(help_to_setup_nodes.get(0));
		Nodes_in_tree[n].set_question(help_to_setup_nodes.get(1));
		Nodes_in_tree[n].set_Pointing_to_me(Edges_in_tree);
		Nodes_in_tree[n].set_Pointing_from_me(Edges_in_tree);
		System.out.println(Nodes_in_tree[n].get_neighbours());
	
		}
		
		
		
	}
	
	public Node [] get_Node_Array(){
		
		return this.Nodes_in_tree;
		
	}
	
	public Edge [] get_Edge_Array(){
		
		return this.Edges_in_tree;
		
	}
	
	public void execute(Node[] Array_of_Nodes, Edge [] Array_of_Edges){
		
		
		int size_of_Nodes = Array_of_Nodes.length;
		Node Current_Node = null;
		Edge Current_Edge = null;
		String which_way;
		
		for (int s = 0; s < size_of_Nodes; s++){ // Sets the start of the tree!
			
			if (Array_of_Nodes[s].get_Pointing_to_me() == null){
				
				Current_Node = Array_of_Nodes[s];
				System.out.println(Current_Node.get_name() + ", " + Current_Node.get_question() + " Ja of Nee (gebruik hoofdletters)?");
				
				
			}
						
			
		}
		
		
		while (Current_Node.get_Pointing_from_me_negative() != null) { // Goes until a null - away - pointing edge is found - then I am at an end!
			
			which_way = ask(Current_Node);
			
			if (which_way.equals("Ja") == true){
				
				Current_Edge = Current_Node.get_Pointing_from_me_positive();
				
				for (int n = 0; n < size_of_Nodes; n++){
					
					
					if ((Array_of_Nodes[n].get_name()).equals(Current_Edge.get_destination()) == true){
						
						Current_Node = Array_of_Nodes[n];
						//System.out.println(Current_Node.get_name());
						
						if (Current_Node.get_Pointing_from_me_negative() == null){
				
							System.out.println(Current_Node.get_name() + ", " + Current_Node.get_question());
						}
						
					}
					
				}
				
			} else {
				
				Current_Edge = Current_Node.get_Pointing_from_me_negative();
				
				for (int n = 0; n < size_of_Nodes; n++){
					
					
					if ((Array_of_Nodes[n].get_name()).equals(Current_Edge.get_destination()) == true){
						
						Current_Node = Array_of_Nodes[n];
						//System.out.println(Current_Node.get_name());
						
						if (Current_Node.get_Pointing_from_me_negative() == null){
				
							System.out.println(Current_Node.get_name() + ", " + Current_Node.get_question());
						}
						
					}
					
				}				
				
			}			
		
		} 		
		
		
	}
	
	public String ask(Node myNode){
		
		
	
		System.out.println(myNode.get_name() + ", " + myNode.get_question() + " Ja of Nee (gebruik hoofdletters)?");
		
		try {
				Scanner myQuestion = new Scanner(System.in);
				String Answer = myQuestion.nextLine();
				while ((Answer.equals("Ja") == false) && (Answer.equals("Nee") == false)){
					System.out.println("Whileloop");
					Answer = ask(myNode);
					
					}
				return Answer;
			}
			catch (Exception e){
				System.out.println("Enter 'Ja' of 'Nee'");
				String Answer = ask(myNode); // Function calls itself till proper input!
				return Answer;
		}
		
		
	}
	

}