package server;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import server.GameStates.GameState;
import server.packet.BallPacket;
import server.packet.PlayerPacket;

public class Server extends Connection {

	// Instance variables
	static GameStates gameState;
	static DatagramSocket socket; 
	static DatagramPacket packet;
	static InetAddress ip;
	static byte[] buf = new byte[1024];
	static InetAddress [] clientIps = new InetAddress[2]; // only room for two

	static PlayerPacket[] users = new PlayerPacket[2]; // room for 2 users

	//Constructor
	public Server(){
		gameState = new GameStates(GameState.PENDING);
	}

	// MAIN METHOD
	public static void main(String[] args) throws Exception {
		socket = new DatagramSocket(port);
		packet = new DatagramPacket(buf, buf.length);
		ip = InetAddress.getByName(host);

		while (true) {
			try {
				// Waiting for connection..
				System.out.println("waiting for incoming data...");
				socket.receive(packet); // retrieving a packet
				// Get the data from packet
				if(getPacketData(packet).getClass() == PlayerPacket.class){ // if it's a playerpacket
					for(Object user: users){
						user = getPacketData(packet);
					}
					for (InetAddress ip : clientIps) {
						ip = packet.getAddress();
					}
					sendToClients(packet);
				}
				else if (getPacketData(packet).getClass() == BallPacket.class) { // if it's a ballpacket
					BallPacket ballPacket;
					ballPacket = (BallPacket)getPacketData(packet);
					sendToClients(ballPacket);
				}
				else { // if its something else
					System.out.println("uknown packet format...");
				}

				switch (gameState.current) {
				case PENDING:
					for(Object user: users){
						user = getPacketData(packet);
					}

					if(users != null){
						gameState.setGameState(GameState.GAMING);
						//TODO: Send packet with gamestate that can be interpreted from the client side 
						//to start the game

					}
					break;
				case GAMING:
					// Recieve and send package of player position and ball position to other client


					break;
				case ENDED:

					break;
				default:
					break;
				};





				InetAddress ipAddress = packet.getAddress();
				int clientPort = packet.getPort();
				String strData = new String(packet.getData());
				strData = strData.trim();
				System.out.println("Message recieved: " + strData);

				// send response back to client
				// TODO: send response to other clients
				byte[] sendData = new byte[1024];
				String response = "Recieved data from client..";
				sendData = response.getBytes();

				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, clientPort);
				socket.send(sendPacket);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}



	}

	// METHODS
	public static Object getPacketData(DatagramPacket packet) throws ClassNotFoundException, IOException{
		ByteArrayInputStream byteArrayInputStream = 
				new ByteArrayInputStream(packet.getData(), packet.getOffset(), packet.getLength());
		ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
		//Returning java object
		return objectInputStream.readObject();
	}

	public static void sendToClients(Object packet) throws IOException{
		ByteArrayOutputStream byteArrayOutputStream =
				new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		byte buf[];
	}

	public static boolean checkReadyStatus(){
		Boolean status = false;
		if (clientIps[0].isAnyLocalAddress() && clientIps[1].isAnyLocalAddress()) {
			status = true;
		}

		return status;
	}

	//	public Object getData(){
	//	
	//		byte [] buf = new byte[1024];
	//		ByteArrayInputStream byteArrayInputStream = 
	//				new ByteArrayInputStream(packet.getData(), packet.getOffset(), packet.getLength());
	//		ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
	//		user = objectInputStream.readObject();
	//		
	//	}
}
