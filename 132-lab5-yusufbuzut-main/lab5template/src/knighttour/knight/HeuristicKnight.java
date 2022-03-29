package knighttour.knight;

import knighttour.Board;

public class HeuristicKnight extends Knight{
	private int[][] access = 
		  {{2, 3, 4, 4, 4, 4, 3, 2},
				   {3, 4, 6, 6, 6, 6, 4, 3},
				   {4, 6, 8, 8, 8, 8, 6, 4},
				   {4, 6, 8, 8, 8, 8, 6, 4},
				   {4, 6, 8, 8, 8, 8, 6, 4},
				   {4, 6, 8, 8, 8, 8, 6, 4},
				   {3, 4, 6, 6, 6, 6, 4, 3},
				   {2, 3, 4, 4, 4, 4, 3, 2}};
	
	public HeuristicKnight(Board board) {
		super(board);
		this.access = access;
	}
	@Override
	public boolean makeMove() {
		int minRow = 99;
	     int minColumn = 99;
		int accessNumber = 99;
		for (int moveType = 0; moveType < 8; moveType++) {
	            // new position of hypothetical moves
	            int testRow = currentRow + vertical[moveType];
	            int testColumn = currentColumn + horizontal[moveType];
	            if (board.isValid(testRow, testColumn)) {
	                // obtain access number
	                if (access[testRow][testColumn] < accessNumber) {
	                   // if this is the lowest access number thus far,
	                   // then set this move to be our next move
	                   accessNumber = access[testRow][testColumn];        
	                   minRow = testRow;
	                   minColumn = testColumn;
	                }
	                --access[testRow][testColumn];
	            }
		}
		if (accessNumber == 99) {
			return false;
		}
		else {
			currentRow = minRow;
            currentColumn = minColumn;
            board.addMove(currentRow,currentColumn);
            access[currentRow][currentColumn] = 10000;
            return true;
		}
	}
	
	@Override
	public void reset() {
		this.currentRow = random.nextInt(board.getSize());
	    this.currentColumn = random.nextInt(board.getSize());
	    board.addMove(currentRow, currentColumn);
	    int[][] reset =  {{2, 3, 4, 4, 4, 4, 3, 2},
				   {3, 4, 6, 6, 6, 6, 4, 3},
				   {4, 6, 8, 8, 8, 8, 6, 4},
				   {4, 6, 8, 8, 8, 8, 6, 4},
				   {4, 6, 8, 8, 8, 8, 6, 4},
				   {4, 6, 8, 8, 8, 8, 6, 4},
				   {3, 4, 6, 6, 6, 6, 4, 3},
				   {2, 3, 4, 4, 4, 4, 3, 2}};
	   	this.access = reset;
	}
}
