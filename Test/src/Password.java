
public class Password {

	final static String password = "14967";
	
	public static void main(String[] args) {
		
//		long counter = 0;
		char[] chars = null;
		boolean ok = false;

		for (char a=33;a<127;a++) {
			for (char b=33;b<127;b++) {
				for (char c=33;c<127;c++) {			
					for (char d=33;d<127;d++) {			
						for (char e=33;e<127;e++) {		
//							counter++;
//							System.out.println(counter);
							String mypass = new String();	
							mypass = Character.toString(a)+Character.toString(b)+Character.toString(c)+Character.toString(d)+Character.toString(e);
							if (password.equals(mypass)) {
							System.out.println("Password was found: " + mypass);
							ok = true;
							break;
							}
					    }
						if (ok) break;
				    }
					if (ok) break;
				}
				if (ok) break;
			}
			if (ok) break;
		}
		System.out.println("Succesfully!!!");
	}

}
