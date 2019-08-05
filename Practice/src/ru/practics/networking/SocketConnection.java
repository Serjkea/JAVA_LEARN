package ru.practics.networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketConnection {
	
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("yandex.ru", 80);
			
			OutputStream out = socket.getOutputStream();
			out.write("hello".getBytes());
			out.flush();
			out.close();
			
			InputStream in = socket.getInputStream();
			int data = in.read();
			in.close();
			
			socket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
