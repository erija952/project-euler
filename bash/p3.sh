#!/bin/bash
n=600851475143
d=2
highest=0
while [ $n -gt 1 ]; do
    while [ $((n%d)) -eq 0 ]; do
        let n=$n/$d
	let highest=$n 
    done
    let d=$d+1
    let square=$d*$d
    if [ $square -gt $n ] ; then
	break
    fi
done

echo Highest $highest
        