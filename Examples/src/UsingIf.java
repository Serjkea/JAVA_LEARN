import javax.swing.*;

public class UsingIf {

	public static void main(String[] args) {
    
		double x,y;
		String title = "Sub numbers";
		String text = "Result: ";
		x = Double.parseDouble(JOptionPane.showInputDialog("Enter first number:"));
		y = Double.parseDouble(JOptionPane.showInputDialog("Enter second number: "));
		if (y!=0) {
			JOptionPane.showMessageDialog(null, text + x/y,title,JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, text + "Error!",title,JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
