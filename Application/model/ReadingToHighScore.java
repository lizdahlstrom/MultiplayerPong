package Application.model;

/*
 * SKAPA EN HASHMAP AV 
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadingToHighScore {
	
	static JSONParser parser;

	static HashMap<Integer,String> hashMapHighScore;
	
	static ArrayList<String> poang;
	
	
	public static void hashHighScore() {
				
		try {
			parser = new JSONParser();
			Object obj = parser.parse(new FileReader("C:\\GamePong2016/MultiPlayerPong/highScoreData.json"));
			
			JSONObject jsonObject = (JSONObject) obj;
			
			String winners = (String) jsonObject.get("HighScore"); System.out.println(""+winners); 
			
			long rank = (Long) jsonObject.get("Rank");
			
			
			hashMapHighScore = new HashMap<Integer, String>();
			System.out.println("The Top 10 are:");
			JSONArray listOfHighScores = (JSONArray) jsonObject.get("Top ten");
			JSONArray listOfPoang = (JSONArray) jsonObject.get("Points");
			
			poang = new ArrayList<>();
			
			
			
			
			Iterator<String> iterator = listOfHighScores.iterator();
			Iterator<String> iteratorScore = listOfPoang.iterator();

//			while(iteratorScore.hasNext()){
//				System.out.println(String.valueOf(iteratorScore.next()));
//			}
			
			int counter = 1;
			while (iterator.hasNext()) {
//				System.out.println(iterator.next());
				hashMapHighScore.put(counter, iterator.next());
//				System.out.println(listOfPoang.get(counter));
				poang.add(String.valueOf(iteratorScore.next()));
				counter++;
				//System.out.println("asd: "+hashMapHighScore.get(counter));
				
			}
			
			//looping through hashmap content
			hashMapHighScore.forEach((key, value) -> System.out.println(key + "+" +value));
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		}
	public HashMap getHashMapHighScore(){
		//hashMapIterator.forEach((key, value) -> System.out.println(key + "+" +value));
		
		return hashMapHighScore;
	}
	
	public ArrayList getPoang() {
		return poang;
	}
	
	public void updateHighScore(){
		hashHighScore();
	}
}
