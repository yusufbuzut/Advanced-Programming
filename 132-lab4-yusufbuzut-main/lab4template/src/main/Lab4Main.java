package main;

/// LAB4 PRELAB

import java.util.ArrayList;
import java.util.Arrays;


/// make changes here so that you can access classes in sports package
import sports.Athlete;
import sports.Club;
import sports.Team;


public class Lab4Main {

	public static void main(String[] args) {
	
		
		// Implement the classes described in the prelab document
		// Uncomment TestA() and its definition to test your program
		
		 TestA(); 
		
		
		// TestB will be implemented during the lab
		// Implement it and test
		
		TestB(); 
		
	}

	
    
	
	// DO NOT CHANGE TestA()
	public static void TestA() {

		System.out.println("Testing Athlete class:\n-----------------------------------");
		System.out.print("- Testing Constructors and getter methods: ");
		Athlete akin = new Athlete("15", "Akin", "Yilmaz", Athlete.Gender.MALE, 20000);
		Athlete cedi = new Athlete("16", "Cedi", "Osman", Athlete.Gender.MALE, 40000);		
		
		//testing constructors and getter methods
		if (
				!cedi.getFullname().equals("Cedi Osman") ||
				akin.getGender().compareTo(Athlete.Gender.MALE) != 0 ||
				akin.getSalary() == 0 ||
				cedi.getJerseyNumber().compareTo("16") != 0 ||
				cedi.getOnContract() 
			)
		{
			System.err.println("Fail.\nPlease check Athlete class constructors and getter methods");
			return;
		} else {
			System.out.println("Passed");
		}
		
		//adding athletes for later tests
		ArrayList<Athlete> athletes = new ArrayList<Athlete>();
		athletes.add( new Athlete("3", "Berkay", "Urkmez", Athlete.Gender.MALE, 20000 ));
		athletes.add( new Athlete("7", "Arda", "Barin", Athlete.Gender.MALE, 10000));
		athletes.add( new Athlete("6", "Berkin", "Kayhan", Athlete.Gender.MALE,30000 ));
		athletes.add( new Athlete("14", "Deniz", "Ucar", Athlete.Gender.MALE, 10000));
		athletes.add( new Athlete("22", "Akin", "Tasdemir", Athlete.Gender.MALE, 40000));
		
		//testing athlete class method
		System.out.print("- Testing Athlete Class Static Variables and Methods: ");
		if ( !Athlete.searchByName("Arda").get(0).getJerseyNumber().equals("7") || Athlete.searchByName("Akin").size() != 2 ) {
			System.err.println("Fail.\nPlease check your searchByName method");
			return;
		} else {
			System.out.println("Passed");
		}
		
		//testing athletes and branches
		System.out.println("\nTesting Team class:\n-----------------------------------");
		System.out.print("- Testing Constructors and getter methods:");
		Team basketball = new Team("Basketball");
		Team football = new Team("Football");
		football.addAthlete(akin);
		football.setCaptain(akin);
		
		for(Athlete ath: athletes)
		{
			football.addAthlete(ath);
		}
		basketball.addAthlete(cedi);
		basketball.setCaptain(cedi);
		basketball.addAthlete(athletes.get(0));		
		football.removeAthlete(Athlete.searchByName("Berkin").get(0));

		if (
				!basketball.getCaptain().getJerseyNumber().equals(cedi.getJerseyNumber()) ||
				football.getAthletes().size() != 5 ||
				football.teamSalary() != 100000 ||
				Athlete.searchByName("Berkin").get(0).getOnContract() ||
				!cedi.getTeam().equals(basketball) ||
				!cedi.getOnContract()
				
			) {
			System.err.println("Fail.\nPlease check your Team class setter and getter methods");
			return;
		} else {
			System.out.println("Passed");
		}
		
		//testing Club
		System.out.println("\nTesting Club class:\n-----------------------------------");
		
		Club fenerbahce = new Club("Fenerbahce", 1907);
		Club besiktas = new Club("Besiktas", 1903);
		fenerbahce.addTeam(basketball);
		besiktas.addTeam(football);
		Club galatasaray = new Club("Galatasaray", 1905);
		
		ArrayList<Team> ts = new ArrayList<Team>(Arrays.asList(football, basketball));
	
		galatasaray.setTeams(ts);
		
		System.out.print("- Testing Constructors and getter methods: ");
		if (
				!football.getClub().equals(besiktas) ||
				besiktas.getYearEstablished() != 1903 ||
				!besiktas.getName().equalsIgnoreCase("Besiktas") ||
				fenerbahce.clubSalary() != 60000 ||
				galatasaray.getTeams().size() != 2
				
			) {
			
			System.err.println("Fail.\nPlease check your Club class setter and getter methods");
			return;
		} else {
			System.out.println("Passed");
		}
		
		
		//// Testing to toString methods
		
		System.out.println("\n--------Testing toString() methods--------\n");
		
		System.out.println(fenerbahce);
		
		System.out.println("\n--------END OF TESTA--------\n");
		
	}
	
    
	
	
	
	
	
	
	public static void TestB() {
		Athlete joe = new Athlete("6", "Joe", "Biden", Athlete.Gender.MALE, 25000);
		Athlete jacinda = new Athlete("5", "Jacinda", "Ardern", Athlete.Gender.FEMALE, 13000);
		Athlete abraham = new Athlete("32", "Abraham"," Lincoln", Athlete.Gender.MALE, 7000);
		Athlete sibel = new Athlete("23", "Sibel", "Siber", Athlete.Gender.FEMALE, 30000);
		Athlete angela = new Athlete("17", "Angela", "Merkel", Athlete.Gender.FEMALE, 40000);
		Athlete harry = new Athlete("55", "Harry", "Truman", Athlete.Gender.MALE, 18000);
		Athlete richard = new Athlete("9", "Richard", "Nixon", Athlete.Gender.MALE, 50000);
		
		
		Team teamA = new Team("TeamA");
		teamA.addAthlete(angela);
		teamA.addAthlete(jacinda);
		teamA.addAthlete(sibel);
		teamA.setCaptain(angela);
		
		Team teamB = new Team("TeamB");
		teamB.addAthlete(richard);
		teamB.addAthlete(abraham);
		teamB.setCaptain(richard);
		
		Team teamC = new Team("TeamC");
		teamC.addAthlete(joe);
		teamC.addAthlete(harry);
		teamC.setCaptain(joe);
		
		Club canberra = new Club("Club Canberra",1907);
		canberra.addTeam(teamA);
		canberra.addTeam(teamC);
		
		Club ottowa = new Club("Club Ottowa", 1910);
		ottowa.addTeam(teamB);
		
		System.out.println(canberra);
		System.out.println(ottowa);
	}
}
