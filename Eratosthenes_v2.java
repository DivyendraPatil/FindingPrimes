import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


class Eratosthenes_v2{
	public static void main(String[] args){
		try{
			Scanner in = new Scanner(System.in);
			System.out.print("Enter the start value: ");
			long lowerLimit = in.nextLong();
			System.out.print("Enter the end value: ");
			long upperLimit = in.nextLong();
	
			int difference = (int) (upperLimit - lowerLimit);
			int sqrtValue = (int) Math.sqrt(upperLimit);
			boolean[] sqrt_primes = new boolean[sqrtValue+1];
			//System.out.println("Square root -> "+sqrtValue);
	
			Arrays.fill(sqrt_primes,true);
	
			for(int i=2; i <= sqrtValue; i++){
				if(sqrt_primes[i])
				{
					for(int j=i*2; j <= sqrtValue; j = i+j)
						sqrt_primes[j] = false;
				}
			}
	
			ArrayList<Integer> savedPrimes = new ArrayList<>(); 
			//int count = 0;
			for(int i=0; i <= sqrtValue;i++)
				if(i >= 2)
					if(sqrt_primes[i])
						savedPrimes.add(i);
					
			//System.out.println("Number of primes in sqrt-> "+savedPrimes.size());
	
			boolean[] primes = new boolean[difference+1];   // Since difference will always be <= 10^9
			Arrays.fill(primes,true);
			long divisor = 0;
			long remainder = 0;
			long temp = 0;

			if(lowerLimit == 1) // if it starts with 1 then it should be false
				primes[0] = false;
	
			for(int i = 0; i < savedPrimes.size(); i++){
				boolean flag = false;
				divisor = lowerLimit/savedPrimes.get(i);
				remainder = lowerLimit%savedPrimes.get(i);
	
				if(remainder == 0)
					temp = lowerLimit;
				else
					temp = (divisor + 1)*savedPrimes.get(i);
	
			
				if(divisor == 0)    // If it's the same number as a prime number then skip it...
					flag = true;
	
				for(long j = temp; j <= upperLimit; j+= savedPrimes.get(i)) // set all the multiples of the current prime number to false
				{
					if(flag)
						flag = false;
					else
						primes[(int)(j - lowerLimit)] = false;
				}
			}
	
			int count = 0;
			for(int i=(int)lowerLimit; i <= upperLimit;i++){
				if(primes[i-(int)lowerLimit]){
					System.out.println(i);
					count++;
				}
			}
			System.out.println("The number of primes are: "+count);	

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

/* 
Input 1000000

Running time 690ms
*/