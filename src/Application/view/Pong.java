package Application.view;


import Application.model.Ball;
import Application.model.Paddle;
import Application.model.ScoreBoard;
import Application.model.SoundEngine;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class Pong {
	final String appName = "Tennis";
	final int FPS = 60;
	final static int WIDTH = 800;
	private Timeline mainLoop;
	private Scene theScene;


	final static int HEIGHT = 600;
	final static int EDGE = 30;

	private Ball ball;
	private Paddle pleft, pright;
	private ScoreBoard score;

	//SoundEngine pSound0, pSound1, pSound2, pSound3, pSound4, pSound5;

	SoundEngine soundEngine = new SoundEngine();


	public Pong (ScoreBoard scoreBoard, Ball ball, Paddle pleft, Paddle pright){
		this.ball = ball;
		this.pleft = pleft;
		this.pright = pright;
		this.score = scoreBoard;
		Group root = new Group();
		theScene = new Scene(root);

		Canvas canvas = new Canvas(WIDTH, HEIGHT);
		root.getChildren().add(canvas);

		GraphicsContext gc = canvas.getGraphicsContext2D();


		// Initial setup
		setHandlers(theScene);


		//animeringsloop(game loop)
		KeyFrame kf = new KeyFrame(Duration.millis(1000 / FPS),
				e -> {
					// uppdatera position
					update();
					// rita bild
					render(gc);
				}
				);
		mainLoop = new Timeline(kf);
		mainLoop.setCycleCount(Animation.INDEFINITE);
		/*mainLoop.play();*/

	}

	void setHandlers(Scene scene)
	{
		scene.setOnKeyPressed(
				e -> {
					KeyCode c = e.getCode();
					switch (c) {
					case A: pleft.setUpKey(true);
					break;
					case Z: pleft.setDownKey(true);
					break;
					case K: pright.setUpKey(true);
					break;
					case M: pright.setDownKey(true);
					break;
					default:
						break;
					};

				}
				);

		scene.setOnKeyReleased(
				e -> {
					KeyCode c = e.getCode();
					switch (c) {
					case A: pleft.setUpKey(false);
					break;
					case Z: pleft.setDownKey(false);
					break;
					case K: pright.setUpKey(false);
					break;
					case M: pright.setDownKey(false);
					break;
					default:
						break;
					}
				}
				);
	}


	//Uppdatera variabler för varje steg
	public void update()
	{
		pleft.move();
		pright.move();
		ball.move();
		ball.checkHit(pleft);
		ball.checkHit(pright);
		playAudioClip();
		checkScore();
	}

	void checkScore() {
		boolean scored = false;
		if (ball.getX() < EDGE) {
			score.bumpRight();
			scored = true;
		}
		if (ball.getX() > WIDTH - EDGE) {
			score.bumpLeft();
			scored = true;
		}
		if (scored)
			ball.reset();
	}

	private void playAudioClip() {
		if (ball.getX() < EDGE || ball.getX() >= WIDTH - EDGE ) {
			System.out.println("Playing sound 4");
			soundEngine.playpSound4();
		}
	}


	//Rita spelplan
	void render(GraphicsContext gc) {
		// fyll bakgrund
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, WIDTH, HEIGHT);
		// rita spelobjekt
		pleft.render(gc);
		pright.render(gc);
		score.render(gc);
		ball.render(gc);
	}


	//animering och events med initiering
	/*public static void main(String[] args) {
		launch(args);
	}*/



	// setters, getters
	public Timeline getGameLoop(){
		return mainLoop;
	}

	public Scene getScene(){
		return theScene;
	}

	public static int getEdge() {
		return EDGE;
	}
	public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}



}