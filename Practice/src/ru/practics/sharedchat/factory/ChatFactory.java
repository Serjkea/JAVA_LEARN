package ru.practics.sharedchat.factory;

import ru.practics.sharedchat.server.controller.ChatController;
import ru.practics.sharedchat.server.controller.ChatControllerImpl;

public class ChatFactory {
	
	private static ChatController chat = ChatControllerImpl.getChatController();
	
	public static ChatController getChat() {
		return chat;
	}

}
