package ru.practics.networking.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorsExample {
	
	public static void main(String[] args) {
		try {
			SelectableChannel channel = SocketChannel.open();
			
			Selector selector = Selector.open(); // creating a Selector
			
			channel.configureBlocking(false);	
			int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE; //OP_CONNECT OP_ACCEPT
			SelectionKey key = channel.register(selector, interestSet); // registering channels with the Selector
			
			int interestSetNew = key.interestOps();

			boolean isInterestedInAccept  = interestSet == SelectionKey.OP_ACCEPT;
			boolean isInterestedInConnect = interestSet == SelectionKey.OP_CONNECT;
			boolean isInterestedInRead    = interestSet == SelectionKey.OP_READ;
			boolean isInterestedInWrite   = interestSet == SelectionKey.OP_WRITE;    
			
			while(true) {
				int readyChannels = selector.selectNow();
				if(readyChannels == 0) continue;
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
				while(keyIterator.hasNext()) {
					SelectionKey tempKey = keyIterator.next();
					if(tempKey.isAcceptable()) {
						// a connection was accepted by a ServerSocketChannel
					} else if(tempKey.isConnectable()) {
						// a connection was established with a remote server
					} else if(tempKey.isReadable()) {
						// a channel is ready for reading
					} else if(tempKey.isWritable()) {
						// a channel is ready for writing
					}
					keyIterator.remove();
				}
			}
		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
