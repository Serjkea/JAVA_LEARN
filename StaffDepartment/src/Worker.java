
public class Worker extends People{
	
	private int department;
	private String profession;
	private double salary;
	private static int id = 0;
	private int workerId;
	
	Worker(String name, String surname, int age, int department, String profession, double salary) {
		super(name, surname, age);
		this.department = department;
		this.profession = profession;
		this.salary = salary;
		this.workerId = ++id;
	}
	
	public void setDepartment(int department) {
		this.department = department;
	}
	
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	public void setSalary(Double salary){
		this.salary = salary;
	}
	
	public int getDepartment(){
		return this.department;
	}
	
	public String getProfession(){
		return this.profession;
	}
	
	public double getSalary(){
		return this.salary;
	}
	
	public int getWorkerId(){
		return this.workerId;
	}
	
	public void clearWorker() {
		this.setName(" ");
		this.setSurname(" ");	
		this.setAge(0);
		this.setDepartment(0);
		this.setProfession(" ");
		this.setSalary(0.0);
	}

}
