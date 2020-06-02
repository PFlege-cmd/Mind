import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;

class Quotes{
	String[][] quotes = {{"galileo", "eppur si muove"},{"archimedes", "heureka"},{"erasmus", "in regione caecorum rex est luscus"}, {"socrates", "I know nothing except the fact of my ignorance"}, {"rené descartes","cogito, ergo sum"}, {"sir isaac newton", "if I have seen further it is by standing on the shoulders of giants"}};
	
	private int current_day = estimate_day();
	private String current_thinker = quotes[current_day][0];
	private String current_thinkers_quote = quotes[current_day][1];
	private String current_month;
	private String week_day;
	private int current_day_of_month;
	private char[] modified_author = convert_to_upper_case(this.current_thinker, true); // Converting String of Thinker and Quote to char-array
	private char[] modified_quote = convert_to_upper_case(this.current_thinkers_quote, false);
	
	public int estimate_day(){
		
		Locale myPlace = new Locale("GERMANY", "GERMAN");
		LocalDate myDate = LocalDate.now();
		
		this.current_day_of_month = myDate.getDayOfMonth(); 
		
		
		Month month = myDate.getMonth();  // Enum-constant (month) from LocalDate-object;
		TextStyle myStyle = TextStyle.FULL; // Enum-constant of TextStyle enumerator.
		String month_string = month.getDisplayName(myStyle, myPlace);
		this.current_month = month_string;
		
		DayOfWeek dayofweek = myDate.getDayOfWeek(); // Makes an enumerator of type 'DayOfWeek'
		String Name_dayofweek = dayofweek.getDisplayName(myStyle, myPlace); // Gets textual representation of enumerator 
		this.week_day = Name_dayofweek;
		
		int day_of_year = myDate.getDayOfYear(); // Gets the year-day from the myDate object, which is a field of the object.
		int day_for_quote = day_of_year%6; // I have 6 quotes, so I have a modulo of 6 to get proper index!
	
		return day_for_quote;

	}
	
	static char[] convert_to_upper_case(String string_word, boolean is_author){ //if I have an array with a lower-case-letter - change it!
		
		char[] word_to_change = string_word.toCharArray(); // Converts the String

		boolean capital_letter = (word_to_change[0] >= 97 && word_to_change[0] <= 122);
			
			if (capital_letter){
				word_to_change[0] = (char) ((int) word_to_change[0] - 32); // Converts lower-case to uppercase letter!
			}
			
			if (is_author){
			
				for (int i = 1; i < word_to_change.length; i++){ // Starts at second letter of name, as first is always made uppercase
					if (word_to_change[i - 1] == 32){ // If previous char is a 'space', this means I am now at the surname! Better make this capital :)
						word_to_change[i] = (char) ((int) word_to_change[i] - 32);
					}
				}
			}
			else {
				if (word_to_change[word_to_change.length - 1] != 33){
					char[] modified_word_to_change = new char[word_to_change.length + 1]; // Creates new word-array with one additional position for '.'
					for (int j = 0; j < word_to_change.length; j++){
						modified_word_to_change[j] = word_to_change[j]; // Fills modified word to change up with all letters of previous words
						}
					modified_word_to_change[modified_word_to_change.length - 1] = (char) 46; // Type-casting, 46 is ASCII number of '.'
					word_to_change = null; // Removes un-used char-array, saves space on heap.
					return modified_word_to_change;
				}
			}
		
			return word_to_change; // if I have an array with an uppercase letter - return it!
			
	}
	
	public char[] get_thinker(){
		return modified_author; // Note to self: Upon return, no 'this.' necessary for instance variables!
	}
	
	public char[] get_thinkers_quote(){
		return modified_quote;
	}
	
	
	
	
	public void print_quote(char[] thinker, char[] quotation){ // Prints out quote by looping through modified char-arrays
		
		System.out.println("Quote for " + week_day + " the " + current_day_of_month + "th of " + current_month + ":");
		
		System.out.print("\"");
		
		for (int j = 0; j < quotation.length; j++){
		System.out.print(quotation[j]);
		}
		
		System.out.print("\" -- ");
		
		for (int i = 0; i < thinker.length; i++){
		System.out.print(thinker[i]);
		}
	
		//System.out.print(":");		
	}
}
