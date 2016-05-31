package Application.controller;

import Application.model.Ball;
import Application.model.GameModel;
import Application.model.Paddle;
import Application.model.ScoreBoard;
import Application.view.Pong;
import Server.Client;

public class GameController {

	//Instance variables
	private GameModel gameModel;
	private Pong gameView;
	private Client client;
	private boolean isPlaying = false;
	private boolean isReady = false;

	private Paddle p1, p2;
	private Ball ball;

	private ScoreBoard scoreBoard;

	private final int WIDTH = 800;
	private final int HEIGHT = 600;
	private final int EDGE = 30;

	//Constructor
	public GameController(){
		scoreBoard = new ScoreBoard(WIDTH, EDGE);
		gameModel = new GameModel(scoreBoard);
		initComponents();
		gameView = new Pong(scoreBoard, ball, p1, p2);
	}

	//Methods
	private void initComponents(){
		p1 = new Paddle(EDGE, gameView);
		p2 = new Paddle(WIDTH - EDGE, gameView);
		ball = new Ball(WIDTH, HEIGHT, gameModel.getSoundEngine());
	}

	public void startGame(){

		//TODO: Wait for other player to be ready
		// update label in startmenu

		isReady = true;
		gameView.getGameLoop().play();
	}

	public void stopGame(){
		isPlaying = false;
		isReady = false;
		gameView.getGameLoop().stop();
	}

	//Setters, getters
	public GameModel getGameModel() {
		return gameModel;
	}



	public Pong getPong() {
		return gameView;
	}

	public boolean isPlaying(){
		return isPlaying;
	}
}

