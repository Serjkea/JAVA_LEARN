
public class Student extends Person{
	
	private String major;
	
	Student(String name, int age, String major){
		super(name,age);
		this.major = major;
	}
	
	public void changeMajor(String major) {
		this.major = major;
	}
	
	public String getDescription(){
		return this.getName() + " " + this.getAge() + " " + this.major; 
	}
	
	public boolean equals(Object otherObject) {
		if (!super.equals(otherObject)) return false;
		Student other = (Student)otherObject;
		return this.major.equals(other.major);
	}
	
	public String toString() {
		return super.toString()+"[major="+major+"] ";
	}

}
