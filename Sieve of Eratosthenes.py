def prime_eratosthenes(n):
	prime_list = set()
	#primes=0
	for i in range(2, n+1):
		if i not in prime_list:
			print (i,end=', ')
			#primes+=1
			for j in range(i*i, n+1, i):
				prime_list.add(j)
	#print("The number of primes are ",primes)
prime_eratosthenes(int(input("Enter the value: "))) #The number of primes till 10000000 are 664579 in 6490ms