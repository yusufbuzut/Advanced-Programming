package lab5;

import knighttour.*;



public class Lab5Main {

	public static void main(String[] args) {
		int boardSize=8;
		String tourType="single";
		String knightType="regular";
		
		KnightTour knightTour;
		
		if (args.length==0) { //default tour: 8x8, single, regular knight
	            knightTour = new KnightTour();
		    System.out.println("Knight Tour default mode 8x8 Single Tour Regular Knight");
		}
		else {
		   boardSize = Integer.parseInt(args[0]);
		   tourType = args[1];
	       knightType  = args[2];
		   switch(tourType) {
		   case "single": 
			   knightTour = new KnightTour(boardSize,knightType);
			   break;
		   case "fixed":
			   knightTour = new FixedKnightTour(boardSize,knightType);
			   break;
		   case "full":
			   knightTour = new FullKnightTour(boardSize,knightType);
			   break;
		   default: 
			   System.out.println("Invalid tour tpye");
			   return;
		   }
		}
		
		System.out.printf("Knight Tour %2dx%2d %s Tour %s Knight%n",boardSize,boardSize,tourType,knightType);
		
		knightTour.tour();
		
		knightTour.printResult();

	}

}
