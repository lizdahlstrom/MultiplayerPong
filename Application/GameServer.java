//Server creating logic for client connection.


package Application;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class GameServer {
	//Instance variables
	private ClientHandler clientHandler;
	private Thread clientThread;

	private final int MAX_CLIENTS = 2;
	//private ClientHandler [] clients;
	private final int PORT = 7777;
	private final String HOST = "localhost";
	public static ArrayList<Socket> clients = new ArrayList<>();
	private int numPlayers;


	//Constructor
	public GameServer(){
		numPlayers = 0;
		//clients = new ClientHandler[MAX_CLIENTS];
		
		
		try {
		ServerSocket socket = new ServerSocket(PORT);
		System.out.println("Waiting for clients...");

		while (true) {
			
				
				
				Socket clientSocket = socket.accept();
				clients.add(clientSocket);
				
				System.out.println("Client connected from: " + clientSocket.getLocalAddress().getHostName());

//				String testStr = "Hello from server";
//				DataOutputStream dos = 	new DataOutputStream(clientSocket.getOutputStream());
//				dos.writeBytes(testStr);
//				
//				
//
//				clientHandler = new ClientHandler(clientSocket);
//				clientThread = new Thread(clientHandler);
//				clientThread.start();	
				
		            //ServerSocket socket = (socket)Gameserver.ClientHandeler.get(i-1);
		            PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
		            out.println("" + clients);
		            out.flush();

			} 

		
	}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
//	synchronized private int addPlayer(ClientHandler client){
//
//		for (int i = 0; i < clients.length; i++) {
//			if (clients[i] == null) {
//				clients[i] = client;
//				numPlayers++;
//
//				return i+1;
//			}	
//		}
//		return -1;
//	}
//
//	synchronized private void removePlayer(int id){
//		clients[id] = null;
//		numPlayers--;
//	}

	synchronized private void tellOther(){

	}

	synchronized private void enoughPlayers(){

	}

	private void saveResult(){

	}


	public static void main(String[] args) {
		GameServer gServer = new GameServer();

	}

}
