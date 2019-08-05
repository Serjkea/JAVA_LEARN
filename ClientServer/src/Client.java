import java.net.*;
import javax.swing.*;
import java.io.*;

public class Client {
	private final InetAddress host;
	private final int port;
	
	public Client(InetAddress host,int port) {
		this.host=host;
		this.port=port;
	}
	
	public void start() {
		try {
			Socket socket=new Socket(host,port);
			MessageReader reader=new MessageReader(socket.getInputStream());
			MessageWriter writer=new MessageWriter(socket.getOutputStream());
			
			writer.writeRequest(new HandshakeRequest());
			MessageReader.UniqueMessage msg=reader.readMessage();
			
			if (!(msg.message instanceof HandshakeResponse)) {
				return;
			}
			
			this.logicStart();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void logicStart() {
		
	}

}
