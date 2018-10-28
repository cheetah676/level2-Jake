package loraxGame;

import java.awt.Graphics;

public class TaxGuy extends GameObject{

	TaxGuy(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
void update() {
	
}
void draw(Graphics g) {
	g.drawImage(GamePanel.taxGuyImg, x, y, width, height, null);
}
}
