package Server;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;

import Server.GameStates.GameState;

public class Server {
	// Instance variables
	private int port = 7777;
	private String host = "localhost";
	private InetAddress ip;

	private DatagramSocket socket;
	private DatagramPacket packet;

	private final int MAX_CLIENTS = 2;
	private ArrayList<Player> players;
	private int numOfPlayers = 0;

	private GameStates gameState;

	// Constructor
	public Server() {
		createServer();
		byte[] buf = new byte[1024];

		while (true) {
			try {

				// RECIEVE PACKET
				packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet); // Getting packet
				InetAddress clientIp = packet.getAddress();
				// System.out.println("Recieving packet from ..." +
				// clientIp.getHostName());

				buf = packet.getData(); // "unpacking" to buffer
				ByteArrayInputStream bis = new ByteArrayInputStream(buf); // Buffer
				ObjectInputStream ois = new ObjectInputStream(bis);
				PacketPosXY packetPosXY = (PacketPosXY) ois.readObject(); // Casting
																			// to
																			// packetPosXY
				// Checking server status..
				if (!isFull()) {

					if (players.isEmpty()) { // If there are no players
						numOfPlayers = 1;
						players.add(new Player(packetPosXY.getId(), clientIp));
						System.out.println("added player 1 ");
						// else if there's a player already...
					} else if (players.size() == 1 && players.get(0).getId() != packetPosXY.getId()) {
						numOfPlayers = 2;
						players.add(new Player(packetPosXY.getId(), clientIp));
						System.out.println("added player 2");
					}

					// if there are two players then ready to start game.
					if (isFull()) {
						System.out.println("Player array is full, ready to start game");
						Thread.sleep(3000);
						gameState.setGameState(GameState.GAMING);
					}
				}

				// ECHO BACK PACKET to players
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(bos);
				oos.writeObject(packetPosXY); // Output stream now has packet
				byte[] outdata = bos.toByteArray();

				for (Player player : players) { // send to each player
					DatagramPacket sendPacket = new DatagramPacket(outdata, outdata.length, player.getIp(), port);
					socket.send(sendPacket);
					System.out.println("sent packet.." + sendPacket);
					Thread.sleep(1000);
				}

			} catch (Exception e) {

			}

		}

	}

	// METHODS

	private void startGame() {
		gameState.setGameState(GameState.GAMING);
	}

	private void endGame() {
		gameState.setGameState(GameState.ENDED);
	}

	private void addPlayer(Player player) {
		// Checks if player already exists
		if (!players.contains(player) && players.size() < 2) {
			System.out.println("Added player: " + player.getIp());
		} else {
			System.out.println("Player already exists...");
		}

	}

	private void removePlayer(Player player) {
		if (!players.isEmpty()) {
			numOfPlayers--;
			players.remove(player);
			System.out.println("Removed player:" + player.getIp());
		} else {
			System.out.println("No player to remove..");
		}
	}

	private void clearPlayers() {
		players.clear();
		System.out.println("Players cleared, game pending..");
	}

	private boolean isFull() {
		if (players.size() == 2) {
			return true;
		}
		return false;
	}

	private void createServer() {
		try {
			System.out.println("starting server..");
			players = new ArrayList<>();
			gameState = new GameStates(GameState.PENDING);
			// ip = InetAddress.getByName(host);
			socket = new DatagramSocket(port);

		} catch (SocketException e) {
			System.out.println("Error creating server...");
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Server server = new Server();
	}

}
