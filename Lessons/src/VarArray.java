
public class VarArray {

	public void vaTest(int ... v) {
		System.out.println(" Arguments count: " + v.length + " Values: ");
		for (int x : v)
			System.out.print(x + " ");
		System.out.println();
	}
}
