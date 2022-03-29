package inlab;

public class InvalidBookException extends Exception {
	public InvalidBookException() {
		
	}
	public InvalidBookException(String message,Throwable cause) {
		super(message,cause);
		System.out.println("Please modify the input argument");
	}
	
	
	
	
	
	
	
	
	
	
}
