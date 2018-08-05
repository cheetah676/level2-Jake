package leagueInvaders;

public class GameObject {
    int x;
    int y;
    int width;
    int height;
    GameObject(int x, int y, int width, int height){
    	this.x=x;
    	this.y=y;
    	this.width=width;
    	this.height=height;
    }
	void update(){
    	
    }
    void draw(int x) {
    	g.fillRect(10, 10, 100, 100);
    }
}

