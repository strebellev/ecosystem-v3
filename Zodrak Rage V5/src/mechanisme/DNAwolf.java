package mechanisme;

import processing.core.PApplet;

public class DNAwolf {
	PApplet parent;
	public float[] genes;
	int diffgenes = 5;
	DNAwolf dnawolf;
	
	public DNAwolf(PApplet p){
		parent = p;
		genes = new float[diffgenes];
		for(int i = 0; i < genes.length; i++){
			genes[i] = p.random(0, 1);
		}
	}
	
	DNAwolf(float[] newgenes){
		genes = newgenes;
	}
	
	public DNAwolf copy(){
		float[] newgenes = new float[genes.length];
		for(int i =0; i < newgenes.length; i++){
			newgenes[i] = genes[i];
		}
		return new DNAwolf(newgenes);
	}
	
	DNAwolf crossover(DNAwolf partner,PApplet p){
		float[] child = new float[genes.length];
		int crossover = (int) p.random(5);
		for(int i = 0; i < genes.length; i++){
			if(i > crossover){
				child[i] = genes[i];
			}
			else{
				child[i] = partner.genes[i];
			}
		}
		DNAwolf newgenes = new DNAwolf(child);
		return newgenes;
	}
	
	public DNAwolf getDNAwolf(){
		return dnawolf;
	}
	
	public void mutate(float m){
		for(int i = 0; i < genes.length; i++){
			if(parent.random(1) < m){
				genes[i] = parent.random(0, 1);
			}
		}
	}
	
}
