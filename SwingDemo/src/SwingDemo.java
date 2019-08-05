import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class SwingDemo {

	JLabel jlab;
	
	SwingDemo() {
		
		JFrame jfrm = new JFrame("Swing Application");
		
		jfrm.setLayout(new FlowLayout());
		
		jfrm.setSize(250,125);
		
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jlab = new JLabel("Swing means powerful GUIs.");
		
		JButton jbut1 = new JButton("Button 1");
		JButton jbut2 = new JButton("Button 2");
		
		jbut1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				jlab.setText("Button 1 was pressed!");
			}
		});
	
		jbut2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				jlab.setText("Button 2 was pressed!");
			}
		});
		
		jfrm.add(jbut1);
		jfrm.add(jbut2);
		jfrm.add(jlab);
		
		jfrm.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SwingDemo();
			}
		});

	}

}
