
public class StackArray {

	private int maxSize;
	private int top;
	private char[] stack;
	
	StackArray (int size) {
		maxSize = size;
		stack = new char[maxSize];
		top = -1;
	}
	
	public void push(char a) {
		stack[++top] = a;
	}
	
	public char pop() {
		return stack[top--];
	}
	
	public char peek() {
		if (top != -1) return stack[top];
		else return '0';
	}
	
	public boolean isEmpty() {
		return (top==-1);
	}
	
	public boolean isFull() {
		return (top==maxSize-1);
	}
	
}
