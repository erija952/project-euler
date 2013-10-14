#!/usr/bin/awk -f

BEGIN{
for (i=1; i<1000; ++i)
{
  if ( i%3 == 0) 
  {
    sum += i; 
  }
  else if ( i%5 == 0) 
  {
    sum += i; 
  }
}
printf "Project euler p1: sum is %d \nBye!\n\n", sum
exit 1
}



#
#BEGIN { print "File\tOwner" }
# {
#  for ( i=1; i < 10; i++) {
#      sum+=i
#  }
#}
#END { print sum}
