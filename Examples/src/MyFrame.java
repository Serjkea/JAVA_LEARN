import javax.swing.*;
import java.awt.event.*;

class MyFrame implements ActionListener {
	MyFrame(String text,int x,int y) {
		JFrame jfr=new JFrame("Window with button");
		jfr.setBounds(x, y, 360, 200);
		jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel jlb=new JLabel(text,JLabel.CENTER);
		jlb.setBounds(10, 10, 330, 100);
		JButton btn=new JButton("Affirmative");
		btn.setBounds(90,120,180,30);
		btn.addActionListener(this);
		jfr.setLayout(null);
		jfr.add(jlb);
		jfr.add(btn);
		jfr.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent AEobj) {
		System.exit(0);
	}

}
