package Server;

public class Clienttest {

	public static void main(String[] args) {
		// instance variables
		String address = "localhost";
		int port = 7777;

		int playerStartX = 0;
		int playerStartY = 0;

		// Testing ...
		PlayerModel playerModel = new PlayerModel(address, port, playerStartX, playerStartY);

		//		Client client = new Client(playerModel);

	}
}
