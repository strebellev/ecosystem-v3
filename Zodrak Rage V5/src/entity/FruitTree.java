package entity;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class FruitTree {
	PApplet parent;
	ArrayList<PVector> fruittree;
	public PVector position;
	
	int r;
	
	PImage img;
	
	@SuppressWarnings("deprecation")
	public FruitTree(PImage tempImg,PApplet p,PVector l){
		position = l.get();
		parent = p;
		r = 32;
		fruittree = new ArrayList<PVector>();
		img = tempImg;
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		fruittree.add(l.get());
	}
	
	public void display(PApplet p){
		p.ellipseMode(PConstants.CENTER);
		p.fill(0);
		//p.ellipse(position.x, position.y, r, r);
		p.image(img, position.x-32, position.y-60);
	}
	
	public ArrayList<PVector> getFruitTree(){
		return fruittree;
	}
	
	public PVector position(){
		return position;
	}
	
	public float getR(){
		return r;
	}
}
