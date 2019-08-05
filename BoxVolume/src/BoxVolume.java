
public class BoxVolume {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BoxWeight mybox1 = new BoxWeight(10, 20, 15, 32.3);
		BoxWeight mybox2 = new BoxWeight(2, 3, 4, 0.075);
		BoxWeight mybox3 = new BoxWeight();
		BoxWeight mycube = new BoxWeight(3,2);
		BoxWeight clone1 = new BoxWeight(mybox1);
		
        System.out.println("MyBox1 Volume: " + mybox1.volume());
        System.out.println("MyBox1 Weight: " + mybox1.weight);
        System.out.println();
        System.out.println("MyBox2 Volume: " + mybox2.volume());
        System.out.println("MyBox2 Weight: " + mybox2.weight);
        System.out.println();
        System.out.println("MyBox3 Volume: " + mybox3.volume());
        System.out.println("MyBox3 Weight: " + mybox3.weight);
        System.out.println();
        System.out.println("MyCube Volume: " + mycube.volume());
        System.out.println("MyCube Weight: " + mycube.weight);
        System.out.println();
        System.out.println("Clone1 Volume: " + clone1.volume());
        System.out.println("Clone1 Weight: " + clone1.weight);
        System.out.println();
		
	}

}
