package leagueInvaders;

import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	 ArrayList<Projectile> dogs = new ArrayList<>();
Rocketship ship;
ObjectManager(Rocketship ship){
	this.ship=ship;
}
void update() {
	ship.update();
	for(int i=0; i<dogs.size(); i++) {
	dogs.get(i).update();
	}
}
void draw(Graphics g) {
	ship.draw(g);
	for(int i=0; i<dogs.size(); i++) {
		dogs.get(i).draw(g);
	}
}
void addProjectile(Projectile p) {
	dogs.add(p);
}
}
