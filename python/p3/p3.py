#!/usr/bin/python
n=600851475143
d=2
highest=0
while n > 1:
    while n % d == 0:
        n=n/d
        highest=n
    d=d+1
    if d*d > n:
        break

print "Highest is " + str(highest)
