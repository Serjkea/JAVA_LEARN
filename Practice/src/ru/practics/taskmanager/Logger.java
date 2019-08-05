package ru.practics.taskmanager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
	
	private File filePath;
	private FileWriter fw;
	
	Logger(String path,String name) {
		filePath = new File(path+name+".log");
		try {
		fw = new FileWriter(filePath);
		fw.write("Welcome to TaskManager\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void write(String msg) {
		try {
			fw.append(msg + "\n");
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void stop() {
		try {
		fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
