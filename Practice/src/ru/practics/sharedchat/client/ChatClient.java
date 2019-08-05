package ru.practics.sharedchat.client;

import java.io.IOException;
import java.net.Socket;

public interface ChatClient {
	
	public void loadConfig();
	public void saveConfig();
	public Socket getConnection() throws IOException;
	public void sendMessage(String message);
	public String getMessage();
	public void startChat();

}
