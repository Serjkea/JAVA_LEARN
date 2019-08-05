import java.util.Formatter;

public class People {
	
	private String fName;
	private String sName;
	private BirthDate birthdate;
	private String gender;
	private String profession;
	
	People(String fName, String sName, BirthDate birthdate, String gender, String profession) {
		this.fName = fName;
		this.sName = sName;
		this.birthdate = birthdate;
		this.gender = gender;
		this.profession = profession;
	}
	
	public void setFName(String fName) {
		this.fName = fName;
	}
	
	public String getFName() {
		return this.fName;
	}
	
	public void setSName(String sName) {
		this.sName = sName;
	}
	
	public String getSName() {
		return this.sName;
	}
	
	public int getAge() {
		return this.birthdate.getAge();
	}
	
	public void setBirthDate(BirthDate birthdate) {
		this.birthdate = birthdate;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	public String getProfession() {
		return this.profession;
	}
	
	@Override
	public boolean equals(Object link) {
		if(link == this) return true;
		if(link == null) return false;
		if(link instanceof People) {
			People temp = (People)link;
			return temp.getFName().equals(this.getFName())&&
			       temp.getSName().equals(this.getSName())&&
			       temp.getAge()==this.getAge()&&
			       temp.getGender().equals(this.getGender())&&
			       temp.getProfession().equals(this.getProfession());
		} return false;
	}
	
	@Override
	public int hashCode() {
		return 31*this.getFName().hashCode() + 
		       31*this.getSName().hashCode() + 
		       this.getAge() + 
		       31*this.getGender().hashCode() +
		       31*this.getProfession().hashCode();
	}
	
	@Override
	public String toString() {
		Formatter f = new Formatter();
		return f.format("%5s %5s birthday: %s gender: %6s   profession: %10s", fName, sName, birthdate, gender, profession).toString();
	}
	

}
