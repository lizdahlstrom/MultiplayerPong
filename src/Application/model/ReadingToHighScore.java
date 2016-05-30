package Application.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadingToHighScore {
	
	public static void main(String[]args) {
		JSONParser parser = new JSONParser();
		
		try {
			Object obj = parser.parse(new FileReader("C:\\GamePong2016/MultiPlayerPong/highScoreData.json"));
			
			JSONObject jsonObject = (JSONObject) obj;
			
			String winners = (String) jsonObject.get("HighScore"); System.out.println(""+winners); 
			
			long rank = (Long) jsonObject.get("Rank");
			
			System.out.println("The Top 10 are:");
			JSONArray listOfHighScores = (JSONArray) jsonObject.get("Top ten");
			Iterator<String> iterator = listOfHighScores.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		}
}
