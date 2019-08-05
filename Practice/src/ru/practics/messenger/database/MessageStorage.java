package ru.practics.messenger.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.practics.messenger.message.Message;

public class MessageStorage {
	
	private static List<Message> messages;
	
	private static MessageStorage instance;
	
	private MessageStorage() {
		messages = new ArrayList<Message>();
	}
	
	public static MessageStorage getMessageStorage() {
		if (instance == null) {	
			instance = new MessageStorage();
		}
		return instance;
	}
	
	public void putMessage(Message message) {
		if (message != null) {
			messages.add(message);
		}
	}
	
	public Message getMessage(String sender) {
		if (sender != null) {
			for(Message msg: messages) {
				if (msg.getSender().equals(sender)) {
					return msg;
				} else return null;
			}
		} return null;
	}
	
	public List<Message> getAllMessages(String reciplier) {
		if (reciplier != null) {
			List<Message> tmp = new ArrayList<Message>();
			for (Message msg: messages) {
				if (msg.getRecipient().equals(reciplier)) tmp.add(msg);
			}
			return tmp;
		}
		return null;
	}
	
	public void clearAll() {
		messages.clear();
	}

}
