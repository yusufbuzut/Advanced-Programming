package sports;

import java.util.ArrayList;

public class Team {
	private String name;
	private ArrayList<Athlete> athletes;
	private	Athlete captain;
	private Club club;
	
	
	
	public Team(String string) {
		
			this.name = string;
			this.athletes = new ArrayList<Athlete>();
			this.club = null;
			this.captain = null;
		
	}
	public void addAthlete(Athlete athlete) {
		this.getAthletes().add(athlete);
		athlete.setOnContract(true);
		athlete.setTeam(this);
	}
	public void removeAthlete(Athlete athlete) {
		this.getAthletes().remove(athlete);
		athlete.setOnContract(false);
		athlete.setTeam(null);
	}
	public int teamSalary() {
		int sum = 0;
		for (Athlete i: this.getAthletes()) {
			sum += i.getSalary();
		}
		return sum;
	}
	public String toString() {
		String members = "";
		for(Athlete ath: athletes)
		{
			members += ath.toString() + "\n";
		}
		
		String out = this.name + "\n" + "Team Captain: " + "\n" + this.captain.toString() + "\n" + "Members: \n" + members;
		
		return out;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Athlete getCaptain() {
		return captain;
	}

	public void setCaptain(Athlete captain) {
		if(this.athletes.contains(captain)) {
			this.captain = captain;		
		}
		else{
			System.out.println("Athlete is not in this team");
		}
		
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public ArrayList<Athlete> getAthletes() {
		return athletes;
	}
	
}
