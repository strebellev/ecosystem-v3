package objects;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class YellowBerry {
	PApplet parent;
	ArrayList<PVector> yellowberry;
	public PVector position;
	
	int r;
	
	float berrylive;
	
	PImage img;
	
	@SuppressWarnings("deprecation")
	public YellowBerry(PImage tempImg, PApplet p, PVector l){
		position = l.get();
		parent = p;
		r = 16;
		yellowberry = new ArrayList<PVector>();
		img = tempImg;
		berrylive = 255;
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		yellowberry.add(l.get());
	}
	
	public void display(PApplet p){
		p.ellipseMode(PConstants.CENTER);
		//p.fill(0);
		//p.ellipse(position.x, position.y, r, r);
		p.image(img, position.x-8, position.y-8);
		//p.text("live " + berrylive, position.x, position.y);
	}
	
	public ArrayList<PVector> getYellowBerry(){
		return yellowberry;
	}
	
	public PVector position(){
		return position;
	}
	
	public float getR(){
		return r;
	}
	
	public void growOld(YellowBerry yb){
		ArrayList<PVector> yellowberry = yb.getYellowBerry();
		for(int i = yellowberry.size()-1; i >= 0; i--){
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
