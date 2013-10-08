#!/usr/bin/python
import math

def get_primes(n):
	a = [[i, True] for i in range(2,n+1)]
	sqrtN = int(round(math.sqrt(n)))
	for i in range(2,sqrtN+1):
            if a[i-2][1] == True:
	        b= [x*i for x in range(0,n)]
		c= [x + i**2 for x in b]
		c[:] = [x for x in c if x<=n] # Remove to large elements
		for j in c:
		    a[j-2][1] = False;
	
	b =[] #Remove the boolean
	for i in range(0,len(a)):
	    if a[i][1] == True:
	        b.append(a[i][0])
	return b

p10 = get_primes(10);
p15 = get_primes(15);
p100 = get_primes(100);
p = get_primes(2000000);
print "Primelist " + str(p10) + " sum is " + str(sum(p10))
print "Primelist " + str(p15) + " sum is " + str(sum(p15))
print "Primelist " + str(p100) + " sum is " + str(sum(p100))
print "Prime below 2000000 summarizes to " + str(sum(p))