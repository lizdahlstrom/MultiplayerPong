package Application.controller;

import Application.model.StartModel;
import Application.view.StartMenu;

public class StartController {
	//Instance variables
	private StartModel startModel;
	private StartMenu startView;

	// Controller
	public StartController(){
		initComponents();

		//Action events are generated when OK is pressed.
		startView.getInputNameBtn().setOnAction(eventOK -> {
			if (eventOK.getSource()==startView.getInputNameBtn() && startView.getTxtYourName().getText()!="")
				startView.getNewStage().close();
			startView.getTxtArea().setText("Player:"+ " " + startView.getTxtYourName().getText()+" " + " " + "Status:" + " " 
					+ startModel.getClientReceive().setStrData());			
		});

		startView.getTxtArea().setText(startModel.getTestStr());


	}

	private void initComponents(){
		startModel = new StartModel();
		startView = new StartMenu();
	}




	// Setters, getters
	public StartModel getStartModel() {
		return startModel;
	}

	public void setStartModel(StartModel startModel) {
		this.startModel = startModel;
	}

	public StartMenu getStartMenu() {
		return startView;
	}

	public void setStartMenu(StartMenu startMenu) {
		this.startView = startMenu;
	}



}
