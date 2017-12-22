from itertools import count
 
def Sieve_Of_Sundaram(n):
	nk = (n-1)//2
	ks = list(range(nk+1))
 
	for i in count(1):
		step  = 2*i+1
		start = i*(step + 1)
		if start > nk:
			break
		ks[start::step] = (0 for _ in range(start, nk+1, step))
	return [2] + [2*k+1 for k in filter(None, ks)]
	
print(Sieve_Of_Sundaram(int(input("Enter the value: "))))

#Input: 1000000, Running Time: 263ms