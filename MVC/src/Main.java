
public class Main {
	
	public static void main(String[] args) {
		View view = new View();		
		Model model = new Model();
		Controller controller = new Controller();
		view.setController(controller);
		view.setModel(model);
		model.setView(view);
		controller.setModel(model);
		controller.setView(view);
		controller.addPeople(new People("Mike","Olban",new BirthDate(12,4,1984),"male","programmer"));
		controller.addPeople(new People("Bob","Danse",new BirthDate(2,12,1980),"male","engineer"));
		controller.addPeople(new People("Nik","Nokda",new BirthDate(21,5,1994),"male","medic"));
		controller.addPeople(new People("Rob","Virst",new BirthDate(17,9,1985),"male","driver"));
		controller.addPeople(new People("John","Brown",new BirthDate(6,10,1974),"male","engineer"));
		System.out.println(controller.getAllPeoples());
		System.out.println();
		System.out.println(controller.getPeople(2));
		System.out.println();
		view.show();
		
	}

}
