package Application.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/*
 *  WRITE TO FILE.
 *  hsObject stands for HighScoreObject.
 */

public class WritingToHighScore {
	
	public static void main(String[]args) {
		JSONObject hsObject = new JSONObject();
		hsObject.put("HighScore","Players");
		hsObject.put("Rank", new Integer(10));
		
		JSONArray listOfHighScores = new JSONArray();
		listOfHighScores.add("Obama");
		listOfHighScores.add("Mother Theresa");
		listOfHighScores.add("Butros Butros");
		listOfHighScores.add("Malala");
		listOfHighScores.add("Nils Dacke");
		listOfHighScores.add("Schindler");
		listOfHighScores.add("Raoul Wallenberg");
		listOfHighScores.add("John Rabe");
		listOfHighScores.add("Jeanne D'arce");
		listOfHighScores.add("Marie Curie");
		
		hsObject.put("Top ten", listOfHighScores);
		
		try {
			//Writing to a file.
			File file = new File("C:\\GamePong2016/MultiPlayerPong/highScoreData.json");
			if(!file.exists()){	
			file.createNewFile();
			}			
			FileWriter fileWriter = new FileWriter(file);
			System.out.println("Writing JSON object to file.");
			System.out.println("----------------------------");
			System.out.println(hsObject);
			
			fileWriter.write(hsObject.toJSONString());
			fileWriter.flush();
			fileWriter.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
