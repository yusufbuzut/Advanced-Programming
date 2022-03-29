package inlab;

public class BookStore {
	
	public static void main(String[] args) throws InvalidBookException {
		
		BookStoreClerk clerk = new BookStoreClerk();
		boolean a = true;
		while(a) {
			try {
				Book tempBook = clerk.readAndValidateBook();
				
				System.out.println(tempBook.toString());

				System.out.println("BookStore Registration Program ended");
				a = false;
			}
			catch(NumberFormatException numberFormatException){
				System.out.println("Cannot create the book instance!");
				
				System.out.println("Please modify the input yearPublished argument");
				throw new InvalidBookException(numberFormatException.getMessage(),numberFormatException);
			}
			catch(Exception e){
				System.out.println("Cannot create the book instance!");
				
				
				throw new InvalidBookException(e.getMessage(),e);
				
			}
		}
		
		
		

	}
}
