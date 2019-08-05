import javax.swing.*;
public class CharArray {
	public static void main(String[] args) {
		int size = 2 + (int)(Math.random()*3);
		int n;
		char s='a';
		String text="Characters array:\n";
		char[][] symbs = new char[size][];
		for (int i=0;i<size;i++) {
			n=1+(int)(Math.random()*8);
			symbs[i]=new char[n];
		}
		for (int j=0;j<symbs.length;j++) {
			text+="\n| ";
			for (int k=0;k<symbs[j].length;k++) {
				symbs[j][k] = s;
				s++;
				text+=symbs[j][k]+" | ";
			}
		}
        JOptionPane.showMessageDialog(null, text);
	}

}
