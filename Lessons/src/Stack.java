
public class Stack {
    private int stck[] = new int[10];
    private int tos;
    
    Stack(int size){
    	stck = new int[size];
    	tos = -1;
    }
	
    void push(int item) {
    	if (tos==stck.length-1) 
    		System.out.println("Stack is full!");
    	else 
    		stck[++tos] = item;
    }
	
    int pop() {
    	if (tos < 0) {
    		System.out.println("Stack is not load!");
    		return 0;
    	}
    	else
    		return stck[tos--];
    }
}
