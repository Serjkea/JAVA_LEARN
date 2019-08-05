import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;


public class AbstractClasses {
	
	public static void main(String[] args) {
		
		Person[] p = new Person[2];
		p[0] = new Student("Sergio Novak",25,"Engineer");
		p[1] = new Worker("Mike Loyud",35,50000.00);
		Student student = (Student)p[0];
		Worker worker = (Worker)p[1];

		System.out.println(p[0].getDescription());
		System.out.println(p[1].getDescription());
		student.changeMajor("Economy");
		worker.setSalary(85000.00);
		System.out.println(p[0].getDescription());
		System.out.println(p[1].getDescription());
		
		Object object = new Student("Sergio Novak",25,"Economy");
		System.out.println(object.equals(student));
		System.out.println(object.hashCode());
		System.out.println(object.toString());
		System.out.println(object.getClass());
		System.out.println(p[0]);
		System.out.println(p[1]);
		System.out.println(student);
		System.out.println(worker);
		
		ArrayList<Person> staff = new ArrayList<Person>();
		staff.add(new Student("Sergio Novak1",25,"Engineer"));
		staff.add(new Worker("Mike Loyud2",35,50000.00));
		System.out.println(staff.size());
		System.out.println(staff.toString());
		staff.set(0, new Student("Garry Hoster1",25,"Economy"));
		System.out.println(staff.toString());
		System.out.println(staff.get(1));
		Student s = student;
		Worker w = worker;
		for(Person pers : staff) {
			if (pers instanceof Student) s = (Student)pers;
			else if (pers instanceof Worker) w = (Worker)pers;
			else {
				System.out.println("Fault");
			}
		}
		System.out.println(s);
		System.out.println(w);
		try {
		Class c = s.getClass();
		Constructor constr = c.getConstructor();
		System.out.println(constr.getAnnotations());
		Field f = c.getDeclaredField("major");
		f.setAccessible(true);
		Object v = f.get(s);
		System.out.println(v);
		System.out.println(Modifier.toString(f.getModifiers()));		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
