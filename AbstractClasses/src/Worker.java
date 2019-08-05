
public class Worker extends Person{
	
	private double salary;
	
	Worker(String name, int age, double salary) {
		super(name,age);
		this.salary = salary;
	}
	
	public void setSalary(double salary){
		this.salary = salary;
	}
	
	public String getDescription() {
		return this.getName() + " " + this.getAge() + " " + this.salary;
	}
	
	public boolean equals(Object otherObject){
		if (!super.equals(otherObject)) return false;
		Worker other = (Worker)otherObject;
		return this.salary == other.salary;
	}
	
	public String toString() {
		return super.toString()+"[salary="+salary+"] ";
	}

}
