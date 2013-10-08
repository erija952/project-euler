#!/usr/bin/python

#Find a + b + c = 1000.

for a in range(1,1000):
    for b in range(1,1000):
        for c in range(1,1000):
            if a+b+c == 1000:
                if a**2 + b**2 == c**2:
                    print "Found " + str(a) + " " + str(b) + " " + str(c) + "a*b*c=" + str(a*b*c)
