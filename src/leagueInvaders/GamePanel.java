package leagueInvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	
	  public static BufferedImage alienImg;

      public static BufferedImage rocketImg;

      public static BufferedImage bulletImg;

      public static BufferedImage spaceImg;
    final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font enter;
	Font space;
	Font gameOver;
	Font enemies;
	Font restart;
	Rocketship ship = new Rocketship(250, 700, 50, 50);
	ObjectManager OM = new ObjectManager(ship);
	Timer timer = new Timer(1000 / 60, this);
	boolean moveRight;
	boolean moveLeft;
	boolean moveUp;
	boolean moveDown;
	GamePanel() {
		titleFont = new Font("Arial", Font.BOLD, 48);
		enter = new Font("Arial", Font.BOLD, 24);
		space = new Font("Arial", Font.BOLD, 24);
		gameOver = new Font("Arial", Font.BOLD, 48);
		enemies = new Font("Arial", Font.BOLD, 24);
		restart = new Font("Arial", Font.BOLD, 24);
		  try {

              alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));

              rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));

              bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));

              spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));

      } catch (IOException e) {

              // TODO Auto-generated catch block

              e.printStackTrace();

      }
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
		if (moveRight == true) {
			ship.x += ship.speed;
		}
		if (moveLeft == true) {
			ship.x -= ship.speed;
		}
		if (moveUp == true) {
			ship.y -= ship.speed;
		}
		if (moveDown == true) {
			ship.y += ship.speed;
		}
	}

	void startGame() {
		timer.start();
	}

	void updateMenuState() {

	}

	void updateGameState() {
		OM.update();
		OM.manageEnemies();
		OM.checkCollision();
		OM.purgeObjects();
	if(ship.isAlive==false) {
			currentState=END_STATE;
		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaderRunner.WIDTH, LeagueInvaderRunner.HEIGHT);
		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		g.drawString("LEAGUE INVADERS", 25, 100);
		g.setFont(enter);
		g.drawString("Press ENTER to start", 130, 300);
		g.setFont(space);
		g.drawString("Press Space for instructions", 80, 500);
	}

	void drawGameState(Graphics g) {
		g.drawImage(GamePanel.spaceImg, 0, 0, LeagueInvaderRunner.WIDTH, LeagueInvaderRunner.HEIGHT, null);
		OM.draw(g);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaderRunner.WIDTH, LeagueInvaderRunner.HEIGHT);
		g.setColor(Color.BLACK);
		g.setFont(gameOver);
		g.drawString("Game Over", 100, 100);
		g.setFont(enemies);
		g.drawString("You killed " + OM.score + " enemies", 125, 250);
		g.setFont(restart);
		g.drawString("Press enter to restart", 120, 400);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == MENU_STATE) {
				currentState = GAME_STATE;
			} else if (currentState == GAME_STATE) {
				currentState = END_STATE;
			}

			else if (currentState == END_STATE) {
				currentState = MENU_STATE;
				ship=new Rocketship(250, 700, 50, 50);
				OM=new ObjectManager(ship);
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moveRight = true;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			moveLeft = true;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			moveUp = true;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			moveDown = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moveRight = false;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			moveLeft = false;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			moveUp = false;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			moveDown = false;
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			OM.addProjectile(new Projectile(ship.x + 20, ship.y + 20, 10, 20));
		}
	}
}