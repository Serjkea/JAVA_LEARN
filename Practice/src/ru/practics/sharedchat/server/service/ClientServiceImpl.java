package ru.practics.sharedchat.server.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import ru.practics.sharedchat.server.controller.ChatControllerImpl;

public class ClientServiceImpl extends Thread{
		
	private Socket client;
	private ChatControllerImpl chatController;
	
	private BufferedWriter out;
	private BufferedReader in;
		
	public ClientServiceImpl(ChatControllerImpl chatController, Socket client) {
		super();
		this.client = client;
		this.chatController = chatController;
	}
	
	@Override
	public void run() {
		try {
			out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String user = null;
			if ((((user = chatController.login(in, out)) != null)||((user = chatController.registration(in, out))) != null)) {
				System.out.println("OK");
				out.write("ok"+"\n");
				out.flush();
				chatController.restoreMessages(this);
				while(client.isConnected()) {
					String message = in.readLine();
					if (message != null) {
						if (message.equals(":exit")) {
							System.out.println(user + " is out!");
							chatController.saveMessages();	//TODO!!!
							chatController.removeClient(this);
						} else {
							System.out.println(user + ": " + message);
							chatController.sendMessage(user + ": " + message);
						}
					}
				}
			} 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public BufferedWriter getBufferedWriter() {
		try {
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out;
	}

}
