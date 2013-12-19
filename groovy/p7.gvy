//By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we
//can see that the 6th prime is 13.
//What is the 10001st prime number?
//Rosses theorem: var upperLimit = (int) (n * Math.Log(n) + n * Math.Log(Math.Log(n)));
//Plus sieve of eratoshthenes (wikipedia)

def get_upper_limit(n)
{
    if (n <= 6)
    {
        return 14
    }
    else
    {

        return Math.floor((n * Math.log(n)) + (n * Math.log(Math.log(n)))) 
    }

}

def get_nth_prime(n)
{
    all_primes = primes(get_upper_limit(n).toInteger())
    return all_primes[n -1] //Might have found more primes, see 13th prime below -1 is indexing
}

def primes(n)
{
    def prime_list = 2..n

    max= Math.floor(Math.sqrt(n)).toInteger()
    println "max " +max + " n " + n    
    for( i in 2..max)
    {
        if(prime_list.contains(i))
        {
           println "i " +i
           j= Math.pow(i,2).toInteger()

           while( j <= n)
           {         
               if(prime_list.contains(j))
               {
                   prime_list = prime_list.minus(j)
               }
               j=j+i
           }
        }
    }
    return prime_list
}         
println "get_nth_prime of 6 is " + get_nth_prime(6) + " should be 13"
println "get_nth_prime of 11 is " +  get_nth_prime(11) + " should be 31"
println "get_nth_prime of 13 is " +  get_nth_prime(13) + " should be 41"
print "get_nth_prime of 10001 is " +  get_nth_prime(10001)