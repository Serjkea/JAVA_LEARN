package ru.practics.networking.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class TransfersExample {
	
	public static void main(String[] args) {
		try {
			
			RandomAccessFile fileFrom = new RandomAccessFile("/from.txt", "wr");
			FileChannel channelFrom = fileFrom.getChannel();
			
			RandomAccessFile fileTo = new RandomAccessFile("/to.txt", "wr");
			FileChannel channelTo = fileTo.getChannel();
			
			long position = 0;
			long size = channelFrom.size();
			
			channelFrom.transferTo(position, size, channelTo);
			
			channelTo.transferFrom(channelFrom, size, position);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
