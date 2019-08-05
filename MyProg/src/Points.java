
public class Points {

	public static void main(String[] args) {
		int i,j;
		
		outer: for (i=0; i<10; i++) {
			System.out.println();
			for (j=0; j<10; j++) {
//				System.out.print(j + " ");
				if (j>i) {
		//			System.out.println();
					continue outer;
				}
				System.out.print(i*j + " ");
			}
		}


	}

}
