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
	Baddie(int x, int y, int width, int height, int target1, int target2){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.target1 = target1;
		this.target2 = target2;
	collisionBox = new Rectangle(x,y,width,height);
}
	void update() {
		collisionBox.setBounds(x, y, width, height);
	}
	void draw(Graphics g) {
		g.setColor(Color.WHITE);
		//g.drawRect(800,500,800,299);
		g.fillRect(x, y, width, height);
	}
}
