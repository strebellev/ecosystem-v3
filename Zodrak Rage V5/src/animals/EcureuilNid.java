package animals;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class EcureuilNid {
	PApplet parent;
	ArrayList<PVector> ecureuilnid;
	public PVector position;
	
	int r;
	int territoire;
	int imgnum = 1;
	PImage[] imgNid = new PImage[imgnum];
	
	@SuppressWarnings("deprecation")
	public EcureuilNid(PApplet p, PVector l){
		position = l.get();
		parent = p;
		r = 32;
		territoire = 1600;
		//imgNid[0] = p.loadImage("res/animal/lapin/lapinTerrier0.png");
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		ecureuilnid.add(l.get());
	}

	public void display(PApplet p){
		p.ellipseMode(PConstants.CENTER);
		//p.fill(0);
		p.stroke(0);
		p.strokeWeight(2);
		//p.ellipse(position.x, position.y, territoire, territoire);
		p.noFill();
		p.noStroke();
		p.fill(0);
		p.ellipse(position.x, position.y, r, r);
		p.noFill();
		//p.image(imgNid[0], position.x-16, position.y-16);
	}
	
	public ArrayList<PVector> getEcureuilNid(){
		return ecureuilnid;
	}
	
	public PVector position(){
		return position;
	}
	
	public float getR(){
		return r;
	}
	
	public float getTerritoire(){
		return territoire;
	}


}
