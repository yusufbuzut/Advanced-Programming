package inlab;

import java.util.Scanner;

public class BookStoreClerk {
	

	// Partitions the single input String into 3 substrings depending 
	// on the occurrences of '-' char and returns a String[] containing 3 elements:
	// First element is the substring from index 0 to first occurrence of '-' character
	// Second element contains the substring from the first occurrence of '-' character to its second
	// Third element contains the substring from the second occurrence of '-' character to the end of the input
	// In case of not finding enough '-' chars (2 in this case) in the input string, should throw Exception.
	private String[] partitionString(String string) throws InvalidBookException{
		int offset = string.indexOf("-");
		int offset2 = string.indexOf("-", offset+1);
		try {
			if (offset == -1 || offset2 == -1) {
				throw new IllegalArgumentException("Invalid Input to partitionString method: Could not find seperator character '-'");			
			}	
		}
		catch (IllegalArgumentException e){
			throw new InvalidBookException(e.getMessage(),e);
		}
		
		
		String [] array = new String[3];
		array[0] = string.substring(0,offset);	
		array[1] = string.substring(offset+1, offset2);
		array[2] = string.substring(offset2+1);

		return array;	
	}	
	// Reads input bookInfo using a ScannerObject
	// Note that bookInfo should be in desired format, as it is explained in Lab Assignment Document
	// First checks whether input book info is blank or null, throws necessary exceptions
	// Then, calls partitionString method to partition input bookInfo into pieces
	// Saves the partitioned pieces into necessary variables
	// Finally, if all necessary info is valid,i.e., bookName, authorName and yearPublished, creates
	// a new book instance and returns it. If even one of them is invalid, throws Exception
	public Book readAndValidateBook() throws InvalidBookException{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter information for book in required format:");
		
		String bookName = scanner.nextLine();
		if (bookName.isBlank()) {
			throw new IllegalArgumentException("Input BookInfo is empty!");
		}
		else {
			
			String[] bookArray = partitionString(bookName);
			String a = bookArray[0];
			String b = bookArray[1];
			try {
				int c = Integer.parseInt(bookArray[2]);
				if (bookArray.length !=3 || bookArray[0].isBlank() || bookArray[1].isBlank() || bookArray[2].isBlank()) {
					throw new IllegalArgumentException("Input BookInfo is invalid!");
				}
						return new Book(a,b,c);
			}
			
			catch (NumberFormatException e){
				throw new InvalidBookException(e.getMessage(),e);
			}
			catch (IllegalArgumentException e) {
				throw new InvalidBookException(e.getMessage(),e);
			}

		}
	}	
}
