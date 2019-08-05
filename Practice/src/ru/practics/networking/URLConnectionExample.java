package ru.practics.networking;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionExample {
	
	public static void main(String[] args) {
		try {
			
			URL url = new URL("https://yandex.ru");// Can be a local file "file:/c:/data/test.txt"
			URLConnection urlConnection = url.openConnection();
			InputStream input = urlConnection.getInputStream();
			DataInputStream dis = new DataInputStream(input);
			
			String data = dis.readLine();
			System.out.println(data);
			while(dis.available() != -1) {
				data = dis.readUTF();
				System.out.println(data);
			}
			input.close();
			dis.close();
			
/*			urlConnection.setDoOutput(true);// if we need POST request

			OutputStream out = urlConnection.getOutputStream();
			out.write("name".getBytes());
			out.flush();
			out.close();
*/			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
