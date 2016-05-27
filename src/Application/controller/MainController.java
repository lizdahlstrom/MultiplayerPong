package Application.controller;

import Application.view.StartMenu;
import Server.Client;
import Application.controller.ClientReceive;



public class MainController {
	
	StartMenu testStart = new StartMenu();
	Client clientSendUDP = new Client();
	ClientReceive clientReceive = new ClientReceive();
	
	
	public String getPlayerName() {
		return testStart.getTxtYourName().getText();
		}
	
	public String setTheName() {
		return clientReceive.setStrData();
	}

}
