import java.io.*;

public class FileWork {
	
	void Init(){
	String value = null;
	
	BufferedReader bufferedReader=null;
	
	try {
		FileReader fileReader = new FileReader("index.html");	
		bufferedReader = new BufferedReader(fileReader);
		while ((value = bufferedReader.readLine()) != null){
			System.out.println(value);
		}
	}
	catch (FileNotFoundException ex) {
		System.out.println("Unable to open file!");
	}
	catch (IOException ex) {
		System.out.println("Error reading file!");
	}
	finally {
		try {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}
		catch (IOException e) {
			
		}
	}
	}
}	

