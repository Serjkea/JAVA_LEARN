import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventDemo {

	JLabel jlab;
	PaintPanel pp;
		
	EventDemo() {
		JFrame jfrm = new JFrame("An Event Example");
	//	jfrm.setLayout(new FlowLayout());
		jfrm.setSize(200, 150);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	JButton jbtnAlpha = new JButton("Alpha");
	//	JButton jbtnBeta = new JButton("Beta");
	/*	jbtnAlpha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				jlab.setText("Alpha was pressed.");
			}
		});
		jbtnBeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				jlab.setText("Beta was pressed.");
			}
		});
		jfrm.add(jbtnAlpha);
		jfrm.add(jbtnBeta);
		
		jlab = new JLabel("Press a button.");
		
		jfrm.add(jlab);
	*/	
		pp = new PaintPanel();
		
		jfrm.add(pp);
		
		jfrm.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new EventDemo();
			}
		});
	}

}
