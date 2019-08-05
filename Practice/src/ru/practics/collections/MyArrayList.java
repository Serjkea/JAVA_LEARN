package ru.practics.collections;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T>,Iterable<T> { 
	
	private int init_size = 8;
	private int size = 0;
	private Object[] array = new Object[init_size];
	private int pointer = 1;
	
	public MyArrayList() {
		this.size = init_size;
	}
	
	public MyArrayList(int size) {
		this.size = size;
		this.array = new Object[size];
	}

	@Override
	public void add(T item) {
		if (pointer == size) resize();
		array[pointer-1] = item;
		pointer++;
	}
	
	private void resize() {
		Object[] temp = array.clone();
		array = new Object[size+=init_size];
		for(int i=0; i<temp.length; i++) {
			array[i] = temp[i];
		}
	}

	@Override
	public T get(int index) {
		if (index < size) return (T) array[index];
		else return null;
	}

	@Override
	public void remove(int index) {
		for (int i=index+1; i<size;i++) {
			array[i-1] = array[i];
		}
		pointer--;
	}

	@Override
	public int size() {
		return pointer-1;
	}
	
	class MyIterator<T> implements Iterator<T> {
		
		private int ptr = 0;

		@Override
		public boolean hasNext() {
			return ptr < pointer - 1;
		}

		@Override
		public T next() {
			if (hasNext()) {
				return (T)array[ptr++];
			}
			return null;
		}

		@Override
		public void remove() {
		}
	}
	
	@Override
	public Iterator<T> iterator() {
		return new MyIterator<T>();
	}

}
