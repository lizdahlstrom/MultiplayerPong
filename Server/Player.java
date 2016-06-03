package Server;

import java.io.Serializable;
import java.net.InetAddress;

public class Player implements Serializable {
	// Instance variables
	private InetAddress ip;
	private int id;

	// Constructor
	public Player(int id, InetAddress ip) {
		this.id = id;
		this.ip = ip;
	}

	public InetAddress getIp() {
		return ip;
	}

	public void setIp(InetAddress ip) {
		this.ip = ip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
