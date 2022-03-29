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

* Check Blackboard LAB4 for possible corrections.

* Print out in the same format, points will be taken off, if you don't print in the same format.

### LATE SUBMISSION 

Each Lab has its late submission rule. Lab4 late submission is :
* Regular Submission: Noon 12pm March 19, at the end of the lab
* Late Submission: March 19
   * 12:05: -2 points
   * 12:10: -5 points
   * 23:59: -45 points

# Athlete Database
In this Laboratory Assignment, you are asked to build an application representing the athlete database. The application keeps track of clubs, teams, and athletes. A club, for example Fenerbahce, has a number of teams, such as a football team, a basketball team. Each team has athletes, a captain, and belongs to a team. 

 The application has 3 classes: “Club”, “Team” and “Athlete” classes. The classes has methods that handle daily operations needed in a database such as listing athletes registered in a club, assigning a new athlete to a team, calculating the total salary in a club and so on. 
 
The **Club** class will contain the teams. A **Club** object such as *Fenerbahce*, *Galatasaray* or *Besiktas* will be composed of **Team** objects such as *Football Team*, *Basketball Team* or *Volleyball Team*. Every **Team** object will be made up of **Athlete** objects such that, for instance, the *Football Team* of the club *Fenerbahçe* will include *Athlete*s such as *Mesut Ozil*, *Diego Perotti*, etc. 
 

The prelab source code comes with the the main class Lab4Main. Lab4Main is in the package **main**. 

You are asked to create the package **sports** and create the following three classes under the sports package:

1. **Athlete** : Holds identity information of an athlete. 
2. **Team** : Presents a branch sports team such as "volleyball branch” and contains its information.
3. **Club** : Presents a sports club such as “Fenerbahce” which can contain several branch teams.

Now you need to implement these classes as described in detail below:

---

## PreLab Lab4Main
---
Make necassary changes in Lab4Main.java so that it can access classes in sports package

---

## PreLab A - Athlete Class
---
#### Athlete Class Private Instance Variables: 
Every instance of the Athlete Class should have the following instance variables. Note that, every instance variable of this class is not visible to other classes and necessary “get” and “set” methods should be implemented: 
1. `jersey_number : String. `
2. `name : String.` 
3. `surname : String.` 
4. `salary : Int.` Holds information of the salary of the athlete, the default value should be “0” 
5. `on_contract : Boolean`. If the athlete is assigned to a team, this variable should be changed to “true”. Its default value is “false”. 
6. `team : Team.` The team that the athlete belongs to. 
7. `gender: enum Gender.` See enum declaration below: 
 
#### Athlete Class Public Enum Data Type: 
```Enum class Gender {FEMALE, MALE}```, you should define it  inside Athlete class. 
 
#### Athlete Class Static Variables and Methods: 
You have seen during lectures that static members belong to the class instead of a specific instance, this means if you make a member static, you can access it without object instances. 
Athlete class is desired to have a private
```java 
private static ArrayList<Athlete> all_athletes
```
which will hold all of the Athlete instances that are created without paying attention to their Teams or Clubs. In other words, every time Athlete class constructor is called, the constructor should initialize the necessary instance variable of the Athlete and then add this Athlete instance to the “all_athletes ArrayList”. 
In addition to the static ArrayList all_athletes, the Athlete class should also implement a static method whose prototype is given as follows: 
```java
public static ArrayList<Athlete> searchByName(String name) 
```

searchByName method, given a String name, will search all_athletes ArrayList to find a matching Athlete with the name argument, and then return every matched Athlete in an ArrayList. If no match is found, the method should return an empty ArrayList. 

#### Athlete Class Public Methods: 
You will define two constructors for this class, their prototype should look like this: 
```java
1. public Athlete (String jersey_number, String name, String surname, Gender gender) 
2. public Athlete (String jersey_number, String name, String surname, Gender gender, int salary) 
```
***Hint***: You can make use of the first constructor while implementing the second one. 

Note from the previous section that both of the constructors should add the created Athlete instance to the static ArrayList of “all_athletes”. 
+ In addition, you will define the necessary get and set methods for all of the variables listed in section “Athlete Class Private Instance Variables”. 
+ Define an additional public method, ```String getFullName()``` which will return the full name of an Athlete as name 
 \+ “ ” + surname. 
 

Use the following toString() method (available form BB Lab4 also)
```
public String toString() {
		return this.jersey_number + "," + this.surname + "," + this.name + "," + this.salary + " TL" ;
	}
```


#### Athlete Class Notes: 
Bear in mind that, when an Athlete instance is first created, since it has not been assigned to a “Team” object yet, Athlete’s “on_contract” variable should be initialized to “false” and its “team” variable should be initialized to “null”. When you are implementing the “Team” class, you will define methods that will enable you to add athletes to or remove athletes from the Team. These add/remove methods should change the Athlete instance’s “on_contract” and “team” variables. 

