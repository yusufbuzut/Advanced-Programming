import java.util.Random;
public class Computer {
	private int numberOfCards;
	private boolean gameMode;
	
	public Computer(int numberOfCards, boolean gameMode) {
		this.gameMode = gameMode;
		this.numberOfCards = numberOfCards;
	}
	public Computer() {
		this.gameMode = true ;
		this.numberOfCards = 0;
	}
	public int removeCards() {	
		if (gameMode) {
			Random number = new Random();
			
			int removedCards = number.nextInt(numberOfCards/2);
			return removedCards;
			
		}
		else {
			int total = 1;
			while (total <= numberOfCards) {
				total *= 2;	
				
			}
			int removedCards = 	numberOfCards - (total/2 - 1);
			if (numberOfCards==2) {
				removedCards = 1;
			}
			return removedCards;
		}
			
	}
	public int getNumberOfCards() {
		return numberOfCards;
	}
	public void setNumberOfCards(int numberOfCards) {
		this.numberOfCards = numberOfCards;
	}
	public boolean getGameMode() {
		return gameMode;
	}
	public void setGameMode(boolean gameMode) {
		this.gameMode = gameMode;
	}
	
} 
