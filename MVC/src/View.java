
public class View implements IView{
	
	private IModel model;
	private IController controller;
	private String str;
	
	View() {
	}
	
	public void setModel(IModel model) {
		this.model = model;
	}
	
	public void setController(IController controller) {
		this.controller = controller;
	}
	
	public void change() {
		str = model.getAllPeoples();
	}
	
	public void show() {
		System.out.println(str);
	}

}
