package animals;

import java.util.ArrayList;

import mechanisme.DNAinsect;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class PapillonB {
	PApplet parent;
	ArrayList<PVector> papillonb;
	
	public PVector position;
	
	DNAinsect dnainsect;
	float xoff;
	float yoff;
	
	PVector velocity;
	PVector acceleration;
	
	float wandertheta;
	float maxforce;
	
	///limite de terrain
	float d = 50;

	////////////variables genetiques
	float water;
	float food;
	public float health;
	float r; ///la taille
	public float maxspeed;
	float lifeTime;
	
	float reproduceTime;
		
	float maxLifeTime;
	float speed;
	
	//////test anim/////
	int animLnumFrame = 3;
	int animRnumFrame = 3;
	int animUnumFrame = 3;
	int animDnumFrame = 3;
	
	int currentFrame = 0;
	
	PImage[] animLeft = new PImage[animLnumFrame];
	PImage[] animRight = new PImage[animRnumFrame];
	PImage[] animUp = new PImage[animUnumFrame];
	PImage[] animDown = new PImage[animDnumFrame];
	
	int previousDisplayTime;
	int deltaTime;
	////////////////////
	
	
	@SuppressWarnings("deprecation")
	public PapillonB(PVector l, DNAinsect dnainsect_, PApplet p){
		parent = p;
		position = l.get();
		xoff = p.random(3200);
		yoff = p.random(3200);
		
		dnainsect = dnainsect_;
		
		health = PApplet.map(dnainsect.genes[0], 0, 1, 50, 250);
		r = PApplet.map(dnainsect.genes[0], 0, 1, 2, 4);
		maxspeed = PApplet.map(dnainsect.genes[0], 0, 1, 1, 2);
		lifeTime = PApplet.map(dnainsect.genes[0], 0, 1, 100, 250);
		//water = PApplet.map(dnainsect.genes[1], 0, 1, 100, 200);
		food = PApplet.map(dnainsect.genes[1], 0, 1, 100, 200);
		
		acceleration = new PVector(0,0);
		velocity = new PVector(0,0);
		maxforce = (float) 0.1;
		
		//////test anim/////
		animLeft[0] = p.loadImage("res/animal/insect/papillon/papillonL0.png");
		animLeft[1] = p.loadImage("res/animal/insect/papillon/papillonL1.png");
		animLeft[2] = p.loadImage("res/animal/insect/papillon/papillonL2.png");
		
		animRight[0] = p.loadImage("res/animal/insect/papillon/papillonR0.png");
		animRight[1] = p.loadImage("res/animal/insect/papillon/papillonR1.png");
		animRight[2] = p.loadImage("res/animal/insect/papillon/papillonR2.png");
		
		animUp[0] = p.loadImage("res/animal/insect/papillon/papillonU0.png");
		animUp[1] = p.loadImage("res/animal/insect/papillon/papillonU1.png");
		animUp[2] = p.loadImage("res/animal/insect/papillon/papillonU2.png");
		
		animDown[0] = p.loadImage("res/animal/insect/papillon/papillonD0.png");
		animDown[1] = p.loadImage("res/animal/insect/papillon/papillonD1.png");
		animDown[2] = p.loadImage("res/animal/insect/papillon/papillonD2.png");
		
		deltaTime = 100; // animation speed +=fast -=slow
		previousDisplayTime = 0;
		
		////////////////////
		
	}
	
	public void mvtUpdate(){
		position.add(velocity);
		velocity.add(acceleration);
		velocity.limit(maxspeed);
		acceleration.mult(0);
		acceleration.limit(maxspeed);
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
		if(health < 0) health = 0;
		if(health > 250) health = 250;
		health -= 0.01;
		lifeTime -= 0.01;
		reproduceTime += 0.1;
	}
	
	@SuppressWarnings({ "deprecation", "static-access" })
	public void wander(PApplet p){
		
		float wanderR = 50;  // Radius for our "wander circle"
		float wanderD = 80;  // Distance for our "wander circle"
		float change = (float) 1.03;
		wandertheta += p.random(-change, change);  // Randomly change wander theta
		
		// Now we have to calculate the new position to steer towards on the wander circle
		PVector circlepos = velocity.get();
		circlepos.normalize();
		circlepos.mult(wanderD);
		circlepos.add(position);  // Make it relative to boid's position
		
		float h = velocity.heading2D();
		
		PVector circleOffSet = new PVector(wanderR*p.cos(wandertheta+h), wanderR*p.sin(wandertheta+h));
		PVector target = PVector.add(circlepos, circleOffSet);
		seek(target);
		
	}
	
	void applyForce(PVector force){
		acceleration.add(force);
	}
	
	void seek(PVector target){
		PVector desired = PVector.sub(target, position);
		desired.normalize();
		desired.mult(maxspeed);
		PVector steer = PVector.sub(desired, velocity);
		steer.limit(maxforce);
		applyForce(steer);
	}
	
	public void boundaries(){
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
		else if(position.y > 3200 -d){
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
	
	public boolean isInDanger(PVector target){
		return PApplet.dist(position.x, position.y, target.x, target.y) < 150;
	}
	
	public void runaway(PVector target){
		PVector desired = new PVector(position.x - target.x, position.y - target.y);
		desired.normalize();
		desired.mult(maxspeed);
		PVector steer = PVector.sub(desired, velocity);
		steer.limit(maxforce);
		applyForce(steer);
	}
	
	public void run(PApplet p){
		update();
	}
	
	@SuppressWarnings({ "deprecation", "static-access" })
	public void display(PApplet p){
		/*
		float theta = velocity.heading2D() + p.radians(90);
		p.fill(91,175,8);
		p.stroke(255,0,0, lifeTime);
		p.strokeWeight(1);
		p.pushMatrix();
		p.translate(position.x, position.y);
		p.rotate(theta);
		p.beginShape(p.TRIANGLES);
		p.vertex(0, -r*2);
		p.vertex(-r, r*2);
		p.vertex(r, r*2);
		p.endShape(PConstants.CLOSE);
		p.popMatrix();
		p.ellipse(position.x,position.y,r*2,r*2);
		
		p.fill(0);
		//
		p.text("food " + food, position.x+10,position.y+10);
		p.noFill();
		*/
		p.text("reproduceTime " + reproduceTime, position.x+10, position.y+10);
		p.text("lifeTime " + lifeTime, position.x+10, position.y+20);
		/////test sprite fct parfait////
		
		int dir = p.round(4 * (velocity.heading2D() + PApplet.radians(90)) /  PApplet.TWO_PI + 4) % 4;
	    switch(dir) {
	    case 0:
	    	//p.text("up",10,10);
	    	if (p.millis() > previousDisplayTime + deltaTime) {
	    	    currentFrame++;
	    	    if (currentFrame > 2) { 
	    	      currentFrame = 0;
	    	    }
	    	    previousDisplayTime = p.millis();
	    	}
	    	p.image(animUp[currentFrame],position.x-24,position.y-24);
	    	break;
	    case 1:
	    	//p.text("right",10,10);
	    	if (p.millis() > previousDisplayTime + deltaTime) {
	    	    currentFrame++;
	    	    if (currentFrame > 2) { 
	    	      currentFrame = 0;
	    	    }
	    	    previousDisplayTime = p.millis();
	    	}
	    	p.image(animRight[currentFrame],position.x-24,position.y-24);
	    	break;
	    case 2:
	    	//p.text("down",10,10);
	    	if (p.millis() > previousDisplayTime + deltaTime) {
	    	    currentFrame++;
	    	    if (currentFrame > 2) { 
	    	      currentFrame = 0;
	    	    }
	    	    previousDisplayTime = p.millis();
	    	}
	    	p.image(animDown[currentFrame],position.x-24,position.y-24);
	    	break;
	    case 3:
	    	//p.text("left",10,10);
	    	if (p.millis() > previousDisplayTime + deltaTime) {
	    	    currentFrame++;
	    	    if (currentFrame > 2) { 
	    	      currentFrame = 0;
	    	    }
	    	    previousDisplayTime = p.millis();
	    	}
	    	p.image(animLeft[currentFrame],position.x-24,position.y-24);
	    	break;
	    }
		////////////////////
		//p.text("health " + health , position.x +10, position.y +20);
	}
	
	public void findFlower(PVector target){
		PVector desired = PVector.sub(target, position);
		float d = desired.mag();
		if(d < 100){
			float m = PApplet.map(d, 0, 10, 0, maxspeed);
			desired.setMag(m);
		}
		else{
			desired.setMag(maxspeed);
		}
		PVector steer = PVector.sub(desired, velocity);
		steer.limit(maxforce);
		applyForce(steer);
	}
	
	public void findNest(PVector target){
		PVector desired = PVector.sub(target, position);
		float d = desired.mag();
		if(d < 100){
			float m = PApplet.map(d, 0, 10, 0, maxspeed);
			desired.setMag(m);
		}
		else{
			desired.setMag(maxspeed);
		}
		PVector steer = PVector.sub(desired, velocity);
		steer.limit(maxforce);
		applyForce(steer);
	}
	
	public DNAinsect getDNAinsect(){
		return dnainsect;
	}
	
	public float getR(){
		return r;
	}
	
	public ArrayList<PVector> getPapillonB(){
		return papillonb;
	}
	
	public boolean dead(){
		if(health <= 0.0 || lifeTime <= 0.0)return true;
		else 	return false;
		
	}
	
	public boolean faim(){
		if(food < 50){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void eatFood(){
		if(food < 40){
			float rndfood = parent.random(100);
			//food += 100;
			food += rndfood;
		}
	}
	
	public boolean reproduceTime(){
		if(reproduceTime > 200){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void resetReproduce(){
		reproduceTime = 0;
	}
	
}
