package knighttour;

public class FullKnightTour extends KnightTour {
	private int[] moveTotals;
	private final int MAX_TOUR_ALLOWED = 200000;
	
	public FullKnightTour(int boardSize, String knightType) {
		super(boardSize,knightType);
		this.moveTotals = new int[boardSize*boardSize];
	}
	
	@Override
	public void tour() {
		fullTour();
		
	}
	private void fullTour() {
		for (int i=0; i < MAX_TOUR_ALLOWED; i++) {
			int a = singleTour();
			moveTotals[a-1] += 1;
			if (a == 64) {
				board.clear();
				knight.reset();
				break;
			}
			board.clear();
			knight.reset();
		}
	}
	@Override
	public void printResult() {
		int sum = 0;
		System.out.print("# tours having # move	\n\n");
		for (int row = 0; row < board.getSize()*board.getSize(); row++) {
			sum = sum + moveTotals[row];
			System.out.printf("%-10d%-5d\n",moveTotals[row], row+1);
		}
		System.out.printf("It took %d tries to get a full tour. %n",sum);
	}
}

