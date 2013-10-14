#!/usr/bin/awk -f

BEGIN{
  f1 = 0
  f2 = 1
  tmp = f1
  while (f2 < 4000000) {
  tmp=f2
  f2=f1+f2
  f1=tmp
  if (f2%2 == 0) {
    sum += f2; 
  }
}
printf "Project euler p2: sum of even is %d \nBye!\n\n", sum
exit 1
}