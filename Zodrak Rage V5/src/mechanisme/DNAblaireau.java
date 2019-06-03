package mechanisme;

import processing.core.PApplet;

public class DNAblaireau {
	PApplet parent;
	public float[] genes;
	int diffgenes = 5;
	DNAblaireau dnablaireau;
	
	public DNAblaireau(PApplet p){
		parent = p;
		genes = new float[diffgenes];
		for(int i = 0; i < genes.length; i++){
			genes[i] = p.random(0, 1);
		}
	}
	
	DNAblaireau(float[] newgenes){
		genes = newgenes;
	}
	
	public DNAblaireau copy(){
		float[] newgenes = new float[genes.length];
		for(int i =0; i < newgenes.length; i++){
			newgenes[i] = genes[i];
		}
		return new DNAblaireau(newgenes);
	}
	
	DNAblaireau crossover(DNAblaireau partner,PApplet p){
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
		DNAblaireau newgenes = new DNAblaireau(child);
		return newgenes;
	}
	
	public DNAblaireau getDNAblaireau(){
		return dnablaireau;
	}
	
	public void mutate(float m){
		for(int i = 0; i < genes.length; i++){
			if(parent.random(1) < m){
				genes[i] = parent.random(0, 1);
			}
		}
	}
	
}
