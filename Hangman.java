import java.io.File; // Imports file-reading class
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Hangman{
	
	public String[] displayed_word;
	char[] riddle_word;
	boolean game_won = false; // Bool to check at the end whether the player has won or not!
	int how_long_is_word;
	boolean help_wanted = false; // Bool to display searched word, if player wants it!
	
	
	static int query_length(){ // Recursive error-catching-function, to ask for length of word!
		try {
			Scanner mainScan = new Scanner(System.in);
			int länge = mainScan.nextInt();  // length of word (German Länge = length)
			while (länge > 10){
				System.out.println("How many letter shall the word have? Enter a number (must not be longer than 10).");
				länge = mainScan.nextInt();
				}
			return länge;
		}
		catch (Exception e){
			System.out.println("How many letter shall the word have? Enter a number (must not be longer than 10).");
			int länge = query_length(); // Function calls itself till proper input!
			return länge;
		}
	}
	
		static String[] make_dictionary(int length_word){  // Reads an input-file and makes a dictionary
		try {
			File words = new File("words.txt");
			Scanner myReader = new Scanner(words); // Uses the scanner object to read input from file!
			ArrayList<String> dictionary = new ArrayList<String>(); // ArrayList which saves proper words, as it needs to grow dynamically, thus no array!
			
			while (myReader.hasNextLine()){ // Has a boolean value!
			
				String read_string = myReader.nextLine(); // Gives the next word of book as input!
				char[] charlist = read_string.toCharArray(); // converts string to array of chars!
				
				boolean no_char;
				if (charlist.length != length_word){
					
					continue; // If word does not have proper length, go immediately to next iteration of while-loop!
					
				}
				int non_char_counter = 0; // Counter which tells me the number of non-char elements! Only if it stays 0 the word will be added to dictionary!
				for (int i = 0; i < charlist.length; i++){
					no_char = (charlist[i] < 65 || (charlist[i] > 90 && charlist[i] < 97 ) || charlist[i] > 122); // Gives me a boolean which says if a value is a char by comparing ASCII
	
					if (no_char){
						non_char_counter++;
						 // If a non-char is in word, I break the loop!
						break;
						}
		
					if (non_char_counter == 0){ // only if no non-char character is in the word, I load it into the dictionary!
						dictionary.add(read_string);
						}
		
					}
			
				}
				
				int size_of_dict = dictionary.size(); // Gives me the size of dictionary!
			
				String[] dict_array = new String[size_of_dict];
				for (int i = 0; i < size_of_dict; i++){
					dict_array[i] = dictionary.get(i);
				}
				myReader.close();
				return dict_array;
				
				
			}
			catch (FileNotFoundException e){
				System.out.println("Error occurred!");
				e.printStackTrace();
			}
			
		String[] emptyString = {"nothing"};
		return emptyString;
	}
	
	
	static boolean do_you_want_help(){ // A function which asks whether the user wants to cheat!
		System.out.println("Do you want to cheat and see the word ;)? yes/no ");

		try {
			Scanner mainScan = new Scanner(System.in);
			String yes_or_no = mainScan.nextLine(); 
			boolean cheat_decision;
			while (yes_or_no.equals("yes") != true && yes_or_no.equals("no") != true){
				System.out.println("Enter yes/no, must be precisely one of those!");
				cheat_decision = do_you_want_help(); // Recursive part!
				}
			if (yes_or_no.equals("yes")){
				return cheat_decision = true;
			} else {
				return cheat_decision = false;
			}
		}
			catch (Exception e){
				System.out.println("You have to enter either yes or no!");
				boolean cheat_decision = do_you_want_help(); // Recursive part
				return cheat_decision;
			}
	
	}
		
	
	static char[] convert_to_lower_case(char[] word_to_change){ //if I have an array with an uppercase letter - change it!
		
		boolean capital_letter = (word_to_change[0] >= 65 && word_to_change[0] <= 90);
			
			if (capital_letter){
				word_to_change[0] = (char) ((int) word_to_change[0] + 32); // Converts lower-case to uppercase letter!
			}
		
		return word_to_change; // if I have an array with an uppercase letter - return it!
	}
	
	static char query_letter(){ // Recursive error-catching-function!	
	System.out.println("Give a letter.");
		try {
			Scanner mainScan = new Scanner(System.in);
			String letter = mainScan.nextLine();
			char[] letter_array = letter.toCharArray(); // Conversion to char_array to check for proper first letter!
			boolean no_char = (letter_array[0] < 65 || (letter_array[0] > 90 && letter_array[0] < 97 ) || letter_array[0] > 122);
			
			while (letter.length() > 1 || no_char ){
				System.out.println("Please give a letter. It does not matter whether upper- or lower-case.");
				letter = mainScan.nextLine();
				letter_array = letter.toCharArray();
				no_char = (letter_array[0] < 65 || (letter_array[0] > 90 && letter_array[0] < 97 ) || letter_array[0] > 122);
				}
			letter_array = letter.toCharArray();
				
			letter_array = convert_to_lower_case(letter_array); 
			
			return letter_array[0];
		}
		catch (Exception e){
			System.out.println("How many letter shall the word have? Enter a number (must not be longer than 10).");
			char letter_only_first_char = query_letter(); // Function calls itself till proper input!
			return letter_only_first_char;
		}
	}
	
	public String[] show_riddle(char[] riddle, String[] display, int which_turn, int length_of_word, boolean help_wanted){
		
		if (this.help_wanted == true){  // Shows riddle word if player needs help!
			System.out.println(riddle);
		}
		
		if (which_turn == 0){  // First iteration - fill up display array!
			for (int i = 0; i < riddle.length; i++){
				display[i] = " _ ";
				System.out.print(display[i]);
				}
				System.out.println();
			}
			
		else if (which_turn < 0){  // Dummy condition, so that game does not run on first call before loop!
			for (int i = 0; i < riddle.length; i++){
				display[i] = " _ ";
				
				}
				System.out.println();
				return display;
				
		}
		else {
			for (int i = 0; i < riddle.length; i++){
			System.out.print(display[i]);
			}
			System.out.println();
			
			}
			char ch = query_letter();
			
			for (int j = 0; j < length_of_word; j++){ // checks now each letter in my word, by looping through the char-array 'riddle_word'.
				if (ch == riddle[j]){ // if the guess char 'ch' is in the word, I replace the " _ " in the 'display_word' with it!
				display[j] = " " + ch + " "; 
				}
			}
		return display;  // Gives back display word	
		}
	
	public boolean unsolved_count(String[] check_list){  // Function which takes displayed word as input, and checks if some letters are still 'undiscovered'
		int unsolved_counter = 0;
		
		for (int i = 0; i < check_list.length; i++){ 
			if (check_list[i] == " _ "){  
				unsolved_counter++;
			}
		}
		if (unsolved_counter != 0){
			return false;
		}
		else {
			return true;
		}
		
	}
		

	public static void main(String[] args){
		
		Hangman newgame = new Hangman(); // Creates new hangman object!
		
		System.out.println("How many letter shall the word have? Enter a number (must not be longer than 10).");
		newgame.how_long_is_word = query_length();
		
		String[] mydict = make_dictionary(newgame.how_long_is_word);
		
		
		Random rand = new Random();
		int random_int = rand.nextInt(mydict.length); // Gets the position of the random word!
		
		String random_word = mydict[random_int];		
		
		newgame.riddle_word = random_word.toCharArray(); // Initializes instance-variable!
		
		newgame.riddle_word = convert_to_lower_case(newgame.riddle_word); // Makes sure word is lowercase!
				
		
		newgame.displayed_word = new String[newgame.how_long_is_word];
		// As a spaces surround the underscores, it is a string!
		
		newgame.displayed_word  = newgame.show_riddle(newgame.riddle_word, newgame.displayed_word, -1, newgame.how_long_is_word, newgame.help_wanted);
		
		newgame.help_wanted = do_you_want_help(); 
		
		System.out.println("Still " + (10) + " tries left!");
		for (int i = 0; i < 10; i++){ // This loop iterates ten times, as I got 10 tries!
						
			newgame.displayed_word = newgame.show_riddle(newgame.riddle_word, newgame.displayed_word, i, newgame.how_long_is_word, newgame.help_wanted);
			
			newgame.game_won = newgame.unsolved_count(newgame.displayed_word); // Checks if no undiscovered letters exist!  

			
			if (newgame.game_won == true){ // If no undiscovered letters, you won ! 
				System.out.println("You won! You rule :) ");
				break;  // Ends game after, well, you won :)
			}
			
			System.out.println("Still " + (9 - i) + " tries left!");
		}
		
		if (newgame.game_won == false){
				System.out.println("Pity! The word was " + new String(newgame.riddle_word) + ".");
				System.out.println("You lost! You don't rule :( ");
		}
			
		
	}
}
