#!/usr/bin/python
f1 = 0
f2 = 1
maxNum=4000000
sum = 0
while f2 < maxNum:
    a=f2
    f2=f1+f2
    f1=a
    if f2 % 2 == 0:
        sum= sum +f2
    
print "Sum is " + str(sum)
