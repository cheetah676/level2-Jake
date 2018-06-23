package arrays;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class _01_RobotRace {
	static int e=50;
	static Random ran = new Random();
	//1. make a main method
public static void main(String[]args) {
	//2. create an array of 5 robots.
Robot[] robotArray=new Robot[3];
for(int i=0; i<robotArray.length; i++) {
	robotArray[i]=new Robot();
robotArray[i].setSpeed(10);
	//3. use a for loop to initialize the robots.
		//4. make each robot start at the bottom of the screen, side by side, facing up
	robotArray[i].moveTo(e, 500);
	e+=100;
}
	//5. use another for loop to iterate through the array and make each robot move 
boolean reachTop=false;
//   a random amount less than 50.
while(!reachTop) {
for(int i=0; i<robotArray.length; i++) {
	if(robotArray[i].getX()>=50) {
	int j=ran.nextInt(200);
	robotArray[i].move(j);
	robotArray[i].turn(j/3);
	}
	else {
		reachTop=true;
		if (robotArray[i].getY()<=0) {
			robotArray[i].moveTo(500, 250);
			robotArray[i].sparkle();
			System.out.println(robotArray[i]+" won!");
		}
		for(int o=0; o<robotArray.length; o++) {
		robotArray[o].turn(360);
		robotArray[o].sparkle();
	}
}
}
	//6. use a while loop to repeat step 5 until a robot has reached the top of the screen.

	//7. declare that robot the winner and throw it a party!

	//8. try different races with different amounts of robots.

	//9. make the robots race around a circular track.
	}
}
}

