
public abstract class Person {
	
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name=name;
		this.age = age;
	}

	public abstract String getDescription();
	
	public String getName() {
		return this.name;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public boolean equals(Object otherObject) {
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (this.getClass() != otherObject.getClass()) return false;
		Person other = (Person)otherObject;
		return this.name.equals(other.name) && 
		       this.age == other.age;
	}
	
//	public int hashCore(){
//		return Objects.hash(name, age);
//	}
	
	public int hashCode() {
		return 7*new Integer(age).hashCode() + 11*name.hashCode();
	}
	
	public String toString() {
		return this.getClass().getName() + " [name="+name+"] [age="+age+"] ";
	}
}
