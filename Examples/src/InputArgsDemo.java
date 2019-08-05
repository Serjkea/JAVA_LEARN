
public class InputArgsDemo {

	public static void main(String[] args) {
		String name=args[0];
		String surname=args[1];
		int age=Integer.parseInt(args[2]);
		double weight=Double.parseDouble(args[3]);
		new Fellow(name,surname,age,weight);
	}

}
