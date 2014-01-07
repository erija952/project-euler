#!/usr/bin/python
f1 = 1
f2 = 1
term = 3

while 1 :
    a=f2
    f2=f1+f2
    f1=a
    length = len(str(f2))
    if length >= 1000:
        print "f2 is " + str(f2)+ " length is " + str(length) + " term nr " + str(term)
        break
    term += 1
