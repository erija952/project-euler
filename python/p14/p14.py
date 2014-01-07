#!/usr/bin/python

def collatz(startNum):
    seql = 1
    while startNum > 1:
        if startNum % 2==0 :
            startNum = startNum / 2
        else :
            startNum = 3 * startNum + 1
        seql +=1
 
    return seql

startNum = 1000000
gseql = 0
gNum = 0;

while startNum  > 1 :
    seql = collatz(startNum)
    if seql > gseql:
        gNum = startNum
        gseql = seql;
        print "New greatest: Seq length " + str(gseql) + " of nr: " + str(gNum)
    startNum -= 1


