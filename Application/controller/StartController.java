package Application.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import Application.model.ReadingToHighScore;
import Application.model.StartModel;
import Application.model.WritingToHighScore;
import Application.view.StartMenu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Labeled;
import javafx.scene.control.TableView;

public class StartController {
	//Instance variables
	private StartModel startModel;
	private StartMenu startView;
	//private WritingToHighScore writingToHighScore;
	private ReadingToHighScore readingToHighScore;
	
	public static final String Column1MapKey = "Rank";
	public static final String Column2MapKey = "Score";
	public static final String Column3MapKey = "Player";

	// Controller
	public StartController(){
		initComponents();

		//Action events are generated when OK is pressed.
		startView.getInputNameBtn().setOnAction(eventOK -> {
			if (eventOK.getSource()==startView.getInputNameBtn() && startView.getTxtYourName().getText()!="")
				startView.getNewStage().close();
			startView.getTxtArea().setText("Player:"+ " " + startView.getTxtYourName().getText()+" " + " " + "Status:" + " " 
					+ startModel.getClientReceive().setStrData());
			//startView.getTable()).setItems(generateDataInMap());
		});

		startView.getTxtArea().setText(startModel.getTestStr());
	}

	private void initComponents(){
		startModel = new StartModel();
		startView = new StartMenu();
		//writingToHighScore = new WritingToHighScore();
		readingToHighScore = new ReadingToHighScore();
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
	
	/*
	public  WritingToHighScore getWritingToHighScore() {
		return writingToHighScore;
	}
	*/
	
	public ReadingToHighScore getReadingToHighScore() {
		return readingToHighScore;
	}
	
	
////This method incorporates highscores and Top ten data generated from the ReadingToHighScore class.
	//as a result the data will be displayed in the HighScore Billboard in GUI.
	private void generateDataInMap() {
        
        HashMap highScoreList = readingToHighScore.getHashMapHighScore();
        
        
        ObservableList<Map> allData = FXCollections.observableArrayList();
        
        
        for (int i = 1; i < highScoreList.size(); i++) {
            Map<String, String> dataRow = new HashMap<>();
 
//            String value1 = "Rank" + i;
//            String value2 = "Score" + i;
//            String value3 = "Player" +i;
 
            dataRow.put(Column1MapKey, (String) highScoreList.get(1));
            dataRow.put(Column2MapKey, (String) highScoreList.get(2));
            dataRow.put(Column3MapKey, (String) highScoreList.get(3));
 
            allData.add(dataRow);
        }
        startView.getTable().setItems(allData);        
    }
}
