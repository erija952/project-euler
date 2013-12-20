//A bit messy, as bigIntegers was neeeded to handle numbers.
def get_primes(n)
{
    a = []
    bigN = n.toBigInteger()
    for( i in 2G..bigN)
    {
        tmp = [i as BigInteger, true] 
        a.add(tmp)
    }
    sqrtN = Math.floor(Math.sqrt(n)).toInteger()

    bigSqrtN = (sqrtN+1).toBigInteger()
    for(i in 2G..bigSqrtN)
    {
        if(a[i-2][1] == true)
        {
            b = []
            for(x in 0G..bigN)
            {
                b.add(x*i)
            }
    
            c = []
            for(x in b)
            {
                c.add(x + i*i)
            }
            
            // Remove to large elements
            d = []
            for(x in c) 
            {
                if(x <= n) 
                {
                    d.add(x)
                }
            }           
            for(j in d)
            {
                a[j-2][1] = false;            
            }
        }
    }
    println "Done"
           
    b =[] //Remove the boolean
    limit = (a.size()-1).toBigInteger()
    for(i in 0G..limit)
    {

        if(a[i][1] == true)
        {

            b.add(a[i][0])
        }
    }

    return b
    
}

println get_primes(2000000).sum()
