import javax.swing.*;
public class NewFrame {
	
	NewFrame() {
		JFrame MyFrame=new JFrame("New window");
		MyFrame.setSize(300,200);
		MyFrame.setBounds(400, 250, 400, 250);
		MyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icn=new ImageIcon();
		JLabel jlb=new JLabel("Hello there!",JLabel.CENTER);
		MyFrame.add(jlb);
		MyFrame.setVisible(true);
	}

}
