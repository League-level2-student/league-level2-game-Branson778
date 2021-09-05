import java.awt.Graphics;

public class ArrowDispenser extends MovingObject {

ArrowDispenser(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
public boolean facingLeft = false;
public boolean facingRight = false;
public Arrow getArrow() {
	return new Arrow(x, y+height/2, 34, 9 );
}
void draw(Graphics g) {
	
}
void fireArrow() {
	
}
}
