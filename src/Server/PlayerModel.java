package Server;

import java.io.Serializable;

public class PlayerModel implements Serializable {

	// Instance variables
	private String address;
	private int port;
	private int posX;
	private int posY;

	// Constructor
	public PlayerModel(String address, int port, int posX, int posY) {
		this.address = address;
		this.port = port;
		this.posX = posX;
		this.posY = posY;
	}

	// Setters, getters
	public String getAddress() {
		return address;
	}

	public int getPort() {
		return port;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

}
