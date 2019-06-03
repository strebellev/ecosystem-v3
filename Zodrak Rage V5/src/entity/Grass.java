package entity;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class Grass {
	PApplet parent;
	ArrayList<PVector> grass;
	public PVector position;
	
	int r ;
	
	PImage img;
	
	@SuppressWarnings("deprecation")
	public Grass(PImage tempImg,PApplet p,PVector l){
		position = l.get();
		parent = p;
		r = 32;
		grass = new ArrayList<PVector>();
		img = tempImg;
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		grass.add(l.get());
	}
	
	public void display(PApplet p){
		/////pour display grow////
		/*
		for(PVector g : grass){
			p.ellipseMode(PConstants.CENTER);
			//p.fill(0);
			//p.ellipse(g.x, g.y, r, r);
			
			p.image(img, g.x-16, g.y-16);
			//p.text("x " + g.x + " y " + g.y, g.x+16 , g.y);
		}
		*/
		//////////////////////////////////
		
		//////pour display dans le world avec grass.add(new Grass(...))
		p.ellipseMode(PConstants.CENTER);
		p.fill(0);
		//p.ellipse(position.x, position.y, r, r);
		p.image(img, position.x-16, position.y-16);
	}
	
	//////fct pas correctement mais gardé comme exemple
	public void grow(){
		int totalgrass = 1;
		while(grass.size() < totalgrass){
			PVector grasses = new PVector();
			grasses.x = parent.random(250, 1750);
			grasses.y = parent.random(250, 1750);
			boolean overlapping = false;
			for(int i = 0; i < grass.size(); i++){
				PVector other = grass.get(i);
				float d = PApplet.dist(grasses.x, grasses.y, other.x, other.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			/*
			//////utilise champi list //// a test si bug ou pas dans l'ordre de run
			ArrayList<PVector> champi = c.getChampi();
			for(int a = 0; a < champi.size(); a++){
				PVector other = champi.get(a);
				float d = PApplet.dist(grasses.x, grasses.y, other.x, other.y);
				if(d < 40){
					overlapping = true;
					break;
				}
			}
			*/
			if(!overlapping ){
				grass.add(grasses);
			}	
		}
	}
	
	
	public ArrayList<PVector> getGrass(){
		return grass;
	}
	
	public PVector position(){
		return position;
	}
	
	public float getR(){
		return r;
	}

}
