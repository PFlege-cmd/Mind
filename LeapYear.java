import java.util.Scanner;


class LeapYear{

	private int year;  // Attribute year - initialized with constructor
	
	public void LeapYear(int inputyear){ // Checks input - year, given into constructor.
		year = inputyear;
	}
	
	public void setYear(){ // If a year already exists, this helps me change it.
		Scanner myScan = new Scanner(System.in); // Helps me get input!
		int newyear = myScan.nextInt();
		this.year = newyear;
	}	
	
	static int queryYear(){ // Recursive error-catching-function!
		try {
			Scanner mainScan = new Scanner(System.in);
			int jahr = mainScan.nextInt();
			return jahr;
		}
		catch (Exception e){
			System.out.println("Give a proper integer!");
			int jahr = queryYear(); // Function calls itself till proper input!
			return jahr;
		}
	}
		

	public boolean checkYear(int inputyear){ // Checks for Leap-year. If a year is a leapyear, it returns 'true', else a 'false'!
		if (inputyear%400 != 0 && inputyear%4 != 0)
		{
		System.out.println("This is not a leapyear!");
		return false;
		}
		else if (inputyear%400 != 0 && inputyear%4 == 0)
		{
		System.out.println("This is a leapyear, but not the start of a new century!");
		return true;
		}
		else
		{
		System.out.println("This is a leapyear, and the start of a new century! Truly something special!");
		return true;
		}	
	}
	
	public int getYear(){
		return this.year;
	}
	
		
	
	
	public static void main(String[] args)
	{
		System.out.println("Enter a year!");  
		
		int asked_year = queryYear(); // Asks user for the year!
		LeapYear User_year = new LeapYear(); // Creates leap-year object!
		User_year.LeapYear(asked_year); // Intializes 'year'-entry of leap-year with year I asked for above!
		User_year.checkYear(asked_year);  // Final check if a leapyear exists!
		
	}
}
