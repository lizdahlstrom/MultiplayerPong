//Server UDP player packets

package Server.packet;

import java.io.Serializable;

public class PlayerPacket implements Serializable {

	//Instance variables
	int x;
	int y;
	int velX;
	int velY;
	int score;
	String ip;

	public PlayerPacket(int x, int y, int velX, int velY, int score, String ip){
		this.x = x;
		this.y = y;
		this.velX = velX;
		this.velY = velY;
		this.score = score;
		this.ip = ip;
	}

}
