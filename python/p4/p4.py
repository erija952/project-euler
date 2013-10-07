#!/usr/bin/python

def isPalindrome(n):
    strN= str(n)
    if  strN == strN[::-1]: #Same number backwards
        return True
    else:
        return False

init=100
max=1000
j=init
k=init
highest = 0
while j < max:
    while k < max:
        current = j*k
        if isPalindrome(current) and (j*k > highest) :
            highest = j*k
        k=k+1
    j=j+1
    k = init
print highest


            
    
    
