import javax.swing.*;

public class TheBig {
	
	String name;
	TheSmall ID;
	
	TheBig (String name, int n) {
		this.name=name;
		ID=new TheSmall(n);
		ID.show();
	}
	
	String getName() {
		String txt="Object name: "+name+".\n";
		return txt;
	}
	
	class TheSmall {
		
		int[] code;
		
		TheSmall(int n) {
			code=new int[n];
			for (int i=0;i<code.length;i++) {
				code[i]=(int)(10*Math.random());
			}
		}
		
		String getCode() {
			String txt="Object code: |";
			for(int i=0;i<code.length;i++) {
				txt+=code[i]+"|";
			}
			return txt;
		}
		
		void show() {
			String txt=getName()+getCode();
			JOptionPane.showMessageDialog(null, txt);
		}
	}
}
