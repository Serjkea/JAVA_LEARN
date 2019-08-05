package ru.practics.sharedchat.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ChatClientImpl implements ChatClient{

	private final static String CONFIG_PATH = "/home/kostenko/New/Practice/bin/ru/practics/sharedchat/client/config/config.properties";
	private Properties properties;
	private Socket connection;
	
	public ChatClientImpl() {
		loadConfig();
		startChat();
	}
	
	private static boolean isLogin = false;
	private BufferedReader in;
	private BufferedWriter out;
	
	@Override
	public void loadConfig() {
		File file = new File(CONFIG_PATH);
		properties = new Properties();
		if (file.exists()) {
			try {
				properties.load(new FileInputStream(file));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			properties.put("host","localhost");  // Load default configuration
			properties.put("port","4004");  
			saveConfig();
		}
		
	}

	@Override
	public void saveConfig() {
		try {
			FileOutputStream fos = new FileOutputStream(CONFIG_PATH);
			properties.store(fos, "");
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public Socket getConnection() throws IOException {
		Socket conn = new Socket(properties.getProperty("host"),Integer.parseInt(properties.getProperty("port")));
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

	@Override
	public void sendMessage(String message) {
		
	}

	@Override
	public String getMessage() {
		
		return null;
	}
	
	@Override
	public void startChat() {
		try {
			connection = getConnection();
			System.out.println("Connected to server!");
			ExecutorService executors = Executors.newFixedThreadPool(2);
			Future future = executors.submit(new Thread() {
				@Override
				public void run() {
					System.out.println("Enter your message: ");
					Scanner scanner = new Scanner(System.in);
					try {
						while (true) {
							String message = scanner.nextLine();
							if (message.equals(":exit")) {
								out.write(message + "\n");
								out.flush();								
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
			executors.submit(new Thread() {
				@Override
				public void run() {
					try {
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		ChatClient client = new ChatClientImpl();
	}
	

}
