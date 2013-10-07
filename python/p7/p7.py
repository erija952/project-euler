#!/usr/bin/python
#By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we
#can see that the 6th prime is 13.

#What is the 10001st prime number?

#Rosses theorem: var upperLimit = (int) (n * Math.Log(n) + n * Math.Log(Math.Log(n)));
#Plus sieve of eratoshthenes (wikipedia)
import math

def get_upper_limit(n):
    if n <= 6:
        return 14
    else:
        return int(round((n * math.log(n)) + (n * math.log(math.log(n)))))

def get_nth_prime(n):
    all_primes = primes(get_upper_limit(n))
    return all_primes[n-1] #Might have found more primes, see 13th prime below

def primes(n):
    prime_list = range(2,n)
    for i in range(2,int(math.sqrt(n))):
        if i in prime_list:
           j=i**2           
           while j <= n:
               if j in prime_list:
                   prime_list.remove(j)
               j=j+i
    return prime_list
          
print "get_nth_prime of 6 is " + str(get_nth_prime(6)) + " should be 13"
print "get_nth_prime of 11 is " +  str(get_nth_prime(11)) + " should be 31"
print "get_nth_prime of 13 is " +  str(get_nth_prime(13)) + " should be 41"
print "get_nth_prime of 10001 is " +  str(get_nth_prime(10001)) + " should be largeq"
