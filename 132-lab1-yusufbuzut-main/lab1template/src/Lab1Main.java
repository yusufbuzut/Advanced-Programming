
public class Lab1Main {
	private static final int SUM=15; // for in-lab exercise

	public static void main(String[] args) {		
	    gameDemo();
	    extraDemo();
	}
	
	
	public static void gameDemo() {	
	   // uncomment below to test your Game class
		Game game = new Game();
		game.play();
	}
	
	
	public static void extraDemo() {
		// In-lab assignments.
		// add method calls to test your in-lab questions.
		puzzleVersion1();
		puzzleVersion2();
	}
	// add methods for in-lab questions below
	static void puzzleVersion1() {
		int solutions = 0;
		for (int i =1000; i < 10000; i++) {
			if (i%2 ==0) {
				continue;
			}
			
			int plus = 0;
			int ones = i%10;
			int ones1 = i/10;
			int tens = ones1%10;
			int tens1 = ones1/10;
			int hund = tens1%10;
			int hund1 = tens1/10;
			int tho = hund1%10;
			plus = ones + tens + hund + tho;
			if (plus != SUM) {
				continue;
			}
			if (tho != 3*tens) {
				continue;
			}
			if (tho != hund && tho != tens && tho != ones && hund != tens && hund != ones && tens != ones) {
				System.out.printf("%d%n",i);	
				solutions +=1;
			}
			
		}
		System.out.printf("Number of solutions %d%n",solutions);
        // uses a single iteration construct
		
	}
	static void puzzleVersion2() {
		int solutions = 0;
		int innerMost = 0;
		for (int i = 1; i < 10 ; i = i+1) {
			for (int j = 0; j < 10 ; j = j+1) {
				if (i ==j || i+j>= SUM) {
					continue;
				}
				for (int k = 0; k < 10 ; k = k+1) {
					if (3*k != i || j ==k || i+j+k >=SUM) {
						continue;
					}
					for (int l = 1; l < 10 ; l = l+2) {
						innerMost += 1;
						if (l%2 == 0 ||k == l || l == i || l == j || i+j+k+l != SUM) {
							continue;
						}
						
						
						System.out.printf("%d%d%d%d%n",i,j,k,l);
						solutions +=1;
					}
					
				}
			}
		}
		System.out.printf("Number of solutions %d%n",solutions);
		System.out.printf("Innermost Loop body is executed %d times%n",innerMost);
		
	}

}
