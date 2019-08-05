import java.io.*;
import java.util.*;

public class HandshakeRequest extends Request {
	
	public static final String HANDSHAKE_STRING="Handshake request";
	
	private String handshake;
	
	@Override
	public void readExternal(DataInputStream dis) throws IOException {
		handshake=dis.readUTF();
	}
	
	@Override
	public void writeExternal(DataOutputStream dos) throws IOException {
		dos.writeUTF(HANDSHAKE_STRING);
	}
	
	public boolean match() {
		return HANDSHAKE_STRING.equals(handshake);
	}

}
