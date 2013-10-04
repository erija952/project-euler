#!/bin/bash
let max=$1-1

f1=1
f2=2
sum=2
if [ $# -ne 1 ]; then
    let max=4000000
fi

while [  $f2 -lt $max ]; do
   a=$f2 
   let f2=$f1+$f2 
   let f1=$a 

   if [ $((f2%2)) -eq 0 ] ; then
       let sum=$sum+$f2
   fi
   
done

echo The sum is $sum
        