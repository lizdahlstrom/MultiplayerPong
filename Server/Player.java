package Server;

import java.io.Serializable;
import java.net.InetAddress;

public class Player implements Serializable {
	// Instance variables
	private InetAddress ip;
	private String id;

	// Constructor
	public Player(String id, InetAddress ip) {
		this.id = id;
		this.ip = ip;
	}

	public InetAddress getIp() {
		return ip;
	}

	public void setIp(InetAddress ip) {
		this.ip = ip;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
