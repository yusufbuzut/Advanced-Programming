import java.util.Random;

public class InLabClass {
		
	public static void inLabProblem(String[] args) {
		Random r = new Random();
		r.setSeed(Integer.parseInt(args[1]));
		oneTour(r,args);
		
	}
	private static void oneTour(Random r,String[] args) {
		int numberOfMove =1;
		int[][] access =
			{{2, 3, 4, 4, 4, 4, 3, 2},
			{3, 4, 6, 6, 6, 6, 4, 3},
			{4, 6, 8, 8, 8, 8, 6, 4},
			{4, 6, 8, 8, 8, 8, 6, 4},
			{4, 6, 8, 8, 8, 8, 6, 4},
			{4, 6, 8, 8, 8, 8, 6, 4},
			{3, 4, 6, 6, 6, 6, 4, 3},
			{2, 3, 4, 4, 4, 4, 3, 2}};
		for (int i = 0 ; i<Integer.parseInt(args[2]);i++) {
			int[][] trial = new int [8][8];
			int currentRow = r.nextInt(8);
			int currentCol = r.nextInt(8);
			trial[currentRow][currentCol] = 1;
			trial = oneMove( currentRow,  currentCol, 8, trial, numberOfMove,access);
			int allMoves = max(trial,8);
			System.out.printf("Trial no %d%n",i);
			System.out.printf("The tour ended with %d moves.%n",allMoves);
			System.out.printf("%5s","");
			for (int y =0; y<8;i++) {
				System.out.printf("%-5d",i);
			}
			System.out.printf("%n");
			for (int y =0; y<8;i++) {
				System.out.printf("%-5d",i);
				for (int j =0;j <8; j++) {
					System.out.printf("%-5d",trial[i][j]);
				}	
				System.out.printf("%n");
			}
		}
	
	}
	private static int[][] oneMove(int currentRow, int currentCol,int n,int[][] chessBoard,int numberOfMove,int[][]access) {
		int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
		int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};
		int[] valids = new int[8];
		int counter = 0;
		for (int i=0;i<8;i++) {
			if (validMove(currentRow,currentCol,n,chessBoard,horizontal,vertical,i)) {
				valids[i] = access[currentRow + vertical[i]][currentCol + horizontal[i]];
				access[currentRow + vertical[i]][currentCol + horizontal[i]] -=1;
				counter +=1;
			}
			else {
				continue;
			}
		}
		if (counter !=0) {
			int max = 8;
			int movement = 0;
			for (int i=0;i<8;i++) {
				if (max >= valids[i]) {
					max = valids[i];
					movement = i;
				}
			}
			access[currentRow][currentCol] -= 1;	
			currentRow = currentRow + vertical[movement];
			currentCol = currentCol + horizontal[movement];	
			numberOfMove = numberOfMove+1;
			chessBoard[currentRow][currentCol] = numberOfMove;			
			oneMove(currentRow,  currentCol, n, chessBoard,numberOfMove,access);
		}
		return chessBoard;
		
		
	}
	private static boolean validMove(int currentRow, int currentCol,int n,int[][] chessBoard,int[] horizontal,int[] vertical,int i) {
		if (currentRow + vertical[i] >=0 && currentCol +horizontal[i] >=0 && currentRow + vertical[i] < n 
				&& currentCol +horizontal[i] <n ) {
			if (chessBoard[currentRow + vertical[i]][currentCol +horizontal[i]] ==0){
				
				return true;					
			}
			else {
				return false;
			}
			
		}
		else {
			return false;
		}
			
	}
	private static int max(int[][] chessBoard,int n) {
		int m = 0;
		for (int i=0; i<n;i++){
			for (int j=0; j<n;j++) {
				if (m< chessBoard[i][j]) {
					m = chessBoard[i][j];
				}
			}
		}
		return m;
	}
			

}
