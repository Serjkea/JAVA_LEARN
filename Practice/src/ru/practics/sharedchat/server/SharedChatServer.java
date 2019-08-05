package ru.practics.sharedchat.server;

import ru.practics.sharedchat.factory.ChatFactory;
import ru.practics.sharedchat.server.controller.ChatController;

public class SharedChatServer {

	public static void main(String[] args) {
		ChatController chat = ChatFactory.getChat();
	}

}
