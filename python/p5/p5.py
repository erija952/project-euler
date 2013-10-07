#!/usr/bin/python
curNum= 20
divisor= 2
while divisor <= 20 :
    if curNum % divisor == 0:
        divisor=divisor+1
    else:
        curNum = curNum+1
        divisor = 1

print curNum
