package Application.model;

import Application.view.Pong;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ScoreBoard {

	int left = 0;  // poäng för spelare vänster
	int right = 0; // poäng för spelare höger

	Font font;
	private Pong pong;

	public ScoreBoard(Pong pong){
		this.pong = pong;
		font = Font.font("SansSerif", FontWeight.BOLD, 24);
	}

	public void render(GraphicsContext gc){
		gc.setFill(Color.WHITE);
		gc.setFont(font);
		gc.fillText(""+left, 2*pong.getEdge(), 2*pong.getEdge());
		gc.fillText(""+right, pong.getWidth() - 2*pong.getEdge(), 2*pong.getEdge());
	}

	public void bumpRight(){
		right++;
	}

	public void bumpLeft(){
		left++;
	}

}
