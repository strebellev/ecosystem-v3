package entity;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class Flower {
	PApplet parent;
	ArrayList<PVector> flower;
	public PVector position;
	
	int r;
	
	PImage img;
	
	@SuppressWarnings("deprecation")
	public Flower(PImage tempImg,PApplet p,PVector l){
		position = l.get();
		parent = p;
		r = 32;
		flower = new ArrayList<PVector>();
		img = tempImg;
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		flower.add(l.get());
	}
	
	public void display(PApplet p){
		p.ellipseMode(PConstants.CENTER);
		p.fill(0);
		//p.ellipse(position.x, position.y, r, r);
		p.image(img, position.x-16, position.y-16);
	}
	
	public ArrayList<PVector> getFlower(){
		return flower;
	}
	
	public PVector position(){
		return position;
	}
	
	public float getR(){
		return r;
	}
}
