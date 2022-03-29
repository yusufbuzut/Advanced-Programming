# LAB7 PRELAB

COMP 132 – Advanced Programming  
Pre-Laboratory Assignment VII  
Book Store Registration Application  
Strings, Exceptions  

### Collaboration Rules
This lab  is an individual work. Everyone should submit their own work. You can use any material from the course, or any other resource on Java programming language. You can discuss lecture related topics, the problem at the concept level with other students, but not the solution. You can reuse (copy-paste) code from the lecture notes, textbook, or code given in the lab, but not from others (internet sources, other students etc.)

### Honor Code - by submitting lab work I accept:
- This code is my own work. 
- I did not consult to any program written other students. 
- I did not search for the solution of the problem in the internet.
- I did not copy-paste code written by others.
- This code is my own work.

### IMPORTANT

* DON'T COPY PASTE code from anybody or any other resource. The code should be written by you. The code similarity tools will find such codes and disciplinary action will be taken.
* You should solve the problem the way we described. By not following instructions, you may lose points.
* Check Blackboard LAB6 for possible corrections.
* Print out in the same format, points will be taken off, if you don't print in the same format.
* It is normal for you get "cannot be resolved" type of errors when you first import your project from Github because all classes are not implemented yet. You will resolve these errors as you create and implement the necessary classes.
* Don't forget to implement setters and getters of the private variables.
* Pay attention to use the appropriate access modifier for instance variables and methods.

### LATE SUBMISSION 

Each Lab has its late submission rule. Lab7 late submission is :
* Regular Submission: Noon 12pm April 16, at the end of the lab
* Late Submission: April 16 
   * 12:05: -2 points
   * 12:10: -5 points
   * 23:59: -50 points

### PRELAB

In this laboratory assignment, you are asked to use your knowledge and skills recently gained on Java Strings and Exceptions in order to design and implement a Book Registration application for a local bookstore. Within this registration application, the user is first prompted to enter the details of a newly acquired book in a specific format. Then, the application reads the input book information, processes it using Java String methods and finally decides whether the input information is faithful to the desired format. If the input information about the book coincides with the desired format, the application should print details of the new book in a specific style, if not, the application should throw and handle exceptions, asking the user to re enter his/her input, until an input with the desired format is entered. 
	
For the pre-laboratory part of this assignment, you are expected to complete and/or modify three .java classes, “Book.java”, “BookStoreClerk.java” and “BookStore.java”, whose templates are provided for you. ***They are all in under prelab package.***

### Book Class: 

Simple Java object that contains three instance variables; String: name,  String: authorName  and int: yearPublished. The Book class should also implement a single public constructor and a public toString() method. The details of how toString() should operate can be observed from the visuals that are shared later in this assignment document.

### BookStoreClerk Class: 

This class is expected to handle the input information processing and supervision. For the specific BookStore application at hand, we only want input book information in the following format:

“name-authorName-yearPublished” for example:
"One Hundred Years of Solitude-Gabriel Garcia Marquez-1967"

In other words, in order for our application to accept an input argument as a valid book information, the input string should contain exactly 2 hyphen characters ‘-’, which separates the 3 input variables that a book should have.

To correctly implement the BookStoreClerk class,  you are asked to complete its two methods, namely a private helper method partitionString() and a public methopd readAndValidateBook().

```java
private String[] partitionString(String)
```

As the name and the above description suggests, this method is expected to take a single String instance as input and return an array of Strings which contains three elements. These three Strings should be substrings of the original input where the separation is governed by the hyphen characters ‘-’. Use any Java.String method of your choosing in order to complete this method. It should be noted that in case where partitionString() method fails to identify exactly 2 hyphen characters ‘-’ inside the input String argument, it should throw an IllegalArgumentException declaring that the input to the partitionString() method is invalid.


```java
public Book readAndValidateBook() 
```
readAndValidateBook() is the method responsible for accepting input from the user using a Scanner object. It first prompts the user to enter book information, reads and processes it.  It throws  IllegalArgumentException if the input is blank and/or empty. Otherwise, it calls partitionString() method to parse the input and get individual parts. These will be used to create and retrun a Book object if all the required information exists in the input with the desired format. Bear in mind that  partitionString() method returns an array of Strings however the  yearPublished method needs to be int type. So Integer.parseInt() will be used to convert it to int. Then these values are used to instantiate tje Book instance. Note that parseInt might throw NumberFormatException if the string can not be converted to an int. In addition, note that, readAndValidateBook() should throw another IllegalArgumentException if any of the Strings that are returned by the  partitionString() method is invalid, i.e.  name or authorName are blank.


### BookStore Class  

BookStore is the class that contains our main method, as it can be also observed from the template that is provided to you. It initiates a BookStoreClerk object and calls its readAndValidateBook() to finalize its functionality. You are expected to modify this class in such a way that it handles all possible exceptions that can be thrown out of the   readAndValidateBook() method and keeps asking user to input the book information until a valid book info is passed and a  Book instance is created. In case of a valid input argument is given by the user, it should print the  Book object (returned by readAndValidateBook) and terminate.

*** Note that  try statements will be put only in this class. ***


###Sample Outputs from the Solution

```
Enter information for book in required format:Great Expectations_Charles Dickens_1860
Cannot create the book instance!
java.lang.IllegalArgumentException: Invalid Input to partitionString method: Could not find seperator character '-'
Please modify the input arguments

Enter information for book in required format:1984-George Orwell-
Cannot create the book instance!
java.lang.NumberFormatException: For input string: ""
Please modify the input yearPublished argument

Enter information for book in required format: 
Cannot create the book instance!
java.lang.IllegalArgumentException: Input BookInfo is empty!
Please modify the input arguments

Enter information for book in required format:Wuthering Heights- -1847
Cannot create the book instance!
java.lang.IllegalArgumentException: Input BookInfo is invalid!
Please modify the input arguments

Enter information for book in required format:Pride and Prejudice-Jane Austen,1813
Cannot create the book instance!
java.lang.IllegalArgumentException: Invalid Input to partitionString method: Could not find seperator character '-'
Please modify the input arguments

Enter information for book in required format:One Flew Over the Cuckoo's Nest-Ken Kesey-1962
Book Name: One Flew Over the Cuckoo's Nest
Author Name: Ken Kesey
Year Published: 1962

BookStore Registration Program ended
```
