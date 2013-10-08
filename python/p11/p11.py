#!/usr/bin/python
import numpy

def get_nums(a):
    f  = open(a)
    ls = [[int(i) for i in l.split()] for l in f]
    f.close()
    return ls

gridDim=20
maxS = 0
cordX = 0
cordY = 0
direction = ""
grid1 = get_nums("grid.txt")
grid = numpy.array(grid1).reshape(20, 20)

print "----------"
print grid
print "----------"

def mult(minigrid):
    if len(minigrid) > 0:
        return reduce(lambda a, b: a*b,minigrid)
    else:
        return 0
       
def get_horizontal(x,y):
    if x+3 < gridDim:
        minigrid=  grid[y,x:(x+4)]
        return minigrid
    else:
        return []

def get_vertical(x,y):
    if y+3 < gridDim:
        minigrid=  grid[y:(y+4),x]
        return minigrid
    else:
        return []

def get_diagPos(x,y):
    if y+3 < gridDim and x+3 < gridDim:
        minigrid= [grid[y,x],grid[y+1,x+1],grid[y+2,x+2],grid[y+3,x+3]]
        return minigrid
    else:
        return []
        
def get_diagNeg(x,y):
    if y-3 > 0 and x+3 < gridDim:
        minigrid= [grid[y,x],grid[y-1,x+1],grid[y-2,x+2],grid[y-3,x+3]]
        return minigrid
    else:
        return []

print "Calculating greatest product"         
for y in range(0,gridDim):
    for x in range(0,gridDim):
        horizontal = get_horizontal(x,y)
        vertical = get_vertical(x,y)
        diagPos = get_diagPos(x,y)
        diagNeg = get_diagNeg(x,y)
        if mult(horizontal) > maxS:
           maxS = mult(horizontal)
           cordX = x
           cordY = y
           direction = "horizontal"
           elements = horizontal
           print "New max coord at (x,y)=(" + str(x) +","+str(y)+") " + direction + " direction."
        if mult(vertical) > maxS:
           maxS = mult(vertical)
           cordX = x
           cordY = y
           direction = "vertical"
           elements = vertical
           print "New max coord at (x,y)=(" + str(x) +","+str(y)+") " + direction + " direction."
        if mult(diagPos) > maxS:
           maxS =mult(diagPos)
           cordX = x
           cordY = y
           direction = "positive diagonal"
           elements = diagPos
           print "New max coord at (x,y)=(" + str(x) +","+str(y)+") " + direction + " direction."
        if mult(diagNeg) > maxS:
           maxS =mult(diagNeg)
           cordX = x
           cordY = y
           direction = "negative diagonal"
           elements = diagNeg
           print "New max coord at (x,y)=(" + str(x) +","+str(y)+") " + direction + " direction."
       

print "Max is " + str(maxS) + " at (x,y)=(" + str(cordX) +","+str(cordY)+") in direction " + direction + ". Elements are: " + str(elements)
