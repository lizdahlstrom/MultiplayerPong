package server.packet;

import java.io.Serializable;

public class BallPacket implements Serializable {

	//Instance variables
	int x;
	int y;
	int velX;
	int velY;

	//Constructor
	public BallPacket(int x, int y, int velX, int velY){
		this.x = x;
		this.y = y;
		this.velX = velX;
		this.velY = velY;
	}

}
