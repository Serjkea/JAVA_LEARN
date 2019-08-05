package ru.practics.networking.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelExample {
	
	public static void main(String[] args) {
		try {
			
			ServerSocketChannel channel = ServerSocketChannel.open();
			channel.socket().bind(new InetSocketAddress(9999));
			boolean flag = true;
			while(flag) {
				SocketChannel socketChannel = channel.accept();
				//do something with Socket channel
			}
			
			//Non blocking mode
			ServerSocketChannel channelNew = ServerSocketChannel.open();
			channelNew.socket().bind(new InetSocketAddress(9999));
			channelNew.configureBlocking(false);
			while(true) {
				SocketChannel socketChannel = channelNew.accept();
				
				if(socketChannel != null) {
					//do something with Socket channel
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
