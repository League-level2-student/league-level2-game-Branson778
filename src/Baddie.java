import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Baddie {
	int x;
	int y;
	int width;
	int height;
	int target1;
	int target2;
	int speed = 2;
	Rectangle collisionBox;
	boolean touchingSide = false;
	boolean touchingBottom = false;
	boolean touchingTop = false;
	boolean isActive = true;
	boolean sideMove;
	boolean movingLeft = false;
	boolean movingUp = false;
	Baddie(int x, int y, int width, int height, int target1, int target2, boolean sideMove){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.target1 = target1;
		this.target2 = target2;
		this.sideMove = sideMove;
	collisionBox = new Rectangle(x,y,width,height);
}
	void update() {
		collisionBox.setBounds(x, y, width, height);
		if(sideMove == true) {
			moveHorizontal();
		}
		else{
			moveVertical();
		}
	}
	void moveHorizontal() {
		if( movingLeft == false) {
			x+=speed;
			if(x>=target2) {
				movingLeft = true;
			}
			
		}
		if( movingLeft == true) {
			x-=speed;
			if(x<=target1) {
				movingLeft = false;
			}
			
		}
	}
	void moveVertical() {
		if(movingUp == false) {
			y+=speed;
			if(y>=target2) {
				movingUp = true;
			}
		}
		if(movingUp == true) {
			y-=speed;
			if(y<=target1) {
				movingUp = false;
			}
		}
	}
	void draw(Graphics g) {
		g.setColor(Color.RED);
		//g.drawRect(800,500,800,299);
		g.fillRect(x, y, width, height);
	}
}
