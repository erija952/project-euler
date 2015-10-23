#!/usr/bin/python
import unittest
import collections

class Card:
    RANKS = (2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)
    SUITS = ('Spades', 'Diamonds', 'Hearts', 'Clubs')

    def __init__(self, rank, suit):
        self._rank = rank
        self._suit = suit
    
    def getRank(self):
        return self._rank
    
    def getSuit(self):
        return self._suit
            
    def __lt__(self, other):
        return( self._rank < other.getRank() )
    
class Hand():
    def __init__(self):
        self.cards = []
    def add(self, card):
        self.cards.insert(0,card)

def find_highest(hand, position = 0):
    maxcard = -1
    vlist = []
    for x in range(0, 5):
        vlist.insert(0,hand.cards[x].getRank())
    vlist.sort()
    vlist = vlist[::-1]
    return vlist[position]

def has_pair(hand):
    if find_highest(hand, 0) == find_highest(hand,1):
        return find_highest(hand)
    else:
        return -1

def has_2pair(hand):
    if find_highest(hand, 0) == find_highest(hand,1):
        if find_highest(hand, 2) == find_highest(hand,3):
            return find_highest(hand, 0) * find_highest(hand, 2)
        else:
            return -1
    else:
        return -1

def has_3oak(hand):
    if find_highest(hand, 0) == find_highest(hand,1) == find_highest(hand,2):
        return find_highest(hand, 0) * 3
    else:
        return -1

def determine_hand(hand):
    if has_3oak(hand) > 0:
        return 40000000 + has_3oak(hand) * 100000 + find_highest(hand,3)
    if has_2pair(hand) > 0:
        return 30000000 + has_2pair(hand) * 1000 + find_highest(hand,4)
    if has_pair(hand) > 0:
        return 20000000 + has_pair(hand) * 100000 + find_highest(hand,2)
    else:
        return 10000000 + find_highest(hand)

def rep(xs,nums=2):
   a = []
   for i in list(xs):
       if(list(xs).count(i)>=nums):
           a.append(i)
   if a:
       return a[0]
   else:
       return -1



#Todo: temporary!
def make_hand(one, two, three, four, five):
      c1 = Card(one, 'Spades')
      c2 = Card(two, 'Spades')
      c3 = Card(three, 'Spades')
      c4 = Card(four, 'Spades')
      c5 = Card(five, 'Spades')

      hand = Hand()
      hand.add(c1)
      hand.add(c2)
      hand.add(c3)
      hand.add(c4)
      hand.add(c5)
      return hand

class TestCards(unittest.TestCase):

    def test_findhighest(self):
         hand = make_hand(2,3,4,6,5)
         self.assertEqual(find_highest(hand), 6)

    def test_find2ndhighest(self):
         hand = make_hand(2,3,4,6,5)
         self.assertEqual(find_highest(hand,1), 5)

    def test_find3rdhighest(self):
         hand = make_hand(2,3,4,6,6)
         self.assertEqual(find_highest(hand,2), 4)

    def test_findhighest2(self):
         hand = make_hand(7,3,4,6,5)
         self.assertEqual(find_highest(hand), 7)
    
    def test_getvaluesingle(self):
         hand = make_hand(7,3,4,6,5)
         self.assertEqual(determine_hand(hand), 10000007)

    def test_getvaluepair(self):
         hand = make_hand(7,7,4,6,5)
         self.assertEqual(determine_hand(hand), 20000000 + 700000 + 6)

    def test_getvaluepair2(self):
         hand = make_hand(8,9,6,6,5)
         self.assertEqual(determine_hand(hand), 30000000 + 36000 + 9)


    def test_getvalue2pair(self):
         hand = make_hand(7,7,6,6,5)
         self.assertEqual(determine_hand(hand), 30000000 + 42000 + 5)

    def test_get3oak(self):
         hand = make_hand(7,7,7,6,5)
         self.assertEqual(determine_hand(hand), 40000000 + 2100000 + 6)

    def test_get3oa2(self):
         hand = make_hand(7,3,2,2,2)
         self.assertEqual(determine_hand(hand), 40000000 + 60000 + 7)

if __name__ == '__main__':

    lst = [2,3,3,4,5]
    print lst[0] in lst[1:]
    print lst[1] in lst[1:]
    import collections
    print collections.Counter(lst)


    unittest.main()
