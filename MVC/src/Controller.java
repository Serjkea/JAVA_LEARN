
public class Controller implements IController{
	
	private IModel model;
	private IView view;
	
	Controller() {
	}
	
	public void setModel(IModel model){
		this.model = model;
	}
	
	public void setView(IView view) {
		this.view = view;
	}
	
	public void addPeople(People people) {
		model.addPeople(people);
	}
	
	public People getPeople(int id){
		return model.getPeople(id);
	}
	
	public String getAllPeoples() {
		return model.getAllPeoples();
	}

}
