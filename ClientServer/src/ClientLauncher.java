import java.net.*;
import javax.swing.*;

public class ClientLauncher {
	public static void main(String[] args) {
		try {
			InetAddress host=InetAddress.getByName(JOptionPane.showInputDialog("Input host: "));
			int port=Integer.parseInt(JOptionPane.showInputDialog("Input a port: "));

			Client client=new Client(host,port);
			client.start();
			
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null,e);
		}
	}

}
