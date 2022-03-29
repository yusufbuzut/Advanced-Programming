package knighttour;

public class Board {
	private int[][] chessboard;
	private int moveCount;
	private int size;
	
	 public Board () {
		 this.size = 8;
		 this.chessboard = new int[8][8];
		 this.moveCount = 0;
	 }
	 public Board (int size) {
		 this.size = size;
		 this.chessboard = new int[size][size];
		 this.moveCount = 0;	 
	 }
	 public  int getMoveCount() {
		 return moveCount;
	 }
	 public int getSize() {
		 return size;
	 }
	 public  boolean isValid(int row, int column) {
		 return (row >= 0 && row < size && column >= 0 && column < size
		         && chessboard[row][column] == 0);
	 }
	 public  void clear() {
		 this.moveCount = 0;
		 for (int i  =0; i<getSize();i++ ) {
			 for (int j =0; j<getSize();j++ ) {
				 chessboard[i][j] =0;
			 }
		 }
			 
		 
	 }
	 public void addMove(int row, int column) {
		 moveCount += 1;
		 chessboard[row][column] = moveCount;
	 }
	 public boolean isFull() {
		 if (moveCount ==64){
			 return true;
		 }
		 else {
			 return false;
		 }
	 }
	 public void printTour() {
	      // display numbers for column
	      for (int k = 0; k < 8; k++) {
	         System.out.printf("%5d", k);
	      }

	      System.out.print("\n\n");

	      for (int row = 0; row < chessboard.length; row++) {
	         System.out.print (row);

	         for (int column = 0; column < chessboard[row].length; column++) {
	            System.out.printf("%5d", chessboard[row][column]);
	         }

	         System.out.println();
	      } 
	   } 
}		
