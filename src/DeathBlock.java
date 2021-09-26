import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class DeathBlock {
	int x;
	int y;
	int width;
	int height;
	Rectangle collisionBox;
	boolean touchingSide = false;
	boolean touchingBottom = false;
	boolean touchingTop = false;
	DeathBlock(int x, int y, int width, int height){
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
		g.setColor(Color.RED);
		//g.drawRect(800,500,800,299);
		g.fillRect(x, y, width, height);
	}
}
