package animals;

import java.util.ArrayList;

import mechanisme.DNAinsect;
import mechanisme.tileWater;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class insect1M {
	PApplet parent;
	ArrayList<PVector> insect1m;
	
	public PVector position;
	DNAinsect dnainsect;
	float xoff;
	float yoff;
	
	///limite de terrain
	float d = 50;
		
	//////variable de reproduction
	float gestation;
	boolean pregnant = false;
	
	////////////variables genetiques
	float water;
	float food;
	float health;
	float r; ///la taille
	float maxspeed;
	float lifeTime;
	
	float colorR;
	float colorG;
	float colorB;
	
	int lastChildTime = -1;
	
	////test segment///////
	float[] x = new float[20];
	float[] y = new float[20];
	float segLength = 18;
	///////////////////////
	
	float maxforce;
	PVector acceleration;
	PVector velocity;
	
	@SuppressWarnings("deprecation")
	public insect1M(PVector l, DNAinsect dnainsect_, PApplet p){
		parent = p;
		position = l.get();
		xoff = p.random(3200);
		yoff = p.random(3200);
		
		dnainsect = dnainsect_;
		health = PApplet.map(dnainsect.genes[0], 0, 1, 50, 250);
		r = PApplet.map(dnainsect.genes[0], 0, 1, 2, 4);
		maxspeed = PApplet.map(dnainsect.genes[0], 0, 1, 1, 2);
		lifeTime = PApplet.map(dnainsect.genes[0], 0, 1, 100, 250);
		water = PApplet.map(dnainsect.genes[1], 0, 1, 100, 200);
		food = PApplet.map(dnainsect.genes[1], 0, 1, 100, 200);
		
		colorR = PApplet.map(dnainsect.genes[2], 0, 1, 0, 255);
		colorG = PApplet.map(dnainsect.genes[3], 0, 1, 0, 255);
		colorB = PApplet.map(dnainsect.genes[4], 0, 1, 0, 255);
		
		acceleration = new PVector(0,0);
		velocity = new PVector(0,0);
		maxforce = (float) 0.1;
	}
	
	void update(){
		water -= 0.05;
		if(water < 0){
			water = 0;
		}
		if(water > 200){
			water = 200;
		}
		food -= 0.1;
		if(food < 0){
			food = 0;
		}
		if(food >200){
			food = 200;
		}
		health -= 0.01;
		lifeTime -= 0.01;
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
	
	
	void boundaries(){
		PVector desired = null;
		
		if(position.x < d){
			desired = new PVector(maxspeed,velocity.y);
		}
		else if(position.x > 3200 - d){
			desired = new PVector(-maxspeed, velocity.y);
		}
		
		if(position.y < d){
			desired = new PVector(velocity.x, maxspeed);
		}
		else if(position.y > 3200-d){
			desired = new PVector(velocity.x, -maxspeed);
		}
		
		if(desired != null){
			desired.normalize();
			desired.mult(maxspeed);
			PVector steer = PVector.sub(desired, velocity);
			steer.limit(maxforce);
			applyForce(steer);
		}
	}
	
	public boolean isTooClose(PVector target){
		return PApplet.dist(position.x, position.y, target.x, target.y) < 50;
	}
	
	public void goAway(PVector target){
		PVector desired = new PVector(position.x - target.x, position.y - target.y);
		desired.normalize();
		desired.mult(maxspeed);
		PVector steer = PVector.sub(desired, velocity);
		steer.limit(maxforce);
		applyForce(steer);
	}
	
	void applyForce(PVector force){
		acceleration.add(force);
	}
	
	public void findFood(PVector target){
		PVector desired = PVector.sub(target, position);
		float d = desired.mag();
		if(d < 100){
			float m = PApplet.map(d, 0, 100, 0, maxspeed);
			desired.setMag(m);
		}
		else{
			desired.setMag(maxspeed);
		}
		PVector steer = PVector.sub(desired, velocity);
		steer.limit(maxforce);
		applyForce(steer);
	}
	
	public void findWater(PVector target){
		PVector desired = PVector.sub(target, position);
		float d = desired.mag();
		if(d < 100){
			float m = PApplet.map(d, 0, 100, 0, maxspeed);
			desired.setMag(m);
		}
		else{
			desired.setMag(maxspeed);
		}
		PVector steer = PVector.sub(desired, velocity);
		steer.limit(maxforce);
		applyForce(steer);
	}
	
	void display(){
		parent.ellipseMode(PConstants.CENTER);
		parent.strokeWeight(1);
		parent.stroke(0);
		//parent.fill(0);
		//parent.fill(colorR,colorG,colorB);
		parent.fill(0,0,0);
		parent.ellipse(position.x, position.y, r, r);
		//parent.text("food " + food, position.x+10, position.y+10);
		parent.noFill();
		parent.noStroke();
		
		parent.strokeWeight(r);
		//parent.stroke(colorR,colorG,colorB);
		parent.stroke(153,0,0);
		
		//////si les 2 nostroke sont inactif tout les segments apparaissent
		
		//parent.noStroke();
		//dragSegment(0, position.x, position.y);
		
		//for(int i=0; i<x.length-1; i++) {
			//dragSegment(i+1, x[i], y[i]);
			//parent.noStroke();   /////si inactif seulement 2 segment apparaisent
		//}
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
	
	public DNAinsect getDNAinsect(){
		return dnainsect;
	}
	
	public float getR(){
		return r;
	}
	
	public float getWater(){
		return water;
	}
	
	public float getFood(){
		return food;
	}
	
	public ArrayList<PVector> getinsect1M(){
		return insect1m;
	}
	
	public void run(PApplet p){
		update();
		boundaries();
		display();
	}
	
	public boolean dead(){
		if(health < 0.0 || lifeTime < 0.0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean soif(){
		if(water < 50){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean faim(){
		if(food < 50){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void drinkWater(){
		water += 100;
	}
	
	public void eatFood(){
		if(food < 20){
			float rndfood = parent.random(100);
			//food += 100;
			food += rndfood;
		}
		
	}
	
	public int lastChildTime(){
		return parent.millis() - lastChildTime;
	}
	
	public void setLastChildTime(int time){
		lastChildTime = time;
	}
	
	
}
