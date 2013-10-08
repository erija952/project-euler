#!/usr/bin/python

num = 2**1000
st = str(num)
sum = 0;
for i in range(len(st)):
    sum = sum +(int)(st[i])
print "2**1000 is " + st
print "Sum is " + str(sum)
