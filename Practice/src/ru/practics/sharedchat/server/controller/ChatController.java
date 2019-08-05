package ru.practics.sharedchat.server.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import ru.practics.sharedchat.server.service.ClientServiceImpl;

public interface ChatController {
	
	public void loadConfig();
	public void saveConfig();
	public void startServer();
	public void stopServer();
	public String login(BufferedReader in, BufferedWriter out) throws IOException;
	public String registration(BufferedReader in, BufferedWriter out) throws IOException;
	public void loadUsersData();
	public void saveUsersData();
	public void sendMessage(String message);
	public void saveMessages();
	public void loadMessages();
	public void restoreMessages(ClientServiceImpl client);
	public void removeClient(ClientServiceImpl client);

}
