package ru.practics.messenger.tests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import ru.practics.messenger.database.MessageStorage;
import ru.practics.messenger.message.Message;

public class MessageStorageTests {
	
	@Test
	public void testGetMessageStorage() {
		MessageStorage store = MessageStorage.getMessageStorage();
		assertNotNull(store);
		store.clearAll();
	}

	@Test
	public void testPutMessage() {
		MessageStorage store = MessageStorage.getMessageStorage();
		Message msg = new Message("Hello","A","B");
		store.putMessage(msg);
		assertEquals(store.getMessage("A"),msg);
		store.clearAll();
	}


	@Test
	public void testGetMessage() {
		MessageStorage store = MessageStorage.getMessageStorage();
		Message msg = new Message("Hello","A","B");
		store.putMessage(msg);
		assertEquals(store.getMessage("A"),msg);
		store.clearAll();
	}

}
