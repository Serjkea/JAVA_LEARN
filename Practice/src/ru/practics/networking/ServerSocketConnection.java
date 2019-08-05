package ru.practics.networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketConnection {
	
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(9000);
			
			boolean isStopped = false;
			while(!isStopped) {
				Socket clientSocket = serverSocket.accept();
				
				clientSocket.close();
			}
			
			serverSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
