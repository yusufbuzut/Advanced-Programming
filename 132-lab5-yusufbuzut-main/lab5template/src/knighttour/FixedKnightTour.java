package knighttour;

public class FixedKnightTour extends KnightTour  {
	private int[] moveTotals;
	private static final int NUMBER_OF_TOURS = 1000;
		
	public FixedKnightTour(int boardSize, String knightType) {
		super(boardSize,knightType);
		this.moveTotals = new int[boardSize*boardSize];

			
	}
	@Override
	public void tour() {
		fixedTour();
	}
	private void fixedTour() {
		for (int i=0; i < NUMBER_OF_TOURS; i++) {
			moveTotals[singleTour()-1] += 1;
			board.clear();
			knight.reset();
		}
	}
	@Override
	public void printResult() {
		System.out.print("# tours having # moves\n\n");
		for (int row = 0; row < board.getSize()*board.getSize(); row++) {
			System.out.printf("%-10d%-5d\n",moveTotals[row], row+1);
		}
		System.out.printf("Total number of tours: %d%n",1000);
	}
}
