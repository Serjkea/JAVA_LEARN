
interface Image {
	void display();
}

class RealImage implements Image {
	
	private String file;
	
	RealImage(String file) {
		this.file = file;
		load(file);
	}
	
	private void load(String file) {
		System.out.println("Load file " + file);
	}
	
	public void display() {
		System.out.println("Display " + this.file);
	}
}

class ProxyImage implements Image {
	
	private String file;
	private RealImage image;
	
	public ProxyImage(String file) {
		this.file = file;
	}
	
	public void display() {
		if(image == null) {
			image = new RealImage(file);
			System.out.println("Create image");
		}
		image.display();
	}
}

public class ProxyPattern {
	
	public static void main(String[] args) {
		Image image = new ProxyImage("myImage.jpg");
		image.display();
		System.out.println();
		image.display();		
	}

}
