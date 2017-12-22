import java.util.*;
import java.io.*;
public class Eratosthenes_v3{	
	 public static void countPrimes(int n){
	     int count=0;
	     boolean[] isnotPrime = new boolean[n];
	     
	     if(n < 3)
	       System.out.print(0);
	      
	      for(int i = 2;i*i<n;i++){ 
	        for(int j = 2;i*j<n;j++){
	               isnotPrime[i*j] = true; 
	        }
	    }

	    for(int i = 2;i<n;i++){
	          if(isnotPrime[i] == false){
	              System.out.println(i + " " ); 
					count++;
			}
	    }
	    System.out.println("The number of primes are: "+count);
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the final value: ");
		int number = in.nextInt();
		countPrimes(number); 
	}
}

// Input:1000000, Running Time: 725ms