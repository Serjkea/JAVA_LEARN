import javax.swing.*;
public class UsingWhile {

	public static void main(String[] args) {
		
		int count;
		int i=1, j=1, sum1=0, sum2=0;
		count = Integer.parseInt(JOptionPane.showInputDialog("Enter number:"));
		String title = "Using While";
		String str1 = "Operator while: ";
		String str2 = "Operator do-while: ";
		while (i <= count) {
			sum1+=i;
			i++;
		}
		do {
			sum2+=j;
			j++;
		} while (j <= count);
		str1+=sum1;
		str2+=sum2;
		JOptionPane.showMessageDialog(null,str1 + "\n" + str2,title,JOptionPane.PLAIN_MESSAGE);
	}

}
