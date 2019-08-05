
public class MementoPattern {

	private String description;
	private int code;
//------------------------MEMENTO----------------------------//
	private Memento undo;
	
	class Memento {
		
		String descriptionTemp;
		int codeTemp;
		
		Memento() {
			descriptionTemp = description;
			codeTemp = code;
		}
		
		String getDescription() {
			return descriptionTemp;
		}
		
		int getCode() {
			return codeTemp;
		}
		
	}
	
	public void preview() {
		undo = new Memento();
	}
	
	public void undoChanges() {
		description = undo.descriptionTemp;
		code = undo.codeTemp;
	}
	
//------------------------------------------------------------//	
	
	public void setChanges(String desc, int c) {
		description = desc;
		code = c;
	}
	
	public void getDescription() {
		System.out.println(description);
	}
	
	public void getCode() {
		System.out.println(code);
	}
	
	MementoPattern(String desc, int c) {
		description = desc;
		code = c;
	}
	
	public static void main(String[] args) {
		MementoPattern mp = new MementoPattern("Hello", 500);
		mp.preview();
		mp.getDescription();
		mp.getCode();
		mp.setChanges("Bye", 200);
		mp.getDescription();
		mp.getCode();
		mp.undoChanges();
		mp.getDescription();
		mp.getCode();
	}
	
}
