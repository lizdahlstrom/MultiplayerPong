package Application;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client implements Runnable {
	//Instance variables
	private final static String host = "localhost";
	private InetAddress address;
	private final static int port = 7777;

	private DatagramSocket socket;
	private DatagramPacket packet;
	private DataOutputStream dos;
	private ByteArrayOutputStream bos;
	private DataInputStream dis;
	private ByteArrayInputStream bis;




	//Constructor
	public Client() {


	}


	// Methods
	private void connect(){
		try {
			address = InetAddress.getByName(host);
			socket = new DatagramSocket(port);

			System.out.println("Found host..");
		} catch (SocketException | UnknownHostException e) {
			System.out.println("Cannot find host..");
			e.printStackTrace();
		}
	}

	private void handshake(){
		String data = "0";
		data.getBytes();
		byte [] buf = new byte [1024];
		packet = new DatagramPacket(buf, buf.length, address, port);
	}

	private void Player(){

	}

	private void Ball() {

	}

	@Override
	public void run() {



	}

}

