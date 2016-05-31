package Application.view;

import Application.model.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage; 

public class StartMenu {

	//Instance variables
	private final TableView table; // = new TableView(); //Table shows the past scores.
	private Text txtPong;  //The text label of Pong.
	private TextArea txtArea; //Text area displaying the status of players logging in to play.
	private Button btnEnterName;
	private Scene menuScene;
	private Button btnEnterName2;
	private Button btnStart;
	private Label lblScene2;
	private FlowPane pane2;
	private Scene scene2;
	private Stage newStage;
	private TextField txtYourName;



	public StartMenu() {

		Group root = new Group();
		//Parent content = FXMLLoader.load(getClass().getResource("lnf_demo.fxml"));

		menuScene = new Scene(root, 800, 600, Color.BLACK);


		//Adding the TableView Highscore list to VBox.
		final VBox vbox = new VBox(5); //Space between child nodes only
		vbox.setPadding(new Insets(10, 0, 0, 10)); //Padding between vbox border and child node

		TableColumn rankCol = new TableColumn("RANK");
		rankCol.getStyleClass().add("tableCol");
		rankCol.setId("rankCol");

		TableColumn scoreCol = new TableColumn("SCORE");
		scoreCol.getStyleClass().add("tableCol");
		scoreCol.setId("scoreCol");

		TableColumn playerCol = new TableColumn("PLAYER");
		playerCol.getStyleClass().add("tableCol");
		playerCol.setId("playerCol");

		/*
		//Show the players' names, scores, ranking.
		TableView<Users> table = new TableView<Users>();
		final ObservableList<Users> data =
				FXCollections.observableArrayList(
						);
		*/

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
		btnEnterName.setLayoutX(442);
		btnEnterName.setLayoutY(290);


		//Handle the action events for the btnEnterName and btnEnterName2.
		btnEnterName.setOnAction(ae -> {
			if (ae.getSource()==btnEnterName)
				newStage.showAndWait();
			else
				newStage.close();
		});

		btnEnterName2 = new Button("OK");
		btnEnterName2.setStyle("-fx-background-color:pink;-fx-font-weight:bold;");
		setTxtYourName(new TextField());
		lblScene2 = new Label("NAME:");
		pane2 = new FlowPane(10,10);
		pane2.setVgap(10);
		pane2.setStyle("-fx-background-color:yellow;-fx-padding:10px;");
		//add everything to panes
		pane2.getChildren().addAll(lblScene2,getTxtYourName(),btnEnterName2);

		//Create scene for pane2.
		scene2 = new Scene(pane2, 300, 160);
		//Make another stage for scene2.
		newStage = new Stage();
		newStage.setScene(scene2);
		//Tell stage that its purpose is pop-up (Modal).
		newStage.initModality(Modality.APPLICATION_MODAL);
		newStage.setTitle("Enter your name");

		getTxtYourName().setOnAction( (aeYourName) -> txtArea.setText("You must add your name"+
				getTxtYourName().getText()));


		//Add the Start button.
		btnStart = new Button("START GAME");
		btnStart.setId("btnStartId");
		btnStart.setLayoutX(650);
		btnStart.setLayoutY(290);

		//When the player clicks 'Start Game' this information is sent to the Server which
		//initialises the game. 
		btnStart.setOnAction(event -> {
			// TODO Auto-generated method stub

		}
				);

		//table.setItems(data);
		table = new TableView();
		table.getColumns().addAll(rankCol, scoreCol, playerCol);

		vbox.getChildren().addAll(table);
		root.getChildren().addAll(txtPong,txtArea,btnEnterName,btnStart);


		//Apply custom look and feel to the scene
		menuScene.getStylesheets().add(getClass().getResource("sample.css").toExternalForm());

		((Group) menuScene.getRoot()).getChildren().addAll(vbox);
	}
	

	// Setters, getters

	public Scene getScene(){
		return menuScene;
	}

	public TextField getTxtYourName() {	
		return txtYourName;
	}


	public void setTxtYourName(TextField txtYourName) {
		this.txtYourName = txtYourName;
	}

	public Scene getInputScene(){
		return scene2;
	}

	public Button getInputNameBtn(){
		return btnEnterName2;
	}

	public Button getBtnStart() {
		return btnStart;
	}

	public TextArea getTxtArea() {
		return txtArea;
	}

	public void setTxtArea(TextArea txtArea) {
		this.txtArea = txtArea;
	}

	public Stage getNewStage() {
		return newStage;
	}

	public void setNewStage(Stage newStage) {
		this.newStage = newStage;
	}

	public TableView getTable() {
		return table;
	}


}
