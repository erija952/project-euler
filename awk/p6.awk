#!/usr/bin/awk -f

BEGIN{
  sumofsquares = 0
  squareofsums = 0
  sum = 0
  for (i=1; i<=100; i++) {
      sumofsquares += i*i
      sum += i
}
squareofsums = sum*sum
diff = squareofsums - sumofsquares
printf "Project euler p6: diff is %d \nBye!\n\n", diff
exit 1
}