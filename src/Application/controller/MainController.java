package Application.controller;

import Application.view.TestStartMenyn;

public class MainController {
	
	TestStartMenyn testStart = new TestStartMenyn();
	
	
	public String getPlayerName() {
		return testStart.getTxtYourName().getText();
		
	}

}
