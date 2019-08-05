
public class Staff {
	
	private final int MAX_STAFF_COUNT = 5;
	private Worker[] staff = new Worker[MAX_STAFF_COUNT];
	public int current_staff_count = 0;
	
	Staff() {
		
	}
	
	public boolean addWorker(Worker worker) {
		if (current_staff_count < (MAX_STAFF_COUNT)) {
			this.staff[current_staff_count] = worker;
			current_staff_count++;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean delWorker(int workerId) {
		boolean delOK = false;
		Worker temp;
		for(int i=0; i<MAX_STAFF_COUNT; i++) {
			if (this.staff[i].getWorkerId() == workerId) {
				if (i == (MAX_STAFF_COUNT - 1)) {
					this.staff[i].clearWorker();
				} else {
					for(int j = i;j<MAX_STAFF_COUNT;j++) {
						this.staff[j] = this.staff[j+1];
					}
				}
				current_staff_count--;
				delOK = true;
			} else {
				delOK = false;
			}
		}
		return delOK;
	}
	
	public void getStaff() {
		for(Worker person : this.staff) {
			System.out.println(person.getWorkerId() + " : " +person.getFullName() + " " + person.getAge() + " " + person.getDepartment() + " " + person.getProfession() + " "  + person.getSalary());
		}
	}

}
