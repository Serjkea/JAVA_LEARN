import javax.swing.*;

public class MakeChoice {

	public static void main(String[] args) {
         int number = Integer.parseInt(JOptionPane.showInputDialog("Enter a number:"));
         String text = number%2 == 0 ? "even" : "odd";
         JOptionPane.showMessageDialog(null, "You enter " + text + " number!");
	}

}
