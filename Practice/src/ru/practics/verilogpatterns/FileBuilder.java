package ru.practics.verilogpatterns;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileBuilder {
	
	private static FileWriter fw;
	private boolean fileExists = false;
	
	public FileBuilder(String path) throws IOException {
		fileExists = (new File(path).exists());
		fw = new FileWriter(path);
	}

	public void write(String text) throws IOException {
		fw.append(text + "\n");
		fw.flush();
	}
	
	public void close() throws IOException {
		fw.close();
	}
	
	

}
