package leagueInvaders;

import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaderRunner {
	GamePanel GP;
	JFrame frame;
	final static int WIDTH=500;
	final static int HEIGHT=800;
	
public static void main(String[]args) {
	
LeagueInvaderRunner LIR=new LeagueInvaderRunner();
	LIR.setup();
}

void setup() {
	GP=new GamePanel();
	frame=new JFrame();
	frame.add(GP);
	frame.addKeyListener(GP);
	frame.setSize(WIDTH, HEIGHT);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
    frame.pack();
    GP.startGame();
}
}
