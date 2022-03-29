package knighttour;

import knighttour.knight.*;

public class KnightTour {
	protected Board board;
	protected Knight knight;
	
	
	public KnightTour() {
		this.board = new Board();
		this.knight = new Knight(board);
	}
	
	public KnightTour (int boardSize, String knightType) {
		this.board = new Board(boardSize);
		if (knightType.equals("regular")) {
			this.knight = new Knight(board); 
		}
		else if (knightType.equals("random")){
			this.knight = new RandomKnight(board);
		}
		else if (knightType.equals("heuristic")){
			this.knight = new HeuristicKnight(board);
		}
		else {
			this.board = new Board(boardSize);
			this.knight = new Knight(board);
		}
	}
	public void tour() {
		singleTour();
	}
	public void printResult() {
		System.out.printf("The tour ended with %d moves.\n", board.getMoveCount());
		if (board.isFull()) {
			System.out.printf("This was a full tour.\n");
		}
		else {
			System.out.printf("This was a not full tour.\n");
		}
		board.printTour();
	}
	protected int singleTour() {
		boolean done = false;
		while(!done) {
			if(knight.makeMove()== false) {
				done = true;
			}
		}
		return board.getMoveCount();
	}

}
