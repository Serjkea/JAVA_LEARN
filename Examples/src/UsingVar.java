import javax.swing.*;

public class UsingVar {

	public static void main(String[] args) {
	    String name = "Ivanov Ivan Ivanovich";
	    int age = 50;
	    char category = 'B';
	    String text = "Driver: " + name + "\n" + "Age: " + age + "\n" + "Category: " + category;
	    JOptionPane.showMessageDialog(null, text);
	}

}
