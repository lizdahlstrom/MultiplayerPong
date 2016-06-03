//This class runs the client application.

package Application;

import java.io.IOException;
import java.net.UnknownHostException;

import Application.controller.GameController;
import Application.controller.StartController;
import Application.network.Client;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	// Instance variables
	private StartController sController;
	private GameController gController;
	private Client client;

	private Thread connThread;

	public static void main(String[] args) {
		System.out.println("launching app");
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		initComponents();
		Scene startmenuScene = sController.getStartMenu().getScene();
		Scene gameScene = gController.getPong().getScene();
		primaryStage.setScene(startmenuScene);

		// Start game
		sController.getStartMenu().getBtnStart().setOnAction(event -> {

			primaryStage.setScene(gameScene);
			if (gController.isPlaying()) {
				gController.stopGame();
			}
			gController.startGame();

		});

		// TODO: display endview when game is done

		primaryStage.show();

	}

	// METHODS
	public void initComponents() throws UnknownHostException, IOException, InterruptedException {
		client = new Client();
		connThread = new Thread(client);
		connThread.start();
		sController = new StartController();
		gController = new GameController(client);
	}

	public void setView() {

	}
}
