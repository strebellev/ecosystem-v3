

import mechanisme.World2;
import processing.core.PApplet;

public class Game extends PApplet{
	
	public static void main(String[] args){
		PApplet.main("Game");
	}
	
	public void settings(){
		size(1200,900);
		
	}
	
	World2 world2;
	//World world;
	
	public void setup(){
		//world = new World(this);
		
		world2 = new World2(this);
		surface.setResizable(true);
	}
	
	public void draw(){
		world2.run();
		//world.makeVegetalPassif(20, 20);
		//world.render();
	}
}
