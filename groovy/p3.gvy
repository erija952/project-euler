long n=600851475143
int d=2
int highest=0
while(n > 1)
{
    while(n % d == 0)
    {
        n=n/d
        highest=n
    }
    d=d+1
    if(d*d > n)
    {
        println "Break"
        break
    }
}

println "Highest is " + highest

