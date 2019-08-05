
public class SortExample {
	
	public static void main(String[] args) {
		Integer[] myarray_1 = {5,2,3,4,1};
		Integer[] myarray_2 = {5,2,3,4,1};
		Integer[] myarray_3 = {5,2,3,4,1,0,8,9,11,6,7,12,10,14,13,15};
		Selection.sort(myarray_1);
		Insertion.sort(myarray_2);
		Shell.sort(myarray_3);
		Shell.show(myarray_3);
	}

}
