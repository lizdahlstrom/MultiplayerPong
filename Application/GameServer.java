package Application;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
	//Instance variables
	private ClientHandler clientHandler;
	private Thread clientThread;

	private final int MAX_CLIENTS = 2;
	private ClientHandler [] clients;
	private final int PORT = 7777;
	private final String HOST = "localhost";

	private int numPlayers;


	//Constructor
	public GameServer(){
		numPlayers = 0;
		clients = new ClientHandler[MAX_CLIENTS];



		while (true) {
			try {
				ServerSocket socket = new ServerSocket(PORT);
				Socket clientSocket = socket.accept();

				String testStr = "Hello from server";
				DataOutputStream dos = 	new DataOutputStream(clientSocket.getOutputStream());
				dos.writeBytes(testStr);

				clientHandler = new ClientHandler(clientSocket);
				clientThread = new Thread(clientHandler);
				clientThread.start();	

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	synchronized private int addPlayer(ClientHandler client){

		for (int i = 0; i < clients.length; i++) {
			if (clients[i] == null) {
				clients[i] = client;
				numPlayers++;

				return i+1;
			}	
		}
		return -1;
	}

	synchronized private void removePlayer(int id){
		clients[id] = null;
		numPlayers--;
	}

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
