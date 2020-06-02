import java.util.ArrayList;


class Fraction{

	final private int numerator;
	final private int denominator;
	private PrimeNumbers PrimeNum = new PrimeNumbers();
	
	private ArrayList<Integer> PrimeList = PrimeNum.create_primenumbers(100);

	public Fraction(int num, int denom){
		numerator = num;
		denominator = denom;
	}
	
	public double toDecimalNotation(){
		
		double double_output = (double) numerator/denominator;
		return double_output;
		
	}
	
	public String toString(){
		
		String string_num = Integer.toString(numerator);
		String string_denom = Integer.toString(denominator);
		String String_output = string_num + "/" + string_denom;
		return String_output;
	}
	
	public void add_int(int number){
		
		int add_to_numerator = denominator*number; // Sets addition to numerator to proper multiplier!
		int new_numerator = numerator + add_to_numerator;
		System.out.println("New fractional number is " + new_numerator + "/" + denominator + ".");
	}
	
	public void add_fraction(int num, int denom){
		
		
		//int multiplier = denominator*denom;
		int summand_1 = numerator*denom;
		int summand_2 = num*denominator;		
		int new_denominator = denominator*denom;
		int result = summand_1 + summand_2;
				//System.out.println("Result is " + result + "/" + frac_denominator + ".");
		simplify(result, new_denominator);

		}	
	

	public void sub_int(int number){  // subtracts a whole integer from the fraction!
		
		int subtract_from_numerator = denominator*number; // Sets subtraction from numerator to proper multiplier!
		int new_numerator = numerator - subtract_from_numerator;
		System.out.println("New fractional number, after subtraction, is " + new_numerator + "/" + denominator + ".");
	}
	
	public void subtract_fraction(int frac_numerator, int frac_denominator){
		
		int make_negative_numerator = frac_numerator*(-1);
		
		this.add_fraction(make_negative_numerator, frac_denominator);
				
		}
	
	public void simplify(int frac_numerator, int frac_denominator){ // Simplifies function down to maximum!
		
			int new_frac_numerator = frac_numerator;
			int new_frac_denominator = frac_denominator;
			int size_of_primelist = PrimeList.size();
			for (int i = 0; i < size_of_primelist; i++){
				
				if ((new_frac_numerator%PrimeList.get(i) == 0) && (new_frac_denominator%PrimeList.get(i) == 0)){ // If both entries are divisible by same number:
				new_frac_numerator = new_frac_numerator/PrimeList.get(i);
				new_frac_denominator = new_frac_denominator/PrimeList.get(i);
				while ((new_frac_numerator%PrimeList.get(i) == 0) && (new_frac_denominator%PrimeList.get(i) == 0)){
					
					new_frac_numerator = new_frac_numerator/PrimeList.get(i);
					new_frac_denominator = new_frac_denominator/PrimeList.get(i);
					
				}
			}
			//System.out.println(" Simplified Output is " + frac_numerator + "/" + frac_denominator + "!!");

		
		}
		
		if (new_frac_numerator%new_frac_denominator == 0){
				
			int result_integer = new_frac_numerator/new_frac_denominator;
			
			System.out.println(" Resultant integer is " + result_integer + "!");
			
		} else {
		
		System.out.println(" Simplified Output is " + new_frac_numerator + "/" + new_frac_denominator + "!!");
		}
	}
		
	public void multiply_int(int number){
		
		int size_of_primelist = PrimeList.size();
		int new_numerator = number*numerator;
		
		// Now check if I can simplify:
		
		simplify(new_numerator, denominator);
		
		
	}
	
	public void multiply_fraction(int frac_numerator, int frac_denominator){
		
		int multiplied_numerator = frac_numerator*numerator;
		int multiplied_denominator = frac_denominator*denominator;
		
		simplify(multiplied_numerator, multiplied_denominator);
		
		
	}
	
	public void divide_int(int number){
		
		int divided_denominator = number*denominator;
		simplify(numerator, divided_denominator);
		
	}
	
	public void divide_fraction(int frac_numerator, int frac_denominator){
		
		int divided_numerator = frac_denominator*numerator;
		int divided_denominator = frac_numerator*denominator;
		
		simplify(divided_numerator, divided_denominator);
		
	}
		
	

}
