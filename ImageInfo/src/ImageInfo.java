import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class ImageInfo {
	
	public final static String FILEPATH = "/home/kostenko/Projects/Java/img/test.jpg";
	
	public static void main(String[] args) {
		FileInputStream fin = null;
		try {
			fin = new FileInputStream(FILEPATH);
			System.out.printf("File size: %d bytes \n", fin.available());
			System.out.println("File data:");
			byte[] buffer = new byte[fin.available()];
			fin.read(buffer,0,buffer.length);
			for(int i = 0; i<100; i++) {
				System.out.printf("%x",buffer[i]);
				if((i > 0) && (i % 16 == 0)) System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
