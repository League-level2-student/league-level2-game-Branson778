import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PlatformObject {
//Normal Platforms
//Jump Through (Semi-Solid) Platforms
//Falling Platforms
//Arrow Trap
	int x;
	int y;
	int width;
	int height;
	Rectangle collisionBox;
	boolean touchingSide = false;
	boolean touchingBottom = false;
	boolean touchingTop = false;
	PlatformObject(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	collisionBox = new Rectangle(x,y,width,height);
}
	void update() {
		collisionBox.setBounds(x, y, width, height);
	}
	void draw(Graphics g) {
		g.setColor(Color.GRAY);
		//g.drawRect(800,500,800,299);
		g.fillRect(x, y, width, height);
	}
}
