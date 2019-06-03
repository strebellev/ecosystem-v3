package objects;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class RedBerry {
	PApplet parent;
	ArrayList<PVector> redberry;
	public PVector position;
	
	int r;
	
	float berrylive;
	
	PImage img;
	
	@SuppressWarnings("deprecation")
	public RedBerry(PImage tempImg, PApplet p, PVector l){
		position = l.get();
		parent = p;
		r = 16;
		redberry = new ArrayList<PVector>();
		img = tempImg;
		berrylive = 255;
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		redberry.add(l.get());
	}
	
	public void display(PApplet p){
		p.ellipseMode(PConstants.CENTER);
		//p.fill(0);
		//p.ellipse(position.x, position.y, r, r);
		p.image(img, position.x-8, position.y-8);
		//p.text("live " + berrylive, position.x, position.y);
	}
	
	public ArrayList<PVector> getRedBerry(){
		return redberry;
	}
	
	public PVector position(){
		return position;
	}
	
	public float getR(){
		return r;
	}
	
	public void growOld(RedBerry rb){
		ArrayList<PVector> redberry = rb.getRedBerry();
		for(int i = redberry.size()-1; i >= 0; i--){
			//berrylive -= 0.56;
		}
		berrylive -= 0.06;
	}
	
	public boolean rotten(){
		if(berrylive < 0.0){
			return true;
		}
		else{
			return false;
		}
	}
}
