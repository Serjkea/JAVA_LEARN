import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MessageFrame implements ActionListener{
	
	private JFrame frame;
	JLabel message;
	JButton button;
	
	MessageFrame(String msg) {
		int width=350;
		int height=150;
		frame=new JFrame("Message...");
		frame.setBounds(400,300,width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		message=new JLabel("<html>"+msg.replace("\n","<br>")+"</html>",JLabel.LEFT);
		message.setBounds(20, 10, width-30, height/2-10);
		frame.add(message);
		button=new JButton("Readed!");
		button.setBounds(width/4, 3*height/5, width/2, height/6);
		button.setFocusPainted(false);
		button.addActionListener(this);
		frame.add(button);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		System.exit(0);
	}
	
	static void show(String txt) {
		new MessageFrame(txt);
	}

}
