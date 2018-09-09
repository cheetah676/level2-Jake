package leagueInvaders;

import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	 ArrayList<Projectile> bullets = new ArrayList<>();
	 ArrayList<Aliens> aliens = new ArrayList<>();
Rocketship ship;
ObjectManager(Rocketship ship){
	this.ship=ship;
}
void update() {
	ship.update();
	for(int i=0; i<bullets.size(); i++) {
	bullets.get(i).update();
	aliens.get(i).update();
	}
}
void draw(Graphics g) {
	ship.draw(g);
	for(int i=0; i<bullets.size(); i++) {
		bullets.get(i).draw(g);
		aliens.get(i).draw(g);
	}
}
void addProjectile(Projectile p) {
	bullets.add(p);
}
void addAlien(Aliens a) {
	aliens.add(a);
}
}
