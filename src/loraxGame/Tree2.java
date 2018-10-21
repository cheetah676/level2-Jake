package loraxGame;

import java.awt.Graphics;

public class Tree2 extends GameObject{

	Tree2(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	void update(){
		
	}
	void draw(Graphics g) {
		g.drawImage(GamePanel.tree2Img, x, y, width, height, null);
	}
}
