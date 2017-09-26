package java_network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

public class Messenger extends Thread {
	private DatagramSocket socket;
	private DatagramPacket packet; // 소켓은 패킷으로 보내고, 받기 때문에 생성
	
	private JTextArea textArea;
	private InetAddress address;
	private int otherPort;
	
	public Messenger(int myPort, int otherPort, String address) {
		try {
			socket = new DatagramSocket(myPort);
			this.address = InetAddress.getByName(address);
			this.otherPort = otherPort;
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	@Override
	public void run() {
		while(true){
			byte[] buf = new byte[255];
			packet = new DatagramPacket(buf, buf.length);
			try {
				socket.receive(packet);
				textArea.append("RECEIVED : " + new String(buf) + "\n");
			
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void sendMessage(String msg){
		byte[] buf = msg.getBytes();
		DatagramPacket packet = new DatagramPacket(buf, buf.length, address, otherPort);
		try {
			socket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
