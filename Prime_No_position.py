from itertools import accumulate
from math import log
#To find the prime number on that position
n = int(input("Enter the value: "))
maximum = n * (log(n) + log(log(n)))
marked = [True] * int(maximum // 2)

slice_proxy = range(len(marked))
for i in range(1, len(marked)//3):
	step = 2*i + 1
	marked[i+step-1::step] = [False] * len(slice_proxy[i+step-1::step])

for i, count in enumerate(accumulate(marked), 1):
	if count+1 == n:
		print(2*i + 1)
		break