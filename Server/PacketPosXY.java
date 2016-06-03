package Server;

import java.io.Serializable;

public class PacketPosXY implements Serializable {
	// Instance variables
	private static final long serialVersionUID = 1L;
	private int playerId;
	private int x;
	private int y;
	private int ballX;
	private int ballY;

	// Constructor
	public PacketPosXY(int id, int x, int y, int ballX, int ballY) {
		this.playerId = id;
		this.x = x;
		this.y = y;
		this.ballX = ballX;
		this.ballY = ballY;
	}

	// toString method
	@Override
	public String toString() {
		return "PacketPosXY [id=" + playerId + ", x=" + x + ", y=" + y + "]";
	}

	// Getters, setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getId() {
		return playerId;
	}

	public void setId(int id) {
		this.playerId = id;
	}

}
