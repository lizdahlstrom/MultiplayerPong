package ponggame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Paddle {
   int x, y; // top-v�nster h�rn

   boolean upKey = false, downKey = false;

   final static int WIDTH = 20;
   final static int HEIGHT = 70;
   final static int SPEED = 6;

   // S�tt x1 mitten av padd
   public Paddle(int x1){
      x = x1 - WIDTH/2;
      y = Pong.EDGE;
   }

   public void move(){
	   if (upKey && getTop()>0)
	       y -= SPEED;
	   if (downKey && getBottom()<Pong.HEIGHT)
	       y += SPEED;
   }

   public void render(GraphicsContext gc){
	   gc.setFill(Color.WHITE);
	   gc.fillRect(x, y, WIDTH, HEIGHT);
   }

   public void setUpKey(Boolean val){
	   upKey = val;
   }

   public void setDownKey(Boolean val){
	   downKey = val;
   }

   //returnerar x-kord i mitten p� padd
   public int getX(){
	   return x+(WIDTH/2);
   }

   public int getTop(){
	   return y;
   }

   public int getBottom(){
	   return y+HEIGHT;
   }
}