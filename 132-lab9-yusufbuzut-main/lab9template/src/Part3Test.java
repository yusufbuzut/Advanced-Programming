import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Part3Test {
	
	public static void main(String[] args) {
			
		/****************************************************
		 *  Perform the following operations using streams	*
		 ***************************************************/
		
		/*
		 * 1. Print a list of strings based on a given list of integers (list1)
		 * Each element should be preceded by the word 'even' if the number is even,
		 * and preceded by the word 'odd' if the number is odd.
		 */
		List<Integer> list1 = Arrays.asList(22, 30, 19, 17, 12, 8, 2, 1, 11, 47);
		List<String> list1converted = list1.stream()
											.map(i -> 
											{if(i%2 == 0) {
												return "even" ;
											}
											if(i%2 ==1) {
												return "odd";
											
											}
											return null;
											})
											.collect(Collectors.toList());
		
		// Print the list and the generated string
		System.out.println("Question 1:");
		System.out.println(list1);
		System.out.println(list1converted);
		System.out.println();
		
		
		
		
		/*
		 * 2. Find the elements of the given list of Strings (list2) which starts with the letter 'a',
		 * and has at least 4 characters. Print the comma separated string (list2filtered) of these elements. 
		 */
		List<String> list2 = Arrays.asList("apple","banana","airplane","car","art");
		String list2filtered = list2.stream()
				.filter(i -> i.charAt(0) == 'a')
				.filter(i -> i.length() >= 4)
				.collect(Collectors.joining(", "));
		
		// Print list2 and list2filtered
		System.out.println("Question 2:");
		System.out.println(list2);
		System.out.println(list2filtered);
		System.out.println();
		
		/*
		 * 3. Convert each string in the list2 to upper case.
		 */
		
		List<String> list2uppercase = list2.stream()
											.map(i -> i.toUpperCase())
											.collect(Collectors.toList());
		
		// Print the resulting list
		System.out.println("Question 3:");
		System.out.println(list2);
		System.out.println(list2uppercase);
		System.out.println();
		
		/*
		 * 4. Find the average of a list of integers (list1) 
		 */
		double average = list1.stream()
							  .mapToDouble(i-> i)
							  .average()
							  .getAsDouble();
		
		// Print the result
		System.out.println("Question 4:");
		System.out.println(list1);
		System.out.println("Average: " + average);
		System.out.println();
		
	}

}