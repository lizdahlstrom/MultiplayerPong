package Application.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

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
	
	public static final String Column1Rank = "Rank";
	public static final String Column2Score = "Score";
	public static final String Column3Player = "Player";

	// Controller
	public StartController(){
		initComponents();

		//Action events are generated when OK is pressed.
		startView.getInputNameBtn().setOnAction(eventOK -> {
			if (eventOK.getSource()==startView.getInputNameBtn() && startView.getTxtYourName().getText()!="")
				startView.getNewStage().close();
			startView.getTxtArea().setText("Player:"+ " " + startView.getTxtYourName().getText()+" " + " " + "Status:" + " " 
					+ startModel.getClientReceive().setStrData());
			generateDataInMap();
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
        readingToHighScore.updateHighScore();
        HashMap highScoreList = readingToHighScore.getHashMapHighScore();
        
        ArrayList poangList = readingToHighScore.getPoang();
        
        
        ObservableList<Map> allData = FXCollections.observableArrayList();
        

        System.out.println("highscore storlek:"+highScoreList.size());
        for (int i = 1; i <= highScoreList.size(); i++) {

        	HashMap<String, String> dataRow = new HashMap<>();    
    
            dataRow.put(Column1Rank, ""+ i);
            dataRow.put(Column2Score, (String) poangList.get(i));
            dataRow.put(Column3Player, (String) highScoreList.get(i));
 			
            allData.add(dataRow); 
        }
        readingToHighScore.getHashMapHighScore().forEach((key, value) -> System.out.println(key + "+" +value));
        startView.getTable().setItems(allData);  
        
    }
	
}
