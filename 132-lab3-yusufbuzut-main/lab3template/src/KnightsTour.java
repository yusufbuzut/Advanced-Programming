import java.util.Random;
public class KnightsTour {
	
	public static void singleTour(String[] args)  {
		int numberOfMove =1;
		final int n = Integer.parseInt(args[0]);
		int[][] chessBoard = new int[n][n];	
		Random r = new Random();
		r.setSeed(Integer.parseInt(args[1]));
		int currentRow = r.nextInt(8);
		int currentCol = r.nextInt(8);
		chessBoard[currentRow][currentCol] = 1;
		chessBoard = oneMove(currentRow,  currentCol, n, chessBoard,numberOfMove);
		int allMoves = max(chessBoard,n);
		System.out.printf("The tour ended with %d moves.%n",allMoves);
		if (allMoves < n*n ) {
			System.out.println("This was not a full tour.");
		}
		else {
			System.out.println("This was a full tour.");
		}
		System.out.printf("%5s","");
		for (int i =0; i<n;i++) {
			System.out.printf("%-5d",i);
		}
		System.out.printf("%n");
		for (int i =0; i<n;i++) {
			System.out.printf("%-5d",i);
			for (int j =0;j <n; j++) {
				System.out.printf("%-5d",chessBoard[i][j]);
			}	
			System.out.printf("%n");
		}
		
		
	}
	private static int[][] oneMove(int currentRow, int currentCol,int n,int[][] chessBoard,int numberOfMove) {
		int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
		int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};
		for (int i=0;i<8;i++) {			
			if (validMove(currentRow,currentCol,n,chessBoard,horizontal,vertical,i)) {
				currentRow = currentRow + vertical[i];
				currentCol = currentCol + horizontal[i];	
				numberOfMove = numberOfMove+1;
				chessBoard[currentRow][currentCol] = numberOfMove;
				oneMove(currentRow,  currentCol, n, chessBoard,numberOfMove);
				break;
			}
			else {
				continue;
			}
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
	static void thousandTours(String[] args) {
		System.out.println("#tours   tour length");
		int n = Integer.parseInt(args[0]);
		int[] histogram = new int[n*n];
		Random r = new Random();
		r.setSeed(Integer.parseInt(args[1]));
		for (int i =0; i<1000; i++) {
			histogram[singleTour2(args,r)-1] += 1;
		}
		for (int i =0; i<64; i++) {
			System.out.printf("%-10d%-3d%n",histogram[i],i+1);
		}
		
		
	}
	private static int singleTour2(String[] args,Random r)  {
		int numberOfMove =1;
		final int n = Integer.parseInt(args[0]);
		int[][] chessBoard = new int[n][n];			
		int currentRow = r.nextInt(8);
		int currentCol = r.nextInt(8);
		chessBoard[currentRow][currentCol] = 1;
		chessBoard = oneMove2(currentRow,  currentCol, n, chessBoard,numberOfMove,r);
		int allMoves = max(chessBoard,n);
		return allMoves;
		
	}
	private static int[][] oneMove2(int currentRow, int currentCol,int n,int[][] chessBoard,int numberOfMove,Random r) {
		int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
		int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};
		int k = r.nextInt(8);
		for (int i =0; i<8;i++) {				
			if (validMove(currentRow,currentCol,n,chessBoard,horizontal,vertical,k)) {
				currentRow = currentRow + vertical[k];
				currentCol = currentCol + horizontal[k];	
				numberOfMove = numberOfMove+1;
				chessBoard[currentRow][currentCol] = numberOfMove;			
				oneMove2(currentRow,  currentCol, n, chessBoard,numberOfMove,r);
				break;
			}
			else {
				k = (k+1)%8;
				continue;
			}
		}
		return chessBoard;
	}
	static void fullTour(String[] args) {
		System.out.println("#tours   tour length");
		int n = Integer.parseInt(args[0]);
		int[] histogram = new int[n*n];
		Random r = new Random();
		r.setSeed(Integer.parseInt(args[1]));
		for (int y =0; y<1;y++){ 
				int k = singleTour2(args,r);
				y = y-1;
				if (k==64) {
					histogram[k-1] += 1;
					break;
				}
				else {
					histogram[k-1] += 1;
				}
			}	
		int sum = 0;
		for (int i =0; i<64; i++) {
			sum = histogram[i]+sum;
			System.out.printf("%-10d%-3d%n",histogram[i],i+1);
		}
		System.out.printf("%n");
		System.out.printf("It took %d tries to get a full tour",sum);
	}
	
}
