// Fig. 7.10: DeckOfCards.java
// DeckOfCards class represents a deck of playing cards.
import java.security.SecureRandom;



///////////////////////////////////////////////////////////////////
//
//
//     PART1 and PART2 
//     ADD ALL YOUR CODE AT THE END OF THE CLASS               
//     Note: This class has overloaded print dec methods (textbook version does not have)
///////////////////////////////////////////////////////////////////

public class DeckOfCards {
   // random number generator
   private static final SecureRandom randomNumbers = new SecureRandom();
   private static final int NUMBER_OF_CARDS = 52; // constant # of Cards

   private Card[] deck = new Card[NUMBER_OF_CARDS]; // Card references
   private int currentCard = 0; // index of next Card to be dealt (0-51)

   // constructor fills deck of Cards
   public DeckOfCards() {
      String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
         "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};    
      String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};      

      // populate deck with Card objects                   
      for (int count = 0; count < deck.length; count++) {  
         deck[count] =                                     
            new Card(faces[count % 13], suits[count / 13]);
      }                                                    
   } 

   // shuffle deck of Cards with one-pass algorithm
   public void shuffle() {
      // next call to method dealCard should start at deck[0] again
      currentCard = 0; 

      // for each Card, pick another random Card (0-51) and swap them
      for (int first = 0; first < deck.length; first++) {
         // select a random number between 0 and 51 
         int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

         // swap current Card with randomly selected Card
         Card temp = deck[first];   
         deck[first] = deck[second];
         deck[second] = temp;       
      } 
   } 

   // deal one Card
   public Card dealCard() {
      // determine whether Cards remain to be dealt
      if (currentCard < deck.length) {
         return deck[currentCard++]; // return current Card in array
      } 
      else {
         return null; // return null to indicate that all Cards were dealt
      } 
   }
   
   // for printing the deck
   public void printDeck() {
	      // print all 52 Cards in the order they are stored in the deck
	      System.out.println("Printing Deck ");
	      for (int i = 0; i < 52; i++) {
	         // deal and display a Card
	         System.out.printf("%-19s", deck[i]);
	         if ((i+1) % 4 == 0) { // output a newline after every fourth card
	            System.out.println();
	         } 
	      } 
	      System.out.printf("End of Deck%n%n");  
   }
   
   // overload printDeck, for printing a given Card Array
   public void printDeck(Card[] cardArray) {
	      // print all  Cards in the order they are stored in the cardArray
	      System.out.println("Printing Deck ");
	      for (int i = 0; i < cardArray.length; i++) {
	         // deal and display a Card
	         System.out.printf("%-19s", cardArray[i]);
	         if ((i+1) % 4 == 0) { // output a newline after every fourth card
	            System.out.println();
	         } 
	      } 
	      System.out.printf("End of Deck%n%n");  
   }
   
   
   
   ///////////////////////////////////////////////////
   //// ADD YOUR CHANGES AFTER THIS POINT ////////////
   
   
   // Prelab 
   // complete isFlush
   public boolean isFlush(int start) {
	   for (int i = 0; i<4;i++) {
		   if (deck[i].getSuit().equals(deck[i+1].getSuit())) {
			  continue; 
		   }
		   else {
			   return false;
		   }
	   }
	   return true; // place holder for not getting syntax error - remove it to write yoru code.   
   }
   
	//Inlab
	// return true the a given hand of five cards is a flush, otherwise flase
	// input: hand - a Card array of length 5
	public boolean isFlush(Card[] hand) {
		for (int i =0 ; i<hand.length-1; i++) {
			if (hand[i].getSuit().equals(hand[i+1].getSuit())) {
				continue;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	// return true if a given Card array has a flush beginning from start
	// returns false if not a flush, or if there are no 5 cards
	public boolean isFlush(Card[] deck, int start) {
		for (int i = 0; i<4;i++) {
			   if (deck[i].getSuit().equals(deck[i+1].getSuit())) {
				  continue; 
			   }
			   else {
				   return false;
			   }
		   }
		   return true;
		
	}
	// create and return a new shuffled Card array
	// the original deck of DeckOfCards is unchanged
	// no new card are created
	public Card[] shuffle2() {
		Card[] cardArray = new Card[NUMBER_OF_CARDS];
		// next call to method dealCard should start at deck[0] again
	      currentCard = 0; 
	      for (int i =0 ; i< NUMBER_OF_CARDS;i++) {
	    	  cardArray[i] = deck[i];
	      }
	      // for each Card, pick another random Card (0-51) and swap them
	      for (int first = 0; first < cardArray.length; first++) {
	         // select a random number between 0 and 51 
	         int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

	         // swap current Card with randomly selected Card
	         Card temp = cardArray[first];   
	         cardArray[first] = cardArray[second];
	         cardArray[second] = temp;       
	      } 
		return cardArray;
		
	}	
	// Deal the next five cards and return them in a new Card array of size 5
	// You should call deal() to get the next card
	public Card[] deal5() {
		Card[] hand = new Card[5];
		for (int i = 0; i< 5; i++) {
			
			hand[i] = dealCard();
			
		}
		return hand;
		
		
	}
} 

