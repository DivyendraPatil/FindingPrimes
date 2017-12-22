def Sieve_Of_Atkin_v2(limit):
	assert limit > 3
	sieve_list = [False] * (limit + 1)
	sieve_list[2:4] = (True, True)

	# Part I: preliminary work
	x = x_squared = 1
	while x_squared < limit:
		y = y_squared = 1
		while y_squared < limit:
			n = 4 * x_squared + y_squared
			if n <= limit and n % 12 in (1, 5):
				sieve_list[n] = not sieve_list[n]

			n = 3 * x_squared + y_squared
			if n <= limit and n % 12 == 7:
				sieve_list[n] = not sieve_list[n]

			if x > y:
				n = 3 * x_squared - y_squared
				if n <= limit and n % 12 == 11:
					sieve_list[n] = not sieve_list[n]
			y += 1
			y_squared = y * y
		x += 1
		x_squared = x * x

	# Part II: Remove the squares of primes (and their multiples)
	r = 5
	r_squared = r * r
	while r_squared < limit:
		if sieve_list[r]:
			for n in range(r_squared, len(sieve_list), r_squared):
				sieve_list[n] = False
		r += 1
		r_squared = r * r

	# Part III: Append everything into a list
	return [x for x, p in enumerate(sieve_list) if p]
		
plist = Sieve_Of_Atkin_v2(int(input("Enter the final value: ")))
print(len(plist))
print(plist)

#Input: 1000000, Running Time: 652 ms