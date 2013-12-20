for(a in 1 .. 1000)
{
    for( b in 1 ..1000)
    {
        for(c in 1..1000)
        {
            if(a+b+c == 1000)
            {
                if(Math.pow(a,2) + Math.pow(b,2) == Math.pow(c,2) )
                {
                    println "Found " + a+ " " + b+ " " + c + "a*b*c=" + a*b*c
                }
            }
        }         
    }
}