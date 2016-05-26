package ponggame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ScoreBoard {

   int left = 0;  // poäng för spelare vänster
   int right = 0; // poäng för spelare höger

   Font font;

   public ScoreBoard(){
	   font = Font.font("SansSerif", FontWeight.BOLD, 24);
   }

   public void render(GraphicsContext gc){
	   gc.setFill(Color.WHITE);
	   gc.setFont(font);
	   gc.fillText(""+left, 2*Pong.EDGE, 2*Pong.EDGE);
	   gc.fillText(""+right, Pong.WIDTH - 2*Pong.EDGE, 2*Pong.EDGE);
   }

   public void bumpRight(){
	   right++;
   }

   public void bumpLeft(){
	   left++;
   }

}
