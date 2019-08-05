
public class SynchThreadDemo {

	public static void main(String[] args) throws InterruptedException{

		MyNewClass obj=new MyNewClass();
		MyNewThread thA=new MyNewThread(true,obj);
		MyNewThread thB=new MyNewThread(false,obj);
		thA.join();
		thB.join();
		System.out.print("End: ");
		obj.get("");

	}

}
