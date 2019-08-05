import java.util.*;

public class Gerbil {
	
	private int gerbilNumber;
	
	Gerbil(int i) {
		gerbilNumber = i;
	}
	
	public void hop() {
		System.out.println("Gerbil number: " + gerbilNumber);
	}
	
	public static void main(String... args) {
		ArrayList<Gerbil> gerbil = new ArrayList<Gerbil>();
		gerbil.add(new Gerbil(5));
		gerbil.add(new Gerbil(10));
		gerbil.add(new Gerbil(20));
		for(int i=0;i<gerbil.size();i++){
			gerbil.get(i).hop();
		}
		for(Gerbil g: gerbil) {
			g.hop();
		}
		Set<Integer> c = new HashSet<Integer>();
		c.add(1);
		c.add(2);
		c.add(2);
		for(Integer i:c){
			System.out.println(i);
		}
	}
	
	

}
