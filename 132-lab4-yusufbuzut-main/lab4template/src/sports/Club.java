package sports;

import java.util.ArrayList;

public class Club {
	private String name;
	private int yearEstablished ;
	private ArrayList<Team> teams;
	
	
	public Club (String name, int yearEstablished) {
		 this.name = name;
		 this.yearEstablished = yearEstablished;
		 this.teams = new ArrayList<Team>();
	 }
	 public Club (String name, int yearEstablished, ArrayList<Team> teams) {
		 this.name = name;
		 this.yearEstablished = yearEstablished;
		 this.teams = teams;
	 }
	 public int genderCount(Athlete.Gender gender) {
		 int genderCount =0;
		 for (Team i:this.getTeams()) {
			 for (Athlete j: i.getAthletes()) {
				 if (j.getGender() == gender) {
					genderCount += 1;
				 }
			 } 
		 }
		 return genderCount;
	 }
	 public void addTeam(Team team) {
		 this.getTeams().add(team);
		 team.setClub(this);
	 }
	 public void removeTeam(Team team) {
		 this.getTeams().remove(team);
		 team.setClub(null);
	 }
	 public int clubSalary() {
		 int sum=0;
		 for (Team i: this.getTeams()) {
			 sum += i.teamSalary();
		 }
		 return sum;
	 }
	 public String toString() 
		{
			String t = "";
			for(Team team: teams)
			{
				t += team.toString() + "\n";
			}	
			String out = "Club: " + this.name + "\n" + "Year Established: " + this.yearEstablished + "\n" + "Teams: " + "\n" + t;                       
			out = out + "Total Club Salary: " + this.clubSalary() + "TL\n" + 
			"Number of female athletes: " + this.genderCount(Athlete.Gender.FEMALE)+ "\n" + 
			"Number of male athletes: " + this.genderCount(Athlete.Gender.MALE)+ "\n"; 
			return out;
		}
	
	 public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYearEstablished() {
		return yearEstablished;
	}
	public void setYearEstablished(int yearEstablished) {
		this.yearEstablished = yearEstablished;
	}
	public ArrayList<Team> getTeams() {
		return teams;
	}
	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
	
}
	
