import java.util.ArrayList;

class PrimeNumbers{


private ArrayList<Integer> Primes = new ArrayList<Integer>();

public ArrayList<Integer> create_primenumbers(int limit){
	
	ArrayList<Integer> dummy_primes = new ArrayList<Integer>();
	int primelist_length = dummy_primes.size();
	int prime_counter = 0;
	dummy_primes.add(2);
	
	for (int i = 3; i < limit; i++){
		
		primelist_length = dummy_primes.size();
		
		for (int p = 0; p < primelist_length; p++){
			
			if (i%dummy_primes.get(p) == 0){
				
				
				break; // Modulo is 0, so the current number (i) is not a prime-number!
				
			} else if ( p == (primelist_length - 1)){
				dummy_primes.add(i); // If the number is not divisible by anything in the list -- it is a prime-number!
			}
			
			
		}
		
		



	}
	//System.out.println(dummy_primes);
	return dummy_primes;
}


}
