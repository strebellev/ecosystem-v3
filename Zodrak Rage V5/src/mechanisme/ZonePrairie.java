package mechanisme;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class ZonePrairie {
	PApplet parent;
	ArrayList<PVector> zoneprairie;
	public PVector position;
	
	int r;
	
	@SuppressWarnings("deprecation")
	public ZonePrairie(PApplet p, PVector l){
		position = l.get();
		parent = p;
		r = 320;
		zoneprairie = new ArrayList<PVector>();
	}
	
	@SuppressWarnings("deprecation")
	public void add(PVector l){
		zoneprairie.add(l.get());
	}
	
	public void display(PApplet p){
		p.ellipseMode(PConstants.CENTER);
		p.strokeWeight(1);
		p.stroke(0);
		//p.fill(0);
		p.ellipse(position.x, position.y, r, r);
		
		p.ellipse(position.x, position.y, 10, 10);
		p.fill(0);
		p.text("prairie", position.x+5, position.y+12);
		p.noFill();
		p.noStroke();
	}
	
	public ArrayList<PVector> getZonePrairie(){
		return zoneprairie;
	}
	
	public PVector position(){
		return position;
	}
	
	public float getR(){
		return r;
	}
}
