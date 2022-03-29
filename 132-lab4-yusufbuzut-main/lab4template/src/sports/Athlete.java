package sports;

import java.util.ArrayList;

public class Athlete {

	private String jersey_number;
	private String name;
	private String surname;
	private int salary;
	private boolean on_contract;
	private Team team;
	private Gender gender;
	private static ArrayList<Athlete> all_athletes = new ArrayList<Athlete>() ;
	
	
	
	
	public static enum Gender{FEMALE, MALE}



	public Athlete (String jersey_number, String name, String surname, Gender gender) {
		this.gender = gender;
		this.jersey_number = jersey_number;
		this.name = name;
		this.surname = surname;
		this.on_contract = false;
		this.team = null;
		all_athletes.add(this);
	}
	public Athlete (String jersey_number, String name, String surname, Gender gender, int salary) {
		this.gender = gender;
		this.jersey_number = jersey_number;
		this.name = name;
		this.surname = surname;
		this.salary = salary;
		this.on_contract = false;
		this.team = null;
		all_athletes.add(this);
	}

	public static ArrayList<Athlete> searchByName(String string) {
		ArrayList<Athlete> matchedAthletes = new ArrayList<Athlete>();
		for (int i=0; i< all_athletes.size();i++) {
			if (all_athletes.get(i).getName()== string) {
				matchedAthletes.add(all_athletes.get(i));
			}
		}
		return matchedAthletes;
	}
	
	
	public String getFullname(){
		return this.getName()+ " " + this.getSurname();
	}
	public String toString() {
		return this.jersey_number + "," + this.surname + "," + this.name + "," + this.salary + " TL" ;
	}
	
	
	
	


	public String getJerseyNumber() {
		return jersey_number;
	}
	public void setJerseyNumber(String jersey_number) {
		this.jersey_number = jersey_number;
	}
	public boolean getOnContract() {
		return on_contract;
	}
	public void setOnContract(boolean on_contrat) {
		this.on_contract = on_contrat;
	}
	
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
	
}
