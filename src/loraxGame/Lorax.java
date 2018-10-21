package loraxGame;

import java.awt.Color;
import java.awt.Graphics;

public class Lorax extends GameObject{

	Lorax(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
void update() {
	
}
void draw(Graphics g) {
	  g.drawImage(GamePanel.loraxImg, x, y, width, height, null);
}
}
