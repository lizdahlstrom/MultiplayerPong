package Application.controller;

import Application.view.StartMenu;
import Server.Client;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.EventListener;

import Application.controller.ClientReceive;



public class MainController {
	
	//Create instances of relevant classes.
	StartMenu theStartMenu;
	Client theClient; 
	ClientReceive theClientReceive;
	
	/*
	public MainController(StartMenu theStartMenu, Client theClient, ClientReceive theClientReceive) {
	//Connect the instances to the instance variables. 
	//The Controller has now control over the actual classes.
		this.theStartMenu = theStartMenu;
		this.theClient = theClient;
		this.theClientReceive = theClientReceive;
		
		//Through the ClientReceive class get the setStrData().
		theClientReceive.setStrData();
		
		//Through the StartMenu class get the getTxtYourName().
		theStartMenu.getTxtYourName().getText();
		
		//Connect listener to the class StartMenu.
		//this.theStartMenu.addViewListener(new ViewListener());
		
	}
	*/
	
	
	public String getPlayerName() {
		return theStartMenu.getTxtYourName().getText();
		}
	
	public String connectionStatus() {
		return theClientReceive.setStrData();
	}

}

/*
//Create an inner class that listens.
class ViewListener implements EventListener {
	
	StartMenu theStartMenu;
	
	public void actionPerformed (EventHandler e) {
		
		String indataName = "";
		
		//Action events are generated when OK is pressed.
	    theStartMenu.btnEnterName2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent eventOK) {
				if (eventOK.getSource()==theStartMenu.btnEnterName2 && theStartMenu.getTxtYourName().getText()!="")
					theStartMenu.newStage.close();
				theStartMenu.txtArea.setText("Player:"+ " " + theStartMenu.getTxtYourName().getText()+" " + " " + "Status:" + " "+" " 
					//+ cr.setStrData()
					);			
			} 
			
	    }
	); 
}
}*/

	    	
	
	

