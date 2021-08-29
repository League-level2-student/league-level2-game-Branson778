import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class MovingObjectManager {
Player player2 = new Player(50, 400, 50, 50);
ArrayList<Arrow> arrows = new ArrayList<Arrow>();
int debugInt;
void  draw (Graphics h) {
	player2.draw(h);
	for (int i = 0; i < arrows.size(); i++) {
		arrows.get(i).draw(h);
	}
	//h.setColor(Color.RED);
	//h.fillRect(50, 50, 15, 15);
}
MovingObjectManager(){
	
}
void update(){
	player2.update();
	for (int i = 0; i < arrows.size(); i++) {
		arrows.get(i).update();
	}
}
}
