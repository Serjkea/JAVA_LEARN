import javax.swing.*;

public class WhatIsYourName {

	public static void main(String[] args) {
       String name;
       name = JOptionPane.showInputDialog("Hello! What's your name?");
       JOptionPane.showMessageDialog(null, "Nice to meet you, " + name + "!");
	}

}
