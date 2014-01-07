#!/usr/bin/python

mysum = 1

for i in range(1,100) :
    mysum = mysum * i



strsum= str(mysum)

print "Factorial is " + strsum

res =   sum(map(int, strsum))

print "Sum of digitsis " + str(res)
