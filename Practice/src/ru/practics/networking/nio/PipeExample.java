package ru.practics.networking.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class PipeExample {
	
	public static void main(String[] args) {
		try {
			
			Pipe pipe = Pipe.open();
			Pipe.SinkChannel sink = pipe.sink();
			ByteBuffer buffer = ByteBuffer.allocate(48);
			buffer.clear();
			buffer.put("hello".getBytes());
			buffer.flip();
			while(buffer.hasRemaining()) {
				sink.write(buffer);
			}
			
			Pipe.SourceChannel source = pipe.source();
			int bytesRead = source.read(buffer);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
