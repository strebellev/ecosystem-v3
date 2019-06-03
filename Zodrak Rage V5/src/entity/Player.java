package entity;



import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class Player {
	PApplet parent;
	
	public PVector position;
	
	////test animation/////fct mais bug a cause du player total buggé
	//int animLeftnumFrame = 3;
	//int currentFrame = 0;
	//PImage[] animLeft = new PImage[animLeftnumFrame];
	///////////////////////
	
	@SuppressWarnings("deprecation")
	public Player(PApplet p, PVector l){
		parent = p;
		position = l.get();
		
		////test animation/////fct mais bug a cause du player total buggé
		//animLeft[0] = p.loadImage("res/player/PlayerL0.png");
		//animLeft[1] = p.loadImage("res/player/PlayerL1.png");
		//animLeft[2] = p.loadImage("res/player/PlayerL2.png");
		///////////////////////
		
	}
	
	public void run(PApplet p){
		parent.fill(204,0,204);
		parent.ellipse(parent.width/2, parent.height/2, 10, 10);
		parent.noStroke();
		
	}
	
	public void PlayerMvt(PApplet p){
		if(p.keyPressed){
			if(p.key == PConstants.CODED){
				if(p.keyCode == PConstants.UP){
					position.y -= 10;
					
					
				}
				if(p.keyCode == PConstants.DOWN){
					position.y += 10;
					
					
				}
				if(p.keyCode == PConstants.LEFT){
					position.x -= 10;
					
					////test////fct mais bug a cause du player total buggé
					//currentFrame = (currentFrame+1) % animLeftnumFrame;
					//int offset = 0;
					//p.image(animLeft[(currentFrame+offset) % animLeftnumFrame],position.x,position.y);
					//offset+=2;
					//p.image(animLeft[(currentFrame+offset) % animLeftnumFrame],position.x,position.y);
					//offset+=2;
					////////////
					
				}
				if(p.keyCode == PConstants.RIGHT){
					position.x += 10;
					
					
				}
			}
		}
	}
	
}
