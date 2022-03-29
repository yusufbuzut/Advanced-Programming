import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Part1Test {

	private static final Comparator StudentComparator = new StudentComparator();

	public static void main(String[] args) {


		List<Student> students = new ArrayList<Student>();

		// Uncomment the following lines to fill the students list.
		
		students.add(new Student(28, "Annie Whittaker", "Comp. Sci.", 23, 98, 6));
		students.add(new Student(32, "Aalia Huber", "Physics", 55, 14, 59));
		students.add(new Student(29, "Alexander Mccormack", "Psychology", 99, 60, 79));
		students.add(new Student(45, "Zakariya Holloway", "Physics", 94, 31, 39));
		students.add(new Student(17, "Montell Dean", "Comp. Sci.", 3, 16, 98));
		students.add(new Student(22, "Pranav Schwartz", "Physics", 94, 68, 49));
		students.add(new Student(56, "Tracy Roman", "Comp. Sci.", 59, 63, 84));
		students.add(new Student(41, "Louie Davey", "Psychology", 99, 63, 40));
		students.add(new Student(36, "Ayesha Schofield", "Psychology", 99, 48, 95));
		students.add(new Student(33, "Bear Hardin", "Comp. Sci.", 53, 62, 43));
		students.add(new Student(25, "Kareem Ratcliffe", "Psychology", 99, 52, 70));
		 


		// Print student list
		System.out.println("Student List:");
		printStudents(students);

		/********************************************
		 *  Perform the following sort operations	*
		 ********************************************/

		/*
		 * 1. Sort students based on their ID
		 */
		// your code below
		
		Collections.sort(students);



		// Print sorted student list
		System.out.println("Sorted Student List based on ID:");
		printStudents(students);

		/*
		 * 2. Sort students based on their overall grade
		 */
		// your code below


		Collections.sort(students, StudentComparator);
		


		// Print sorted student list
		System.out.println("Sorted Student List based on Overall Grade:");
		printStudents(students);

		/*
		 * 3. Sort students based on their overall grade in reverse order
		 */
		// your code below



		Collections.sort(students, StudentComparator.reversed());


		// Print sorted student list
		System.out.println("Reverse sorted Student List based on Overall Grade:");
		printStudents(students);


		/* 
		 * 4. Sort students based on their ID in reverse order
		 */
         // your code below

		Collections.sort(students,Collections.reverseOrder());


		//  Print sorted student list
		System.out.println("Reverse sorted Student List based on ID:");
		printStudents(students);


		/* 
		 * 5. Map students to their departments,
		 * Calculate department averages of final grades
		 * Fill the functions 'departmentMap' and 'calcDeptAverage'
		 */
		System.out.println("Department averages:");
		// your code below
		Map<String, List<Student>> mapStudents = departmentMap(students);
		
		for (String s : mapStudents.keySet()) {
			System.out.println(s + ": " + calcDeptAverage(mapStudents, s));
			
		}
		
	}

    // complete this method
	private static Map<String, List<Student>> departmentMap(List<Student> sList) {
		/*
		 * This method creates a map
		 * Keys are department names 
		 * Values are the list of students registered to that department
		 * Returns the map
		 */
		
		return sList.stream().collect(Collectors.groupingBy(student -> student.getDepartment()));
	}

     // complete this method
	private static double calcDeptAverage(Map<String, List<Student>> deptMap, String dept) {
		/*
		 * This method calculates the average of final grades for the input "dept" and returns the average
		 * NOTE: To calculate average, YOU MUST USE STREAMS. Otherwise, you will not receive any credit. 
		 */
		
		return deptMap.get(dept).stream().mapToDouble(student -> student.getFinalGrade()).average().getAsDouble();
	}

	private static void printStudents(List<Student> sList) {
		sList.forEach(System.out::println);
		System.out.println();
	}


}
