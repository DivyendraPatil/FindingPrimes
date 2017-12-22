def Sieve_Of_Eratosthenes(n):
	prime_list = set()
	primes=0
	for i in range(2, n+1):
		if i not in prime_list:
			print (i,end=', ')
			primes+=1
			for j in range(i*i, n+1, i):
				prime_list.add(j)
	print("The number of primes are ",primes)
Sieve_Of_Eratosthenes(int(input("Enter the value: "))) 
#Input 1000000, Runing Time 723ms