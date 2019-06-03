package mechanisme;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class tileWater {
	PApplet parent;
	ArrayList<PVector> tilewater;
	public PVector position;
	
	int r;
	
	PImage img;
	
	@SuppressWarnings("deprecation")
	public tileWater(PImage tempImg, PApplet p, PVector l){
		position = l.get();
		parent = p;
		r = 32;
		tilewater = new ArrayList<PVector>();
		img = tempImg;
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		tilewater.add(l.get());
	}
	
	public void display(PApplet p){
		p.rectMode(PConstants.CORNER);
		//p.fill(153,0,153);
		p.rect(position.x, position.y, r, r);
		p.image(img, position.x, position.y);
		
	}
	
	public ArrayList<PVector> getTileWater(){
		return tilewater;
	}
	
	public PVector position(){
		return position;
	}
}
