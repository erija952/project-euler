f1 = 0
f2 = 1
max=4000000
sum = 0
while(f1 < max)
{
    tmp = f2
    f2 = f1 + tmp
    f1 = tmp
    if(f2 % 2 == 0)
    {
        sum = sum + f2
    }
}
println "sum is " + sum
