//for test only not included in the final application


package Server;

/*
 * Java’s implementation of UDP is split into two classes: DatagramPacket and Datagram Socket. 
 * The DatagramPacket class stuffs bytes of data into UDP packets called datagrams and lets you 
 * unstuff datagrams that you receive. A DatagramSocket sends as well as receives UDP datagrams. 
 * To send data, you put the data in a DatagramPacket and send the packet using a DatagramSocket. 
 * To receive data, you take a DatagramPacket object from a DatagramSocket and then inspect the contents 
 * of the packet. The sockets themselves are very simple creatures. In UDP, everything about a datagram, 
 * including the address to which it is directed, is included in the packet itself; the socket only needs 
 * to know the local port on which to listen or send. 
 * 
 * DatagramPacket uses different constructors depending on whether the packet will be used to send data 
 * or to receive data. 
 */

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
	
	
	MainController mController;
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
			
			
			//SEND THE PLAYER'S ENTERED NAME TO THE SERVER.
			String sendName = playerName;
			byte[] nameData = sendName.getBytes("UTF-8");
			DatagramPacket sendingName = new DatagramPacket(nameData,nameData.length,serverIpAddress, port);
			socket.send(sendingName);
			
					
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

