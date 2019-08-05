import java.io.*;
import java.util.*;

public class MessageReader {
	
	public static final int HEADER_LENGTH=12;
	
	private final DataInputStream dis;
	
	public MessageReader(InputStream is) {
		this.dis=new DataInputStream(is);
	}
	
	public UniqueMessage readMessage() throws IOException {
		int packageLength=dis.readInt();
		if (packageLength<HEADER_LENGTH) {
			throw new IOException("Wrong package length");
		}
		
		byte[] buf=new byte[packageLength-4];
		dis.readFully(buf);
		
		DataInputStream messageIS=new DataInputStream(new ByteArrayInputStream(buf));
		
		int uniqueId=messageIS.readInt();
		int message_id=messageIS.readInt();
		
		IMessage message=MessageFactory.createMessage(message_id);
		
		message.readExternal(messageIS);
		System.out.println("Message "+message.getClass().getName() + " received.");
		
		return new UniqueMessage(message,uniqueId);
	}
	
	public static class UniqueMessage {
		public final IMessage message;
		public final int uniqueId;
		
		private UniqueMessage(IMessage message,int uniqueId) {
			this.message=message;
			this.uniqueId=uniqueId;
		}
	}

}
