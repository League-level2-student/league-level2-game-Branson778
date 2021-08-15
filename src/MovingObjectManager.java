import java.awt.Color;
import java.awt.Graphics;

public class MovingObjectManager {
Player player2 = new Player(50, 400, 50, 50);
int debugInt;
void  draw (Graphics h) {
	player2.draw(h);
	//h.setColor(Color.RED);
	//h.fillRect(50, 50, 15, 15);
}
MovingObjectManager(){
	
}
void update(){
	player2.update();
}
}
