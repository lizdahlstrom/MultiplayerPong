package Application.controller;

import Application.view.StartMenu;

public class MainController {
	
	StartMenu testStart = new StartMenu();
	
	
	public String getPlayerName() {
		return testStart.getTxtYourName().getText();
		
	}

}
