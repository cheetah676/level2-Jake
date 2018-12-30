package loraxGame;

import java.applet.AudioClip;
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
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import leagueInvaders.Aliens;
import leagueInvaders.LeagueInvaderRunner;
import leagueInvaders.ObjectManager;
import leagueInvaders.Rocketship;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	AudioClip sound = JApplet.newAudioClip(getClass().getResource("pow.wav"));
	final int MENU_STATE=0;
	final int GAME_STATE=1;
	final int END_STATE=2;
	final int WIN_STATE=3;
	int currentState=MENU_STATE;
	boolean drawTree=true;
	boolean drawTree2=false;
	boolean message=false;
Timer timer=new Timer(1000/60, this);
long taxTimer=0;
long otherTimer=0;
long idkTimer=0;
int taxGuyVisit=15000;
int second=1000;
int i=16;
int score=50;
int taxAmount;
int addedScore=1;
int moreProductionPrice=50;
int auto=0;
int autoPrice=30;
int percent;
int tax=45;
int times5=5;
boolean doubleTree=false;
int doubleTreePrice=200;
Font font;
Font enter;
Font H;
Font taxText;
Font nextTax;
Font showScore;
Font upgradeA;
Font upgradeP;
Font upgradeD;
Font D;
Font win;
Font restart;
Lorax lorax=new Lorax(250, 200, 100, 100);
Tree tree=new Tree(220, 20, 200, 200);
Rock rock=new Rock(350, 200, 200, 100);
Tree2 tree2=new Tree2(300, 100, 200, 200);
TaxGuy taxGuy=new TaxGuy(800, 300, 200, 200);
DoubleTree doubletree=new DoubleTree(170, 20, 200, 200);
DoubleTree2 doubletree2=new DoubleTree2(300, 50, 200, 200);
SuperLorax superLorax=new SuperLorax(200, 95, 400, 400);
public static BufferedImage loraxImg;
public static BufferedImage rockImg;              
public static BufferedImage treeImg;
public static BufferedImage tree2Img;
public static BufferedImage taxGuyImg;
public static BufferedImage doubletreeImg;
public static BufferedImage doubletree2Img;
public static BufferedImage SuperLoraxImg;
GamePanel(){
	font=new Font("Arial", Font.PLAIN, 48);
	enter=new Font("Arial", Font.PLAIN, 24);
	H=new Font("Arial", Font.PLAIN, 24);
	taxText=new Font("Arial", Font.PLAIN, 24);
	nextTax=new Font("Arial", Font.PLAIN, 24);
	upgradeA=new Font("Arial", Font.BOLD, 14);
	upgradeP=new Font("Arial", Font.BOLD, 14);
	upgradeD=new Font("Arial", Font.BOLD, 14);
	D=new Font("Arial", Font.BOLD, 14);
	win=new Font("Arial", Font.BOLD, 24);
	restart=new Font("Arial", Font.BOLD, 14);
    try {
        loraxImg = ImageIO.read(this.getClass().getResourceAsStream("lorax.png"));
        rockImg = ImageIO.read(this.getClass().getResourceAsStream("rock.png"));
        treeImg = ImageIO.read(this.getClass().getResourceAsStream("tree.png"));
        tree2Img = ImageIO.read(this.getClass().getResourceAsStream("tree2.png"));
        taxGuyImg = ImageIO.read(this.getClass().getResourceAsStream("taxGuy.png"));
        doubletreeImg = ImageIO.read(this.getClass().getResourceAsStream("doubletree.png"));
        doubletree2Img = ImageIO.read(this.getClass().getResourceAsStream("doubletree2.png"));
        SuperLoraxImg = ImageIO.read(this.getClass().getResourceAsStream("SuperLorax.jpg"));
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
	g.setFont(H);
	g.drawString("Press H for instructions", 240, 400);
}
void drawGameState(Graphics g) {
	GameRunner.frame.pack();
	percent=score/10;
	if(message==false) {
	if(score>=50000) {
		System.out.println("You win. You are the god of Lorax Clicker");
		message=true;
		currentState=WIN_STATE;
		taxGuy.x=800;
	}
	}
	g.setColor(Color.GREEN);
	g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);
	lorax.draw(g);
	rock.draw(g);
	taxGuy.draw(g);
	if(drawTree==true) {
		tree.draw(g);
		if(doubleTree==true) {
			doubletree.draw(g);
		}
	}
	if(drawTree2==true) {
		tree2.draw(g);
		if(doubleTree==true) {
			doubletree2.draw(g);
		}
	}
	if (System.currentTimeMillis() - idkTimer >=1000) {
		i-=1;
		score+=auto;
idkTimer=System.currentTimeMillis();
if (System.currentTimeMillis() - taxTimer >= taxGuyVisit) {
	taxGuy.x-=200;
	taxTimer = System.currentTimeMillis();
}
if (System.currentTimeMillis() - otherTimer >= taxGuyVisit+3000) {
	taxGuy.x+=200;
	otherTimer = taxTimer;
	taxAmount=tax+percent;
	score-=taxAmount;
	tax+=times5;
	times5+=5;
	if(score<0) {
		currentState=END_STATE;
	}
}
	}
	g.setColor(Color.BLUE);
	g.setFont(nextTax);
	g.drawString("Next tax come in " +i+ " seconds", 20, 50);
		if(i<=0) {
			i=15;
		}
		g.setFont(showScore);
		g.setColor(Color.BLACK);
		g.drawString("Score:"+score, 20, 450);
		g.setFont(upgradeA);
		g.drawString("Press A to add an auto clicker-"+autoPrice, 490, 20);
		g.setFont(upgradeP);
		g.drawString("Press P to get more materials per whack-"+moreProductionPrice, 490, 70);
		g.setFont(upgradeD);
		g.drawString("Press D to double production per whack-"+doubleTreePrice, 490, 130);
		g.setFont(D);
		g.drawString("D is a one time upgrade and only doubles current, not future production", 100, 350);
		}

