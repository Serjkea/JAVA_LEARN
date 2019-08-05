
public class Shell {
	
	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j){
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static boolean isSorted(Comparable[] a) {
		for(int i=1; i<a.length; i++) {
			if (less(a[i],a[i-1])) return false;
		} return true;
	}
	
	public static void sort(Comparable[] a) {
		int h = 1;
		while (h < a.length/3) h = 3*h + 1;
		while (h >= 1) {
			for (int i=h;i<a.length;i++) {
				for (int j=i;j>=h && less(a[j],a[j-h]);j-=h) exch(a,j,j-h);
			}
			h = h/3;
		}
	}
	
	public static void show(Comparable[] a) {
		for(int i=0; i<a.length;i++) {
			System.out.print(a[i] + " ");
		}
	}

}
