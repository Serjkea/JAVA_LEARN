import javax.swing.*;

public class Fellow {
	String name;
	String surname;
	int age;
	double weight;
	
	Fellow(String name,String surname, int age, double weight) {
		this.name=name;
		this.surname=surname;
		this.age=age;
		this.weight=weight;
		show();
	}
	
	void show() {
		String str="Name: "+name+"\n"+"Surname: "+surname+"\n"+"Age: "+age+"\n"+"Weight: "+weight;
		JOptionPane.showMessageDialog(null, str);
	}
}
