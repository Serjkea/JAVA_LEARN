import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.*;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class GraphicsTest {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new DrawFrame(); 
				frame.setTitle("DrawFrame");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
		});
	}

}

class DrawFrame extends JFrame {

	DrawFrame() {
		add(new DrawComponent());
		pack();
		}
}

class DrawComponent extends JComponent {
	
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 400;
	
	public void paintComponent(Graphics2D g) {
		Graphics2D g2 = (Graphics2D)g;
		
		double leftX = 100;
		double topY = 100;
		double width = 200;
		double height = 150;
		Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
		g2.setPaint(Color.BLACK);
		g2.draw(rect);
		g2.fill(rect);
	}
	
	public Dimension getPrefferedSize() {
		return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
}
