package loraxGame;

import java.awt.Dimension;

import javax.swing.JFrame;
public class GameRunner {
	static JFrame frame;
	final static int WIDTH=800;
	final static int HEIGHT=500;
	static GamePanel GP;
	public static void main(String[]args) {
		GameRunner GR=new GameRunner();
		GR.run();
	}
	void run() {
GP=new GamePanel();
frame=new JFrame();
frame.setTitle("Lorax Clicker");
frame.add(GP);
frame.addKeyListener(GP); 
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(WIDTH, HEIGHT);
frame.setVisible(true);
frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
GP.startGame();
	}
}
