package ru.practics.sharedchat.server.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import ru.practics.sharedchat.server.service.ClientServiceImpl;
import ru.practics.sharedchat.server.user.User;

public class ChatControllerImpl implements ChatController {
	
	private static ChatController chatController;
	
	private ChatControllerImpl() {
		loadConfig();
		loadUsersData();
		loadMessages();
		startServer();
	}
	
	public static ChatController getChatController() {
		if (chatController == null) {
			chatController = new ChatControllerImpl();
		} return chatController;
	}
	
	private final static String CONFIG_PATH = "/home/kostenko/New/Practice/bin/ru/practics/sharedchat/server/config/config.properties";
	private final static String USERS_PATH = "/home/kostenko/New/Practice/bin/ru/practics/sharedchat/server/database/users.db";
	private final static String MSGS_PATH = "/home/kostenko/New/Practice/bin/ru/practics/sharedchat/server/database/messages.db";
	
	private Properties properties;
	private ServerSocket serverSocket;
	private Socket client;
		
	private static ArrayList<User> users = new ArrayList<User>();
	private static ArrayList<String> messages = new ArrayList<String>();
	private static ArrayList<ClientServiceImpl> clients = new ArrayList<ClientServiceImpl>();
	
	private Lock lock = new ReentrantLock();
	
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
			properties.put("port","4004");  // Load default configuration
			saveConfig();
		}
	}
	
	@Override
	public void loadUsersData() {
		File file = new File(USERS_PATH);
		if (file.exists()) {
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			try {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				while (fis.available() > 0) {
					User tmpUser = (User) ois.readObject();
					users.add(tmpUser);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					fis.close();
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	@Override
	public void saveUsersData() {
		File file = new File(USERS_PATH);
		if (file.exists()) {
			ObjectOutputStream oos = null;
			try {
				oos = new ObjectOutputStream(new FileOutputStream(file));
				for(User tmpUser: users) {
					tmpUser.isLogin = false;
					oos.writeObject(tmpUser);
				}
				oos.flush();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			ObjectOutputStream oos = null;
			try {
				file.createNewFile();
				oos = new ObjectOutputStream(new FileOutputStream(file));
				for(User tmpUser: users) {
					tmpUser.isLogin = false;
					oos.writeObject(tmpUser);
				}
				oos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void saveConfig() {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(CONFIG_PATH);
			properties.store(fos, "");
			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void startServer() {
		try {
			serverSocket = new ServerSocket(Integer.parseInt(properties.getProperty("port")));
			System.out.println("Server was started!");
			while(true) {
				client = serverSocket.accept();
				ClientServiceImpl clientService = new ClientServiceImpl(this, client);
				clients.add(clientService);
				clientService.start();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			stopServer();
		}
		
	}

	@Override
	public void stopServer() {
		try {
			saveUsersData();
			saveMessages();
			serverSocket.close();
			System.out.println("Server was stopped!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String login(BufferedReader in, BufferedWriter out) throws IOException {
		System.out.println("LOGIN");
		out.write("login:" + "\n");
		out.flush();
		String login = in.readLine();
		for(User user: users) {
			if (user.getName().equals(login)) {
				out.write("password:" + "\n");
				out.flush();
				String password = in.readLine();
				if (user.getPassword().equals(password)) {
					user.isLogin = true;
					out.write("Welcome " + login + "\n");
					out.flush();
					return login;
				} else {
					out.write("Password is not correct!" + "\n");
					out.flush();
					return null;	//TODO!!!
				}
			}
		} 
		out.write("Login is not correct!" + "\n");
		out.flush();
		return null;
	}
	
	public String registration(BufferedReader in, BufferedWriter out) throws IOException {
		System.out.println("REGISTRATION");
		out.write("Registration" + "\n");
		out.flush();
		boolean isRegistered = false;
		boolean isExist = false;
		while(!isRegistered) {
			out.write("login:" + "\n");
			out.flush();
			String login = in.readLine();
			isRegistered = false;
			isExist = false;
			for(User user: users) {
				if (user.getName().equals(login)) {
					out.write("Login already exists!" + "\n");
					out.flush();
					isExist = true;
					break;
				} 
			}
			if (isExist) {
				continue;
			} else {
				out.write("password:" + "\n");
				out.flush();
				String password = in.readLine();
				users.add(new User(login, password));
				isRegistered = true;
				saveUsersData();		
				out.write("Welcome " + login + "\n");
				out.flush();
				return login;
//				out.write("repeat password:" + "\n");//TODO!!!
//				out.flush();
			}
		}
		return null;
	}

	@Override
	public void sendMessage(String message) {
		lock.lock();
		messages.add(message);	
		try {
			for (ClientServiceImpl receiver: clients) {
				BufferedWriter out = receiver.getBufferedWriter();
				out.newLine();
				out.write(message + "\n");
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		lock.unlock();
	}

	@Override
	public void saveMessages() {
		lock.lock();
		File file = new File(MSGS_PATH);
		if (file.exists()) {
			DataOutputStream dos = null;
			try {
				dos = new DataOutputStream(new FileOutputStream(file));
				for (String msg: messages) {
					dos.writeUTF(msg);
					dos.flush();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		lock.unlock();
	}

	@Override
	public void loadMessages() {
		File file = new File(MSGS_PATH);
		if (file.exists()) {
			DataInputStream dis = null;
			try {
				dis = new DataInputStream(new FileInputStream(file));
				while (dis.available() > 0) {
					String str = dis.readUTF();
					messages.add(str);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void restoreMessages(ClientServiceImpl client) {
		try {
			BufferedWriter out = client.getBufferedWriter();
			for(String message: messages) {
				out.newLine();
				out.write(message + "\n");
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	@Override
	public void removeClient(ClientServiceImpl client) {
		lock.lock();
		clients.remove(client);
		clients.trimToSize();
		lock.unlock();
	}
	
}
