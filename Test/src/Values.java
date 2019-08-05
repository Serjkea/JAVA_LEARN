
public class Values {
	private int[] vals;	
	
	Values (int... x) {
		vals = x;		
		System.out.println("Number of values is " + vals.length);
	}
	
	Values () {
		vals = null;
		System.out.println("Number of values is NULL");
	}
	
	public void changeValue(int pos, int val) {
		if (pos > vals.length) System.out.println("Error! No value in this position");
		else vals[pos] = val;
	}
	
	public void getLength() {
		System.out.println("Number of values is " + vals.length);
	}
	
	public void getVals(){
		for (int i=0; i<vals.length; i++)
		System.out.print(vals[i] + " ");
	}
	
	

}
