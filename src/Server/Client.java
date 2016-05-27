package Server;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import Application.controller.MainController;
import Application.view.StartMenu;

public class Client extends Connection implements Runnable {
	// Instance variables
	static private PlayerModel playerModel;
	
	
	MainController mController = new MainController();
	String playerName; //Get the player's entered name.
	
	
	// Constructor 1
	public Client(PlayerModel playerModel, MainController mController) {
		this.playerModel = playerModel;
		this.mController = mController;
		
	}
	
	// Constructor 2
	public Client () {
		playerName = mController.getPlayerName();
	}
	
	

	// RUN METHOD
	@Override
	public void run() {
		byte[] buf = new byte[1024];
		InetAddress serverIpAddress;
		try {
			serverIpAddress = InetAddress.getByName(host);

			DatagramSocket socket = new DatagramSocket(0);
			socket.setSoTimeout(10000);
			DatagramPacket packet = new DatagramPacket(buf, buf.length);

			/*
			 * Thread recieveData = new Thread(new ClientRecieve(socket,
			 * packet)); recieveData.start();
			 */

			/*
			 * String yourName = "Player 1"; String message = "Hello from " +
			 * yourName + " sent by the host: " + InetAddress.getLocalHost();
			 */
			ByteArrayOutputStream baoStream = new ByteArrayOutputStream();
			ObjectOutputStream ooStream = new ObjectOutputStream(baoStream);
			ooStream.writeObject(playerModel);
			byte[] sendData = new byte[1024];
			sendData = baoStream.toByteArray();
			
			
			/////////////////////////////////////////////////
			String sendName = playerName;
			byte[] nameData = sendName.getBytes();		
			//////////////////////////////////////////////////
					

			// buffer
			/*
			 * byte[] sendData = new byte[1]; sendData = message.getBytes();
			 */

			DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, serverIpAddress, port);
			socket.send(sendPacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}

// Thread for recieving packets
class ClientRecieve implements Runnable {
	// Instance variables
	DatagramPacket packet;
	DatagramSocket socket;

	// Constructor
	public ClientRecieve(DatagramSocket socket, DatagramPacket packet) {
		this.socket = socket;
		this.packet = packet;
	}

	@Override
	public void run() {

		while (true) {
			try {
				socket.receive(packet);
				String strData = new String(packet.getData());
				strData = strData.trim();
				System.out.println("Message recieved: " + strData);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}