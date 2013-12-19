def isPalindrome(n)
{
    str= n.toString()
    backWards = str.reverse()
    if ( str == backWards ) 
    {//Same number backwards
        return true
    }
    else
    {
        return false
    }
}

init=100
max=1000
j=init
k=init
highest = 0
while (j < max)
{
    while (k < max)
    {
        current = j*k
        if(isPalindrome(current) && (j*k > highest))
        {
            highest = j*k
        }
        k=k+1
    }
    j=j+1
    k = init
}
print highest

