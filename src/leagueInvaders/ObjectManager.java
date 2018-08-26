package leagueInvaders;

import java.awt.Graphics;

public class ObjectManager {
Rocketship ship;
ObjectManager(Rocketship ship){
	this.ship=ship;
}
void update() {
	ship.update();
}
void draw(Graphics g) {
	ship.draw(g);
}
}
