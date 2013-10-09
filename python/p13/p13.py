#!/usr/bin/python

def get_nums(a):
    f  = open(a)
    ls = [l.split() for l in f]
    f.close()
    return ls

nums = get_nums("nums.txt")

sum = 0
i = 0
for num in nums:
	print "i " + str(i)
	sum += int(num[0])
	i += 1

strsum = str(sum)
print "First ten digits of sum is is "
print strsum[:10]