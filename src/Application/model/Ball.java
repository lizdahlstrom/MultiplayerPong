package Application.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball {
	int x, y; // center p� boll
	int vx,vy; // velocity vector
	private final int WIDTH, HEIGHT;

	private SoundEngine soundEngine;

	final static int RADIUS = 12;


	public Ball(int WIDTH, int HEIGHT, SoundEngine soundEngine) {
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		this.soundEngine = soundEngine;
		reset();
	}

	public void render(GraphicsContext gc){
		gc.setFill(Color.WHITE);
		gc.fillOval(x-RADIUS, y-RADIUS, 2*RADIUS, 2*RADIUS);
	}


	//Starta bollen i mitten och den skjuts h�ger eller v�nster randomly
	public void reset() {
		x = WIDTH/2;
		y = HEIGHT/4;
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

		// omv�nd riktning
		soundEngine.playpSound1();
		vx = -vx;
		System.out.println("PADkolision: " + py1 + "Vad �r py2: " + py2);
	}

	public void move() {
		x += vx;
		y += vy;
		// Studsar mot l�ngsidorna
		if (y < RADIUS || y+RADIUS > HEIGHT){
			vy = -vy;
			soundEngine.playpSound2();
			System.out.println("kolisionsdata top o botten med riktning: " + "x: " + x + "y: " + y + "vx: " + vx + "vy: " + vy);
		}

	}

}