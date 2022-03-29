import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;



public class Part2Test {

	public static void main(String[] args) {
		
	    Integer[] data = {1, 8, 4, 3, 9, 6, 9, 20, 2, 3, 25, 4, 3, 3, 6};

		Integer tobeMerged[] = {1,9,3,6, 18, 36};
		
		/* 
		 * Define "list1" with initial values from data 
		 */
		// your code below
	
		List<Integer> list1 = List.of(data);

		/*
		 * Define a list called "list2"
		 * with initial values from the array "tobeMerged"
		 */
		// your code below
		
		List<Integer> list2 = List.of(tobeMerged);
		
		/*
		 * Print initial lists (list1,list2)
		 */
		// your code below
		
		System.out.println(list1);
		System.out.println(list2);
		
		/*
		 * Merge elements
		 */
		// your code below
		
		List<Integer> mergedList = merge_elements(list1,list2);
		/*
		 * Print merged list
		 */
		// your code below
		
		System.out.println(mergedList);
		/*
		 * Print the second minimum element of list1
		 */
		// your code below
		
		System.out.println("Second minimum element of list1: " +second_min(list1));

		/*
		 * Print the second minimum element of list2
		 */
		// your code below
		
		
		System.out.println("Second minimum element of list2: " + second_min(list2));

		/*
		 * Print lists (list1,list2)
		 */
		// your code below
		
		System.out.println(list1);
		System.out.println(list2);
		

	}
	
	// complete this method
	public static List<Integer> merge_elements(Collection<Integer> c1, Collection<Integer> c2) {
		/*
		 * This method use iterators to iterate over c2
		 * If c1 does not contain the element of c2, adds it to c1, otherwise does nothing
		 */
		Iterator<Integer> iterator1 = c1.iterator();
		Iterator<Integer> iterator2 = c2.iterator();
		List<Integer> integerList = new ArrayList<Integer>();
		while(iterator1.hasNext()) {
			int temporary = iterator1.next();
			if (!integerList.contains(temporary)) {
				integerList.add(temporary);
			}			
		}
		while(iterator2.hasNext()) {
			int temporary = iterator2.next();
			if (!integerList.contains(temporary)) {
				integerList.add(temporary);
			}			
		}
		return integerList;
	}
	

	// complete this method
	public static int second_min(Collection<Integer> c) {
		
		Iterator<Integer> iterator = c.iterator();
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;
		while(iterator.hasNext()) {
			int temporary = iterator.next();
			if (temporary < first)            {         
                second = first;
                first = temporary;
            } 
            else if (temporary < second){
            	second = temporary;
            }            
		}
		return second;
	}

}
