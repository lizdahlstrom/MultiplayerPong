package Application.model;

import Application.view.Pong;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball {
	int x, y; // center på boll
	int vx,vy; // velocity vector

	private Pong pong;
	private SoundEngine soundEngine;

	final static int RADIUS = 12;


	public Ball(Pong pong, SoundEngine soundEngine) {
		this.pong = pong;
		this.soundEngine = soundEngine;
		reset();
	}

	public void render(GraphicsContext gc){
		gc.setFill(Color.WHITE);
		gc.fillOval(x-RADIUS, y-RADIUS, 2*RADIUS, 2*RADIUS);
	}


	//Starta bollen i mitten och den skjuts höger eller vänster randomly
	public void reset() {
		x = pong.getWidth()/2;
		y = pong.getHeight()/4;
		if (Math.random() < 0.5)
			vx = -3;
		else
			vx = 3;
		vy = (int)(2+2*Math.random());
	}

	public int getX() {
		return x;
	}

	public void checkHit(Paddle p) {
		int px = p.getX();
		if (Math.abs(px - x) > RADIUS)
			return;
		int py1 = p.getTop();
		int py2 = p.getBottom();
		if ((y < py1)||(y > py2))
			return;

		// omvänd riktning
		soundEngine.playpSound1();
		vx = -vx;
	}

	public void move() {
		x += vx;
		y += vy;
		// Studsar mot långsidorna
		if (y < RADIUS || y+RADIUS > pong.getHeight()){
			vy = -vy;
			soundEngine.playpSound2();
		}

	}

}