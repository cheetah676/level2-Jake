package leagueInvaders;
import javax.swing.Timer;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class GamePanel extends JPanel implements ActionListener, KeyListener{
	GameObject GO;

	Timer timer=new Timer(1000/60, this);
GamePanel(){
	GO=new GameObject(1, 1, 1, 1);
}
	@Override
	public void paintComponent(Graphics g){

	        }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
	void startGame() {
		timer.start();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Hi");
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Yo");
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Yee");
	}
}
