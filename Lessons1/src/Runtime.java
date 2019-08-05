
public class Runtime {

	public static void main(String[] args) {

		try {
			ProcessBuilder proc = new ProcessBuilder("nedit");
			proc.start();
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}

}
