
public class S_unit {
	
	private int opcode;
	private int op1;
	private int op2;
	
	class ADD implements CalcInterface{
		
		ADD(int o1, int o2){
			op1 = o1;
			op2 = o2;
		}
		
		public int calc(){
			return op1 + op2;
		}
	}
	
	class SUB implements CalcInterface{
		
		SUB(int o1, int o2){
			op1 = o1;
			op2 = o2;
		}
		
		public int calc(){
			return op1 - op2;
		}
	}
	
	public void getCalc(int o1, int o2, int opcode) {
		this.opcode = opcode;
		switch(opcode){
		  case 0: System.out.println(new ADD(o1,o2).calc());
			      break;
		  case 1: System.out.println(new SUB(o1,o2).calc());
			      break;
		  case 2: System.out.println(new ADD(o1,o2).calc());
			      break;
		  default:;
		}
			
	}
	
	public static void main(String[] args) {
		new S_unit().getCalc(5, 10, 1);
	}

}
