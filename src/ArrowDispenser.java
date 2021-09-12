import java.awt.Color;
import java.awt.Graphics;

public class ArrowDispenser extends MovingObject {

ArrowDispenser(int x, int y, int width, int height, boolean facingRight) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		this.facingRight=facingRight;
	}
//public boolean facingLeft = false;
public boolean facingRight = false;
public Arrow getArrow() {
	return new Arrow(x, y+height/2-12, 34, 9 ,facingRight );
}
void draw(Graphics g) {
	g.setColor(Color.green);
	g.fillRect(x,y,width,height);
}
/*
void arrowLeft(Arrow arrow) {
	facingRight = false;
	arrow.facingRight = false;
}
void arrowRight(Arrow arrow) {
	facingRight = true;
	arrow.facingRight = true;
}
*/
}