## PreLab B - Team Class
---
#### Team Class Private Instance Variables: 
Every instance of the Team Class should have the following instance variables. Note that, every instance variable of this class is not visible to other classes and necessary “get” and “set” methods should be implemented: 
1. ```name : String.```
2. ```athletes : ArrayList<Athletes>```, List of athletes in the team. 
3. ```captain : Athlete```, which will be assigned as Team captain. 
4. ```club : Club,``` The club that this belongs to. 
 
#### Team Class Public Methods:
+ You will define one constructors for this class, its prototype should look like this: 
```java
public Team (String name) 
```

When the Team instance is first created, its “athletes” variable should be initialized to an empty ArrayList of Athletes, its “club” and “captain” variables should be assigned to null. 
+ Define the required get and set methods of all instance variables except the set method for “athletes” 
variable. 
+ Additionally implement three methods for adding and removing athletes from the team and calculating the total salary of the team.
``` java 
1. public void addAthlete(Athlete athlete) 

2. public void removeAthlete(Athlete athlete)  
```
+ You can use add, remove methods of the ArrayLists. 
+ Remember to update on_contract and team fields of the added athlete. You can assign “this” to athlete's team field when adding an athlete, and null when removing the athlete from the team. 
``` java 
3. public int teamSalary()
```
+ This method should iterate over the “athletes” ArrayList of the team, summing every athlete’s salary to calculate the team salary.


4. Use the following toString() method (available form BB Lab4 also)
```
public String toString() {
		String members = "";
		for(Athlete ath: athletes)
		{
			members += ath.toString() + "\n";
		}
		
		String out = this.name + "\n" + "Team Captain: " + "\n" + this.captain.toString() + "\n" + "Members: \n" + members;
		
		return out;
	}
```
#### Team Class Notes: 
Please note that the setter method setCaptain(Athlete captain) should first check if the argument captain is in the team, if it is, change the captain variable of the team. If the argument captain is not in the team, the method should display an error message.  
 
## PreLab C - Club Class
---
#### Club Class Private Instance Variables: 
Every instance of the Club Class should have the following instance variables. Note that, every instance variable of this class is not visible to other classes and necessary “get” and “set” methods should be implemented: 
1. ```name : String ```
2. ```yearEstablished : int ```
3. ```teams : ArrayList<Team>```, List of teams registered to the club 
 
#### Club Class Public Methods: 
You will define two constructors for this class, their prototype should look like this: 
```java
1. public Club (String name, int yearEstablished) 
2. public Club (String name, int yearEstablished, ArrayList<Team> teams) 
```

Define the required get and set methods of all class instance variables. 

Additionally implement three methods for adding and removing teams from club and calculate the total salary of the club. 
```java
1. public void addTeam(Team team) 
2. public void removeTeam(Team team) 
```
+ You can use add, remove methods of the ArrayList. 
+ Note that you should update the team’s club field inside these methods. You can assign “this” to teams club field when adding team, and null when removing the team from the club. 
```java
3. public int clubSalary()
``` 
+ This method should iterate over the “teams” ArrayList of the club, summing every team's salary to calculate the club salary.     
***Hint:*** use teamSalary() method of class “Team” while iterating. 

4. Use the following toString() method (available form BB Lab4 also)
```
public String toString() 
	{
		String t = "";
		for(Team team: teams)
		{
			t += team.toString() + "\n";
		}
		
		String out = "Club: " + this.name + "\n" + "Year Established: " + this.yearEstablished + "\n" + "Teams: " + "\n" + t;
		out = out + "Total Club Salary: " + this.clubSalary() + "TL\n";
		out = out + "Number of female athletes:  " + this.genderCount(Athlete.Gender.FEMALE) + "\nNumber of male athletes:  " + this.genderCount(Athlete.Gender.MALE) + "\n";
		
		return out;
	}
```


### SAMPLE OUTPUT 
```
Testing Athlete class:
-----------------------------------
- Testing Constructors and getter methods: Passed
- Testing Athlete Class Static Variables and Methods: Passed

Testing Team class:
-----------------------------------
- Testing Constructors and getter methods:Passed

Testing Club class:
-----------------------------------
- Testing Constructors and getter methods: Passed

--------Testing toString() methods--------

Club: Fenerbahce
Year Established: 1907
Teams: 
Basketball
Team Captain: 
16,Osman,Cedi,40000 TL
Members: 
16,Osman,Cedi,40000 TL
3,Urkmez,Berkay,20000 TL

Total Club Salary: 60000TL
Number of female athletes:  0
Number of male athletes:  2


--------END OF TESTA--------
```
