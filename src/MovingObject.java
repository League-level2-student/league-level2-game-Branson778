import java.awt.Rectangle;

public class MovingObject {
//Arrow
//Player
	//int debugInt;
	int x;
	int y;
	int width;
	int height;
	int speed=0;
	boolean touchingSide = false;
	boolean touchingBottom = false;
	boolean touchingTop = false;
	Rectangle collisionBox;
	boolean isActive=true;
	MovingObject(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		collisionBox = new Rectangle(x,y,width,height);
	}

	 void update() {
		  collisionBox.setBounds(x, y, width, height);
	}
}
