#!/usr/bin/python
class Color:
    hearts = 1
    spades = 2
    diamonds = 3
    clubs = 4

class Card():    
    def __init__(self, color, value):
        self.color = color
        self.value = value

class Hand():
    def __init__(self):
        self.cards = []
    def add(self, card):

        self.cards.insert(0,card)


def find_highest(hand):
    return max(hand.cards)

