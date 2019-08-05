
public class StaffDepartment {
	
	public static void main(String[] args) {
		Staff staff = new Staff();
		staff.addWorker(new Worker("Andy", "Smith", 25, 1, "engineer", 35000));
		staff.addWorker(new Worker("Mike", "Moonter", 22, 1, "designer", 45000));
		staff.addWorker(new Worker("Norman", "Bakes", 34, 2, "manager", 60000));
		staff.addWorker(new Worker("Fred", "Werny", 50, 3, "cook", 30000));
		staff.addWorker(new Worker("Sandy", "Noltan", 52, 3, "cleaner", 25000));
		staff.getStaff();
		staff.delWorker(5);
		staff.addWorker(new Worker("Michael", "Kinsly", 38, 2, "manager", 55000));	
		staff.getStaff();
		
	}

}
