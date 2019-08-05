import java.awt.*;
import javax.swing.*;

class SimpleFrame extends JFrame {
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public SimpleFrame() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
	//	pack();
		setSize(screenWidth/6,screenHeight/4);
	//	setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		setLocationByPlatform(true);
		
	//	setIconImage(img);
	}
}

class HelloComponent extends JComponent {
	
	public static final int MESSAGE_X = 75;
	public static final int MESSAGE_Y = 100;
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public void paintComponent(Graphics g) {
		g.drawString("Hello Component", MESSAGE_X, MESSAGE_Y);
	}
	
	public Dimension getPrefferedSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}

public class GraphicUserInterface {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run() {
				SimpleFrame frame = new SimpleFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("SizedFrame");
				frame.add(new HelloComponent());
				frame.setVisible(true);
			}
		});
	}
}
