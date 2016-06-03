//Connect client to server. 


package Application;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client implements Runnable {
	//Instance variables
	
	private ClientHandler ClientHandler;
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
			
			Socket ClientSocket = null;
			try {
				ClientSocket = new Socket("localhost", 7777);
				DataOutputStream outToServer = new DataOutputStream(ClientSocket.getOutputStream());
				System.out.println("You connected to: "+ host);
				
				BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
				String text = inFromUser.readLine();
				outToServer.writeBytes(text + '\n');
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
//		address = InetAddress.getByName(host);
//			socket = new DatagramSocket(host);
//
//		socket = new DatagramSocket(host);
//        System.out.println("You connected to: "+ host);
//		
//        ClientHandler = new ClientHandler(socket);
//        
//			System.out.println("Found host..");
//		} catch (SocketException e) {
//			System.out.println("Cannot find host..");
//			e.printStackTrace();
//		}
		
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

