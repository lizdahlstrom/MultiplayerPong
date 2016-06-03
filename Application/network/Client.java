package Application.network;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.UUID;

public class Client implements Runnable {
	// Instance variables
	private DatagramSocket socket;
	private DatagramPacket packet;
	private PacketReceiver packetReceiver;

	private String host = "localhost";
	private InetAddress ip = InetAddress.getByName(host);
	private int port = 7777;

	private String playerId;

	// Constructor
	public Client() throws IOException, InterruptedException {
		System.out.println("Running client...");
		playerId = UUID.randomUUID().toString();
		socket = new DatagramSocket();
		updatePos(new PacketPosXY(playerId, 21, 23, 575, 780));
		packetReceiver = new PacketReceiver();
		Thread recieveThread = new Thread(packetReceiver);
		recieveThread.start();

		// Testing to send a packet...
		// PacketPosXY packetPosXY = new PacketPosXY(playerId, 23, 23);
		// System.out.println("created packet: " + packetPosXY.toString());
		//
		// ByteArrayOutputStream bos = new ByteArrayOutputStream();
		//
		// ObjectOutputStream oos = new ObjectOutputStream(bos);
		//
		// oos.writeObject(packetPosXY);
		// byte[] data = bos.toByteArray();
		// DatagramPacket sendPacket = new DatagramPacket(data, data.length, ip,
		// port);
		// socket.send(sendPacket);
		//
		// System.out.println("sent packet..");

		// while (true) {
		// // RECEIVE PACKET
		// byte[] buf = new byte[1024];
		// System.out.println("waiting for packet");
		// DatagramSocket inSocket = new DatagramSocket();
		// DatagramPacket inPacket = new DatagramPacket(buf, buf.length);
		// inSocket.receive(inPacket); // Getting packet
		// System.out.println("got packet");
		// buf = inPacket.getData(); // "unpacking" to buffer
		// ByteArrayInputStream bis = new ByteArrayInputStream(buf); // Buffer
		// ObjectInputStream ois = new ObjectInputStream(bis);
		// try {
		// PacketPosXY incomingPacketPosXY = (PacketPosXY) ois.readObject();
		// System.out.println("got packet " + incomingPacketPosXY.toString());
		// } catch (ClassNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } // Casting
		// // to
		// // packetPosXY
		// }

	}

	private PacketPosXY receivePacket(DatagramSocket socket) {
		byte[] buf = new byte[1024];
		DatagramPacket incomingPacket = new DatagramPacket(buf, buf.length);
		PacketPosXY incomingPacketPosXY = null;

		try {
			socket.receive(incomingPacket); // Getting packet
			System.out.println("attempting to recieve");
			buf = packet.getData(); // "unpacking" to buffer
			ByteArrayInputStream bis = new ByteArrayInputStream(buf); // Buffer
			ObjectInputStream ois = new ObjectInputStream(bis);
			incomingPacketPosXY = (PacketPosXY) ois.readObject();
			System.out.println("recieved packet" + incomingPacketPosXY.toString());
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return incomingPacketPosXY;
	}

	public void updatePos(PacketPosXY packetPosXY) throws IOException {

		System.out.println("created packet: " + packetPosXY.toString());

		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		ObjectOutputStream oos = new ObjectOutputStream(bos);

		oos.writeObject(packetPosXY);
		byte[] data = bos.toByteArray();
		DatagramPacket sendPacket = new DatagramPacket(data, data.length, ip, port);
		socket.send(sendPacket);

		System.out.println("sent packet..");
	}

	public String getPlayerId() {
		return playerId;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}

class PacketReceiver implements Runnable {

	@Override
	public void run() {
		System.out.println("running clientreceiver");
		while (true) {
			// RECEIVE PACKET
			byte[] buf = new byte[1024];
			System.out.println("waiting for packet");

			try {
				DatagramSocket inSocket = new DatagramSocket();
				DatagramPacket inPacket = new DatagramPacket(buf, buf.length);
				inSocket.receive(inPacket);
				System.out.println("got packet");
				buf = inPacket.getData(); // "unpacking" to buffer
				ByteArrayInputStream bis = new ByteArrayInputStream(buf); // Buffer
				ObjectInputStream ois = new ObjectInputStream(bis);
				PacketPosXY incomingPacketPosXY = (PacketPosXY) ois.readObject();
				System.out.println("got packet " + incomingPacketPosXY.toString());
			} catch (IOException | ClassNotFoundException e1) {
				e1.printStackTrace();
			} // Getting packet

		}
	}

}
