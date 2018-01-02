def main():
	MAX=1000000
	nonprimes = MAX * [False]
	nonprimes[0] = nonprimes[1] = True
	
	for i in range(2, MAX ): 
		if not nonprimes[i]:
			print(i, end=", ")
			for j in range(2*i, MAX , i):
				nonprimes[j] = True
	print() 

main()

#Input 1000000, Runing Time 456ms