import java.awt.*;

import javax.swing.*;

public class ExampleGraphics {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new SimpleFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}

class SimpleFrame extends JFrame {
	SimpleFrame() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		setSize(d.width/4,d.height/6);
		pack();
		add(new MyComponent());
		StringBuilder sb;
	}
}

class MyComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawRect(50, 50, 300, 200);
		super.paintComponent(g2);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(400,300);
	}
	
}