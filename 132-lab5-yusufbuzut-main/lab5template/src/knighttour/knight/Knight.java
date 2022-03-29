package knighttour.knight;

import java.util.Random;

import knighttour.Board;

public class Knight {
	protected int currentRow;
	protected int currentColumn;
	protected Board board;
	protected static final int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
	protected static final int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};
	protected static final Random random = new Random();
	
	
	public Knight(Board board) {
		this.currentRow = random.nextInt(board.getSize());
	    this.currentColumn = random.nextInt(board.getSize());
	    this.board = board;
	    board.addMove(currentRow, currentColumn);
	}	
	public void reset() {
		this.currentRow = random.nextInt(board.getSize());
	    this.currentColumn = random.nextInt(board.getSize());
	    board.addMove(currentRow, currentColumn);	
	}
	public boolean makeMove() {
		for (int count = 0; count < 8; count++) {
			if (board.isValid(currentRow + vertical[count], currentColumn + horizontal[count])) {
				currentRow = currentRow + vertical[count];
				currentColumn = currentColumn + horizontal[count];
				board.addMove(currentRow,currentColumn);
				return true;
			}
		}
		return false;
	}
	
}
