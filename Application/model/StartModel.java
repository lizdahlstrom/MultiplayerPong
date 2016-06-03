package Application.model;

import Application.controller.ClientReceive;

public class StartModel {
	// Instance variables
	private ClientReceive clientReceive;

	private String testStr = "Waiting for players..";
	// TODO: Highscore implementation
	// private Highscore hs;

	// Constructor
	public StartModel() {
		clientReceive = new ClientReceive();
	}

	public ClientReceive getClientReceive() {
		return clientReceive;
	}

	public String getTestStr() {
		return testStr;
	}

}
