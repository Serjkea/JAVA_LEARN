package ru.practics.messenger.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MessengerClient {
	
	private final static String HOSTNAME = "localhost";
	private final static int PORT = 4004;
	
	private static Socket connection;
	private static BufferedReader in;
	private static BufferedWriter out;
	
	private static boolean isLogin = false;
	
	private static Socket getConnection(String host, int port) throws UnknownHostException, IOException {
		Socket conn = new Socket(host, port);
		in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
		Scanner scanner = new Scanner(System.in);
		while (!isLogin) {
			String msg = in.readLine();
			if (msg.equals("ok")) {
				isLogin = true;
			} else if (msg.equals("login:") || msg.equals("password:") || msg.equals("repeat password:")) {
			   System.out.println(msg);
			   out.write(scanner.nextLine() + "\n");
			   out.flush();
			}
		}
		return conn;
	}
	
	
	
	public static void main(String[] args) {
		try {
			connection = getConnection(HOSTNAME,PORT);
			System.out.println("Connected");
			
			ExecutorService executors = Executors.newFixedThreadPool(2);
			Future future = executors.submit(
			new Thread() {
				@Override
				public void run() {
					System.out.println("Enter your message: ");
					Scanner scanner = new Scanner(System.in);
					try {
//						out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
						while (true) {
							String message = scanner.nextLine();
							if (message.equals(":exit")) {
								break;
							} else if (message != null) {
								out.write(message + "\n");
								out.flush();
							}
						}
						if (connection.isConnected()) { 
							out.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					} 					
				}
			});
			
			executors.submit(
			new Thread() {
				@Override
				public void run() {
					try {
//						in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
						while(connection.isConnected()){
							String tmp = in.readLine();
							if (tmp != null) {
								System.out.println(in.readLine());
							}
						}
						if (connection.isConnected()) { 
							in.close();
						}
					} catch (SocketException e) {
						
					} catch (IOException e) {
						e.printStackTrace();
					} 
				}
			});
			
			while(!future.isDone());
			executors.shutdown();
			if (connection.isConnected()) {
				connection.close();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection.isConnected()) {
					in.close();
					out.close();
					connection.close();
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	


}
