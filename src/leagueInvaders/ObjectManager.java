package leagueInvaders;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<Projectile> bullets = new ArrayList<>();
	ArrayList<Aliens> aliens = new ArrayList<>();
	Rocketship ship;
	long enemyTimer = 0;
	int enemySpawnTime = 3500;
int score=0;
	ObjectManager(Rocketship ship) {
		this.ship = ship;
	}

	void update() {
		ship.update();
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).update();
		}
		for (int a = 0; a < aliens.size(); a++) {
			aliens.get(a).update();
		}
	}

	void draw(Graphics g) {
		ship.draw(g);
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).draw(g);
		}
		for (int a = 0; a < aliens.size(); a++) {
			aliens.get(a).draw(g);
		}
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Aliens(new Random().nextInt(LeagueInvaderRunner.WIDTH), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}

	void addProjectile(Projectile p) {
		bullets.add(p);
	}

	void addAlien(Aliens a) {
		aliens.add(a);
	}
	int getScore() {
		return score;
	}
	void checkCollision(){
		for(Aliens a : aliens){

	        if(ship.collisionBox.intersects(a.collisionBox)){

	                ship.isAlive = false;

	        }	
	}
		for (Projectile b: bullets) {
			for(Aliens a : aliens) {
			if (a.collisionBox.intersects(b.collisionBox)) {
				a.isAlive=false;
				b.isAlive=false;
			}
			}
		}
		}
	void purgeObjects() {
		for (int a = 0; a < aliens.size(); a++) {
			if (aliens.get(a).isAlive == false) {
				aliens.remove(aliens.get(a));
				score+=1;
			}
		}
			for (int i = 0; i < bullets.size(); i++) {
				if (bullets.get(i).isAlive == false) {
					bullets.remove(bullets.get(i));
			}
			}
	}
}
