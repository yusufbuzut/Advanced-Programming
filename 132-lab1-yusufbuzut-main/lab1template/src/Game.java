
import java.util.Scanner;
public class Game {
	private int numberOfCards;
	private int mode;
	private int start;
	public void play() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of cards:");
		
		 while (!input.hasNextInt()) {
		      System.out.println("Enter number of cards:");
		      input.nextLine();
		 }
		 numberOfCards = input.nextInt();
		 
		 
		 
		 System.out.println("Enter 0 if the computer plays in stupid mode, 1 for smart mode:");
		 mode = 0;
		 while (!input.hasNextInt() || (mode = input.nextInt()) != 0) {
			 if (mode==1){ 
		    	  break;
		      }
		      System.out.println("Enter 0 or 1.");
		      input.nextLine();
		 }
		 
		 Computer cp1 = new Computer();
		 if (mode == 1) {
			 cp1.setGameMode(false);
			 System.out.println("Computer is playing in smart mode");
		 }
		 else if (mode == 0) {
			 System.out.println("Computer is playing in stupid mode");
		 }
		 
		 
		 
		 System.out.println("Enter 0 if the human stars,  1 if computer starts:");
		 start = 0;
		 while (!input.hasNextInt() || (start = input.nextInt()) != 0 ) {
			 if (start==1){ 
		    	  break;
		      }
		      System.out.println("Enter 0 or 1.");
		      input.nextLine();
		 }
		 
		 cp1.setNumberOfCards(numberOfCards);
		 playTurn(numberOfCards,start, cp1);
		 if (start == 0) {
				System.out.println("Computer Wins");
				
			}
		else {
				System.out.println("You win");
				
				
		}
	}
	private static void playTurn(int numberOfCards, int start , Computer cp1) {
		System.out.printf("There are %d cards left%n", numberOfCards);
		Scanner input = new Scanner(System.in);
		
		if (start == 0) {		
			System.out.println("Your turn.  How many you want to remove:");
			int wantRemove = 0;
			while (!input.hasNextInt() || (wantRemove = input.nextInt()) > (numberOfCards/2)) {
			      System.out.println("You can enter half the number of cards that are left at most");
			      input.nextLine();
			 }
			 
			 numberOfCards = numberOfCards - wantRemove;
			 cp1.setNumberOfCards(numberOfCards);
			 start = 1;
			 
		}
		else {
			System.out.printf("Computer removed %d cards%n", cp1.removeCards());
			numberOfCards = numberOfCards - cp1.removeCards();
			cp1.setNumberOfCards(numberOfCards);
			start = 0;
		}
		while (numberOfCards > 0) {
			if (cp1.getNumberOfCards() == 1) {
				break;
							
			}
			else {
				playTurn(numberOfCards,start, cp1);
			}
			 
		}
		
	}
	

}
