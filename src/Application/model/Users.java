package Application.model;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Users {
	private final SimpleIntegerProperty rank;
	private final SimpleIntegerProperty score;
	private final SimpleStringProperty name;
	
	private Users(byte ranking, int scoring, String naming) {
        this.rank = new SimpleIntegerProperty (ranking);
        this.score = new SimpleIntegerProperty (scoring);
        this.name = new SimpleStringProperty (naming);
    }
	
	//Get the player's name.
	public String getName() {
		return name.get();
	}
	
	//Set the player's name.
	 public void setName(String naming) {
	        name.set(naming);
	    }
	
	//Get the player's score.
	public int getScore() {
		return score.get();
	}
	
	//Set the player's score.
	public void setScore(int scoring) {
		score.set(scoring);
	}
	
	//Rank the players' score
	public void setRank() {	
	};
	
	
}
