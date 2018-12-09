package loraxGame;

import java.awt.Graphics;
public class DoubleTree2 extends GameObject{

	DoubleTree2(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
void update() {

}
void draw(Graphics g) {
	  g.drawImage(GamePanel.doubletree2Img, x, y, width, height, null);
}
}