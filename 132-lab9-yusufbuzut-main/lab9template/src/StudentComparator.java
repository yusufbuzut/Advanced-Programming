import java.util.Comparator;

// modify StudentComparator as needed

public class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student o7, Student o1) {
		return Double.compare(o7.overAllGrade(), o1.overAllGrade());
	}
	
}
