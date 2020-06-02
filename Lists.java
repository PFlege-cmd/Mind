import java.util.Random; // Imports 'Random'-class!
import java.util.ArrayList; // My List will be an array-list!

class Lists{

	public int max_value = 100; // Maximum random number!
	public int length_value = 10; // Length of list. Fixed values, thus private!
	int maximum = 0;
	int minimum = 100;
	int second_to_lowest = 100; 
	
	public ArrayList<Integer> create_List(){
		Random rand = new Random(); // Creates an object of the 'Random'-class!
		ArrayList<Integer> myArrayList = new ArrayList<Integer>(); // New ArrayList object with wrapper class Integer!
		
		for (int i = 0; i < length_value; i++){  // Initializes the random list!
			int random_int = rand.nextInt(max_value);
			myArrayList.add(random_int);  
		}
		return(myArrayList);
	}
	
	public void get_extrema(ArrayList<Integer> array_list){
		int maximum = 0; // Every value is higher than this  - initializes the first entry in the list as the maximum by default
		int minimum = 100; // Every value is lower than this - initializes the first entry in the list as the minimum by default
		int current_entry; // Holds the current entry of the Array_List!
		for (int i = 0; i < length_value; i++){
			
			//Integer current_entry_wrapper = array_list.get(i);
			current_entry = (array_list.get(i)).intValue();
			//int temp_min = this.minimum;
			this.maximum = (current_entry > this.maximum)?current_entry:this.maximum; // If current entry is greater than maximum, set current entry to maximum, else leave it!
			//this.minimum = (current_entry < this.minimum)?current_entry:this.minimum; // If current smaller than minimum, set minimum to it.
			if (current_entry < this.minimum){
				this.second_to_lowest = this.minimum; // At the final iteration, this will keep the minimum value!
				this.minimum = current_entry;
			}
		}
	}
	
		
		
	public int get_maximum(){
		return this.maximum;
	}
	
	public int get_minimum(){
		return this.minimum;
	}
	
	public int get_second_to_lowest(){
		return this.second_to_lowest;
	}
	
	public void filter(ArrayList<Integer> array_list){ // Displays all even values!
		ArrayList<Integer> helparray = new ArrayList<Integer>();
		for (int i = 0; i < length_value; i++){
			int test_int = (array_list.get(i)).intValue(); // Gets integer from list, and converts it to primitive datatype integer!
			if (test_int%2 == 0){
				helparray.add(test_int);
			}
		}
		System.out.println("Even numbers are " + helparray);
	}
	
	public ArrayList<ArrayList<Integer>> split(ArrayList<Integer> array_list){
		ArrayList<ArrayList<Integer>> list_list = new ArrayList<ArrayList<Integer>>(); // An ArrayList which contains arraylists!
		ArrayList<Integer> two_list = new ArrayList<Integer>();
		ArrayList<Integer> three_list = new ArrayList<Integer>();
		ArrayList<Integer> five_list = new ArrayList<Integer>();
		ArrayList<Integer> other_list = new ArrayList<Integer>();
		for (int i = 0; i < length_value; i++){ // Goes through each element in list, and adds it if divisible by number!
			int test_int = (array_list.get(i)).intValue(); 
			if (test_int%2 == 0){
				two_list.add(test_int);
			}
			else if (test_int%3 == 0){
				three_list.add(test_int);
			}
			else if (test_int%5 == 0){
				five_list.add(test_int);
			}
			else {
				other_list.add(test_int);
			}
		}
		// Here ArrayLists are added to ArrayList of ArrayLists!
		list_list.add(two_list);
		list_list.add(three_list);
		list_list.add(five_list);
		list_list.add(other_list);
		
		return list_list;
	}
			

	
	public ArrayList<Integer> bubblesort(ArrayList<Integer> array_list){
		int swapcounter = -1; // Must by default be nonzero, to start while-loop!
		int max_iterations = length_value - 1; // Variable which gets reduced at every iteration!
		while (swapcounter != 0){
			swapcounter = 0; // I am in loop, so I set it to 0!
			for (int i = 0; i < max_iterations; i++){
				//Integer value_1_Integer = array_list.get(i);
				//Integer value_2_Integer = array_list.get(i + 1);
				int value_1 = (array_list.get(i)).intValue();
				int value_2 = (array_list.get(i + 1)).intValue(); 
				if (value_1 > value_2){ // If one element is out of order, ie. previous element bigger than subsequent - swap!
					array_list.set(i, value_2); 
					array_list.set(i + 1, value_1); 
					swapcounter++;
				}
			}
			max_iterations--; // Reduces the length of the for-loop, as the last elements of the list will already be sorted!
			
		}
		return array_list; // returns sorted list!
	}

	public static void main(String[] args){
		
		Lists dummy_object = new Lists(); // Creates a Lists object
		
		ArrayList<Integer> mainList = dummy_object.create_List(); // I call the function to create a list!
		
		int main_length = mainList.size(); // Gets integer with size!
		
		System.out.println("My new list is " + mainList);
		
		dummy_object.get_extrema(mainList);
		int max_of_list = dummy_object.get_maximum();
		int min_of_list = dummy_object.get_minimum();//Those two methods give the value of the extrema!
		int second_to_lowest_of_list = dummy_object.get_second_to_lowest();
		System.out.println("Maximum is " + max_of_list + ", minimum is " + min_of_list +", second to lowest is " + second_to_lowest_of_list +"!");
		System.out.println("Sum of lowest two is " + (min_of_list + second_to_lowest_of_list) + "!");
		
		dummy_object.filter(mainList); // Filters all numbers, ie shows the ones which are even!
		
		ArrayList<ArrayList<Integer>> list_of_all_lists = dummy_object.split(mainList);
		int size_of_list_of_lists = list_of_all_lists.size();
		for (int j = 0; j < size_of_list_of_lists; j++){
			switch(j){
				case 0:
				System.out.println("Two-list is " + list_of_all_lists.get(j));
				break;
				case 1:
				System.out.println("Three-list is " + list_of_all_lists.get(j));
				break;
				case 2:
				System.out.println("Five-list is " + list_of_all_lists.get(j));
				break;
				default:
				System.out.println("Other-list is " + list_of_all_lists.get(j));
			}
				
		}
		
		mainList = dummy_object.bubblesort(mainList);
		
		System.out.println("Bubble-sorted list is " + mainList);
		
		
	}
}
	
