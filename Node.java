class Node{

	private String Node_name;
	private String Node_question;
	Edge Pointing_to_me;
	Edge Pointing_from_me_positive; // Edge which is the positive answer!
	Edge Pointing_from_me_negative; // Edge which is the negative answer!
	
	
	public void set_name(String Name){
		
		this.Node_name = Name;
		this.Node_name.replaceAll("\\s", "");
	}
	
	public String get_name(){
		
		return this.Node_name;
	}
	
	public void set_question(String Question){
		
		this.Node_question = Question;
		
	}
	
	public String get_question(){
		
		return this.Node_question;
	}
	
	public void set_Pointing_to_me(Edge[] Array_of_Edges){ // Gets the proper incoming edge!
	
		int size_of_array = Array_of_Edges.length;
		boolean check_incoming = false; // if this bool, after looping through the edge-array, is false, no edge points to this node!
		
		for (int e = 0; e < size_of_array; e++){
			
			String desti = Array_of_Edges[e].get_destination();
			
			if ((Array_of_Edges[e].get_destination()).equals(this.Node_name)){
				
				Pointing_to_me = Array_of_Edges[e];
				check_incoming = true;
				
			}
			
		}
		
		if (!check_incoming){ // No incoming branches! It is thus a 'beginning' node!
			Pointing_to_me = null;
		}
		
		
	}
	
	public Edge get_Pointing_to_me(){
		
		return Pointing_to_me;
		
	}
	
	public Edge get_Pointing_from_me_positive(){
		
		return Pointing_from_me_positive;
		
	}
	
	public Edge get_Pointing_from_me_negative(){
		
		return Pointing_from_me_negative;
		
	}
	
	public void set_Pointing_from_me(Edge[] Array_of_Edges){
		
		int size_of_array = Array_of_Edges.length;
		boolean check_outgoing = false; // if this bool, after looping through the edge-array, is false, no edge points away from this node!
		
		for (int e = 0; e < size_of_array; e++){
			
			
			if (((Array_of_Edges[e].get_origin()).equals(this.Node_name))&&(Array_of_Edges[e].get_answer())){ // If there is an outgoing 'Ja'-edge
				
				Pointing_from_me_positive = Array_of_Edges[e];
				check_outgoing = true;
				
			} else if (((Array_of_Edges[e].get_origin()).equals(this.Node_name))&&(!Array_of_Edges[e].get_answer())){ // If there is an outgoing 'Nee' - edge
			
				Pointing_from_me_negative = Array_of_Edges[e];
				check_outgoing = true;
			
			}
		}
		
		if (!check_outgoing){
			Pointing_from_me_positive = null; // If there is no outgoing branch, both 'outgoing' pointers will point to null! It is thus an 'end'!
			Pointing_from_me_negative = null;
		}
	}
		
	public String get_neighbours(){
		
		String neighbour_upstream;
		String neighbour_downstream_positive;
		String neighbour_downstream_negative;
		
		if (this.Pointing_to_me == null){
			neighbour_upstream = "nothing";
		} else {
			neighbour_upstream = this.Pointing_to_me.get_origin();
		}
		
		if (this.Pointing_from_me_positive == null){
			neighbour_downstream_positive = "no one";
			neighbour_downstream_negative = "no one";
		} else {
			neighbour_downstream_positive = this.Pointing_from_me_positive.get_destination();
			neighbour_downstream_negative = this.Pointing_from_me_negative.get_destination();
		}
		
		String neighbourinhos = "This is " + this.Node_name + ", Upstream lies " + neighbour_upstream + ", downstream in positive answer lies " + neighbour_downstream_positive + ", and downstream negative is " + neighbour_downstream_negative + ".";
		
		return neighbourinhos;
		
		
		
	}
	
	


	
		
}

	




