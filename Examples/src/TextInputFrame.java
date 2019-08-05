import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextInputFrame implements ActionListener{
	
	private JFrame frame;
	JLabel enter;
	JTextField tf;
	JButton btYes;
	JButton btNo;
	private String name;
	
	TextInputFrame(String msg) {
		int width=300;
		int height=150;
		frame=new JFrame("Window for input name...");
		frame.setBounds(400,300,width,height);
		frame.setLayout(null);
		enter=new JLabel(msg,JLabel.LEFT);
		enter.setBounds(10,10,width-20,height/6);
		tf=new JTextField(frame.getWidth()-20);
		tf.setBounds(10,enter.getHeight()+5,enter.getWidth(),height/6);
		btYes=new JButton("OK");
		btYes.setBounds(10,height/2+10,(width-30)/2,height/6);
		btYes.setFocusPainted(false);
		btNo=new JButton("Close");
		btNo.setBounds((width-30)/2+18,height/2+10,(width-30)/2,height/6);
		btNo.setFocusPainted(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(enter);
		frame.add(tf);
		frame.add(btYes);
		frame.add(btNo);
		frame.setResizable(false);
		btYes.addActionListener(this);
		btNo.addActionListener(this);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String btName=ae.getActionCommand();
		if (btName.equalsIgnoreCase(btYes.getText())) {
			name=tf.getText();
			frame.setVisible(false);
			IntInputFrame.show("How old are you? Set youre age: ", name);
		}
		else System.exit(0);
	}
	
	static void show(String txt) {
		new TextInputFrame(txt);
	}

}
