package leagueInvaders;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class GamePanel extends JPanel implements ActionListener, KeyListener{
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState=MENU_STATE;
	Font titleFont;
	Font enter;
	Font space;
	Timer timer=new Timer(1000/60, this);
GamePanel(){
	titleFont=new Font("Arial", Font.PLAIN, 48);
	enter=new Font("Arial", Font.BOLD, 24);
	space=new Font("Arial", Font.BOLD, 24);
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
		repaint();
		   if(currentState == MENU_STATE){
               updateMenuState();
       }
		   else if(currentState == GAME_STATE){
               updateGameState();
       }
		   else if(currentState == END_STATE){
               updateEndState();
       }
	}
	void startGame() {
		timer.start();
	}
	void updateMenuState() {
		
	}
	void updateGameState() {
		
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
		g.drawString("Press ENTER to start", 100, 300);
		g.setFont(space);
		g.drawString("Press Space for instructions", 50, 500);
	}
	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaderRunner.WIDTH, LeagueInvaderRunner.HEIGHT);   	
	}
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaderRunner.WIDTH, LeagueInvaderRunner.HEIGHT);   
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		if(currentState==MENU_STATE) {
			currentState=GAME_STATE;
		}
		else if(currentState==GAME_STATE) {
			currentState=END_STATE;
		}

		else if(currentState==END_STATE){
            currentState = MENU_STATE;
        }
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
