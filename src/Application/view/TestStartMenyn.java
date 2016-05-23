package Application.view;

import javafx.application.Application; 
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group; 
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color; 
import javafx.scene.shape.Line; 
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Font;
import javafx.scene.text.Text; 
import javafx.stage.Stage; 

public class TestStartMenyn extends Application {
	
	private final TableView table = new TableView(); //Table shows the past scores.
	
	Text txtPong;  //The text label of Pong.
	
	TextArea txtArea; //Text area displaying the players logging in to play.
	
	Button btnEnterName;
	
	

	public static void main(String[] args) {
		launch(args);
}
	
	@Override public void init() {
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Welcome to your Pong adventure");
		
		Group root = new Group();
		//Parent content = FXMLLoader.load(getClass().getResource("lnf_demo.fxml"));
		
		Scene myScene = new Scene(root, 800, 600, Color.BLACK);
		
		
		//Adding the TableView Highscore list to VBox.
		final VBox vbox = new VBox(5); //space between child nodes only
		vbox.setPadding(new Insets(10, 0, 0, 10)); //padding between vbox border and child node
		
		TableColumn rankCol = new TableColumn("RANK");
		rankCol.getStyleClass().add("tableCol");
		rankCol.setId("rankCol");
		
		TableColumn scoreCol = new TableColumn("SCORE");
		scoreCol.getStyleClass().add("tableCol");
		scoreCol.setId("scoreCol");
		
		TableColumn playerCol = new TableColumn("PLAYER");
		playerCol.getStyleClass().add("tableCol");
		playerCol.setId("playerCol");
		
		table.getColumns().addAll(rankCol, scoreCol, playerCol);
		
		//Add the label Pong with CSS tag.
		txtPong = new Text(475,85, "PONG");
		txtPong.setId("txtPongId");
		
		//Add the text area.
		txtArea = new TextArea();
		txtArea.setId("txtAreaId");
		txtArea.setLayoutX(440);
		txtArea.setLayoutY(95);
		txtArea.setMaxWidth(300);
		txtArea.setMaxHeight(350);
	
		//Add the button, the player should enter his/her name.
		btnEnterName = new Button("ENTER YOUR NAME");
		btnEnterName.setId("btnEnterNameId");
		btnEnterName.setLayoutX(538);
		btnEnterName.setLayoutY(290);
		
		
		
		
		
		vbox.getChildren().addAll(table);
		root.getChildren().addAll(txtPong,txtArea,btnEnterName);
		
		
		//Apply custom look and feel to the scene
		myScene.getStylesheets().add(getClass().getResource("sample.css").toExternalForm());
		
		((Group) myScene.getRoot()).getChildren().addAll(vbox);
		 
	        primaryStage.setScene(myScene);
	        primaryStage.show();

		
		
	}

}
