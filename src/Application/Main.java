package Application;

import Application.controller.StartController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	//Instance variables
	private StartController sController;



	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		initComponents();
		Scene startmenuScene = sController.getStartMenu().getScene();

		primaryStage.setScene(startmenuScene);

		primaryStage.show();

	}

	//METHODS
	public void initComponents(){
		//		mainController = new MainController();
		sController = new StartController();
	}

	public void setView(){

	}

}
