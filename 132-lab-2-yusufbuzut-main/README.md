### Collaboration Rules
This lab  is an indivual work. Everyone should submit their own work. You can use any material from the course, or any other resource on Java programming language. You can discuss lecture realted topics, teh problem at the concept level with other students, but not the solution. You can reuse (copy-paste) code from the lecture notes, textbook, or code given in the lab, but not from others (internet sources, otehr students etc.)

### Honor Code - by submitting lab work I accept:
- This code is my own work. 
- I did not consult to any program written other students. 
- I did not search for the solution of the problem in the internet.
- I did not copy-paste code written by others.
- This code is my own work.

# LAB2

*Before starting Lab2 please make sure you follow the steps in "Preliminaries - Eclipse and GitHub Classroom" in blackboard for creating your eclipse project without problem (particularly unchecking teh top folder druing import - see blackboard.*

You are given a Java project template for Lab2 assignment. The project has a main class (Lab2Main). It is the driver code which calls several class methods that you are asked to implement (Lab problems). Some problems will be given before the lab so that you start working on it.  Additional problems will be given during the lab (Inlab problems). If you don't do the prelab befor eteh lab, you end up spending time doing the lab. We strongly suggest completing prelab before the lab (setting up the eclipse project from the assigment and solving a few problems).

This Lab has three parts
* PART1   Prelab problems which involves DeckOfCard and Card classes (Section 7.6 of you text book).
* PART2   Inlab problems which involbes DeckOfCard and Card classes (continuation of part1)
* PART3   Inlab problems which involves writing methods dealing with arrays (You will add your methods at the end of Lab2Main class)

** PLEASE MAKE CHANGES IN THE PLACES WHERE INDICATED **

## PART1

You are asked to add several new features to the DeckOfCards example from your book. First, study the example and run it. Then add the following features.

### Part1.1 Keeping track of Card instances

DeckOfCards creates Card objects to form a deck. We want the Card class to keep track of how many instances of Card is created. Do the following:

1. We want to count how many  instances of Card is created.  Declare an appropriate  variable, called cardCount shared by all instances. This variable should not be accessible by other classes.
2. Modify it in an appropiate method in Card (incrementing)
3. Add a class level  method to get the value of cardCount, it will be called like Card.getCardCount().


### Part1.2 

In five-card poker hand, a flush is a hand where all five cards are of the same suit. We want to add a method to DeckOfCards to check if any five consecutive cards in the deck is a flush.

Add the following method to DeckOfCards 

```
// returns true if the five cards starting at position 'start' of the deck is a flush
// returns false if not a flush, or if there are no 5 cards
public boolean isFlush(int start) {

}
```

Add a getter method for the suit instance variable of Card.
In order to compare suit value of a Card objects, you need it.

Note: you can compare two strings as follows: Assume s1 and s2 are of type String.

```
s1.equals(s2)
```
returs true if they are equal.

END OF PART1


**NOTE: Lab2Main contains test method for prelab work (prelab()). But it is commented out so that you don't get syntax error. Remove the comment block of PART1 to test your work.**

**NOTE: Lab2Main  contains test methods for PART2 and PART3. They are commented out. During the lab, you will get questions and uncomment those parts to run the tests.**

### SAMPLE OUTPUT
```
Number of Card instances should be zero: 0
Printing Deck 
Ace of Hearts      Deuce of Hearts    Three of Hearts    Four of Hearts     
Five of Hearts     Six of Hearts      Seven of Hearts    Eight of Hearts    
Nine of Hearts     Ten of Hearts      Jack of Hearts     Queen of Hearts    
King of Hearts     Ace of Diamonds    Deuce of Diamonds  Three of Diamonds  
Four of Diamonds   Five of Diamonds   Six of Diamonds    Seven of Diamonds  
Eight of Diamonds  Nine of Diamonds   Ten of Diamonds    Jack of Diamonds   
Queen of Diamonds  King of Diamonds   Ace of Clubs       Deuce of Clubs     
Three of Clubs     Four of Clubs      Five of Clubs      Six of Clubs       
Seven of Clubs     Eight of Clubs     Nine of Clubs      Ten of Clubs       
Jack of Clubs      Queen of Clubs     King of Clubs      Ace of Spades      
Deuce of Spades    Three of Spades    Four of Spades     Five of Spades     
Six of Spades      Seven of Spades    Eight of Spades    Nine of Spades     
Ten of Spades      Jack of Spades     Queen of Spades    King of Spades     
End of Deck

Number of Card instances should be 52 now: 52
Is the first five cards is a flush? true
Printing Deck 
Nine of Spades     Deuce of Diamonds  Three of Hearts    Ten of Clubs       
Ten of Spades      Four of Diamonds   Queen of Spades    Six of Clubs       
Deuce of Hearts    Queen of Clubs     Nine of Diamonds   Seven of Diamonds  
Nine of Clubs      Jack of Spades     Queen of Diamonds  King of Hearts     
Queen of Hearts    Five of Spades     Deuce of Clubs     Five of Diamonds   
Seven of Spades    King of Clubs      Eight of Clubs     Three of Clubs     
Six of Hearts      Four of Spades     Seven of Clubs     Eight of Hearts    
Deuce of Spades    King of Diamonds   Three of Diamonds  Ace of Hearts      
Six of Spades      Four of Hearts     Six of Diamonds    Seven of Hearts    
Ace of Spades      Four of Clubs      Ace of Clubs       King of Spades     
Jack of Clubs      Five of Hearts     Ace of Diamonds    Jack of Diamonds   
Eight of Spades    Ten of Diamonds    Ten of Hearts      Jack of Hearts     
Eight of Diamonds  Nine of Hearts     Five of Clubs      Three of Spades    
End of Deck

Is the first five cards is a flush? false
```
