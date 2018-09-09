package leagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Aliens extends GameObject {

	Aliens(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	void update() {
	y-=10;
	}
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
}
}                     
