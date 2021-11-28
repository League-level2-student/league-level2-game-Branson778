import java.util.ArrayList;
import java.util.Random;

public class GenerationSystem {
	public static Random gen1 = new Random();
 public static ArrayList<PlatformObject> createPlatforms() {
	 ArrayList<PlatformObject> platforms = new ArrayList<PlatformObject>();
	int amount = gen1.nextInt(5)+1;
	 for(int i = 0; i < amount; i++ ) {
		 int ranX = gen1.nextInt(800)+200;
		 int ranY = gen1.nextInt(400)+250;
		 int ranWidth = gen1.nextInt(75)+5;
		 int ranHeight = gen1.nextInt(80)+10;
		 PlatformObject platform1 = new PlatformObject(ranX,ranY,ranWidth,ranHeight,"Tileset_2EDIT6.png");
		 platforms.add(platform1);
	 }
	 return platforms;
 }
  public static ArrayList<DeathBlock> createDeathBlocks() {
	return null;
	  
  }
  public static ArrayList<Baddie> createBaddies() {
	return null;
	  
  } 
  public static ArrayList<ArrowDispenser> createDispensers() {
	return null;
	  
  }
  public static ArrayList<PowerSoul> createPowerSouls() {
	return null;
	  
  }
}
