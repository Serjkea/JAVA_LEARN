import java.io.*;
import java.net.*;

public class TestAsServer {

	public static void main(String[] args) throws InterruptedException {
		
		try {
			ServerSocket server=new ServerSocket(3345); 
			Socket client=server.accept();
			System.out.println("Connection accepted.");
			DataInputStream in=new DataInputStream(client.getInputStream());
			DataOutputStream out=new DataOutputStream(client.getOutputStream());
			while (!client.isClosed()) {
				String entry=in.readUTF();
				if (entry.equalsIgnoreCase("quit")) {
					out.writeUTF("Server reply - "+entry+" - OK");
					out.flush();
					Thread.sleep(3000);
					break;
				}
				out.writeUTF("Server reply - "+entry+" - OK");
				out.flush();
			}
			in.close();
			out.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
