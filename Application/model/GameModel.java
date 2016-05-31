package Application.model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

public class GameModel {

	//Instance variables
	private Timeline timeline;
	private KeyFrame keyFrame;
	private SoundEngine soundEngine;
	private ScoreBoard scoreBoard;

	// Constructor
	public GameModel(ScoreBoard scoreBoard){
		this.scoreBoard = scoreBoard;
		timeline = new Timeline();
		soundEngine = new SoundEngine();

	}


	public SoundEngine getSoundEngine(){
		return soundEngine;

	}
}
