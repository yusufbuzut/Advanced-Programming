package prelab;

public class Book {

	// Instance variables:
	// name
	// authorName
	// yearPublished
	
	// Methods:
	// Constructor
	// toString
	public String name;
	public String authorName;
	public int yearPublished;
	
	public Book (String name, String authorName, int yearPublished) {
		this.name = name;
		this.authorName = authorName;
		this.yearPublished = yearPublished;
	}
	@Override
	public String toString() {
		
		
		return ("Book Name: "+ this.name + "\r\n" + "Author Name: " +this.authorName + "\r\n" + "Year Published: " + this.yearPublished);
	}
	
}
