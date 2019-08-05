package ru.practics.messenger.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ru.practics.messenger.database.MessageStorage;
import ru.practics.messenger.message.Message;

public class MessageServer {
	
	private final static int PORT = 4004; 
	
	private static ServerSocket server;
	private Socket client;

	private static List<String> storage = new ArrayList<String>();
	private static Map<String, String> users = new HashMap<String,String>();
	
	public MessageServer() {
		
	}
	
	private String login(BufferedReader in, BufferedWriter out) throws IOException {
		System.out.println("LOGIN");
		out.write("login:" + "\n");
		out.flush();
		String login = in.readLine();
		if(users.containsKey(login)) {
			out.write("password:" + "\n");
			out.flush();
			String password = in.readLine();
			if(users.get(login).equals(password)) {
				out.write("Welcome " + login + "\n");
				out.flush();
				return login;
			} else {
				out.write("Password is not correct!" + "\n");
				out.flush();
				return null;
			}
		} else {
			out.write("Login is not correct!" + "\n");
			out.flush();
		}
		return null;
	}
	
	private String registration(BufferedReader in, BufferedWriter out) throws IOException {
		System.out.println("REGISTRATION");
		out.write("login:" + "\n");
		out.flush();
		String login = in.readLine();
		if(!users.containsKey(login)) {
			out.write("password:" + "\n");
			out.flush();
			String password = in.readLine();
			out.write("repeat password:" + "\n");
			out.flush();
			while (!password.equals(in.readLine())) {
				out.write("incorrect password:" + "\n");
				out.flush();
			} 
			users.put(login, password);
			out.write("Welcome " + login + "\n");
			out.flush();
			return login;
		}
		return null;
	}
	
	public static void main(String[] args) {
		final MessageServer messageServer = new MessageServer();
		users.put("admin", "12345");
		try {
			server = new ServerSocket(PORT);
			System.out.println("Server was started!");
			ExecutorService executors = Executors.newFixedThreadPool(2);
			while(true) {
				final Socket client = server.accept();
				executors.submit( new Thread() {
					@Override 
					public void run() {
						try {
							BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
							BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
							String user = null;
							if ((((user = messageServer.login(in, out)) != null)||((user = messageServer.registration(in, out))) != null)) {
								System.out.println("OK");
								out.write("ok"+"\n");
								out.flush();
								while(client.isConnected()) {
									String message = in.readLine();
									if (message != null) {
										System.out.println(user + ": " + message);
										storage.add(new Date().toString() + " " + message);
									}
								}								
							} 
							out.close();
							in.close();
						} catch (IOException e) {
							e.printStackTrace();
						} 
					}
				});
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				server.close();
//				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
}
