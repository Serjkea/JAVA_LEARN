
interface Iterator {
	boolean hasNext();
	Object next();
}

class Numbers {
	
	private Integer[] obj = new Integer[]{1,2,3};

	public Iterator createIterator() {
		return new ConcreteIterator();
	}
	
	private class ConcreteIterator implements Iterator{
	
		private int index;
	
		public boolean hasNext() {
			if(index < obj.length) return true;
			return false;
		}

		public Object next() {
			if(index < obj.length) return obj[index++];
			else return null;
		}
	}
}

public class IteratorPattern {
	
	public static void main(String[] args) {
		Numbers num = new Numbers();
		Iterator iterator = num.createIterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
