import javax.swing.*;
public class NewSimpleArray {
	public static void main(String[] args) {
		int row,col;
		row = Integer.parseInt(JOptionPane.showInputDialog("Number of rows: "));
		col = Integer.parseInt(JOptionPane.showInputDialog("Number of columns: "));
		String text = "Result array:\n";
		int[][] myArray = new int [row][col];
		for (int i=0;i<row;i++) {
			text += "\n";
			for (int j=0; j<col; j++) {
				myArray[i][j] = (int)(10*Math.random());
				text += myArray[i][j] + " ";
			}
		}
		JOptionPane.showMessageDialog(null, text);
	}

}
