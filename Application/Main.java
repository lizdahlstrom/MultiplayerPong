package Application;

import Application.controller.GameController;
import Application.controller.StartController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	//Instance variables
	private StartController sController;
	private GameController gController;



	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		initComponents();
		Scene startmenuScene = sController.getStartMenu().getScene();
		Scene gameScene = gController.getPong().getScene();
		primaryStage.setScene(startmenuScene);

		//Start game
		sController.getStartMenu().getBtnStart().setOnAction(event -> {


			primaryStage.setScene(gameScene);
			if(gController.isPlaying()){
				gController.stopGame();
			}
			gController.startGame();



		});

		// TODO: display endview when game is done




		primaryStage.show();

	}

	//METHODS
	public void initComponents(){
		//		mainController = new MainController();
		sController = new StartController();
		gController = new GameController();
	}

	public void setView(){

	}
}
