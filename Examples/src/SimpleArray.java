import javax.swing.*;
public class SimpleArray {
	public static void main(String[] args) {
		int i,size;
		size = Integer.parseInt(JOptionPane.showInputDialog("Enter a size of array:"));
		String text = "Array of:\n";
		int[] myArray = new int[size];
		for (i=0;i<size;i++){
			myArray[i] = 2*i+1;
			text += myArray[i] + " "; 
		}
		JOptionPane.showMessageDialog(null, text);
	}

}
