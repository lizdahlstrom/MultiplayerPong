package Application.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EndView {

	//Instance variables
	private String title = "Game over";
	private Scene scene;
	private VBox root;
	private HBox btnHbox;
	private Label lblResult;
	private Button btnQuit;
	private Button btnPlay;


	//Constructor
	public EndView(String result){
		lblResult = new Label(result);
		generateView();
	}


	//Methods
	private void generateView(){
		btnQuit = new Button("Quit");
		btnPlay = new Button("Play again");
		btnHbox = new HBox();
		btnHbox.getChildren().addAll(btnQuit, btnPlay);
		root = new VBox(lblResult, btnHbox);
		scene = new Scene(root);
	}

	//Getters, setters
	public Scene getScene(){
		return scene;
	}


}
