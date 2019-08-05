package ru.practics.networking.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BasicChannelExample {
	
	public static void main(String[] args) {
		try {
			RandomAccessFile raf = new RandomAccessFile("/file.txt","rw");
			FileChannel channel = raf.getChannel();
			
			ByteBuffer buffer = ByteBuffer.allocate(48);
			
			int bytesRead = channel.read(buffer);
			while(bytesRead != -1) {
				System.out.println(bytesRead);
				buffer.flip();// to READ MODE
				
				while(buffer.hasRemaining()) {
					System.out.println((char) buffer.get());
				}
				buffer.clear();// to WRITE MODE
				bytesRead = channel.read(buffer);
				buffer.put((byte) 125);
			}
			
			//Scatter/Gather
			ByteBuffer header = ByteBuffer.allocate(128);
			ByteBuffer body = ByteBuffer.allocate(1024);
			
			ByteBuffer[] array = {header, body};
			channel.read(array);
			
			channel.write(array);
			
			raf.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
