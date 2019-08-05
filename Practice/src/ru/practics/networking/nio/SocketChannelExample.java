package ru.practics.networking.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelExample {
	
	public static void main(String[] args) {
		try {
			SocketChannel socketChannel = SocketChannel.open();
			socketChannel.connect(new InetSocketAddress("http://yandex.ru", 80));
			ByteBuffer buffer = ByteBuffer.allocate(48);
			int bytesRead = socketChannel.read(buffer);
			
			buffer.clear();
			buffer.put("hello".getBytes());
			buffer.flip();
			while(buffer.hasRemaining()) {
				socketChannel.write(buffer);
			}
			socketChannel.close();
			
			//Non blocking mode
			socketChannel.configureBlocking(false); 
			socketChannel.connect(new InetSocketAddress("http://yandex.ru", 80));
			while(!socketChannel.finishConnect()) {
				//wait, or do something else
				socketChannel.write(buffer);
				socketChannel.read(buffer);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
