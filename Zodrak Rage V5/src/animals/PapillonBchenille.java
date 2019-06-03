package animals;

import java.util.ArrayList;

import mechanisme.DNAinsect;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class PapillonBchenille {
	PApplet parent;
	ArrayList<PVector> papillonbchenille;
	
	public PVector position;
	DNAinsect dnainsect;
	float xoff;
	float yoff;
	
	float grow;
	float growUp;
	float r;
	
	float maxspeed;
	float maxforce;
	PVector acceleration;
	PVector velocity;
	
	////test segment///////
	float[] x = new float[2];
	float[] y = new float[2];
	float segLength = 18;
	///////////////////////
	
	@SuppressWarnings("deprecation")
	public PapillonBchenille(PVector l, DNAinsect dnainsect_,PApplet p){
		parent = p;
		position = l.get();
		dnainsect = dnainsect_;
		xoff = p.random(3200);
		yoff = p.random(3200);
		
		r = PApplet.map(dnainsect.genes[0], 0, 1, 2, 4);
		maxspeed = PApplet.map(dnainsect.genes[0], 0, 1, 1, 1);
		grow = 0;
		growUp = PApplet.map(dnainsect.genes[0], 0, 1, 200, 250);
		acceleration = new PVector(0,0);
		velocity = new PVector(0,0);
		maxforce = (float) 0.1;
	}
	
	public void update(){
		grow +=0.1;
		display();
	}
	
	public void mvtUpdate(){
		position.add(velocity);
		velocity.add(acceleration);
		velocity.limit(maxspeed);
		acceleration.mult(0);
		acceleration.limit(maxspeed);
	}
	
	public void randomMv(){
		float vx = PApplet.map(parent.noise(xoff), 0, 1, -maxspeed, maxspeed);
		float vy = PApplet.map(parent.noise(yoff), 0, 1, -maxspeed, maxspeed);
		PVector velocity = new PVector(vx,vy);
		position.add(velocity);
		///modif le mvt random
		xoff += 0.01;
		yoff += 0.01;
	}
	
	public boolean isTooFar(PVector target){
		return PApplet.dist(position.x, position.y, target.x, target.y) > 20;
	}
	
	public void stayCloseBuisson(PVector target){
		PVector desired = PVector.sub(target, position);
		float d = desired.mag();
		if(d < 50){
			float m = PApplet.map(d, 0, 20, 0, maxspeed);
			desired.setMag(m);
		}
		else{
			desired.setMag(maxspeed);
		}
		PVector steer = PVector.sub(desired, velocity);
		steer.limit(maxforce);
		applyForce(steer);
	}
	
	
	void applyForce(PVector force){
		acceleration.add(force);
	}
	
	void display(){
		parent.ellipseMode(PConstants.CENTER);
		parent.strokeWeight(1);
		parent.stroke(0,102,204);
		//parent.fill(0);
		//parent.fill(colorR,colorG,colorB);
		parent.fill(0);
		parent.ellipse(position.x, position.y, r, r);
		//parent.text("food " + food, position.x+10, position.y+10);
		parent.noFill();
		parent.noStroke();
		
		parent.strokeWeight(r);
		//parent.stroke(colorR,colorG,colorB);
		parent.stroke(0,102,204);
		
		//parent.noStroke();
		dragSegment(0, position.x, position.y);
		
		for(int i=0; i<x.length-1; i++) {
			dragSegment(i+1, x[i], y[i]);
			parent.noStroke();
		}
		
		//parent.fill(0);
		//parent.text("growup " + grow, position.x+10, position.y+10);
		//parent.noFill();
	}
	
	public void dragSegment(int i, float xin, float yin) {
		float dx = xin - x[i];
		float dy = yin - y[i];
		float angle = PApplet.atan2(dy, dx);  
		x[i] = xin - PApplet.cos(angle) * r;
		y[i] = yin - PApplet.sin(angle) * r;
		segment(x[i], y[i], angle);
	}
	
	void segment(float x, float y, float a) {
		parent.pushMatrix();
		parent.translate(x, y);
		parent.rotate(a);
		parent.line(0, 0, 2, 0);
		parent.popMatrix();
	}
	
	public float getR(){
		return r;
	}
	
	public ArrayList<PVector> getPapillonBchenille(){
		return papillonbchenille;
	}
	
	public boolean growUp(){
		if(grow > growUp){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	
}
