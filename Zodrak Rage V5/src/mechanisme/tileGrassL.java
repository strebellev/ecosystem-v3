package mechanisme;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class tileGrassL {
	PApplet parent;
	ArrayList<PVector> tilegrassl;
	public PVector position;
	
	int r;
	
	PImage img;
	
	@SuppressWarnings("deprecation")
	public tileGrassL(PImage tempImg, PApplet p, PVector l){
		position = l.get();
		parent = p;
		r = 32;
		tilegrassl = new ArrayList<PVector>();
		img = tempImg;
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		tilegrassl.add(l.get());
	}
	
	public void display(PApplet p){
		p.rectMode(PConstants.CORNER);
		//p.fill(153,0,153);
		p.rect(position.x, position.y, r, r);
		p.image(img, position.x, position.y);
		
		//p.fill(0);
		//p.text("x " + position.x + " y " + position.y, position.x +10, position.y +10);
		//p.noFill();
		
	}
	
	public ArrayList<PVector> getTileGrassL(){
		return tilegrassl;
	}
	
	public PVector position(){
		return position;
	}
}
