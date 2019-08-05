package ru.practics.networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPSocket {
	
	public static void sendDatagram(byte[] buffer) {
		try {
			
			InetAddress localAddress = InetAddress.getLocalHost(); // Local address
			InetAddress address = InetAddress.getByName("yandex.ru");
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 80);
			DatagramSocket socket = new DatagramSocket();
			socket.send(packet);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void receiveDatagram() {
		try {
			
			DatagramSocket socket = new DatagramSocket(80);
			byte[] buffer = new byte[10];
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			socket.receive(packet);
			byte[] inputBuffer = packet.getData();
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		sendDatagram(new byte[65508]);
		receiveDatagram();
	}

}
