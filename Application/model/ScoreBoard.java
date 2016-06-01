//Creates the score board and increments of points.


package Application.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ScoreBoard {

	int left = 0;  // Left player score
	int right = 0; // Right player score

	Font font;
	private final int WIDTH;
	private final int EDGE;

	public ScoreBoard(int WIDTH, int EDGE){
		this.EDGE = EDGE;
		this.WIDTH = WIDTH;
		font = Font.font("SansSerif", FontWeight.BOLD, 24);
	}

	public void render(GraphicsContext gc){
		gc.setFill(Color.WHITE);
		gc.setFont(font);
		gc.fillText(""+left, 2*EDGE, 2*EDGE);
		gc.fillText(""+right, WIDTH - 2*EDGE, 2*EDGE);
	}

	public void bumpRight(){
		right++;
	}

	public void bumpLeft(){
		left++;
	}

}
