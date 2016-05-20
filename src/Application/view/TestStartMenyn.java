package Application.view;

import javafx.application.Application; 
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color; 
import javafx.scene.shape.Line; 
import javafx.scene.shape.StrokeLineCap; 
import javafx.scene.text.Text; 
import javafx.stage.Stage; 

public class TestStartMenyn extends Application {
	
	private final TableView table = new TableView();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Welcome to your Pong adventure");
		
		Group root = new Group();
		Scene myScene = new Scene(root, 800, 600, Color.BLACK);
		
		final VBox vbox = new VBox(5); //space between child nodes only
		vbox.setPadding(new Insets(10, 0, 0, 10)); //padding between vbox border and child node
		
		TableColumn rankCol = new TableColumn("Rank");
		TableColumn scoreCol = new TableColumn("Score");
		TableColumn playerCol = new TableColumn("Player");
		
		table.getColumns().addAll(rankCol, scoreCol, playerCol);
		
		vbox.getChildren().addAll(table);
		
		 ((Group) myScene.getRoot()).getChildren().addAll(vbox);
		 
	        primaryStage.setScene(myScene);
	        primaryStage.show();

		
		
	}

}
