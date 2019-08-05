
public class BoundedWildcard {
	static void showXY(Coords<?> c) {
		System.out.println("Coords X Y: ");
		for(int i=0; i<c.coords.length; i++) {
			System.out.println(c.coords[i].x + " " + c.coords[i].y);
			System.out.println();
		}
	}
	
	static void showXYZ(Coords<? extends ThreeD> c) {
		System.out.println("Coords X Y Z:");
		for(int i=0;i<c.coords.length;i++)
			System.out.println(c.coords[i].x + " " + c.coords[i].y + " " + c.coords[i].z);
		System.out.println();
	}
	
	static void showXYZT(Coords<? extends FourD> c) {
		System.out.println("Coords X Y Z T:");
		for(int i=0;i<c.coords.length;i++)
			System.out.println(c.coords[i].x + " " + c.coords[i].y + " " + c.coords[i].z + " " + c.coords[i].t);
		System.out.println();
	}
	
	public static void main(String args[]) {
		TwoD td[] = {
				new TwoD(0,0),
				new TwoD(7,4),
				new TwoD(10,1),
				new TwoD(-5,-14)
		};
		
		Coords<TwoD> tdlocs = new Coords<TwoD>(td);
		
		showXY(tdlocs);
//		showXYZ(tdlocs);
//		showXYZT(tdlocs);
		
		FourD fd[] = {
				new FourD(1,2,3,5),
				new FourD(-5,2,1,4),
				new FourD(7,5,-3,5),
				new FourD(-8,2,6,4)
		};
		
		Coords<FourD> fdlocs = new Coords<FourD>(fd);
		
		showXY(fdlocs);
		showXYZ(fdlocs);
		showXYZT(fdlocs);
		
		
	}

}
