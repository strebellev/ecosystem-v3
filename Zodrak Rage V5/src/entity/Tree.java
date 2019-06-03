package entity;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class Tree {
	PApplet parent;
	ArrayList<PVector> tree;
	public PVector position;
	
	int r;
	
	PImage img;
	
	@SuppressWarnings("deprecation")
	public Tree(PImage tempImg,PApplet p,PVector l){
		position = l.get();
		parent = p;
		r = 32;
		tree = new ArrayList<PVector>();
		img = tempImg;
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		tree.add(l.get());
	}
	
	public void display(PApplet p){
		p.ellipseMode(PConstants.CENTER);
		p.fill(0);
		//p.ellipse(position.x, position.y, r, r);
		p.image(img, position.x-38, position.y-85);
	}
	
	public ArrayList<PVector> getTree(){
		return tree;
	}
	
	public PVector position(){
		return position;
	}
	
	public float getR(){
		return r;
	}
}
