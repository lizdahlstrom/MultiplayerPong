package Application.model;

//VÄVA IN JSON OCH GSON

/*
 * Java does not have explicit peer-to-peer communication in its core networking API.
 * However, applications can easily offer peer-to-peer communications in several ways, most commonly by
 * acting as both a server and a client. Alt., the peers can communicate with each other
 * through an intermediate server program that forwards data from one peer to the other peers.
 * This neatly solves the discovery problem of how two peers find each other.
 */


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Users {
	private final SimpleIntegerProperty rank;
	private final SimpleIntegerProperty score;
	private final SimpleStringProperty name;
	
	
	private Users(int i, int scoring, String naming) {
        this.rank = new SimpleIntegerProperty (i);
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
	
	//The object containing the player's name and score.
	String nameAndScore = getName() + getScore();
	
	//Rank the players' score
	public void setRank() {	
	};
	
	
}