void drawEndState(Graphics g) {
	g.setColor(Color.RED);
	g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);
	g.setFont(taxText);
	g.setColor(Color.BLACK);
	g.drawString("You became broke due to taxes, and died.", 150, 200);
}
void drawWinState(Graphics g) {
	g.setColor(Color.YELLOW);
	g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);
	g.setFont(win);
	g.setColor(Color.BLACK);
	g.drawString("Winner Winner Chicken Dinner", 220, 30);
	g.drawString("You are the god of Lorax Clicker", 210, 60);
	g.setFont(restart);
	g.drawString("Press ENTER to restart, with no point limit.  Restart the program if you would like to win again", 100, 90);
	superLorax.draw(g);
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
score=50;
tax=45;
addedScore=1;
moreProductionPrice=50;
auto=0;
autoPrice=30;
doubleTreePrice=200;
doubleTree=false;
taxTimer=0;
otherTimer=0;
idkTimer=0;
i=16;
taxGuyVisit=15000;
message=false;
}
else if(currentState==WIN_STATE) {
	drawWinState(g);
	score=50;
	tax=45;
	addedScore=1;
	moreProductionPrice=50;
	auto=0;
	autoPrice=30;
	doubleTreePrice=200;
	doubleTree=false;
	taxTimer=0;
	otherTimer=0;
	idkTimer=0;
	i=16;
	taxGuyVisit=15000;
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
		}
		if (currentState == END_STATE) {
			currentState = MENU_STATE;
		}
		if (currentState == WIN_STATE) {
			currentState = MENU_STATE;
		}
		}
	else if(e.getKeyCode()==KeyEvent.VK_BACK_SLASH) {
		score+=1000;
	}
	else if (e.getKeyCode()==KeyEvent.VK_SPACE) {
		drawTree=false;
		drawTree2=true;
	}
	else if(e.getKeyCode()==KeyEvent.VK_H) {
		JOptionPane.showMessageDialog(null, "Press Space to mine the rock, and upgrade your whacking power with upgrades shown on the next screen.  Do not become broke due to taxes, or you lose.  Get at least 55 to pass the first round, and it will progessively get harder after.  Get 50,000 or more to win.");
	}
}
private void playSound(String pow) {
	sound.stop();
	sound.play();
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	if (e.getKeyCode()==KeyEvent.VK_SPACE && currentState==GAME_STATE) {
		drawTree=true;
		drawTree2=false;
		score+=addedScore;
		playSound("pow.wav");
	}
	else if(e.getKeyCode()==KeyEvent.VK_A && currentState==GAME_STATE) {
		auto+=2;
		score-=autoPrice;
		autoPrice+=10;
	}
	else if(e.getKeyCode()==KeyEvent.VK_P && currentState==GAME_STATE) {
		addedScore+=1;
		score-=moreProductionPrice;
		moreProductionPrice+=10;
	}
	else if(e.getKeyCode()==KeyEvent.VK_D && currentState==GAME_STATE) {
		if(doubleTree==false) {
		addedScore*=2;
		auto*=2;
		doubleTree=true;
		score-=doubleTreePrice;
		}
		else {
			JOptionPane.showMessageDialog(null, "You already have double trees");
		}
	}
}
}
