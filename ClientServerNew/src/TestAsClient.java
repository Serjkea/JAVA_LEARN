import java.io.*;
import java.net.*;

public class TestAsClient {
	
	public static void main(String[] args) throws InterruptedException {
		
		try {
			Socket socket=new Socket("localhost",3345);
		    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		    DataOutputStream oos=new DataOutputStream(socket.getOutputStream());
		    DataInputStream ois=new DataInputStream(socket.getInputStream()); 
		    
			System.out.println("Client connected to socket");
			
			while (!socket.isOutputShutdown()) {
				if (br.ready()) {
					System.out.println("Client start writing in channel...");
					String clientCommand=br.readLine();
					oos.writeUTF(clientCommand);
					oos.flush();
					
					if(clientCommand.equalsIgnoreCase("quit")) {
						System.out.println("Client kill connections");
						
						if(ois.read()>-1) {
							System.out.println("reading...");
							String in=ois.readUTF();
							System.out.println(in);
						}
					break;
					}
					System.out.println("Waiting for data from server...");
					if (ois.read()>-1) {
						System.out.println("reading...");
						String in=ois.readUTF();
						System.out.println(in);
					}
				}
			}
		    } catch (UnknownHostException e) {
		    	e.printStackTrace();
		    } catch (IOException e) {
		    	e.printStackTrace();
		    }
		    
		
	}

}
