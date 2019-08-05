import java.util.*;

public class CollectionsS {
	
	public static class NewThread1 implements Runnable {
		
		private Thread t;
		
		NewThread1(String name) {
			t = new Thread(this, name);
//			t.setDaemon(true);
			t.start();
		}

		public void run() {
			try {
				System.out.println("Thread is started!");
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println(e.toString());
			}
			System.out.println("End!");
		}
		
	}	
	

	public static void main(String[] args) {
		List<Integer> ls = new ArrayList<Integer>();
		ls.add(100);
		ls.add(200);
		ls.add(300);
		ls.add(400);
		ls.add(500);
		System.out.println(ls.get(0));
		System.out.println(ls.get(1));
		System.out.println(ls.get(2));
		System.out.println(ls.get(3));
		System.out.println(ls.get(4));
		ListIterator<Integer> it = ls.listIterator();
		for (int i = 0; i < 5; i++) {
			System.out.println(it.next());
			System.out.println(it.hasNext());
			System.out.println(it.nextIndex());
		}
		List<Integer> lls = new LinkedList<Integer>();
		lls.add(101);
		lls.add(202);
		lls.add(303);
		lls.add(404);
		lls.add(505);
		System.out.println(lls.get(0));
		System.out.println(lls.get(1));
		System.out.println(lls.get(2));
		System.out.println(lls.get(3));
		System.out.println(lls.get(4));
		ListIterator<Integer> lit = lls.listIterator();
		for (int i = 0; i < 5; i++) {
			System.out.println(lit.next());
			System.out.println(lit.hasNext());
			System.out.println(lit.hasPrevious());
			System.out.println(lit.previousIndex());
			System.out.println(lit.nextIndex());
		}
		System.out.println("_______________________");
		Set<Integer> s = new HashSet<Integer>();
		s.add(100);
		s.add(105);
		s.add(103);
		s.add(102);
		s.add(101);
		System.out.println(s.hashCode());
		System.out.println(s.size());
		Iterator<Integer> sit = s.iterator();
		for (int i = 0; i < 5; i++) {
			System.out.println(sit.next());
			System.out.println(sit.hasNext());
		}
		Set<Integer> sl = new TreeSet<Integer>();
		sl.add(100);
		sl.add(105);
		sl.add(103);
		sl.add(102);
		sl.add(101);
		System.out.println(sl.contains(103));
		Iterator<Integer> slit = sl.iterator();
		for (int i = 0; i < 5; i++) {
			System.out.println(slit.next());
			System.out.println(slit.hasNext());
		}
		for (int i:sl) {
			System.out.println(i);
		}
		Map<Integer,Integer> m = new HashMap<Integer,Integer>();
		m.put(2, 100);
		m.put(3, 102);
		m.put(1, 104);
		m.put(4, 101);
		m.put(5, 103);
		System.out.println(m.size());
		System.out.println(m.isEmpty());
		System.out.println(m.entrySet());		
		System.out.println(m.get(2));		
		System.out.println(m.keySet());
		System.out.println(m.values());	
		Map<Integer,Integer> tm = new TreeMap<Integer,Integer>();
		tm.put(1, 101);
		tm.put(3, 100);
		tm.put(2, 102);
		tm.put(4, 104);
		tm.put(5, 103);
		System.out.println(tm.size());
		System.out.println(tm.isEmpty());
		System.out.println(tm.entrySet());
		System.out.println(tm.keySet());
		System.out.println(tm.values());
		System.out.println("_______________________");	
		Collections.sort(ls);
		for (int i:ls){
			System.out.println(i);
		}
		Collections.reverse(ls);
		for (int i:ls){
			System.out.println(i);
		}
		
		NewThread1 nt = new NewThread1("Demo");
		Thread t1 = Thread.currentThread();
		System.out.println(t1.getName());
		System.out.println(t1.isAlive());		
		System.out.println(t1.isDaemon());		
		System.out.println(t1.isInterrupted());		
		System.out.println(nt.toString());	
		System.out.println(nt.t.isAlive());	
		System.out.println(nt.t.getName());	
		System.out.println(nt.t.isAlive());		
		
//		MyException me = new MyException(3);
//		me.initCause(new MyException(5));
		
		try {
			System.out.println("Try");
			MyException me = new MyException(3);
			me.initCause(new MyException(5));
	//		throw new MyException(1);
			throw me;
		} catch (MyException e) {
			System.out.println(e.toString());
			System.out.println(e.getCause().toString());
		}
	}

}
