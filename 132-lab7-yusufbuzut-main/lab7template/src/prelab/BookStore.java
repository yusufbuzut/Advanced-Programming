package prelab;

public class BookStore {
	
	public static void main(String[] args) {
		
		BookStoreClerk clerk = new BookStoreClerk();
		boolean a = true;
		while(a) {
			try {
				Book tempBook = clerk.readAndValidateBook();
				
				System.out.println(tempBook.toString());

				System.out.println("BookStore Registration Program ended");
				a= false;
			}
			catch(NumberFormatException numberFormatException){
				System.out.println("Cannot create the book instance!");
				numberFormatException.printStackTrace();
				System.out.println("Please modify the input yearPublished argument");
			}
			catch(Exception e){
				System.out.println("Cannot create the book instance!");
				e.printStackTrace();
				System.out.println("Please modify the input arguments");
			}
		}
		
		
		

	}
}
