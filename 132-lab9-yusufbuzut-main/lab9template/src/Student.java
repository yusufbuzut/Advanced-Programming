
// modify Student as needed

public class Student implements Comparable<Student>{
	private int ID;
	private String name;
	private String department;
	private double midterm1Grade;
	private double midterm2Grade; 
	private double finalGrade;
	
	Student(int ID,	String name,String department,double midterm1Grade,	double midterm2Grade,double	finalGrade){
		this.ID = ID;
		this.name = name;
		this.department = department;
		this.midterm1Grade = midterm1Grade;
		this.midterm2Grade = midterm2Grade; 
		this.finalGrade = finalGrade;
		
	}
	
	public int compareTo(Student student){
		return Integer.compare(this.ID, student.ID);
		
	}
	public String toString() {
		return "Student "+ID+" => "+ "Name: "+name+", Dept: "+department+", MT1: "+midterm1Grade+", MT2: "+midterm2Grade+
				", Final: " + finalGrade;
	}

	public int getID() {
		return ID;
	}
	public double overAllGrade() {
		return 0.25*midterm1Grade+ 0.25*midterm2Grade +  0.5*finalGrade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getMidterm1Grade() {
		return midterm1Grade;
	}

	public void setMidterm1Grade(double midterm1Grade) {
		this.midterm1Grade = midterm1Grade;
	}

	public double getMidterm2Grade() {
		return midterm2Grade;
	}

	public void setMidterm2Grade(double midterm2Grade) {
		this.midterm2Grade = midterm2Grade;
	}

	public double getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(double finalGrade) {
		this.finalGrade = finalGrade;
	}

	public void setID(int iD) {
		ID = iD;
	}
}	
