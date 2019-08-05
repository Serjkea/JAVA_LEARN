import java.io.*;
import java.net.*;

public class MonoThreadClientHandler implements Runnable {
	
	private static Socket clientDialog;
	
	public MonoThreadClientHandler(Socket client) {
		MonoThreadClientHandler.clientDialog=client;
	}
	
	@Override
	public void run() {
		try {
			DataOutputStream out=new DataOutputStream(clientDialog.getOutputStream());
			DataInputStream in=new DataInputStream(clientDialog.getInputStream());
			
			while(!clientDialog.isClosed()) {
				String entry=in.readUTF();
				if (entry.equalsIgnoreCase("quit")) {
					out.writeUTF("Server reply - "+entry+" - OK");
					break;
				}
				out.writeUTF(entry);
				out.flush();
			}
			in.close();
			out.close();
			clientDialog.close();
		} catch (IOException e) {
			e.printStackTrace();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
		}
		
	}

}
