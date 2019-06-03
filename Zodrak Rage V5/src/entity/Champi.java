package entity;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class Champi {
	PApplet parent;
	ArrayList<PVector> champi;
	public PVector position;
	
	int r;
	
	/////les list pour overlapping////
	//ArrayList<PVector> grass;
	//////////////////////////////////
	
	
	PImage img;
	
	
	@SuppressWarnings("deprecation")
	public Champi(PImage tempImg, PApplet p, PVector l){
		position = l.get();
		parent = p;
		r = 32;
		img = tempImg;
		champi = new ArrayList<PVector>();
		
	}
	
	
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		champi.add(l.get());
	}
	
	public void display(PApplet p){
		/////pour display grow////
		for(PVector c : champi){
			//////structure simple/////
			p.ellipseMode(PConstants.CENTER);
			//p.fill(255,0,0);
			//p.ellipse(c.x, c.y, r, r);
			///////////////////////////
			
			p.image(img, c.x-16, c.y-16);
			////////test xy ect...///////
			//parent.fill(255,0,0);
			//parent.text("x: " + c.x + "\n" + "y: "+ c.y, c.x+10, c.y+10);
			/////////////////////////////
		}
		/////////////////////////////
		//////pour display dans le world avec champi.add(new Champi(...))
		p.ellipseMode(PConstants.CENTER);
		p.fill(0);
		//p.ellipse(position.x, position.y, r, r);
		p.image(img, position.x-16, position.y-16);
	}
	
	//////fct pas correctement mais gardé comme exemple
	public void grow(Grass g){
		int totalchamp = 1;
		while(champi.size() < totalchamp){
			PVector champis = new PVector();
			champis.x = parent.random(250, 1750);
			champis.y = parent.random(250, 1750);
			boolean overlapping = false;
			/////il utilise l'arraylist de champi
			for(int i = 0; i < champi.size(); i++){
				PVector other = champi.get(i);
				float d = PApplet.dist(champis.x, champis.y, other.x, other.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			/////il utilise l'arraylist de grass
			ArrayList<PVector> grass = g.getGrass();
			for(int a = 0; a < grass.size(); a++){
				PVector other = grass.get(a);
				float d = PApplet.dist(champis.x, champis.y, other.x, other.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			if(!overlapping){
				champi.add(champis);
			}
		}
	}
	
	
	
	public ArrayList<PVector> getChampi(){
		return champi;
	}
	
	public PVector position(){
		return position;
	}
	
	public float getR(){
		return r;
	}
}
