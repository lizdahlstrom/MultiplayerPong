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

	private boolean isReady = false;




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



		/*String data = "0";
		byte[] buf = new byte [1024];
		try {
			buf = data.getBytes("UTF-8");
			packet = new DatagramPacket(buf, buf.length, address, port);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}*/

	}

	private void Player(){

	}

	private void Ball() {

	}

	public boolean checkIfReady(){
		// TODO: Check if two players are populating server, in that case set isready to true
		return isReady;

	}

	// RUN METHOD
	@Override
	public void run() {
		System.out.println("Running client service...");
		while (true) {

		}

	}

}

