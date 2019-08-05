import javax.swing.*;
public class UsingSwitch {

	public static void main(String[] args) {
        int num;
        String str;
        String text = JOptionPane.showInputDialog("Enter a number:");
        num = Integer.parseInt(text);
        switch (num) {
        case 0: str = "You enter 0";
                break;
        case 1:
        case 3:
        case 5:
        case 7:
        case 9: str = "Simple number";
                break;
        case 2:
        case 4:
        case 6:
        case 8:
        case 10: str = "Even number";
                 break;
        default: str = "Bad number";
        }
        JOptionPane.showMessageDialog(null, str);
	}

}
