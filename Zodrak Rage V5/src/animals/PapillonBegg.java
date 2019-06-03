package animals;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class PapillonBegg {
	PApplet parent;
	ArrayList<PVector> papillonbegg;
	
	public PVector position;
	
	float grow;
	float r;
	
	@SuppressWarnings("deprecation")
	public PapillonBegg(PVector l, PApplet p){
		parent = p;
		position = l.get();
		grow = 0;
		r = 5;
	}
	
	void update(){
		grow += 0.1;
	}
	
	void display(){
		parent.ellipseMode(PConstants.CENTER);
		parent.strokeWeight(1);
		parent.stroke(0);
		parent.fill(0,102,204);
		parent.ellipse(position.x, position.y, r, r);
		parent.noFill();
		parent.noStroke();
		
		//parent.fill(0);
		//parent.text("grow " + grow, position.x+10, position.y+10);
		//parent.noFill();
	}
	
	public float getR(){
		return r;
	}
	
	public float getGrow(){
		return grow;
	}
	
	public void run(PApplet p){
		update();
		display();
	}
	
	public boolean growUp(){
		if(grow > 200){
			return true;
		}
		else{
			return false;
		}
	}
}
