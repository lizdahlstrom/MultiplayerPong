package Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server extends Connection {

	// Instance variables
	static DatagramSocket socket;
	static DatagramPacket packet;
	static InetAddress ip;
	static byte[] buf = new byte[1024];

	static PlayerModel[] users = new PlayerModel[2]; // room for 2 users

	// MAIN METHOD
	public static void main(String[] args) throws Exception {
		socket = new DatagramSocket(port);
		packet = new DatagramPacket(buf, buf.length);
		ip = InetAddress.getByName(host);

		while (true) {
			try {
				// Waiting for connection..
				System.out.println("waiting for incoming data...");
				socket.receive(packet);
				// Get the data from packet
				InetAddress ipAddress = packet.getAddress();
				int clientPort = packet.getPort();
				String strData = new String(packet.getData());
				strData = strData.trim();
				System.out.println("Message recieved: " + strData);

				// send response back to client
				// TODO: send response to other clients
				byte[] sendData = new byte[1024];
				sendData = response.getBytes();

				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, clientPort);
				socket.send(sendPacket);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
