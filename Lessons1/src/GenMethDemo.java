
public class GenMethDemo {
	static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
		for(int i=0;i<y.length;i++)
			if (x.equals(y[i])) return true;
		return false;
	}

	public static void main(String[] args) {
		Integer nums[] = {1,2,3,4,5};
		
		if(isIn(2, nums)) System.out.println("2 in nums[]");
		
		if(!isIn(7, nums)) System.out.println("7 not in nums[]");

		System.out.println();
		
		String str[] = {"One","Two","Three","Four","Five"};
		
		if(isIn("Two", str)) System.out.println("Two in str[]");

		if(!isIn("Seven", str)) System.out.println("Seven not in str[]");
	
	}

}
