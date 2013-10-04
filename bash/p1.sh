#!/bin/bash
let max=$1-1
sum=0
if [ $# -ne 1 ]; then
    let max=10-1
    echo Max number not set
fi

for i in `seq 1 $max`; do
   j=`expr $i % 3`
   k=`expr $i % 5`
   if [[ $j -eq 0 || $k -eq 0 ]] ; then
       let sum=$sum+$i
   fi
done
echo The sum is $sum
        