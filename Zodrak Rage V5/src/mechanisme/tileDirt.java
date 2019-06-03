package mechanisme;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class tileDirt {
	PApplet parent;
	ArrayList<PVector> tiledirt;
	public PVector position;
	
	int r;
	
	PImage img;
	
	@SuppressWarnings("deprecation")
	public tileDirt(PImage tempImg, PApplet p, PVector l){
		position = l.get();
		parent = p;
		r = 32;
		tiledirt = new ArrayList<PVector>();
		img = tempImg;
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		tiledirt.add(l.get());
	}
	
	public void display(PApplet p){
		p.rectMode(PConstants.CORNER);
		//p.fill(153,0,153);
		p.rect(position.x, position.y, r, r);
		p.image(img, position.x, position.y);
		
	}
	
	public ArrayList<PVector> getTileDirt(){
		return tiledirt;
	}
	
	public PVector position(){
		return position;
	}
}
