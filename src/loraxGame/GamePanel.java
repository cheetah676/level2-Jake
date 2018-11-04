package loraxGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import leagueInvaders.Aliens;
import leagueInvaders.LeagueInvaderRunner;
import leagueInvaders.ObjectManager;
import leagueInvaders.Rocketship;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	final int MENU_STATE=0;
	final int GAME_STATE=1;
	final int END_STATE=2;
	int currentState=MENU_STATE;
	boolean drawTree=true;
	boolean drawTree2=false;
Timer timer=new Timer(1000/60, this);
long taxTimer=0;
long otherTimer=0;
long idkTimer=0;
int taxGuyVisit=15000;
int taxGuyLeave=18000;
int second=1000;
int i=15;
Font font;
Font enter;
Font space;
Font tax;
Font nextTax;
Lorax lorax=new Lorax(250, 200, 100, 100);
Tree tree=new Tree(220, 20, 200, 200);
Rock rock=new Rock(350, 200, 200, 100);
Tree2 tree2=new Tree2(300, 100, 200, 200);
TaxGuy taxGuy=new TaxGuy(800, 300, 200, 200);
public static BufferedImage loraxImg;
public static BufferedImage rockImg;
public static BufferedImage treeImg;
public static BufferedImage tree2Img;
public static BufferedImage taxGuyImg;
GamePanel(){
	font=new Font("Arial", Font.PLAIN, 48);
	enter=new Font("Arial", Font.PLAIN, 24);
	space=new Font("Arial", Font.PLAIN, 24);
	tax=new Font("Arial", Font.PLAIN, 24);
	nextTax=new Font("Arial", Font.PLAIN, 24);
    try {
        loraxImg = ImageIO.read(this.getClass().getResourceAsStream("lorax.png"));
        rockImg = ImageIO.read(this.getClass().getResourceAsStream("rock.png"));
        treeImg = ImageIO.read(this.getClass().getResourceAsStream("tree.png"));
        tree2Img = ImageIO.read(this.getClass().getResourceAsStream("tree2.png"));
        taxGuyImg = ImageIO.read(this.getClass().getResourceAsStream("taxGuy.png"));
} catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
}


}
void updateMenuState() {
	
}
void updateGameState() {
	lorax.update();
	tree.update();
	rock.update();
	tree2.update();
	if (System.currentTimeMillis() - taxTimer >= taxGuyVisit) {
		taxGuy.x-=200;
		taxTimer = System.currentTimeMillis();
	}
	if (System.currentTimeMillis() - otherTimer >= taxGuyLeave) {
		taxGuy.x+=200;
		otherTimer = System.currentTimeMillis();
	}
}
void updateEndState(){
	
}
void drawMenuState(Graphics g) {
	g.setColor(Color.BLUE);
	g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);
	g.setFont(font);
	g.setColor(Color.BLACK);
	g.drawString("Lorax Game", 250, 100);
	g.setFont(enter);
	g.drawString("Press ENTER to start", 265, 250);
	g.setFont(space);
	g.drawString("Press H for instructions", 240, 400);
}
void drawGameState(Graphics g) {
	g.setColor(Color.GREEN);
	g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);
	lorax.draw(g);
	rock.draw(g);
	taxGuy.draw(g);
	if(drawTree==true) {
		tree.draw(g);
	}
	if(drawTree2==true) {
		tree2.draw(g);
	}
	if (System.currentTimeMillis() - idkTimer >=1000) {
		i-=1;
idkTimer=System.currentTimeMillis();
	}
	g.setColor(Color.BLUE);
	g.setFont(nextTax);
	g.drawString("Next tax come in " +i+ " seconds", 50, 50);
		if(i<0) {
			i=15;
		}
}
void drawEndState(Graphics g) {
	g.setColor(Color.RED);
	g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);
	g.setFont(tax);
	g.setColor(Color.BLACK);
	g.drawString("You became broke due to taxes, and died.", 150, 200);
}
void startGame() {
	timer.start();
}
@Override
public void paintComponent(Graphics g){
    if(currentState == MENU_STATE){
drawMenuState(g);
}
    else if(currentState == GAME_STATE){
drawGameState(g);
}
else if(currentState == END_STATE){
drawEndState(g);
}
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
    if(currentState == MENU_STATE){
        updateMenuState();
}
    else if(currentState == GAME_STATE){
        updateGameState();
}
    else if(currentState == END_STATE){
        updateEndState();
}
	repaint();
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
		}
	}
	else if (e.getKeyCode()==KeyEvent.VK_SPACE) {
		drawTree=false;
		drawTree2=true;
	}
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	if (e.getKeyCode()==KeyEvent.VK_SPACE) {
		drawTree=true;
		drawTree2=false;
	}
}
}
