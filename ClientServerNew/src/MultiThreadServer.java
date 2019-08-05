import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadServer {
	
	static ExecutorService executeIt=Executors.newFixedThreadPool(2);

	public static void main(String[] args) {
		
		try {
			ServerSocket server=new ServerSocket(3345);
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Server socket created");
			
		while (!server.isClosed()) {
			if (br.ready()) {
				String serverCommand=br.readLine();
				if (serverCommand.equalsIgnoreCase("quit")) {
					server.close();
					break;
				}
			}
			
			Socket client=server.accept();
			
			executeIt.execute(new MonoThreadClientHandler(client));
			System.out.println("Connection accepted");
		}
		executeIt.shutdown();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
