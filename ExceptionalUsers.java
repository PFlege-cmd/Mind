class ExceptionalUsers{

	private String User;
	private String Password;


	static String check_password(){
	
		Scanner myPassw = new Scanner(System.in);
		String check_passw = myPassw.nextLine();
		
		boolean has_number = false;
		boolean has_uppercase = false;
		boolean has_lowercase = false;
		
		int length_of_word = check_passw.length();
		for (int i = 0; i < length_of_word; i++){
			int ascii_code = check_passw.codePointAt(i);
			has_number = (ascii_code >= 48 && ascii_code <= 57)?true:has_number; 
			has_uppercase = (ascii_code >= 65 && ascii_code <= 90)?true:has_uppercase; 
			has_lowercase = (ascii_code >= 97 && ascii_code <= 122)?true:has_lowercase;			
		}
		
		
		//while ((check_passw.equals("Ja") == false) && (check_passw.equals("Nee") == false)){
		//			System.out.println("Whileloop");
		//			check_passw = check_password();
					
		//			}
		//		return Answer;
		return check_passw;
	}





}