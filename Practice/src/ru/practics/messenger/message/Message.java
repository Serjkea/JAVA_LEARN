package ru.practics.messenger.message;

import java.util.Date;

public class Message {
	
	private String text;
	private String sender;
	private String recipient;
	private String date;
	
	public Message(String text, String sender, String recipient) {
		this.text = text;
		this.sender = sender;
		this.recipient = recipient;
		this.date = new Date().toString();
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public String getSender() {
		return this.sender;
	}
	
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	
	public String getRecipient() {
		return this.recipient;
	}
	
	@Override
	public String toString() {
		return this.date + " " + this.text;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		else if (obj == this) return true;
		else if (obj instanceof Message) {
			Message tmp = (Message) obj;
			return this.text.equals(tmp.text) &&
			       this.sender.equals(tmp.sender) &&
			       this.recipient.equals(tmp.recipient) &&
			       this.date.equals(tmp.date);
		} else return false;
	}
	
	@Override 
	public int hashCode() {
		return this.text.hashCode() + this.sender.hashCode() + this.recipient.hashCode() + this.date.hashCode();
	}
	
}
