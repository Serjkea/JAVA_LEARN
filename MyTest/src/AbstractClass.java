
public abstract class AbstractClass {
	
	int x;
	public int y;
	private int z;
	
	public AbstractClass(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void printMethod(){
		System.out.println("Print Method!" + x + y + z);
	}
	
	

}
