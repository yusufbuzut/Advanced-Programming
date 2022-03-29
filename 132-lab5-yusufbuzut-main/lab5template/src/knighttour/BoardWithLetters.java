package knighttour;

import java.util.Random;

public class BoardWithLetters extends Board{
	char[][] letterBoard;
	char[] storedMove;
	
	public BoardWithLetters (int size) {
		super(size);
		this.letterBoard = new char[size][size];
		this.storedMove = new char[size*size];
		Random random = new Random();
		char[] comp = {'C','O','M','P'};
		for (int i = 0;i<size; i++) {		
			for (int j = 0;j<size; j++) {
				letterBoard[i][j] = comp[random.nextInt(4)];
			}
			
		}
	}
	private void printLetterBoard() {
		for (int row = 0; row < letterBoard.length; row++) {
	         System.out.print (row);

	         for (int column = 0; column < letterBoard[row].length; column++) {
	            System.out.printf("%5c", letterBoard[row][column]);
	         }

	         System.out.println();
	      } 
	}
	private boolean checkCOMP(int row, int column,char[] storedMove) {
		Character a = 'C';
		Character b = 'O';
		Character c = 'M';
		Character d = 'P';
		if ( a== storedMove[0] && b==(storedMove[2]) && c==(storedMove[4]) &&d==(storedMove[6])) {
			return true;
		}
		else{
			return false;
		}
	}
	public void addMove(int row, int column) {
		super.addMove(row, column);
		storeMove(row, column);
		System.out.println(storeMove(0, 0));
		if(checkCOMP(row, column,getStoredMove())) {
			System.out.printf("******COMP found******* at move %d%n",getMoveCount());
			printTour();
			printLetterBoard();
		}
	}
	private char[] storeMove(int row, int column) {
		System.out.println(letterBoard[row][column]);
		System.out.println((getMoveCount()-1)%4);
		storedMove[(getMoveCount()-1)%8] = letterBoard[row][column];
		return storedMove;
	}
	public char[] getStoredMove() {
		return storedMove;
	}
	
}
