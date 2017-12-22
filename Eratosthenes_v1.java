import java.util.*;
import java.math.*;
class Eratosthenes_v1{
	public static void main(String[] args)
	{
		long start;
		long end;

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter start of the range : ");
		start = scan.nextLong();
		System.out.print("Enter end of the range : ");
		end = scan.nextLong();

		int range = (int)(end - start);
		int myRange = (int)Math.sqrt(end);
		//System.out.println(myRange);
		boolean[] primeArray = new boolean[myRange + 1];

		for(int i = 0; i < primeArray.length; i++)
		{
			primeArray[i] = true;
		}

		ArrayList<Integer> myPrimes = new ArrayList<Integer>();
		myPrimes = getPrimes(myRange,primeArray);

		int count = countPrimes(start,end,range,myPrimes);
		System.out.print("Prime numbers between "+start+" & "+end+" = "+count);
		
}

	//Function to store the prime numbers up to sqrt of the upper limit.
	public static ArrayList<Integer> getPrimes(int x, boolean[] arr)
	{
		for(int i=2; i <= x; i++){
			if(arr[i])
			{
				for(int j=i*2; j <= x; j = i+j) //Using Eratosthenes to elimiate the multiples of primes upto sqrt of upper limit
					arr[j] = false;
			}
		}

		ArrayList<Integer> myPrimes = new ArrayList<>(); //Storing the prime number which will in turn compute the prime numbers between the given range using Eratosthenes.
		//int count = 0;
		for(int i=0; i <= x;i++){
			if(i >= 2)
				if(arr[i])
					myPrimes.add(i);
		}
		return myPrimes;
	}

	public static int countPrimes(long low, long high, int range, ArrayList<Integer> arr)
	{
		//int count = 0;
		boolean[] primes = new boolean[range+1];   
		for(int i = 0; i < primes.length; i++)
		{
			primes[i] = true;
		}
		long divisor = 0;
		long remainder = 0;
		long temp = 0;

		if(low == 1) // if it starts with 1 then it should be false
			primes[0] = false;

		for(int i = 0; i < arr.size(); i++){
			boolean flag = false;
			divisor = low/arr.get(i);
			remainder = low%arr.get(i);

			if(remainder == 0)
				temp = low;
			else
				temp = (divisor + 1)*arr.get(i);
		
			if(divisor == 0)    // If it's the same number as a prime number then skip it...
				flag = true;

			for(long j = temp; j <= high; j+= arr.get(i)) // Eliminating multiples of current prime number.
			{
				//System.out.println(j);
				if(flag)
					flag = false;
				else
					primes[(int)(j - low)] = false;
			}
		}

		int count = 0;
		for(int i=0; i <= range;i++){
			if(primes[i]){
				count++;
			}
		}		
		return count;
	}
}

/*
// Gives only count of primes in a range:

Enter start of the range : 1
Enter end of the range : 100
Prime numbers between 1 & 100 = 25

Running time 189ms
*/