import math

def Sieve_Of_Atkin(limit):
	P = [2,3]
	sieve=[False]*(limit+1)
	sqlim = int(math.sqrt(limit))
	for x in range(1,sqlim+1):
		for y in range(1,sqlim+1):
			n = 4*x**2 + y**2
			if n<=limit and (n%12==1 or n%12==5) : sieve[n] = not sieve[n]
			n = 3*x**2+y**2
			if n<= limit and n%12==7 : sieve[n] = not sieve[n]
			n = 3*x**2 - y**2
			if x>y and n<=limit and n%12==11 : sieve[n] = not sieve[n]
	for x in range(5,sqlim):
		if sieve[x]:
			for y in range(x**2,limit+1,x**2):
				sieve[y] = False
	for p in range(5,limit):
		if sieve[p] : P.append(p)
	return P

plist = Sieve_Of_Atkin(int(input("Enter the final value: "))) 
print(plist)
print()
print("Number of primes: ",len(plist))

# Input 1000000, Running time 2163 ms