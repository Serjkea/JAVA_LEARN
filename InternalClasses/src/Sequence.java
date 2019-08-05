import java.util.Random;


class StringStore {
	
	private String str;
	
	StringStore(String str) {
		this.str = str;
	}
	
	public String toString() {
		return str;
	}
	
}

public class Sequence {
	
	private Object[] items;
	private int next = 0;
	
	public Sequence(int size) {
		items = new Object[size];
	}
	
	public void add(Object x) {
		if(next < items.length) {
			items[next++] = x;
		}
	}
	
	private class SequenceSelector implements Selector {

		private int i = 0;

		public boolean end() {
			return i == items.length;
		}

		public Object current() {
			return items[i];
		}

		public void next() {
			if(i < items.length) {
				i++;
			}
		}
		
		public Sequence getSequence() {
			return Sequence.this;
		}
	}
	
	public Selector selector(){
		return new SequenceSelector();
	}
	
	public static void main(String[] args) {
		Sequence sequence = new Sequence(10);
		for(int i = 0; i < 10; i++) {
			sequence.add(new Random().nextInt(10));
		}
		Selector selector = sequence.selector();
		while(!selector.end()){
			System.out.println(selector.current() + " ");
			selector.next();
		}
		Sequence stringSequence = new Sequence(5);
		for(int i = 0; i < 5; i++){
			stringSequence.add(new StringStore("my string " + i));
		}
		Selector stringSelector = stringSequence.selector();
		while(!stringSelector.end()){
			System.out.println(stringSelector.current() + " ");
			stringSelector.next();
		}
		System.out.println(((SequenceSelector)stringSelector).getSequence());
		OuterClass.InnerClass obj = new OuterClass().new InnerClass();
		obj.pubPrintInner();
		System.out.println(obj.getClass());
	}

}
