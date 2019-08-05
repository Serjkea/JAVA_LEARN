import java.net.*;
import java.io.*;
import javax.swing.*;

public class Server implements Runnable{
	private final int port;
	private Context context;
	
	public Server() {
		this.port=5000;
		this.context=new Context();
	}
	
	@Override
	public void run() {
		try {
			ServerSocket ss=new ServerSocket(port);
			
			while(!context.stopFlag) {
				System.out.println("Waiting connection on port: "+ port);
				Socket clientSocket=ss.accept();
				System.out.println("New client connected to server");
				
				ClientSession clientSession=new ClientSession(clientSocket,context);
				context.getSessionsManager().addSession(clientSession);
				clientSession.start();
			}
			
			ss.close();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	

}
