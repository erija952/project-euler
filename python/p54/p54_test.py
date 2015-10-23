#!/usr/bin/python
import unittest
from collections import Counter
from operator import itemgetter
from itertools import groupby

d = {'1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, \
     '7': 7, '8': 8, '9': 9, 'T': 10, 'J': 11, 'Q': 12, \
     'K': 13, 'A': 14}

def highest_card(cnt, rdHighest = 0):
    return sorted(cnt.most_common(5)[rdHighest:])[-1][0]

def has_pair(cnt):    
    for k, v in cnt.iteritems():
        if v == 2:
            return k
        else:
            continue

def has_2pair(cnt):    
    counter = 0;
    num = 1;
    if len(cnt) == 3:
        for k, v in cnt.iteritems():
            if v == 2:
                num= num*k
                counter = counter +1;
                if counter == 2:
                    return num
            else:
                continue

def has_3oak(cnt):    
    for k, v in cnt.iteritems():
        if v == 3:
            return k
        else:
            continue
    return -1

def has_4oak(cnt):    
    for k, v in cnt.iteritems():
        if v == 4:
            return k
        else:
            continue

def has_straight(vList):
    sor = sorted(vList)
    i = 0
    while i <= 3:
        if sor[i]+1 == sor[i+1]:
            i= i+1
        else:
            return -1
    return max(vList)

def has_flush(cList):
    if len(set(cList)) == 1:
        return 1
    else:
        return -1

def has_fullhouse(cnt): 
    print cnt
    if has_3oak(cnt) > 0:
        if has_pair(cnt) > 0:
            return has_3oak(cnt) + has_pair(cnt)
    return -1

def has_straightflush(vList, cList):
    if has_straight(vList) > 0:
        if has_flush(cList) > 0:
            return max(vList)
        else:
            return -1
    else:
        return -1

def determine_hand(vList,cList,cnt):
    if has_straightflush(vList,cList) > 0:
        return 10000000000*has_straightflush(vList,cList)
    if has_4oak(cnt) > 0:
        return 1000000000*has_4oak(cnt)+highest_card(cnt)
    if has_fullhouse(cnt) > 0:
        return 100000000*has_fullhouse(cnt)
    if has_flush(cList) > 0:
       return 10000000 + highest_card(cnt)
    if has_straight(vList) > 0:
       return has_straight(vList) * 1000000
    if has_3oak(cnt) > 0:
       return has_3oak(cnt) * 100000 + highest_card(cnt,1)
    if has_2pair(cnt) > 0:
        return has_2pair(cnt) * 1000 + highest_card(cnt,2)
    if has_pair(cnt) > 0:
        return has_pair(cnt) * 100 + highest_card(cnt,1)
    else:
        return 10*highest_card(cnt) + highest_card(cnt,1)

def getvalue(cards):
    vList = []
    cList = []
    for card in cards:
        vList.extend([d[str(card[0])]])
        cList.extend([str(card[1])])
        
    cnt = Counter()
    for num in vList:
        cnt[num] += 1

    return determine_hand(vList,cList,cnt)
    

def run():
    file = open('p054_poker.txt', "r")
    i = 0
    h1wins = 0
    for line in file.readlines():
        hand = line[:14].split(' ')
        hand2 = line[15:-1].split(' ')

        
        h1 = getvalue(hand)
        h2 = getvalue(hand2)
        if(h1 > h2):
            h1wins = h1wins + 1

        i = i+1
    print 'h1 wins', h1wins, ' of ', i


run()

