import java.net.*;
import java.io.*;
import javax.swing.*;

public class ClientSession extends Thread{
	private final Socket socket;
	private final MessageReader reader;
	private final MessageWriter writer;
	private final Context context;
	
	public ClientSession(final Socket socket,final Context context) throws IOException {
		this.socket=socket;
		this.reader=new MessageReader(socket.getInputStream());
		this.writer=new MessageWriter(socket.getOutputStream());
		this.context=context;
	}
	
	public void run() {
		MessageReader.UniqueMessage msg;
		try {
			msg=reader.readMessage();
			
			if(msg.message instanceof HandshakeRequest) {
				if(((HandshakeRequest)msg.message).match()) {
					writer.writeResponse(new HandshakeResponse(),msg.uniqueId);
				}
			}
			
			this.doWork();
			
			this.socket.close();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	private void doWork() {}

}
