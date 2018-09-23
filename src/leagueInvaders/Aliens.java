package leagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Aliens extends GameObject {
	boolean right = true;
	int speed = 5;

	Aliens(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	void update() {
		super.update();
		if (x >= 500 - 50) {
			y += 50;
			speed = -5;
		} else if (x <= 0) {
			y += 50;
			speed = 5;
		}
		x += speed;
	}

	void draw(Graphics g) {
		 g.drawImage(GamePanel.alienImg, x, y, width, height, null);
	}
}
