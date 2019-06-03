package mechanisme;

import java.util.ArrayList;
import java.util.Iterator;

import animals.BearF;
import animals.BearM;
import animals.BearNid;
import animals.BlaireauF;
import animals.BlaireauM;
import animals.BlaireauNid;
import animals.BoarF;
import animals.BoarM;
import animals.EcureuilF;
import animals.EcureuilM;
import animals.EcureuilNid;
import animals.FoxF;
import animals.FoxM;
import animals.FoxNid;
import animals.FuretF;
import animals.FuretM;
import animals.FuretNid;
import animals.LapinF;
import animals.LapinM;
import animals.LapinNid;
import animals.PapillonB;
import animals.PapillonBchenille;
import animals.PapillonBegg;
import animals.SourisF;
import animals.SourisM;
import animals.SourisNid;
import animals.WolfF;
import animals.WolfM;
import animals.WolfNid;
import animals.insect1M;
import entity.Buisson;
import entity.BuissonFruitJaune;
import entity.BuissonFruitRouge;
import entity.Champi;
import entity.Feuillu;
import entity.Flower;
import entity.FruitTree;
import entity.GrassFeuillu;
import entity.Player;
import entity.Rock;
import objects.RedBerry;
import objects.YellowBerry;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class World2 {
	PApplet parent;
	
	public int worldW = 3200;
	public int worldH = 3200;
	
	
	
	Player player;
	
	ArrayList<ZoneFeuillu> zonefeuillu;
	
	ArrayList<Buisson> buisson;
	ArrayList<BuissonFruitJaune> buissonfruitjaune;
	ArrayList<BuissonFruitRouge> buissonfruitrouge;
	ArrayList<Champi> champi;
	ArrayList<Feuillu> feuillu;
	ArrayList<Flower> flower;
	ArrayList<FruitTree> fruittree;
	ArrayList<GrassFeuillu> grassfeuillu;
	ArrayList<Rock> rock;
	
	ArrayList<RedBerry> redberry;
	ArrayList<YellowBerry> yellowberry;
	
	ArrayList<insect1M> insect1m;
	
	ArrayList<PapillonB> papillonb;
	ArrayList<PapillonBegg> papillonbegg;
	ArrayList<PapillonBchenille> papillonbchenille;
	
	ArrayList<SourisM> sourism;
	ArrayList<SourisF> sourisf;
	ArrayList<SourisNid> sourisnid;
	
	ArrayList<LapinM> lapinm;
	ArrayList<LapinF> lapinf;
	ArrayList<LapinNid> lapinnid;
	
	ArrayList<EcureuilM> ecureuilm;
	ArrayList<EcureuilF> ecureuilf;
	ArrayList<EcureuilNid> ecureuilnid;
	
	ArrayList<FuretM> furetm;
	ArrayList<FuretF> furetf;
	ArrayList<FuretNid> furetnid;
	
	ArrayList<FoxM> foxm;
	ArrayList<FoxF> foxf;
	ArrayList<FoxNid> foxnid;
	
	ArrayList<BlaireauM> blaireaum;
	ArrayList<BlaireauF> blaireauf;
	ArrayList<BlaireauNid> blaireaunid;
	
	ArrayList<BoarM> boarm;
	ArrayList<BoarF> boarf;
	
	ArrayList<WolfM> wolfm;
	ArrayList<WolfF> wolff;
	ArrayList<WolfNid> wolfnid;
	
	ArrayList<BearM> bearm;
	ArrayList<BearF> bearf;
	ArrayList<BearNid> bearnid;
	
	
	
	
	PImage[] ImgBuisson = new PImage[9];
	PImage[] ImgBuissonFruitJaune = new PImage[1];
	PImage[] ImgBuissonFruitRouge = new PImage[1];
	PImage[] Imgchampignons = new PImage[8];
	PImage[] ImgFeuillu = new PImage[4];
	PImage[] ImgFlower = new PImage[11];
	PImage[] ImgFruitTree = new PImage[2];
	PImage[] ImgGrassFeuillu = new PImage[9];
	PImage[] ImgRock = new PImage[4];
	
	PImage[] ImgRedBerry = new PImage[1];
	PImage[] ImgYellowBerry = new PImage[1];
	
	PImage[] ImgSourisNid = new PImage[1];
	PImage[] ImgLapinNid = new PImage[1];
	PImage[] ImgEcureuilNid = new PImage[1];
	
	
	////////test fond/////
	
	////pour la generation random du terrain
	int locX, locY;
	final int unit = 32;
	byte[][] terrain = new byte[100][100];
	
	ArrayList<Tuile> tuile;
	
	ArrayList<tileGrassL> tilegrassl;
	ArrayList<tileGrassD> tilegrassd;
	ArrayList<tileDirt> tiledirt;
	ArrayList<tileWater> tilewater;
	
	PImage[] ImgGrassL = new PImage[5];
	PImage[] ImgGrassD = new PImage[4];
	PImage[] ImgDirt = new PImage[3];
	PImage[] ImgWater = new PImage[1];
	//////////////////////
	
	
	
	
	
	public World2(PApplet p){
		parent = p;
		
		//p.frameRate(30);
		
		//////player//////
		float px = worldW/2;
		float py = worldH/2;
		
		PVector playerVector = new PVector(px,py); 
		player = new Player(parent,playerVector);
		//////////////////
		
		/////BUISSON///////
		for(int i = 0; i < ImgBuisson.length; i++){
			ImgBuisson[i] = p.loadImage("res/vegetal/buisson/buisson" +i+".png");
		}
		buisson = new ArrayList<Buisson>();
		//////////////////////
		
		//////buissonfruitjaune////
		for(int i = 0; i < ImgBuissonFruitJaune.length; i++){
			ImgBuissonFruitJaune[i] = p.loadImage("res/vegetal/buissonfruit/buissonfruitJ.png");
		}
		buissonfruitjaune = new ArrayList<BuissonFruitJaune>();
		///////////////////////////
		
		//////buissonfruitrouge////
		for(int i = 0; i < ImgBuissonFruitRouge.length; i++){
			ImgBuissonFruitRouge[i] = p.loadImage("res/vegetal/buissonfruit/buissonfruitR.png");
		}
		buissonfruitrouge = new ArrayList<BuissonFruitRouge>();
		///////////////////////////
		
		//////CHAMPIGNON///////
		for(int i = 0; i < Imgchampignons.length; i++){
			Imgchampignons[i] = p.loadImage("res/vegetal/champi/champi" +i+".png");
		}
		champi = new ArrayList<Champi>();
		///////////////////
		
		///////feuillu//////
		for(int i = 0; i < ImgFeuillu.length; i++){
			ImgFeuillu[i] = p.loadImage("res/vegetal/feuillu/tree" +i+ ".png");
		}
		feuillu = new ArrayList<Feuillu>();
		////////////////////
		
		/////FLOWER///////////
		for(int i = 0; i < ImgFlower.length; i++){
			ImgFlower[i] = p.loadImage("res/vegetal/flower/flower" +i+".png");
		}
		flower = new ArrayList<Flower>();
		//////////////////////
		
		//////fruittree////////
		for(int i = 0; i < ImgFruitTree.length; i++){
			ImgFruitTree[i] = p.loadImage("res/vegetal/fruittree/fruit-tree" +i+ ".png");
		}
		fruittree = new ArrayList<FruitTree>();
		///////////////////////
		
		/////GRASSfeuillu/////////
		for(int i = 0; i < ImgGrassFeuillu.length; i++){
			ImgGrassFeuillu[i] = p.loadImage("res/vegetal/grassfeuillu/grassfeuillu" +i+ ".png");
		}
		grassfeuillu = new ArrayList<GrassFeuillu>();
		//////////////////////////
		
		//////rock//////////////
		for(int i = 0; i < ImgRock.length; i++){
			ImgRock[i] = p.loadImage("res/vegetal/rock/rock" +i+ ".png");
		}
		rock = new ArrayList<Rock>();
		////////////////////////
		
		/////Zone feuillu///////
		zonefeuillu = new ArrayList<ZoneFeuillu>();
		////////////////////////
		
		/////RedBerry/////////
		for(int i = 0; i < ImgRedBerry.length; i++){
			ImgRedBerry[i] = p.loadImage("res/vegetal/berry/redberry.png");
		}
		redberry = new ArrayList<RedBerry>();
		//////////////////////
		
		/////YellowBerry/////////
		for(int i = 0; i < ImgYellowBerry.length; i++){
			ImgYellowBerry[i] = p.loadImage("res/vegetal/berry/jellowberry.png");
		}
		yellowberry = new ArrayList<YellowBerry>();
		//////////////////////
		
		///////INSECT/////////
		insect1m = new ArrayList<insect1M>();
		//////////////////////
		
		///////papillon///////
		papillonb = new ArrayList<PapillonB>();
		papillonbegg = new ArrayList<PapillonBegg>();
		papillonbchenille = new ArrayList<PapillonBchenille>();
		//////////////////////
		
		//////SOURIS///////////
		sourism = new ArrayList<SourisM>();
		sourisf = new ArrayList<SourisF>();
		ImgSourisNid[0] = p.loadImage("res/animal/souris/terrier0.png");
		sourisnid = new ArrayList<SourisNid>();
		///////////////////////
		
		///////LAPIN//////////
		lapinm = new ArrayList<LapinM>();
		lapinf = new ArrayList<LapinF>();
		ImgLapinNid[0] = p.loadImage("res/animal/lapin/lapinTerrier0.png");
		lapinnid = new ArrayList<LapinNid>();
		//////////////////////
		
		//////ECUREUIL////////
		ecureuilm = new ArrayList<EcureuilM>();
		ecureuilf = new ArrayList<EcureuilF>();
		ecureuilnid = new ArrayList<EcureuilNid>();
		//////////////////////
		
		//////FURET///////////
		furetm = new ArrayList<FuretM>();
		furetf = new ArrayList<FuretF>();
		furetnid = new ArrayList<FuretNid>();
		//////////////////////
		
		/////FOX//////////////
		foxm = new ArrayList<FoxM>();
		foxf = new ArrayList<FoxF>();
		foxnid = new ArrayList<FoxNid>();
		//////////////////////
		
		///////BLAIREAU///////
		blaireaum = new ArrayList<BlaireauM>();
		blaireauf = new ArrayList<BlaireauF>();
		blaireaunid = new ArrayList<BlaireauNid>();
		//////////////////////
		
		///////BOAR///////////
		boarm = new ArrayList<BoarM>();
		boarf = new ArrayList<BoarF>();
		//////////////////////
		
		///////WOLF///////////
		wolfnid = new ArrayList<WolfNid>();
		wolfm = new ArrayList<WolfM>();
		wolff = new ArrayList<WolfF>();
		//////////////////////
		
		bearnid = new ArrayList<BearNid>();
		bearm = new ArrayList<BearM>();
		bearf = new ArrayList<BearF>();
		
		//////////////////////
		
		////////test fond/////
		////pour la generation random du terrain
		for (int i = 0; i < 100; i++){
			for (int j = 0; j < 100; j++){
				terrain[i][j] = (byte) PApplet.ceil(p.noise((float) (i*0.05),(float) (j*0.05))*60);
			}
		}
		//locX = (int) (p.random(6,94)); //si random beaucoup de gris apparait
		//locY = (int) (p.random(6,94));
		locX = (int) 6;
		locY = (int) 6;
		
		tuile = new ArrayList<Tuile>();
		tilegrassl = new ArrayList<tileGrassL>();
		tilegrassd = new ArrayList<tileGrassD>();
		tiledirt = new ArrayList<tileDirt>();
		tilewater = new ArrayList<tileWater>();
		
		for(int i = 0; i < ImgGrassL.length; i++){
			ImgGrassL[i] = p.loadImage("res/floor/grassL" +i+ ".png");
		}
		
		for(int i = 0; i < ImgGrassD.length; i++){
			ImgGrassD[i] = p.loadImage("res/floor/grassD" +i+ ".png");
		}
		
		for(int i = 0; i < ImgDirt.length; i++){
			ImgDirt[i] = p.loadImage("res/floor/dirt" +i+ ".png");
		}
		
		for(int i = 0; i < ImgWater.length; i++){
			ImgWater[i] = p.loadImage("res/floor/water" +i+ ".png");
		}
		//////////////////////
		
	}
	
	public void run(){
		
		parent.background(0); ///fond noir = le néant
		
		////// attention il faut pop les créature sur base du monde et non de l'écran !!!! 
		////// mtn il faut mettre dans le push les objets, ou il vont suivrent la camera
		
		parent.pushMatrix();
		
		
		//////fct pas correctement, a refaire avec une "camera"
		parent.translate(-player.position.x+worldW-parent.width-200, -player.position.y+worldH-parent.height-650);
		
		
		//////le fond blanc//////
		parent.fill(255); ///le monde en lui meme
		parent.rect(0, 0, worldW, worldH);
		parent.noFill();
		/////////////////////////
		
		/////le fond vert /////////
		parent.noStroke();
		parent.fill(0,153,0,50);
		parent.rect(0, 0, worldW, worldH,7);
		parent.noFill();
		/////////////////////////
		
		////////test fond/////
		while(tilegrassl.size() < 1){
			
			for (int i = 0; i < 100; i++){
				for (int j = 0; j < 100; j++){
					int offsetX = locX+i-6;
				    int offsetY = locY+j-6;
				    
				    PVector l = new PVector();
				    l.x = offsetX*32;
				    l.y = offsetY*32;
				    
				    boolean grassL = false;
				    boolean grassD = false;
				    boolean dirt = false;
				    boolean water = false;
				    
				    if (offsetX < 0 || offsetX > 99 || offsetY < 0 || offsetY > 99) parent.fill(0xff808080);
				    else{
				    	if (terrain[offsetX][offsetY]>32){
				    		parent.fill(0xff005000); //vert sombre
				    		grassD = true;
				    	}
				    	else if (terrain[offsetX][offsetY]>29){
				    		parent.fill(0xff005000); //vert sombre
				    		grassD = true;
				    	}
				    	else if (terrain[offsetX][offsetY]>20){
				    		parent.fill(0xff008000); //vert clair
				    		grassL = true;
				    	}
				    	else if (terrain[offsetX][offsetY]>12){
				    		//parent.fill(0xff0000c0); //bleu
				    		parent.fill(0xff008000); //vert clair
				    		
				    		grassL = true;
				    	}
				    	else{
				    		parent.fill(0xff0000c0); //bleu
				    		water = true;
				    	}
				    }
				    parent.rect(i*unit, j*unit, unit, unit);
				    if(grassL){
				    	int randomgrassl = (int) parent.random(0, 100);
				    	if(randomgrassl < 96){
				    		tilegrassl.add(new tileGrassL(ImgGrassL[0], parent, l));
				    	}
				    	if(randomgrassl >= 96 && randomgrassl <= 97){
				    		tilegrassl.add(new tileGrassL(ImgGrassL[1], parent, l));
				    	}
				    	if(randomgrassl >= 98 && randomgrassl <= 98){
				    		tilegrassl.add(new tileGrassL(ImgGrassL[2], parent, l));
				    	}
				    	if(randomgrassl >= 99 && randomgrassl <= 99){
				    		tilegrassl.add(new tileGrassL(ImgGrassL[3], parent, l));
				    	}
				    	if(randomgrassl > 99){
				    		tilegrassl.add(new tileGrassL(ImgGrassL[4], parent, l));
				    	}
				    	
				    }
				    if(grassD){
				    	int randomgrassd = (int) parent.random(0, 100);
				    	if(randomgrassd < 97){
				    		tilegrassd.add(new tileGrassD(ImgGrassD[0], parent, l));
				    	}
				    	if(randomgrassd >= 97 && randomgrassd <= 98){
				    		tilegrassd.add(new tileGrassD(ImgGrassD[1], parent, l));
				    	}
				    	if(randomgrassd >= 99 && randomgrassd <= 99){
				    		tilegrassd.add(new tileGrassD(ImgGrassD[2], parent, l));
				    	}
				    	if(randomgrassd > 99){
				    		tilegrassd.add(new tileGrassD(ImgGrassD[3], parent, l));
				    	}
				    }
				    if(water){
				    	int index = (int) (parent.random(0,ImgWater.length));
				    	tilewater.add(new tileWater(ImgWater[index], parent, l));
				    }
				}
			}
		}
		
		Iterator<tileDirt> TD = tiledirt.iterator();
		while(TD.hasNext()){
			tileDirt td = TD.next();
			td.display(parent);
		}
		
		Iterator<tileGrassD> TGD = tilegrassd.iterator();
		while(TGD.hasNext()){
			tileGrassD tgd = TGD.next();
			tgd.display(parent);
		}
		
		Iterator<tileGrassL> TGL = tilegrassl.iterator();
		while(TGL.hasNext()){
			tileGrassL tgl = TGL.next();
			tgl.display(parent);
		}
		
		Iterator<tileWater> TW = tilewater.iterator();
		while(TW.hasNext()){
			tileWater tw = TW.next();
			tw.display(parent);
		}
		
		
		Iterator<Tuile> T = tuile.iterator();
		while(T.hasNext()){
			Tuile t = T.next();
			t.display(parent);
		}
		//////////////////////
		
		
		////////Zone Feuillu//////
		int totalZoneFeuillu = 6;
		while(zonefeuillu.size() < totalZoneFeuillu){
			PVector l = new PVector();
			l.x = parent.random(worldW-1750 , worldW-250);
			l.y	= parent.random(worldH-1750 , worldH-250);
			boolean tooClose = false;
			boolean tooFar = false;
			for(int a = 0; a < zonefeuillu.size(); a++){
				ZoneFeuillu other = zonefeuillu.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 150){
					tooClose = true;
					break;
				}
				if(d > 800){
					tooFar = true;
					break;
				}
			}
			if(!tooClose && !tooFar ){
				zonefeuillu.add(new ZoneFeuillu(parent,l));
			}
		}
		/////////////
		Iterator<ZoneFeuillu> ZF = zonefeuillu.iterator();
		while(ZF.hasNext()){
			ZoneFeuillu zf = ZF.next();
			zf.display(parent);
		}
		/////////////////////////
		
		/////////plantes/////////
		///////Les plantes overlapp ok en attente de positions/////
		
		int totalBuisson = 40;
		while(buisson.size() < totalBuisson){
			PVector l = new PVector();
			l.x = parent.random(worldW-3150 , worldW-50);
			l.y	= parent.random(worldH-3150 , worldH-50);
			boolean overlapping = false;
			for(int a = 0; a < buisson.size(); a++){
				Buisson other = buisson.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			/*
			for(int a = 0; a < zonefeuillu.size(); a++){
				ZoneFeuillu other = zonefeuillu.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 232){
					overlapping = true;
					break;
				}
			}
			*/
			for(int a = 0; a < tilegrassd.size(); a++){
				tileGrassD other = tilegrassd.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 50){
					overlapping = true;
					break;
				}
			}
			
			for(int a = 0; a < tilewater.size(); a++){
				tileWater other = tilewater.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 60){
					overlapping = true;
					break;
				}
			}
			
			if(!overlapping){
				int index = (int) (parent.random(0,ImgBuisson.length));
				buisson.add(new Buisson(ImgBuisson[index], parent, l));
			}
		}
		
		
		
		Iterator<Buisson> B = buisson.iterator();
		while(B.hasNext()){
			Buisson b = B.next();
			b.display(parent);
		}
		
		/////BUISSON FOOD//////
		int totalbuissonfruitjaune = 10;
		while(buissonfruitjaune.size() < totalbuissonfruitjaune){
			PVector l = new PVector();
			l.x = parent.random(worldW-3150 , worldW-50);
			l.y	= parent.random(worldH-3150 , worldH-50);
			boolean overlapping = false;
			for(int a = 0; a < buissonfruitjaune.size(); a++){
				BuissonFruitJaune other = buissonfruitjaune.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			/*
			for(int a = 0; a < zonefeuillu.size(); a++){
				ZoneFeuillu other = zonefeuillu.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 232){
					overlapping = true;
					break;
				}
			}
			*/
			for(int a = 0; a < tilegrassd.size(); a++){
				tileGrassD other = tilegrassd.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 50){
					overlapping = true;
					break;
				}
			}
			
			for(int a = 0; a < tilewater.size(); a++){
				tileWater other = tilewater.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 60){
					overlapping = true;
					break;
				}
			}
			
			for(int a = 0; a < buisson.size(); a++){
				Buisson other = buisson.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			if(!overlapping){
				int index = (int) (parent.random(0,ImgBuissonFruitJaune.length));
				buissonfruitjaune.add(new BuissonFruitJaune(ImgBuissonFruitJaune[index], parent, l));
			}
		}
		
		Iterator<BuissonFruitJaune> BJ = buissonfruitjaune.iterator();
		while(BJ.hasNext()){
			BuissonFruitJaune bj = BJ.next();
			bj.display(parent);
		}
		
		//////BUISSON ROUGE///////
		int totalbuissonfruitrouge = 10;
		while(buissonfruitrouge.size() < totalbuissonfruitrouge){
			PVector l = new PVector();
			l.x = parent.random(worldW-3150 , worldW-50);
			l.y	= parent.random(worldH-3150 , worldH-50);
			boolean overlapping = false;
			for(int a = 0; a < buissonfruitrouge.size(); a++){
				BuissonFruitRouge other = buissonfruitrouge.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			/*
			for(int a = 0; a < zonefeuillu.size(); a++){
				ZoneFeuillu other = zonefeuillu.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 232){
					overlapping = true;
					break;
				}
			}
			*/
			for(int a = 0; a < tilegrassd.size(); a++){
				tileGrassD other = tilegrassd.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 50){
					overlapping = true;
					break;
				}
			}
			
			for(int a = 0; a < tilewater.size(); a++){
				tileWater other = tilewater.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 60){
					overlapping = true;
					break;
				}
			}
			
			for(int a = 0; a < buisson.size(); a++){
				Buisson other = buisson.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < buissonfruitjaune.size(); a++){
				BuissonFruitJaune other = buissonfruitjaune.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			if(!overlapping){
				int index = (int) (parent.random(0,ImgBuissonFruitRouge.length));
				buissonfruitrouge.add(new BuissonFruitRouge(ImgBuissonFruitRouge[index], parent, l));
			}
		}
		
		Iterator<BuissonFruitRouge> BR = buissonfruitrouge.iterator();
		while(BR.hasNext()){
			BuissonFruitRouge br = BR.next();
			br.display(parent);
		}
		
		///////RED BERRY///////
		int totalredberry = buissonfruitrouge.size()*4;
		if(parent.random(1) < 0.01 && redberry.size() < totalredberry){
			Iterator<BuissonFruitRouge> BFR = buissonfruitrouge.iterator();
			while(BFR.hasNext()){
				BuissonFruitRouge bfr = BFR.next();
				PVector l = new PVector(parent.random(bfr.position.x -50, bfr.position.x +50), 
										parent.random(bfr.position.y-50, bfr.position.y +50));
				int index = (int) (parent.random(0,ImgRedBerry.length));
				redberry.add(new RedBerry(ImgRedBerry[index],parent,l));
			}
		}
		
		Iterator<RedBerry> RB = redberry.iterator();
		while(RB.hasNext()){
			RedBerry rb = RB.next();
			rb.display(parent);
			rb.growOld(rb);
			if(rb.rotten()){
				RB.remove();
			}
		}
		///////////////////////
		
		////////YELLOWBERRY/////
		int totalyellowberry = buissonfruitjaune.size()*4;
		if(parent.random(1) < 0.01 && yellowberry.size() < totalyellowberry){
			Iterator<BuissonFruitJaune> BFJ = buissonfruitjaune.iterator();
			while(BFJ.hasNext()){
				BuissonFruitJaune bfj = BFJ.next();
				PVector l = new PVector(parent.random(bfj.position.x -50, bfj.position.x +50), 
										parent.random(bfj.position.y-50, bfj.position.y +50));
				int index = (int) (parent.random(0,ImgYellowBerry.length));
				yellowberry.add(new YellowBerry(ImgYellowBerry[index],parent,l));
			}
		}
		
		Iterator<YellowBerry> YB = yellowberry.iterator();
		while(YB.hasNext()){
			YellowBerry yb = YB.next();
			yb.display(parent);
			yb.growOld(yb);
			if(yb.rotten()){
				YB.remove();
			}
		}
		////////////////////////
		
		////CHAMPI///////
		int totalChampi = 140;
		while(champi.size() < totalChampi){
			PVector l = new PVector();
			l.x = parent.random(worldW-3150 , worldW-50);
			l.y	= parent.random(worldH-3150 , worldH-50);
			boolean overlapping = false;
			boolean tooFar = false;
			for(int a = 0; a < champi.size(); a++){
				Champi other = champi.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			/*
			for(int a = 0; a < zonefeuillu.size(); a++){
				ZoneFeuillu other = zonefeuillu.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d > 800){
					tooFar = true;
					break;
				}
			}
			*/
			for(int a = 0; a < tilegrassl.size(); a++){
				tileGrassL other = tilegrassl.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 50){
					overlapping = true;
					break;
				}
			}
			
			for(int a = 0; a < tilewater.size(); a++){
				tileWater other = tilewater.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 60){
					overlapping = true;
					break;
				}
			}
			
			for(int a = 0; a < buisson.size(); a++){
				Buisson other = buisson.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < buissonfruitjaune.size(); a++){
				BuissonFruitJaune other = buissonfruitjaune.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < buissonfruitrouge.size(); a++){
				BuissonFruitRouge other = buissonfruitrouge.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			if(!overlapping && !tooFar){
				int index = (int) (parent.random(0,Imgchampignons.length));
				champi.add(new Champi(Imgchampignons[index], parent, l));
			}
		}
		
		Iterator<Champi> C = champi.iterator();
		while(C.hasNext()){
			Champi c = C.next();
			c.display(parent);
		}
		
		
		////ARBRE//////
		int totalfeuillu = 100;
		while(feuillu.size() < totalfeuillu){
			PVector l = new PVector();
			l.x = parent.random(worldW-3150 , worldW-50);
			l.y	= parent.random(worldH-3150 , worldH-50);
			boolean overlapping = false;
			boolean tooFar = false;
			//boolean tooClose = false;
			for(int a = 0; a < feuillu.size(); a++){
				Feuillu other = feuillu.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 90){
					overlapping = true;
					break;
				}
			}
			/*
			for(int a = 0; a < zonefeuillu.size(); a++){
				ZoneFeuillu other = zonefeuillu.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d > 800){
					tooFar = true;
					break;
				}
			}
			*/
			for(int a = 0; a < tilegrassl.size(); a++){
				tileGrassL other = tilegrassl.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 50){
					overlapping = true;
					break;
				}
			}
			
			for(int a = 0; a < tilewater.size(); a++){
				tileWater other = tilewater.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 60){
					overlapping = true;
					break;
				}
			}
			
			for(int a = 0; a < buisson.size(); a++){
				Buisson other = buisson.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < buissonfruitjaune.size(); a++){
				BuissonFruitJaune other = buissonfruitjaune.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < buissonfruitrouge.size(); a++){
				BuissonFruitRouge other = buissonfruitrouge.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < champi.size(); a++){
				Champi other = champi.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			if(!overlapping && !tooFar){
				int index = (int) (parent.random(0,ImgFeuillu.length));
				feuillu.add(new Feuillu(ImgFeuillu[index], parent, l));
			}
		}
		
		/*
		Iterator<Feuillu> F = feuillu.iterator();
		while(F.hasNext()){
			Feuillu f = F.next();
			f.display(parent);
		}
		*/
		
		/////ARBRE FOOD/////
		int totalfruittree = 10;
		while(fruittree.size() < totalfruittree){
			PVector l = new PVector();
			l.x = parent.random(worldW-3150 , worldW-50);
			l.y	= parent.random(worldH-3150 , worldH-50);
			boolean overlapping = false;
			for(int a = 0; a < fruittree.size(); a++){
				FruitTree other = fruittree.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 100){
					overlapping = true;
					break;
				}
			}
			/*
			for(int a = 0; a < feuillu.size(); a++){
				Feuillu other = feuillu.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 100){
					overlapping = true;
					break;
				}
			}
			*/
			for(int a = 0; a < tilegrassd.size(); a++){
				tileGrassD other = tilegrassd.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 50){
					overlapping = true;
					break;
				}
			}
			
			for(int a = 0; a < tilewater.size(); a++){
				tileWater other = tilewater.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 60){
					overlapping = true;
					break;
				}
			}
			
			for(int a = 0; a < buisson.size(); a++){
				Buisson other = buisson.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < buissonfruitjaune.size(); a++){
				BuissonFruitJaune other = buissonfruitjaune.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < buissonfruitrouge.size(); a++){
				BuissonFruitRouge other = buissonfruitrouge.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < champi.size(); a++){
				Champi other = champi.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			if(!overlapping){
				int index = (int) (parent.random(0,ImgFruitTree.length));
				fruittree.add(new FruitTree(ImgFruitTree[index], parent, l));
			}
		}
		
		/*
		Iterator<FruitTree> FT = fruittree.iterator();
		while(FT.hasNext()){
			FruitTree ft = FT.next();
			ft.display(parent);
		}
		*/
		
		////FLOWER/////
		int totalflower = 200;
		while(flower.size() < totalflower){
			PVector l = new PVector();
			l.x = parent.random(worldW-3150 , worldW-50);
			l.y	= parent.random(worldH-3150 , worldH-50);
			boolean overlapping = false;
			for(int a = 0; a < flower.size(); a++){
				Flower other = flower.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < fruittree.size(); a++){
				FruitTree other = fruittree.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			/*
			for(int a = 0; a < feuillu.size(); a++){
				Feuillu other = feuillu.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			*/
			
			for(int a = 0; a < tilegrassd.size(); a++){
				tileGrassD other = tilegrassd.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 50){
					overlapping = true;
					break;
				}
			}
			
			for(int a = 0; a < tilewater.size(); a++){
				tileWater other = tilewater.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 60){
					overlapping = true;
					break;
				}
			}
			
			for(int a = 0; a < buisson.size(); a++){
				Buisson other = buisson.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < buissonfruitjaune.size(); a++){
				BuissonFruitJaune other = buissonfruitjaune.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < buissonfruitrouge.size(); a++){
				BuissonFruitRouge other = buissonfruitrouge.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < champi.size(); a++){
				Champi other = champi.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			if(!overlapping){
				int index = (int) (parent.random(0,ImgFlower.length));
				flower.add(new Flower(ImgFlower[index], parent, l));
			}
		}
		
		Iterator<Flower> FL = flower.iterator();
		while(FL.hasNext()){
			Flower fl = FL.next();
			fl.display(parent);
		}
		
		
		/////ROCK//////
		int totalrock = 70;
		while(rock.size() < totalrock){
			PVector l = new PVector();
			l.x = parent.random(worldW-3150 , worldW-50);
			l.y	= parent.random(worldH-3150 , worldH-50);
			boolean overlapping = false;
			for(int a = 0; a < rock.size(); a++){
				Rock other = rock.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < flower.size(); a++){
				Flower other = flower.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < fruittree.size(); a++){
				FruitTree other = fruittree.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < feuillu.size(); a++){
				Feuillu other = feuillu.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < buisson.size(); a++){
				Buisson other = buisson.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < buissonfruitjaune.size(); a++){
				BuissonFruitJaune other = buissonfruitjaune.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < buissonfruitrouge.size(); a++){
				BuissonFruitRouge other = buissonfruitrouge.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < champi.size(); a++){
				Champi other = champi.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < tilewater.size(); a++){
				tileWater other = tilewater.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 60){
					overlapping = true;
					break;
				}
			}
			if(!overlapping){
				int index = (int) (parent.random(0,ImgRock.length));
				rock.add(new Rock(ImgRock[index], parent, l));
			}
		}
		
		Iterator<Rock> R = rock.iterator();
		while(R.hasNext()){
			Rock r = R.next();
			r.display(parent);
		}
		
		//////HERBE//////
		int totalgrassfeuillu = 1000;
		while(grassfeuillu.size() < totalgrassfeuillu){
			PVector l = new PVector();
			l.x = parent.random(worldW-3150 , worldW-50);
			l.y	= parent.random(worldH-3150 , worldH-50);
			boolean overlapping = false;
			for(int a = 0; a < grassfeuillu.size(); a++){
				GrassFeuillu other = grassfeuillu.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < rock.size(); a++){
				Rock other = rock.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < flower.size(); a++){
				Flower other = flower.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < fruittree.size(); a++){
				FruitTree other = fruittree.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < feuillu.size(); a++){
				Feuillu other = feuillu.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < buisson.size(); a++){
				Buisson other = buisson.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < buissonfruitjaune.size(); a++){
				BuissonFruitJaune other = buissonfruitjaune.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < buissonfruitrouge.size(); a++){
				BuissonFruitRouge other = buissonfruitrouge.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < champi.size(); a++){
				Champi other = champi.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 32){
					overlapping = true;
					break;
				}
			}
			for(int a = 0; a < tilewater.size(); a++){
				tileWater other = tilewater.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 60){
					overlapping = true;
					break;
				}
			}
			if(!overlapping){
				int index = (int) (parent.random(0,ImgGrassFeuillu.length));
				grassfeuillu.add(new GrassFeuillu(ImgGrassFeuillu[index], parent, l));
			}
		}
		
		Iterator<GrassFeuillu> GF = grassfeuillu.iterator();
		while(GF.hasNext()){
			GrassFeuillu gf = GF.next();
			gf.display(parent);
		}
		
		//////////////////////
		///////INSECT/////////
		//////////////////////
		
		////a modif pour plus de cohérence
		
		//while(insect1m.size() < 1){
			int totalinsect1m = 80;
			for(int i = 0; i < totalinsect1m; i++){
				//PVector l = new PVector(parent.random(50, 3150), parent.random(50, 3150));
				//DNAinsect dnainsect = new DNAinsect(parent);
				//insect1m.add(new insect1M(l, dnainsect, parent));
				PVector l = new PVector();
				l.x = parent.random(worldW-3150 , worldW-50);
				l.y	= parent.random(worldH-3150 , worldH-50);
				boolean overlapping = false;
				for(int a = 0; a < tilewater.size(); a++){
					tileWater other = tilewater.get(a);
					float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
					if(d < 60){
						overlapping = true;
						break;
					}
				}
				if(!overlapping && insect1m.size() < 80){
					DNAinsect dnainsect = new DNAinsect(parent);
					insect1m.add(new insect1M(l, dnainsect, parent));
				}
			}
		//}
		
		Iterator<insect1M> I1M = insect1m.iterator();
		while(I1M.hasNext()){
			insect1M i1m = I1M.next();
			i1m.run(parent);
			
			
			if(i1m.faim() == false){
				i1m.randomMv();
				i1m.mvtUpdate();
				
			}
			if(i1m.faim() == true){
				i1m.eatFood();
			}
			
			Iterator<tileWater> tileW = tilewater.iterator();
			while(tileW.hasNext()){
				tileWater tilew = tileW.next();
				PVector target = new PVector(tilew.position.x, tilew.position.y);
				if(i1m.isTooClose(target)){
					i1m.goAway(target);
				}
			}
			
		}
		
		//////////////////////
		
		/////papillon/////////
		while(papillonb.size() < 1){
			int totalpapillonb = 20;
			for(int i = 0; i < totalpapillonb; i++){
				PVector l = new PVector(parent.random(50, 3150), parent.random(50, 3150));
				DNAinsect dnainsect = new DNAinsect(parent);
				papillonb.add(new PapillonB(l,dnainsect,parent));
			}
		}
		
		Iterator<PapillonB> PB = papillonb.iterator();
		while(PB.hasNext()){
			PapillonB pb = PB.next();
			pb.run(parent);
			pb.boundaries();
			pb.display(parent);
			pb.wander(parent);
			pb.mvtUpdate();
			
			if(pb.dead() == true){
				PB.remove();
			}
			
			/////si utilisé les papillon stop pour manger mais ne vont pas vers flower
			if(pb.faim() == false){
				//pb.wander(parent);
				//pb.mvtUpdate();
			}
			if(pb.faim() == true){
				//pb.eatFood();
			}
		}
		
		//////find flower/food////////
		if(papillonb.size() > 0){
			float currentSmallest;
			float dist;
			for(int a = papillonb.size()-1; a >= 0; a--){
				PapillonB papb = papillonb.get(a);
				if(papb.faim() == true){
					PVector target = new PVector(0,0);
					currentSmallest = (worldH * worldH) + (worldW * worldW);
					for(int b = flower.size()-1; b >= 0; b--){
						Flower flo = flower.get(b);
						dist = ((papb.position.x - flo.position.x) * (papb.position.x - flo.position.x)) +
							   ((papb.position.y - flo.position.y) * (papb.position.y - flo.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = flo.position.x;
							target.y = flo.position.y;
						}
						if(dist < 32){
							papb.eatFood();
						}
					}
					papb.findFlower(target);
					
				}
			}
		}
		//////////////////////////////
		
		/////find nest//////
		if(papillonb.size() > 0){
			float currentSmallest;
			float dist;
			for(int a = papillonb.size()-1; a >= 0; a--){
				PapillonB papb = papillonb.get(a);
				if(papb.reproduceTime()== true){
					PVector target = new PVector(0,0);
					currentSmallest = (worldH * worldH) + (worldW * worldW);
					for(int b = buisson.size()-1; b >= 0; b--){
						Buisson bui = buisson.get(b);
						dist = ((papb.position.x - bui.position.x) * (papb.position.x - bui.position.x)) +
							   ((papb.position.y - bui.position.y) * (papb.position.y - bui.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = bui.position.x;
							target.y = bui.position.y;
						}
					}
					papb.findNest(target);
				}
			}
		}
		//////////////////////
		
		//////drop eggs///////
		for(int a = papillonb.size()-1; a >= 0; a--){
			PapillonB papb = papillonb.get(a);
			for(int b = buisson.size()-1; b >= 0; b--){
				Buisson bui = buisson.get(b);
				PVector papbpos = papb.position;
				PVector buipos = bui.position;
				float d = PVector.dist(papbpos, buipos);
				if(d < 10 && papb.reproduceTime() == true){
					papillonbegg.add(new PapillonBegg(papbpos,parent));
					papb.resetReproduce();
				}
			}
		}
		//////////////////////
		
		/////////EGGS/////////
		Iterator<PapillonBegg> PBE = papillonbegg.iterator();
		while(PBE.hasNext()){
			PapillonBegg pbe = PBE.next();
			pbe.run(parent);
			if(pbe.growUp()== true){
				PBE.remove();
				PVector pbepos = pbe.position;
				DNAinsect dnainsect = new DNAinsect(parent);
				papillonbchenille.add(new PapillonBchenille(pbepos,dnainsect,parent));
			}
		}
		//////////////////////
		
		///////chenille///////
		Iterator<PapillonBchenille> PBC = papillonbchenille.iterator();
		while(PBC.hasNext()){
			PapillonBchenille pbc = PBC.next();
			pbc.update();
			pbc.randomMv();
			pbc.mvtUpdate();
			if(pbc.growUp() == true){
				PBC.remove();
				PVector l = pbc.position;
				DNAinsect dnainsect = new DNAinsect(parent);
				papillonb.add(new PapillonB(l,dnainsect,parent));
			}
		}
		//////////////////////
		
		///////find buisson/////
		if(papillonbchenille.size() > 0){
			float currentSmallest;
			float dist;
			for(int a = papillonbchenille.size()-1; a >= 0; a--){
				PapillonBchenille papbc = papillonbchenille.get(a);
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				for(int b = buisson.size()-1; b >= 0; b--){
					Buisson bui = buisson.get(b);
					dist = ((papbc.position.x - bui.position.x) * (papbc.position.x - bui.position.x)) +
						   ((papbc.position.y - bui.position.y) * (papbc.position.y - bui.position.y));
					if( dist < currentSmallest){
						currentSmallest = dist;
						target.x = bui.position.x;
						target.y = bui.position.y;
					}
				}
				papbc.stayCloseBuisson(target);
			}
		}
		////////////////////////
		/////SOURIS/////////////
		////////////////////////
		
		///////SourisNid//////////
		int totalnid = 1;
		while(sourisnid.size() < totalnid){
			PVector l = new PVector();
			l.x = parent.random(worldW-3150 , worldW-50);
			l.y	= parent.random(worldH-3150 , worldH-50);
			boolean overlapping = false;
			for(int a = 0; a < tilewater.size(); a++){
				tileWater other = tilewater.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 60){
					overlapping = true;
					break;
				}
			}
			if(!overlapping){
				sourisnid.add(new SourisNid(parent, l));
			}
			
		}
			
		
		Iterator<SourisNid> SN = sourisnid.iterator();
		while(SN.hasNext()){
			SourisNid sn = SN.next();
			sn.display(parent);
		}
		
		/////////////////////////
		
		///////SourisM//////////
		
		while(sourism.size() < 1){
			int totalsourisM = 2;
			for(int i = 0; i < totalsourisM; i++){
				Iterator<SourisNid> SON = sourisnid.iterator();
				while(SON.hasNext()){
					SourisNid son = SON.next();
					PVector l = new PVector(parent.random(son.position.x, son.position.x), parent.random(son.position.y, son.position.y));
					DNAsouris dnasouris = new DNAsouris(parent);
					sourism.add(new SourisM(l,dnasouris,parent));
				}
			}
		}
		
		
		Iterator<SourisM> SM = sourism.iterator();
		while(SM.hasNext()){
			SourisM sm = SM.next();
			sm.display(parent);
			sm.run(parent);
			sm.boundaries();
			
			if(sm.eatingTime() == false ){
				//sm.wander(parent);
				sm.mvtUpdate();
			}
			
			if(sm.dead() == true){
				SM.remove();
			}
			
			Iterator<tileWater> tileW = tilewater.iterator();
			while(tileW.hasNext()){
				tileWater tilew = tileW.next();
				PVector target = new PVector(tilew.position.x, tilew.position.y);
				if(sm.isTooClose(target)){
					sm.goAway(target);
				}
			}
			
		}
		
		///////find food insecte/ chenille/////////
		if(sourism.size() > 0){
			float currentSmallest;
			float dist;
			for(int a = sourism.size()-1; a >=0; a--){
				SourisM soum = sourism.get(a);
				
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(soum.faim() == false){
					soum.wander(parent);
				}
				if(soum.faim() == true){
					for(int b = insect1m.size()-1; b >=0; b--){
						insect1M i1m = insect1m.get(b);
						dist = ((soum.position.x - i1m.position.x) * (soum.position.x - i1m.position.x)) +
							   ((soum.position.y - i1m.position.y) * (soum.position.y - i1m.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = i1m.position.x;
							target.y = i1m.position.y;
						}
					}
					for(int c = papillonbchenille.size()-1; c >=0; c--){
						PapillonBchenille pbc = papillonbchenille.get(c);
						dist = ((soum.position.x - pbc.position.x) * (soum.position.x - pbc.position.x)) +
							   ((soum.position.y - pbc.position.y) * (soum.position.y - pbc.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = pbc.position.x;
							target.y = pbc.position.y;
						}
					}
					soum.findPray(target);
				}
				
			}
		}
		/////////////////////////
		
		////////eat insect////////
		Iterator<SourisM> SouM = sourism.iterator();
		while(SouM.hasNext()){
			SourisM soum = SouM.next();
			Iterator<insect1M> i1M = insect1m.iterator();
			while(i1M.hasNext()){
				insect1M i1m = i1M.next();
				PVector i1mpos = i1m.position;
				PVector soumpos = soum.position;
				float d = PVector.dist(i1mpos, soumpos);
				if(soum.faim() == true){
					if(d < soum.getR()){
						soum.eatFood();
						i1M.remove();
						soum.resetEating();
					}
				}
			}
		}
		//////////////////////////
		
		////////eat chenille////////
		Iterator<SourisM> SourM = sourism.iterator();
		while(SourM.hasNext()){
			SourisM sourm = SourM.next();
			Iterator<PapillonBchenille> Pbc = papillonbchenille.iterator();
			while(Pbc.hasNext()){
				PapillonBchenille pbc = Pbc.next();
				PVector pbcpos = pbc.position;
				PVector soumpos = sourm.position;
				float d = PVector.dist(pbcpos, soumpos);
				if(sourm.faim() == true){
					if(d < sourm.getR()){
						sourm.eatFood();
						Pbc.remove();
						sourm.resetEating();
					}
				}
			}
		}
		//////////////////////////
		
		
		///////SourisF//////////
		
		while(sourisf.size() < 1){
			int totalsourisF = 2;
			for(int i = 0; i < totalsourisF; i++){
				Iterator<SourisNid> SON = sourisnid.iterator();
				while(SON.hasNext()){
					SourisNid son = SON.next();
					PVector l = new PVector(parent.random(son.position.x, son.position.x), parent.random(son.position.y, son.position.y));
					DNAsouris dnasouris = new DNAsouris(parent);
					sourisf.add(new SourisF(l,dnasouris,parent));
				}
			}
		}
		
		Iterator<SourisF> SF = sourisf.iterator();
		while(SF.hasNext()){
			SourisF sf = SF.next();
			sf.display(parent);
			sf.run(parent);
			sf.boundaries();
			
			if(sf.eatingTime() == false ){
				//sf.wander(parent);
				sf.mvtUpdate();
			}
			
			if(sf.dead() == true){
				SF.remove();
			}
			
			Iterator<tileWater> tileW = tilewater.iterator();
			while(tileW.hasNext()){
				tileWater tilew = tileW.next();
				PVector target = new PVector(tilew.position.x, tilew.position.y);
				if(sf.isTooClose(target)){
					sf.goAway(target);
				}
			}
			
		}
		
		///////find food insecte/chenille /////////
		if(sourisf.size() > 0){
			float currentSmallest;
			float dist;
			for(int a = sourisf.size()-1; a >=0; a--){
				SourisF souf = sourisf.get(a);
				
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(souf.faim() == false){
					souf.wander(parent);
				}
				if(souf.faim() == true){
					for(int b = insect1m.size()-1; b >=0; b--){
						insect1M i1m = insect1m.get(b);
						dist = ((souf.position.x - i1m.position.x) * (souf.position.x - i1m.position.x)) +
							   ((souf.position.y - i1m.position.y) * (souf.position.y - i1m.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = i1m.position.x;
							target.y = i1m.position.y;
						}
					}
					for(int c = papillonbchenille.size()-1; c >=0; c--){
						PapillonBchenille pbc = papillonbchenille.get(c);
						dist = ((souf.position.x - pbc.position.x) * (souf.position.x - pbc.position.x)) +
							   ((souf.position.y - pbc.position.y) * (souf.position.y - pbc.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = pbc.position.x;
							target.y = pbc.position.y;
						}
					}
					
					souf.findPray(target);
				}
				
			}
		}
		/////////////////////////
		
		////////eat insect////////
		Iterator<SourisF> SouF = sourisf.iterator();
		while(SouF.hasNext()){
			SourisF souf = SouF.next();
			Iterator<insect1M> i1M = insect1m.iterator();
			while(i1M.hasNext()){
				insect1M i1m = i1M.next();
				PVector i1mpos = i1m.position;
				PVector soufpos = souf.position;
				float d = PVector.dist(i1mpos, soufpos);
				if(souf.faim() == true){
					if(d < souf.getR()){
						souf.eatFood();
						i1M.remove();
						souf.resetEating();
					}
				}
			}
		}
		//////////////////////////
		
		////////eat chenille////////
		Iterator<SourisF> SourF = sourisf.iterator();
		while(SourF.hasNext()){
			SourisF sourf = SourF.next();
			Iterator<PapillonBchenille> Pbc = papillonbchenille.iterator();
			while(Pbc.hasNext()){
				PapillonBchenille pbc = Pbc.next();
				PVector pbcpos = pbc.position;
				PVector soufpos = sourf.position;
				float d = PVector.dist(pbcpos, soufpos);
				if(sourf.faim() == true){
					if(d < sourf.getR()){
						sourf.eatFood();
						Pbc.remove();
						sourf.resetEating();
					}
				}
			}
		}
		//////////////////////////
		

		
		////////////////////////
		//////reproduction//////
		
		//////find female///////
		if(sourisf.size() >= 1){
			float currentSmallest;
			float dist;
			for(int a = sourism.size()-1; a >=0; a--){
				SourisM soum = sourism.get(a);
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(soum.reproduceTime() == false){
					soum.wander(parent);
				}
				if(soum.reproduceTime() == true){
					for(int b = sourisf.size()-1; b >= 0; b--){
						SourisF souf = sourisf.get(b);
						dist = ((soum.position.x - souf.position.x) * (soum.position.x - souf.position.x)) +
							   ((soum.position.y - souf.position.y) * (soum.position.y - souf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = souf.position.x;
							target.y = souf.position.y;
						}
					}
					soum.findFemale(target);
				}
			}
		}
		////////////////////////
		
		/////reproduction///////
		for(int a = sourism.size()-1; a >= 0; a--){
			for(int b = sourisf.size()-1; b >= 0; b--){
				for(int c = sourisnid.size()-1; c >=0; c--){
					SourisM sm = sourism.get(a);
					SourisF sf = sourisf.get(b);
					SourisNid nid = sourisnid.get(c);
					PVector smpos = sm.position;
					PVector sfpos = sf.position;
					PVector nidpos = nid.position;
					float d = PVector.dist(smpos, sfpos);
					if(d < sf.getR() && sf.reproduceTime() == true){  /////a changer juste pour test
						DNAsouris momgenes = sm.getDNAsouris();
						DNAsouris dadgenes = sf.getDNAsouris();
						DNAsouris childdna = momgenes.crossover(dadgenes, parent);
						//if(parent.random(1) < 0.9){
							if(parent.random(10) > 5 && sourism.size() < 20){
								sourism.add(new SourisM(nidpos, childdna, parent));
								sf.resetReproduce();
								sm.resetReproduce();
							}
							if(parent.random(10) < 5 && sourisf.size() < 20){
								sourisf.add(new SourisF(nidpos, childdna, parent));
								sf.resetReproduce();
								sm.resetReproduce();
							}
						//}
					}
				}
			}
		}
		
		////////////////////////
		
		
		////////////////////////
		////////LAPIN///////////
		
		///////LapinNid//////////
		int totallapinnid = 1;
		while(lapinnid.size() < totallapinnid){
			PVector l = new PVector();
			l.x = parent.random(worldW-3150 , worldW-50);
			l.y	= parent.random(worldH-3150 , worldH-50);
			boolean overlapping = false;
			for(int a = 0; a < tilewater.size(); a++){
				tileWater other = tilewater.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 60){
					overlapping = true;
					break;
				}
			}
			if(!overlapping){
				lapinnid.add(new LapinNid(parent, l));
			}
			
		}
		
		Iterator<LapinNid> LN = lapinnid.iterator();
		while(LN.hasNext()){
			LapinNid ln = LN.next();
			ln.display(parent);
		}

		
		///////LapinM//////////
		while(lapinm.size() < 1){ ///a modif ou sinon pop eternel
			int totallapinM = 1;
			for(int i = 0; i < totallapinM; i++){
				Iterator<LapinNid> LAN = lapinnid.iterator();
				while(LAN.hasNext()){
					LapinNid lan = LAN.next();
					PVector l = new PVector(parent.random(lan.position.x, lan.position.x), parent.random(lan.position.y, lan.position.y));
					DNAlapin dnalapin = new DNAlapin(parent);
					lapinm.add(new LapinM(l,dnalapin,parent));
				}
			}
		}
		
		Iterator<LapinM> LM = lapinm.iterator();
		while(LM.hasNext()){
			LapinM lm = LM.next();
			lm.display(parent);
			lm.run(parent);
			lm.boundaries();
			
			if(lm.eatingTime() == false ){
				//lm.wander(parent);
				lm.mvtUpdate();
			}
			
			if(lm.dead() == true){
				LM.remove();
			}
			
			Iterator<tileWater> tileW = tilewater.iterator();
			while(tileW.hasNext()){
				tileWater tilew = tileW.next();
				PVector target = new PVector(tilew.position.x, tilew.position.y);
				if(lm.isTooClose(target)){
					lm.goAway(target);
				}
			}
			
		}
		
		///////find food grassfeuillu/ red and yellow fruit flower / /////////
		if(lapinm.size() > 0){
			float currentSmallest;
			float dist;
			for(int a = lapinm.size()-1; a >=0; a--){
				LapinM lm = lapinm.get(a);
				
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(lm.faim() == false){
					lm.wander(parent);
				}
				if(lm.faim() == true){
					for(int b = grassfeuillu.size()-1; b >=0; b--){
						GrassFeuillu gf = grassfeuillu.get(b);
						dist = ((lm.position.x - gf.position.x) * (lm.position.x - gf.position.x)) +
							   ((lm.position.y - gf.position.y) * (lm.position.y - gf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = gf.position.x;
							target.y = gf.position.y;
						}
					}
					for(int c = redberry.size()-1; c >=0; c--){
						RedBerry rb = redberry.get(c);
						dist = ((lm.position.x - rb.position.x) * (lm.position.x - rb.position.x)) +
							   ((lm.position.y - rb.position.y) * (lm.position.y - rb.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = rb.position.x;
							target.y = rb.position.y;
						}
					}
					for(int d = yellowberry.size()-1; d >=0; d--){
						YellowBerry yb = yellowberry.get(d);
						dist = ((lm.position.x - yb.position.x) * (lm.position.x - yb.position.x)) +
							   ((lm.position.y - yb.position.y) * (lm.position.y - yb.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = yb.position.x;
							target.y = yb.position.y;
						}
					}
					for(int e = flower.size()-1; e >=0; e--){
						Flower fl = flower.get(e);
						dist = ((lm.position.x - fl.position.x) * (lm.position.x - fl.position.x)) +
							   ((lm.position.y - fl.position.y) * (lm.position.y - fl.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = fl.position.x;
							target.y = fl.position.y;
						}
					}
					lm.findFood(target);
				}
				
			}
		}
		/////////////////////////
		
		////////eat grassfeuillu/ redberry/ yellow and flower////////
		Iterator<LapinM> LaM = lapinm.iterator();
		while(LaM.hasNext()){
			LapinM lam = LaM.next();
			Iterator<GrassFeuillu> GrF = grassfeuillu.iterator();
			while(GrF.hasNext()){
				GrassFeuillu grf = GrF.next();
				PVector grasspos = grf.position;
				PVector lapinmpos = lam.position;
				float d = PVector.dist(grasspos, lapinmpos);
				if(lam.faim() == true){
					if(d < lam.getR()){
						lam.eatFood();
						//GrF.remove(); //pas de remove pour l'instant
						lam.resetEating();
					}
				}
			}
			Iterator<RedBerry> ReB = redberry.iterator();
			while(ReB.hasNext()){
				RedBerry reb = ReB.next();
				PVector rebpos = reb.position;
				PVector lapinmpos = lam.position;
				float d = PVector.dist(rebpos, lapinmpos);
				if(lam.faim() == true){
					if(d < lam.getR()){
						lam.eatFood();
						//ReB.remove(); //pas de remove pour l'instant
						lam.resetEating();
					}
				}
			}
			Iterator<YellowBerry> YeB = yellowberry.iterator();
			while(YeB.hasNext()){
				YellowBerry yeb = YeB.next();
				PVector yebpos = yeb.position;
				PVector lapinmpos = lam.position;
				float d = PVector.dist(yebpos, lapinmpos);
				if(lam.faim() == true){
					if(d < lam.getR()){
						lam.eatFood();
						//YeB.remove(); //pas de remove pour l'instant
						lam.resetEating();
					}
				}
			}
			Iterator<Flower> Fl = flower.iterator();
			while(Fl.hasNext()){
				Flower fl = Fl.next();
				PVector flpos = fl.position;
				PVector lapinmpos = lam.position;
				float d = PVector.dist(flpos, lapinmpos);
				if(lam.faim() == true){
					if(d < lam.getR()){
						lam.eatFood();
						//Fl.remove(); //pas de remove pour l'instant
						lam.resetEating();
					}
				}
			}

		}
		//////////////////////////
		
		
		
		///////LapinF//////////
		while(lapinf.size() < 1){ ///a modif ou sinon pop eternel
			int totallapinF = 1;
			for(int i = 0; i < totallapinF; i++){
				Iterator<LapinNid> LAN = lapinnid.iterator();
				while(LAN.hasNext()){
					LapinNid lan = LAN.next();
					PVector l = new PVector(parent.random(lan.position.x, lan.position.x), parent.random(lan.position.y, lan.position.y));
					DNAlapin dnalapin = new DNAlapin(parent);
					lapinf.add(new LapinF(l,dnalapin,parent));
				}
			}
		}
		
		Iterator<LapinF> LF = lapinf.iterator();
		while(LF.hasNext()){
			LapinF lf = LF.next();
			lf.display(parent);
			lf.run(parent);
			lf.boundaries();
			
			if(lf.eatingTime() == false ){
				//lf.wander(parent);
				lf.mvtUpdate();
			}
			
			if(lf.dead() == true){
				LF.remove();
			}
			
			Iterator<tileWater> tileW = tilewater.iterator();
			while(tileW.hasNext()){
				tileWater tilew = tileW.next();
				PVector target = new PVector(tilew.position.x, tilew.position.y);
				if(lf.isTooClose(target)){
					lf.goAway(target);
				}
			}
			
		}
		
		///////find food grassfeuillu/////////
		if(lapinf.size() > 0){
			float currentSmallest;
			float dist;
			for(int a = lapinf.size()-1; a >=0; a--){
				LapinF lf = lapinf.get(a);
				
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(lf.faim() == false){
					lf.wander(parent);
				}
				if(lf.faim() == true){
					for(int b = grassfeuillu.size()-1; b >=0; b--){
						GrassFeuillu gf = grassfeuillu.get(b);
						dist = ((lf.position.x - gf.position.x) * (lf.position.x - gf.position.x)) +
							   ((lf.position.y - gf.position.y) * (lf.position.y - gf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = gf.position.x;
							target.y = gf.position.y;
						}
					}
					for(int c = redberry.size()-1; c >=0; c--){
						RedBerry rb = redberry.get(c);
						dist = ((lf.position.x - rb.position.x) * (lf.position.x - rb.position.x)) +
							   ((lf.position.y - rb.position.y) * (lf.position.y - rb.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = rb.position.x;
							target.y = rb.position.y;
						}
					}
					for(int d = yellowberry.size()-1; d >=0; d--){
						YellowBerry yb = yellowberry.get(d);
						dist = ((lf.position.x - yb.position.x) * (lf.position.x - yb.position.x)) +
							   ((lf.position.y - yb.position.y) * (lf.position.y - yb.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = yb.position.x;
							target.y = yb.position.y;
						}
					}
					for(int e = flower.size()-1; e >=0; e--){
						Flower fl = flower.get(e);
						dist = ((lf.position.x - fl.position.x) * (lf.position.x - fl.position.x)) +
							   ((lf.position.y - fl.position.y) * (lf.position.y - fl.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = fl.position.x;
							target.y = fl.position.y;
						}
					}

					lf.findFood(target);
				}
				
			}
		}
		/////////////////////////
		
		////////eat grassfeuillu////////
		Iterator<LapinF> LaF = lapinf.iterator();
		while(LaF.hasNext()){
			LapinF laf = LaF.next();
			Iterator<GrassFeuillu> GrF = grassfeuillu.iterator();
			while(GrF.hasNext()){
				GrassFeuillu grf = GrF.next();
				PVector grasspos = grf.position;
				PVector lapinfpos = laf.position;
				float d = PVector.dist(grasspos, lapinfpos);
				if(laf.faim() == true){
					if(d < laf.getR()){
						laf.eatFood();
						//GrF.remove(); //pas de remove pour l'instant
						laf.resetEating();
					}
				}
			}
			Iterator<RedBerry> ReB = redberry.iterator();
			while(ReB.hasNext()){
				RedBerry reb = ReB.next();
				PVector rebpos = reb.position;
				PVector lapinfpos = laf.position;
				float d = PVector.dist(rebpos, lapinfpos);
				if(laf.faim() == true){
					if(d < laf.getR()){
						laf.eatFood();
						//ReB.remove(); //pas de remove pour l'instant
						laf.resetEating();
					}
				}
			}
			Iterator<YellowBerry> YeB = yellowberry.iterator();
			while(YeB.hasNext()){
				YellowBerry yeb = YeB.next();
				PVector yebpos = yeb.position;
				PVector lapinfpos = laf.position;
				float d = PVector.dist(yebpos, lapinfpos);
				if(laf.faim() == true){
					if(d < laf.getR()){
						laf.eatFood();
						//YeB.remove(); //pas de remove pour l'instant
						laf.resetEating();
					}
				}
			}
			Iterator<Flower> Fl = flower.iterator();
			while(Fl.hasNext()){
				Flower fl = Fl.next();
				PVector flpos = fl.position;
				PVector lapinfpos = laf.position;
				float d = PVector.dist(flpos, lapinfpos);
				if(laf.faim() == true){
					if(d < laf.getR()){
						laf.eatFood();
						//Fl.remove(); //pas de remove pour l'instant
						laf.resetEating();
					}
				}
			}

		}
		//////////////////////////
		
		////////////////////////
		//////reproduction//////
		
		//////find female///////
		if(lapinf.size() >= 1){
			float currentSmallest;
			float dist;
			for(int a = lapinm.size()-1; a >=0; a--){
				LapinM lm = lapinm.get(a);
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(lm.reproduceTime() == false){
					lm.wander(parent);
				}
				if(lm.reproduceTime() == true){
					for(int b = lapinf.size()-1; b >= 0; b--){
						LapinF lf = lapinf.get(b);
						dist = ((lm.position.x - lf.position.x) * (lm.position.x - lf.position.x)) +
							   ((lm.position.y - lf.position.y) * (lm.position.y - lf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = lf.position.x;
							target.y = lf.position.y;
						}
					}
					lm.findFemale(target);
				}
			}
		}
		////////////////////////
		
		/////reproduction///////
		for(int a = lapinm.size()-1; a >= 0; a--){
			for(int b = lapinf.size()-1; b >= 0; b--){
				for(int c = lapinnid.size()-1; c >=0; c--){
					LapinM lm = lapinm.get(a);
					LapinF lf = lapinf.get(b);
					LapinNid nid = lapinnid.get(c);
					PVector lmpos = lm.position;
					PVector lfpos = lf.position;
					PVector nidpos = nid.position;
					float d = PVector.dist(lmpos, lfpos);
					if(d < lf.getR() && lf.reproduceTime() == true){  /////a changer juste pour test
						DNAlapin momgenes = lm.getDNAlapin();
						DNAlapin dadgenes = lf.getDNAlapin();
						DNAlapin childdna = momgenes.crossover(dadgenes, parent);
						//if(parent.random(1) < 0.9){
							if(parent.random(10) > 5 && lapinm.size() < 20){
								lapinm.add(new LapinM(nidpos, childdna, parent));
								lf.resetReproduce();
								lm.resetReproduce();
							}
							if(parent.random(10) < 5 && lapinf.size() < 20){
								lapinf.add(new LapinF(nidpos, childdna, parent));
								lf.resetReproduce();
								lm.resetReproduce();
							}
						//}
					}
				}
			}
		}
		
		////////////////////////
		////////////////////////
		
		
		//////ECUREUIL//////////
		
		//////MALE//////////////
		while(ecureuilm.size() < 1){ ///a modif ou sinon pop eternel
			int totalecureuilm = 1;
			for(int i = 0; i < totalecureuilm; i++){
				PVector l = new PVector(parent.random(50, 3150), parent.random(50, 3150));
				DNAecureuil dnaecureuil = new DNAecureuil(parent);
				ecureuilm.add(new EcureuilM(l,dnaecureuil,parent));
			}
		}

		Iterator<EcureuilM> EM = ecureuilm.iterator();
		while(EM.hasNext()){
			EcureuilM em = EM.next();
			em.display(parent);
			em.run(parent);
			em.boundaries();
			
			if(em.eatingTime() == false ){
				//em.wander(parent);
				em.mvtUpdate();
			}
			
			if(em.dead() == true){
				EM.remove();
			}
			
			Iterator<tileWater> tileW = tilewater.iterator();
			while(tileW.hasNext()){
				tileWater tilew = tileW.next();
				PVector target = new PVector(tilew.position.x, tilew.position.y);
				if(em.isTooClose(target)){
					em.goAway(target);
				}
			}
			
		}

		///////find food insecte/flower/berry/champi/////////
		if(ecureuilm.size() > 0){
			float currentSmallest;
			float dist;
			for(int a = ecureuilm.size()-1; a >=0; a--){
				EcureuilM ecum = ecureuilm.get(a);
				
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(ecum.faim() == false){
					ecum.wander(parent);
				}
				if(ecum.faim() == true){
					for(int b = insect1m.size()-1; b >=0; b--){
						insect1M i1m = insect1m.get(b);
						dist = ((ecum.position.x - i1m.position.x) * (ecum.position.x - i1m.position.x)) +
							   ((ecum.position.y - i1m.position.y) * (ecum.position.y - i1m.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = i1m.position.x;
							target.y = i1m.position.y;
						}
					}
					for(int c = redberry.size()-1; c >=0; c--){
						RedBerry rb = redberry.get(c);
						dist = ((ecum.position.x - rb.position.x) * (ecum.position.x - rb.position.x)) +
							   ((ecum.position.y - rb.position.y) * (ecum.position.y - rb.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = rb.position.x;
							target.y = rb.position.y;
						}
					}
					for(int d = yellowberry.size()-1; d >=0; d--){
						YellowBerry yb = yellowberry.get(d);
						dist = ((ecum.position.x - yb.position.x) * (ecum.position.x - yb.position.x)) +
							   ((ecum.position.y - yb.position.y) * (ecum.position.y - yb.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = yb.position.x;
							target.y = yb.position.y;
						}
					}
					for(int e = flower.size()-1; e >=0; e--){
						Flower fl = flower.get(e);
						dist = ((ecum.position.x - fl.position.x) * (ecum.position.x - fl.position.x)) +
							   ((ecum.position.y - fl.position.y) * (ecum.position.y - fl.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = fl.position.x;
							target.y = fl.position.y;
						}
					}
					for(int f = champi.size()-1; f >=0; f--){
						Champi ch = champi.get(f);
						dist = ((ecum.position.x - ch.position.x) * (ecum.position.x - ch.position.x)) +
								   ((ecum.position.y - ch.position.y) * (ecum.position.y - ch.position.y));
							if( dist < currentSmallest){
								currentSmallest = dist;
								target.x = ch.position.x;
								target.y = ch.position.y;
							}
					}
					ecum.findPray(target);
				}
				
			}
		}
		/////////////////////////
		
		////////eat insect redberry yellow berry flower champi////////
		Iterator<EcureuilM> EcuM = ecureuilm.iterator();
		while(EcuM.hasNext()){
			EcureuilM ecum = EcuM.next();
			Iterator<insect1M> i1M = insect1m.iterator();
			while(i1M.hasNext()){
				insect1M i1m = i1M.next();
				PVector i1mpos = i1m.position;
				PVector ecumpos = ecum.position;
				float d = PVector.dist(i1mpos, ecumpos);
				if(ecum.faim() == true){
					if(d < ecum.getR()){
						ecum.eatFood();
						i1M.remove();
						ecum.resetEating();
					}
				}
			}
			Iterator<RedBerry> ReB = redberry.iterator();
			while(ReB.hasNext()){
				RedBerry reb = ReB.next();
				PVector rebpos = reb.position;
				PVector ecumpos = ecum.position;
				float d = PVector.dist(rebpos, ecumpos);
				if(ecum.faim() == true){
					if(d < ecum.getR()){
						ecum.eatFood();
						ReB.remove();
						ecum.resetEating();
					}
				}
			}
			Iterator<YellowBerry> YeB = yellowberry.iterator();
			while(YeB.hasNext()){
				YellowBerry yeb = YeB.next();
				PVector yebpos = yeb.position;
				PVector ecumpos = ecum.position;
				float d = PVector.dist(yebpos, ecumpos);
				if(ecum.faim() == true){
					if(d < ecum.getR()){
						ecum.eatFood();
						YeB.remove();
						ecum.resetEating();
					}
				}
			}
			Iterator<Flower> Fl = flower.iterator();
			while(Fl.hasNext()){
				Flower fl = Fl.next();
				PVector flpos = fl.position;
				PVector ecumpos = ecum.position;
				float d = PVector.dist(flpos, ecumpos);
				if(ecum.faim() == true){
					if(d < ecum.getR()){
						ecum.eatFood();
						//Fl.remove(); //pas de remove pour l'instant
						ecum.resetEating();
					}
				}
			}
			Iterator<Champi> Ch = champi.iterator();
			while(Ch.hasNext()){
				Champi ch = Ch.next();
				PVector chpos = ch.position;
				PVector ecumpos = ecum.position;
				float d = PVector.dist(chpos, ecumpos);
				if(ecum.faim() == true){
					if(d < ecum.getR()){
						ecum.eatFood();
						//Ch.remove(); //pas de remove pour l'instant
						ecum.resetEating();
					}
				}
			}
		}
		//////////////////////////

		
		
		////////////////////////
		
		//////FEMALE////////////
		while(ecureuilf.size() < 1){ ///a modif ou sinon pop eternel
			int totalecureuilf = 1;
			for(int i = 0; i < totalecureuilf; i++){
				PVector l = new PVector(parent.random(50, 3150), parent.random(50, 3150));
				DNAecureuil dnaecureuil = new DNAecureuil(parent);
				ecureuilf.add(new EcureuilF(l,dnaecureuil,parent));
			}
		}
		
		
		Iterator<EcureuilF> EF = ecureuilf.iterator();
		while(EF.hasNext()){
			EcureuilF ef = EF.next();
			ef.display(parent);
			ef.run(parent);
			ef.boundaries();
			
			if(ef.eatingTime() == false ){
				//em.wander(parent);
				ef.mvtUpdate();
			}
			
			if(ef.dead() == true){
				EF.remove();
			}
			
			Iterator<tileWater> tileW = tilewater.iterator();
			while(tileW.hasNext()){
				tileWater tilew = tileW.next();
				PVector target = new PVector(tilew.position.x, tilew.position.y);
				if(ef.isTooClose(target)){
					ef.goAway(target);
				}
			}
			
		}

		///////find food insecte redberry yellow berry flower champi/////////
		if(ecureuilf.size() > 0){
			float currentSmallest;
			float dist;
			for(int a = ecureuilf.size()-1; a >=0; a--){
				EcureuilF ecuf = ecureuilf.get(a);
				
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(ecuf.faim() == false){
					ecuf.wander(parent);
				}
				if(ecuf.faim() == true){
					for(int b = insect1m.size()-1; b >=0; b--){
						insect1M i1m = insect1m.get(b);
						dist = ((ecuf.position.x - i1m.position.x) * (ecuf.position.x - i1m.position.x)) +
							   ((ecuf.position.y - i1m.position.y) * (ecuf.position.y - i1m.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = i1m.position.x;
							target.y = i1m.position.y;
						}
					}
					for(int c = redberry.size()-1; c >=0; c--){
						RedBerry rb = redberry.get(c);
						dist = ((ecuf.position.x - rb.position.x) * (ecuf.position.x - rb.position.x)) +
							   ((ecuf.position.y - rb.position.y) * (ecuf.position.y - rb.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = rb.position.x;
							target.y = rb.position.y;
						}
					}
					for(int d = yellowberry.size()-1; d >=0; d--){
						YellowBerry yb = yellowberry.get(d);
						dist = ((ecuf.position.x - yb.position.x) * (ecuf.position.x - yb.position.x)) +
							   ((ecuf.position.y - yb.position.y) * (ecuf.position.y - yb.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = yb.position.x;
							target.y = yb.position.y;
						}
					}
					for(int e = flower.size()-1; e >=0; e--){
						Flower fl = flower.get(e);
						dist = ((ecuf.position.x - fl.position.x) * (ecuf.position.x - fl.position.x)) +
							   ((ecuf.position.y - fl.position.y) * (ecuf.position.y - fl.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = fl.position.x;
							target.y = fl.position.y;
						}
					}
					for(int f = champi.size()-1; f >=0; f--){
						Champi ch = champi.get(f);
						dist = ((ecuf.position.x - ch.position.x) * (ecuf.position.x - ch.position.x)) +
							   ((ecuf.position.y - ch.position.y) * (ecuf.position.y - ch.position.y));
							if( dist < currentSmallest){
								currentSmallest = dist;
								target.x = ch.position.x;
								target.y = ch.position.y;
							}
					}
					ecuf.findPray(target);
				}
			}
		}
		/////////////////////////
		
		////////eat insect////////
		Iterator<EcureuilF> EcuF = ecureuilf.iterator();
		while(EcuF.hasNext()){
			EcureuilF ecuf = EcuF.next();
			Iterator<insect1M> i1M = insect1m.iterator();
			while(i1M.hasNext()){
				insect1M i1m = i1M.next();
				PVector i1mpos = i1m.position;
				PVector ecufpos = ecuf.position;
				float d = PVector.dist(i1mpos, ecufpos);
				if(ecuf.faim() == true){
					if(d < ecuf.getR()){
						ecuf.eatFood();
						i1M.remove();
						ecuf.resetEating();
					}
				}
			}
			Iterator<RedBerry> ReB = redberry.iterator();
			while(ReB.hasNext()){
				RedBerry reb = ReB.next();
				PVector rebpos = reb.position;
				PVector ecufpos = ecuf.position;
				float d = PVector.dist(rebpos, ecufpos);
				if(ecuf.faim() == true){
					if(d < ecuf.getR()){
						ecuf.eatFood();
						ReB.remove();
						ecuf.resetEating();
					}
				}
			}
			Iterator<YellowBerry> YeB = yellowberry.iterator();
			while(YeB.hasNext()){
				YellowBerry yeb = YeB.next();
				PVector yebpos = yeb.position;
				PVector ecufpos = ecuf.position;
				float d = PVector.dist(yebpos, ecufpos);
				if(ecuf.faim() == true){
					if(d < ecuf.getR()){
						ecuf.eatFood();
						YeB.remove();
						ecuf.resetEating();
					}
				}
			}
			Iterator<Flower> Fl = flower.iterator();
			while(Fl.hasNext()){
				Flower fl = Fl.next();
				PVector flpos = fl.position;
				PVector ecufpos = ecuf.position;
				float d = PVector.dist(flpos, ecufpos);
				if(ecuf.faim() == true){
					if(d < ecuf.getR()){
						ecuf.eatFood();
						//Fl.remove(); //pas de remove pour l'instant
						ecuf.resetEating();
					}
				}
			}
			Iterator<Champi> Ch = champi.iterator();
			while(Ch.hasNext()){
				Champi ch = Ch.next();
				PVector chpos = ch.position;
				PVector ecufpos = ecuf.position;
				float d = PVector.dist(chpos, ecufpos);
				if(ecuf.faim() == true){
					if(d < ecuf.getR()){
						ecuf.eatFood();
						//Ch.remove(); //pas de remove pour l'instant
						ecuf.resetEating();
					}
				}
			}

		}
		//////////////////////////

		////////reproduction SANS NID//////
		//////find female///////
		if(ecureuilf.size() >= 1){
			float currentSmallest;
			float dist;
			for(int a = ecureuilm.size()-1; a >=0; a--){
				EcureuilM em = ecureuilm.get(a);
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(em.reproduceTime() == false){
					em.wander(parent);
				}
				if(em.reproduceTime() == true){
					for(int b = ecureuilf.size()-1; b >= 0; b--){
						EcureuilF ef = ecureuilf.get(b);
						dist = ((em.position.x - ef.position.x) * (em.position.x - ef.position.x)) +
							   ((em.position.y - ef.position.y) * (em.position.y - ef.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = ef.position.x;
							target.y = ef.position.y;
						}
					}
					em.findFemale(target);
				}
			}
		}
		////////////////////////
		
		/////reproduction///////
		for(int a = ecureuilm.size()-1; a >= 0; a--){
			for(int b = ecureuilf.size()-1; b >= 0; b--){
				for(int c = feuillu.size()-1; c >=0; c--){
					EcureuilM em = ecureuilm.get(a);
					EcureuilF ef = ecureuilf.get(b);
					Feuillu feuill = feuillu.get(c);
					PVector lmpos = em.position;
					PVector lfpos = ef.position;
					PVector nidpos = feuill.position;
					float d = PVector.dist(lmpos, lfpos);
					if(d < ef.getR() && ef.reproduceTime() == true){  /////a changer juste pour test
						DNAecureuil momgenes = em.getDNAecureuil();
						DNAecureuil dadgenes = ef.getDNAecureuil();
						DNAecureuil childdna = momgenes.crossover(dadgenes, parent);
						//if(parent.random(1) < 0.9){
							if(parent.random(10) > 5 && ecureuilm.size() < 20){
								ecureuilm.add(new EcureuilM(nidpos, childdna, parent));
								ef.resetReproduce();
								em.resetReproduce();
							}
							if(parent.random(10) < 5 && ecureuilf.size() < 20){
								ecureuilf.add(new EcureuilF(nidpos, childdna, parent));
								ef.resetReproduce();
								em.resetReproduce();
							}
						//}
					}
				}
			}
		}
		
		////////////////////////
		
		///////////////////////////////////
		
		
		////////////////////////
		
		//////NID///////////////
		/////fct pas pour l'instant
		/*
		///////find tree/////////
		if(ecureuilf.size() > 0){
			float currentSmallest;
			float dist;
			for(int a = ecureuilf.size()-1; a >=0; a--){
				EcureuilF ecuf = ecureuilf.get(a);
				
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(ecuf.dontHaveNest() == true){
					for(int b = feuillu.size()-1; b >=0; b--){
						Feuillu feuil = feuillu.get(b);
						dist = ((ecuf.position.x - feuil.position.x) * (ecuf.position.x - feuil.position.x)) +
							   ((ecuf.position.y - feuil.position.y) * (ecuf.position.y - feuil.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = feuil.position.x;
							target.y = feuil.position.y;
						}
					}
					ecuf.findTree(target);
				}
				
			}
		}
		/////////////////////////

		////////make nest////////
		Iterator<EcureuilF> EcurF = ecureuilf.iterator();
		while(EcurF.hasNext()){
			EcureuilF ecuf = EcurF.next();
			Iterator<Feuillu> Tree = feuillu.iterator();
			while(Tree.hasNext()){
				Feuillu tree = Tree.next();
				PVector treepos = tree.position;
				PVector ecufpos = ecuf.position;
				float d = PVector.dist(treepos, ecufpos);
				if(ecuf.dontHaveNest() == true){
					if(d < ecuf.getR()){
						ecureuilnid.add(new EcureuilNid(parent, treepos));
						ecuf.makeNest();
					}
					
				}
			}
		}
		*/
		//////////////////////////

		
		Iterator<EcureuilNid> EN = ecureuilnid.iterator();
		while(EN.hasNext()){
			EcureuilNid en = EN.next();
			en.display(parent);
		}
		
		////////////////////////
		
		///////FURET////////////
		
		///////FuretNid//////////
		int totalfuretnid = 1;
		while(furetnid.size() < totalfuretnid){
			PVector l = new PVector();
			l.x = parent.random(worldW-3150 , worldW-50);
			l.y	= parent.random(worldH-3150 , worldH-50);
			boolean overlapping = false;
			for(int a = 0; a < tilewater.size(); a++){
				tileWater other = tilewater.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 60){
					overlapping = true;
					break;
				}
			}
			if(!overlapping){
				furetnid.add(new FuretNid(parent, l));
			}
			
		}
		
		Iterator<FuretNid> FN = furetnid.iterator();
		while(FN.hasNext()){
			FuretNid fn = FN.next();
			fn.display(parent);
		}
		/////////////////////////
		
		///////FuretM//////////
		while(furetm.size() < 1){ ///a modif ou sinon pop eternel
			int totalfuretM = 1;
			for(int i = 0; i < totalfuretM; i++){
				Iterator<FuretNid> FUN = furetnid.iterator();
				while(FUN.hasNext()){
					FuretNid fun = FUN.next();
					PVector l = new PVector(parent.random(fun.position.x, fun.position.x), parent.random(fun.position.y, fun.position.y));
					DNAfuret dnafuret = new DNAfuret(parent);
					furetm.add(new FuretM(l,dnafuret,parent));
				}
			}
		}
		
		Iterator<FuretM> FM = furetm.iterator();
		while(FM.hasNext()){
			FuretM fm = FM.next();
			fm.display(parent);
			fm.run(parent);
			fm.boundaries();
			
			if(fm.eatingTime() == false ){
				//fm.wander(parent);
				fm.mvtUpdate();
			}
			
			if(fm.dead() == true){
				FM.remove();
			}
			
			Iterator<tileWater> tileW = tilewater.iterator();
			while(tileW.hasNext()){
				tileWater tilew = tileW.next();
				PVector target = new PVector(tilew.position.x, tilew.position.y);
				if(fm.isTooClose(target)){
					fm.goAway(target);
				}
			}
			
		}
		
		///////find food insecte ecureuil souris lapin/////////
		if(furetm.size() > 0){
			float currentSmallest;
			float dist;
			for(int a = furetm.size()-1; a >=0; a--){
				FuretM fum = furetm.get(a);
				
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(fum.faim() == false){
					fum.wander(parent);
				}
				if(fum.faim() == true){
					for(int b = insect1m.size()-1; b >=0; b--){
						insect1M i1m = insect1m.get(b);
						dist = ((fum.position.x - i1m.position.x) * (fum.position.x - i1m.position.x)) +
							   ((fum.position.y - i1m.position.y) * (fum.position.y - i1m.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = i1m.position.x;
							target.y = i1m.position.y;
						}
					}
					for(int c = ecureuilm.size()-1; c >=0; c--){
						EcureuilM ecm = ecureuilm.get(c);
						dist = ((fum.position.x - ecm.position.x) * (fum.position.x - ecm.position.x)) +
								   ((fum.position.y - ecm.position.y) * (fum.position.y - ecm.position.y));
							if( dist < currentSmallest){
								currentSmallest = dist;
								target.x = ecm.position.x;
								target.y = ecm.position.y;
							}
					}
					for(int d = ecureuilf.size()-1; d >=0; d--){
						EcureuilF ecf = ecureuilf.get(d);
						dist = ((fum.position.x - ecf.position.x) * (fum.position.x - ecf.position.x)) +
							   ((fum.position.y - ecf.position.y) * (fum.position.y - ecf.position.y));
							if( dist < currentSmallest){
								currentSmallest = dist;
								target.x = ecf.position.x;
								target.y = ecf.position.y;
							}
					}
					for(int e = sourism.size()-1; e >=0; e--){
						SourisM som = sourism.get(e);
						dist = ((fum.position.x - som.position.x) * (fum.position.x - som.position.x)) +
							   ((fum.position.y - som.position.y) * (fum.position.y - som.position.y));
							if( dist < currentSmallest){
								currentSmallest = dist;
								target.x = som.position.x;
								target.y = som.position.y;
							}
					}
					for(int f = sourisf.size()-1; f >=0; f--){
						SourisF sof = sourisf.get(f);
						dist = ((fum.position.x - sof.position.x) * (fum.position.x - sof.position.x)) +
							   ((fum.position.y - sof.position.y) * (fum.position.y - sof.position.y));
							if( dist < currentSmallest){
								currentSmallest = dist;
								target.x = sof.position.x;
								target.y = sof.position.y;
							}
					}
					for(int g = lapinm.size()-1; g >=0; g--){
						LapinM lam = lapinm.get(g);
						dist = ((fum.position.x - lam.position.x) * (fum.position.x - lam.position.x)) +
							   ((fum.position.y - lam.position.y) * (fum.position.y - lam.position.y));
							if( dist < currentSmallest){
								currentSmallest = dist;
								target.x = lam.position.x;
								target.y = lam.position.y;
							}
					}
					for(int h = lapinf.size()-1; h >=0; h--){
						LapinF laf = lapinf.get(h);
						dist = ((fum.position.x - laf.position.x) * (fum.position.x - laf.position.x)) +
							   ((fum.position.y - laf.position.y) * (fum.position.y - laf.position.y));
							if( dist < currentSmallest){
								currentSmallest = dist;
								target.x = laf.position.x;
								target.y = laf.position.y;
							}
					}
					fum.findPray(target);
				}
				
			}
		}
		/////////////////////////
		
		////////eat insect ecureuil souris lapin////////
		Iterator<FuretM> FUM = furetm.iterator();
		while(FUM.hasNext()){
			FuretM fum = FUM.next();
			Iterator<insect1M> i1M = insect1m.iterator();
			while(i1M.hasNext()){
				insect1M i1m = i1M.next();
				PVector i1mpos = i1m.position;
				PVector fumpos = fum.position;
				float d = PVector.dist(i1mpos, fumpos);
				if(fum.faim() == true){
					if(d < fum.getR()){
						fum.eatFood();
						i1M.remove();
						fum.resetEating();
					}
				}
			}
			Iterator<EcureuilM> EcM = ecureuilm.iterator();
			while(EcM.hasNext()){
				EcureuilM ecm = EcM.next();
				PVector fumpos = fum.position;
				PVector ecmpos = ecm.position;
				float d = PVector.dist(ecmpos, fumpos);
				if(fum.faim() == true){
					if(d < fum.getR()){
						fum.eatFood();
						EcM.remove();
						fum.resetEating();
					}
				}
			}
			Iterator<EcureuilF> EcF = ecureuilf.iterator();
			while(EcF.hasNext()){
				EcureuilF ecf = EcF.next();
				PVector fumpos = fum.position;
				PVector ecfpos = ecf.position;
				float d = PVector.dist(ecfpos, fumpos);
				if(fum.faim() == true){
					if(d < fum.getR()){
						fum.eatFood();
						EcF.remove();
						fum.resetEating();
					}
				}
			}
			Iterator<SourisM> SoM = sourism.iterator();
			while(SoM.hasNext()){
				SourisM som = SoM.next();
				PVector fumpos = fum.position;
				PVector sompos = som.position;
				float d = PVector.dist(sompos, fumpos);
				if(fum.faim() == true){
					if(d < fum.getR()){
						fum.eatFood();
						SoM.remove();
						fum.resetEating();
					}
				}
			}
			Iterator<SourisF> SoF = sourisf.iterator();
			while(SoF.hasNext()){
				SourisF sof = SoF.next();
				PVector fumpos = fum.position;
				PVector sofpos = sof.position;
				float d = PVector.dist(sofpos, fumpos);
				if(fum.faim() == true){
					if(d < fum.getR()){
						fum.eatFood();
						SoF.remove();
						fum.resetEating();
					}
				}
			}
			Iterator<LapinM> LapM = lapinm.iterator();
			while(LapM.hasNext()){
				LapinM lapm = LapM.next();
				PVector fumpos = fum.position;
				PVector lapmpos = lapm.position;
				float d = PVector.dist(lapmpos, fumpos);
				if(fum.faim() == true){
					if(d < fum.getR()){
						fum.eatFood();
						LapM.remove();
						fum.resetEating();
					}
				}
			}
			Iterator<LapinF> LapF = lapinf.iterator();
			while(LapF.hasNext()){
				LapinF lapf = LapF.next();
				PVector fumpos = fum.position;
				PVector lapfpos = lapf.position;
				float d = PVector.dist(lapfpos, fumpos);
				if(fum.faim() == true){
					if(d < fum.getR()){
						fum.eatFood();
						LapF.remove();
						fum.resetEating();
					}
				}
			}

			
		}
		//////////////////////////

		
		///////////////////////
		
		
		///////FuretF//////////
		while(furetf.size() < 1){ ///a modif ou sinon pop eternel
			int totalfuretF = 1;
			for(int i = 0; i < totalfuretF; i++){
				Iterator<FuretNid> FUN = furetnid.iterator();
				while(FUN.hasNext()){
					FuretNid fun = FUN.next();
					PVector l = new PVector(parent.random(fun.position.x, fun.position.x), parent.random(fun.position.y, fun.position.y));
					DNAfuret dnafuret = new DNAfuret(parent);
					furetf.add(new FuretF(l,dnafuret,parent));
				}
			}
		}
		
		Iterator<FuretF> FF = furetf.iterator();
		while(FF.hasNext()){
			FuretF ff = FF.next();
			ff.display(parent);
			ff.run(parent);
			ff.boundaries();
			
			if(ff.eatingTime() == false ){
				//ff.wander(parent);
				ff.mvtUpdate();
			}
			
			if(ff.dead() == true){
				FF.remove();
			}
			
			Iterator<tileWater> tileW = tilewater.iterator();
			while(tileW.hasNext()){
				tileWater tilew = tileW.next();
				PVector target = new PVector(tilew.position.x, tilew.position.y);
				if(ff.isTooClose(target)){
					ff.goAway(target);
				}
			}
			
		}
		////////////////////////

		///////find food insecte/////////
		if(furetf.size() > 0){
			float currentSmallest;
			float dist;
			for(int a = furetf.size()-1; a >=0; a--){
				FuretF fuf = furetf.get(a);
				
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(fuf.faim() == false){
					fuf.wander(parent);
				}
				if(fuf.faim() == true){
					for(int b = insect1m.size()-1; b >=0; b--){
						insect1M i1m = insect1m.get(b);
						dist = ((fuf.position.x - i1m.position.x) * (fuf.position.x - i1m.position.x)) +
							   ((fuf.position.y - i1m.position.y) * (fuf.position.y - i1m.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = i1m.position.x;
							target.y = i1m.position.y;
						}
					}
					for(int c = ecureuilm.size()-1; c >=0; c--){
						EcureuilM ecm = ecureuilm.get(c);
						dist = ((fuf.position.x - ecm.position.x) * (fuf.position.x - ecm.position.x)) +
							   ((fuf.position.y - ecm.position.y) * (fuf.position.y - ecm.position.y));
							if( dist < currentSmallest){
								currentSmallest = dist;
								target.x = ecm.position.x;
								target.y = ecm.position.y;
							}
					}
					for(int d = ecureuilf.size()-1; d >=0; d--){
						EcureuilF ecf = ecureuilf.get(d);
						dist = ((fuf.position.x - ecf.position.x) * (fuf.position.x - ecf.position.x)) +
							   ((fuf.position.y - ecf.position.y) * (fuf.position.y - ecf.position.y));
							if( dist < currentSmallest){
								currentSmallest = dist;
								target.x = ecf.position.x;
								target.y = ecf.position.y;
							}
					}
					for(int e = sourism.size()-1; e >=0; e--){
						SourisM som = sourism.get(e);
						dist = ((fuf.position.x - som.position.x) * (fuf.position.x - som.position.x)) +
							   ((fuf.position.y - som.position.y) * (fuf.position.y - som.position.y));
							if( dist < currentSmallest){
								currentSmallest = dist;
								target.x = som.position.x;
								target.y = som.position.y;
							}
					}
					for(int f = sourisf.size()-1; f >=0; f--){
						SourisF sof = sourisf.get(f);
						dist = ((fuf.position.x - sof.position.x) * (fuf.position.x - sof.position.x)) +
							   ((fuf.position.y - sof.position.y) * (fuf.position.y - sof.position.y));
							if( dist < currentSmallest){
								currentSmallest = dist;
								target.x = sof.position.x;
								target.y = sof.position.y;
							}
					}
					for(int g = lapinm.size()-1; g >=0; g--){
						LapinM lam = lapinm.get(g);
						dist = ((fuf.position.x - lam.position.x) * (fuf.position.x - lam.position.x)) +
							   ((fuf.position.y - lam.position.y) * (fuf.position.y - lam.position.y));
							if( dist < currentSmallest){
								currentSmallest = dist;
								target.x = lam.position.x;
								target.y = lam.position.y;
							}
					}
					for(int h = lapinf.size()-1; h >=0; h--){
						LapinF laf = lapinf.get(h);
						dist = ((fuf.position.x - laf.position.x) * (fuf.position.x - laf.position.x)) +
							   ((fuf.position.y - laf.position.y) * (fuf.position.y - laf.position.y));
							if( dist < currentSmallest){
								currentSmallest = dist;
								target.x = laf.position.x;
								target.y = laf.position.y;
							}
					}

					fuf.findPray(target);
				}
				
			}
		}
		/////////////////////////
		
		////////eat insect////////
		Iterator<FuretF> FUF = furetf.iterator();
		while(FUF.hasNext()){
			FuretF fuf = FUF.next();
			Iterator<insect1M> i1M = insect1m.iterator();
			while(i1M.hasNext()){
				insect1M i1m = i1M.next();
				PVector i1mpos = i1m.position;
				PVector fufpos = fuf.position;
				float d = PVector.dist(i1mpos, fufpos);
				if(fuf.faim() == true){
					if(d < fuf.getR()){
						fuf.eatFood();
						i1M.remove();
						fuf.resetEating();
					}
				}
			}
			Iterator<EcureuilM> EcM = ecureuilm.iterator();
			while(EcM.hasNext()){
				EcureuilM ecm = EcM.next();
				PVector fufpos = fuf.position;
				PVector ecmpos = ecm.position;
				float d = PVector.dist(ecmpos, fufpos);
				if(fuf.faim() == true){
					if(d < fuf.getR()){
						fuf.eatFood();
						EcM.remove();
						fuf.resetEating();
					}
				}
			}
			Iterator<EcureuilF> EcF = ecureuilf.iterator();
			while(EcF.hasNext()){
				EcureuilF ecf = EcF.next();
				PVector fufpos = fuf.position;
				PVector ecfpos = ecf.position;
				float d = PVector.dist(ecfpos, fufpos);
				if(fuf.faim() == true){
					if(d < fuf.getR()){
						fuf.eatFood();
						EcF.remove();
						fuf.resetEating();
					}
				}
			}
			Iterator<SourisM> SoM = sourism.iterator();
			while(SoM.hasNext()){
				SourisM som = SoM.next();
				PVector fufpos = fuf.position;
				PVector sompos = som.position;
				float d = PVector.dist(sompos, fufpos);
				if(fuf.faim() == true){
					if(d < fuf.getR()){
						fuf.eatFood();
						SoM.remove();
						fuf.resetEating();
					}
				}
			}
			Iterator<SourisF> SoF = sourisf.iterator();
			while(SoF.hasNext()){
				SourisF sof = SoF.next();
				PVector fufpos = fuf.position;
				PVector sofpos = sof.position;
				float d = PVector.dist(sofpos, fufpos);
				if(fuf.faim() == true){
					if(d < fuf.getR()){
						fuf.eatFood();
						SoF.remove();
						fuf.resetEating();
					}
				}
			}
			Iterator<LapinM> LapM = lapinm.iterator();
			while(LapM.hasNext()){
				LapinM lapm = LapM.next();
				PVector fufpos = fuf.position;
				PVector lapmpos = lapm.position;
				float d = PVector.dist(lapmpos, fufpos);
				if(fuf.faim() == true){
					if(d < fuf.getR()){
						fuf.eatFood();
						LapM.remove();
						fuf.resetEating();
					}
				}
			}
			Iterator<LapinF> LapF = lapinf.iterator();
			while(LapF.hasNext()){
				LapinF lapf = LapF.next();
				PVector fufpos = fuf.position;
				PVector lapfpos = lapf.position;
				float d = PVector.dist(lapfpos, fufpos);
				if(fuf.faim() == true){
					if(d < fuf.getR()){
						fuf.eatFood();
						LapF.remove();
						fuf.resetEating();
					}
				}
			}

		}
		//////////////////////////

		//////reproduction//////
		
		//////find female///////
		if(furetf.size() >= 1){
			float currentSmallest;
			float dist;
			for(int a = furetm.size()-1; a >=0; a--){
				FuretM fum = furetm.get(a);
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(fum.reproduceTime() == false){
					fum.wander(parent);
				}
				if(fum.reproduceTime() == true){
					for(int b = furetf.size()-1; b >= 0; b--){
						FuretF fuf = furetf.get(b);
						dist = ((fum.position.x - fuf.position.x) * (fum.position.x - fuf.position.x)) +
							   ((fum.position.y - fuf.position.y) * (fum.position.y - fuf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = fuf.position.x;
							target.y = fuf.position.y;
						}
					}
					fum.findFemale(target);
				}
			}
		}
		////////////////////////
		
		/////reproduction///////
		for(int a = furetm.size()-1; a >= 0; a--){
			for(int b = furetf.size()-1; b >= 0; b--){
				for(int c = furetnid.size()-1; c >=0; c--){
					FuretM fm = furetm.get(a);
					FuretF ff = furetf.get(b);
					FuretNid nid = furetnid.get(c);
					PVector fmpos = fm.position;
					PVector ffpos = ff.position;
					PVector nidpos = nid.position;
					float d = PVector.dist(fmpos, ffpos);
					if(d < ff.getR() && ff.reproduceTime() == true){  /////a changer juste pour test
						DNAfuret momgenes = fm.getDNAfuret();
						DNAfuret dadgenes = ff.getDNAfuret();
						DNAfuret childdna = momgenes.crossover(dadgenes, parent);
						//if(parent.random(1) < 0.9){
							if(parent.random(10) > 5 && furetm.size() < 20){
								furetm.add(new FuretM(nidpos, childdna, parent));
								ff.resetReproduce();
								fm.resetReproduce();
							}
							if(parent.random(10) < 5 && furetf.size() < 20){
								furetf.add(new FuretF(nidpos, childdna, parent));
								ff.resetReproduce();
								fm.resetReproduce();
							}
						//}
					}
				}
			}
		}
		

		
		////////////////////////
		////////////////////////
		
		///////FOX//////////////
		
		///////FoxNid//////////
		int totalfoxnid = 1;
		while(foxnid.size() < totalfoxnid){
			PVector l = new PVector();
			l.x = parent.random(worldW-3150 , worldW-50);
			l.y	= parent.random(worldH-3150 , worldH-50);
			boolean overlapping = false;
			for(int a = 0; a < tilewater.size(); a++){
				tileWater other = tilewater.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 60){
					overlapping = true;
					break;
				}
			}
			if(!overlapping){
				foxnid.add(new FoxNid(parent, l));
			}
			
		}
		
		Iterator<FoxNid> FoN = foxnid.iterator();
		while(FoN.hasNext()){
			FoxNid fon = FoN.next();
			fon.display(parent);
		}
		/////////////////////////
		
		///////FoxM//////////
		while(foxm.size() < 1){
			int totalfoxM = 1;
			for(int i = 0; i < totalfoxM; i++){
				Iterator<FoxNid> FON = foxnid.iterator();
				while(FON.hasNext()){
					FoxNid fon = FON.next();
					PVector l = new PVector(parent.random(fon.position.x, fon.position.x), parent.random(fon.position.y, fon.position.y));
					DNAfox dnafox = new DNAfox(parent);
					foxm.add(new FoxM(l,dnafox,parent));
				}
			}
		}
		
		Iterator<FoxM> FoM = foxm.iterator();
		while(FoM.hasNext()){
			FoxM fom = FoM.next();
			fom.display(parent);
			fom.run(parent);
			fom.boundaries();
			
			if(fom.eatingTime() == false ){
				//fom.wander(parent);
				fom.mvtUpdate();
			}
			
			if(fom.dead() == true){
				FoM.remove();
			}
			
			Iterator<tileWater> tileW = tilewater.iterator();
			while(tileW.hasNext()){
				tileWater tilew = tileW.next();
				PVector target = new PVector(tilew.position.x, tilew.position.y);
				if(fom.isTooClose(target)){
					fom.goAway(target);
				}
			}
			
		}
		
		
		///////find food insecte champi souris lapin ecureuil furet ?///////// ////ajout des autres proie à faire
		if(foxm.size() > 0){
			float currentSmallest;
			float dist;
			for(int a = foxm.size()-1; a >=0; a--){
				FoxM fom = foxm.get(a);
				
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(fom.faim() == false){
					fom.wander(parent);
				}
				if(fom.faim() == true){
					for(int b = insect1m.size()-1; b >=0; b--){
						insect1M i1m = insect1m.get(b);
						dist = ((fom.position.x - i1m.position.x) * (fom.position.x - i1m.position.x)) +
							   ((fom.position.y - i1m.position.y) * (fom.position.y - i1m.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = i1m.position.x;
							target.y = i1m.position.y;
						}
					}
					for(int c = champi.size()-1; c >=0; c--){
						Champi ch = champi.get(c);
						dist = ((fom.position.x - ch.position.x) * (fom.position.x - ch.position.x)) +
							   ((fom.position.y - ch.position.y) * (fom.position.y - ch.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = ch.position.x;
							target.y = ch.position.y;
						}
					}
					for(int d = sourism.size()-1; d >=0; d--){
						SourisM soum = sourism.get(d);
						dist = ((fom.position.x - soum.position.x) * (fom.position.x - soum.position.x)) +
							   ((fom.position.y - soum.position.y) * (fom.position.y - soum.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = soum.position.x;
							target.y = soum.position.y;
						}
					}
					for(int e = sourisf.size()-1; e >=0; e--){
						SourisF souf = sourisf.get(e);
						dist = ((fom.position.x - souf.position.x) * (fom.position.x - souf.position.x)) +
							   ((fom.position.y - souf.position.y) * (fom.position.y - souf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = souf.position.x;
							target.y = souf.position.y;
						}
					}
					for(int f = lapinm.size()-1; f >=0; f--){
						LapinM lam = lapinm.get(f);
						dist = ((fom.position.x - lam.position.x) * (fom.position.x - lam.position.x)) +
							   ((fom.position.y - lam.position.y) * (fom.position.y - lam.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = lam.position.x;
							target.y = lam.position.y;
						}
					}
					for(int g = lapinf.size()-1; g >=0; g--){
						LapinF laf = lapinf.get(g);
						dist = ((fom.position.x - laf.position.x) * (fom.position.x - laf.position.x)) +
							   ((fom.position.y - laf.position.y) * (fom.position.y - laf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = laf.position.x;
							target.y = laf.position.y;
						}
					}
					for(int h = ecureuilm.size()-1; h >=0; h--){
						EcureuilM ecm = ecureuilm.get(h);
						dist = ((fom.position.x - ecm.position.x) * (fom.position.x - ecm.position.x)) +
							   ((fom.position.y - ecm.position.y) * (fom.position.y - ecm.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = ecm.position.x;
							target.y = ecm.position.y;
						}
					}
					for(int i = ecureuilf.size()-1; i >=0; i--){
						EcureuilF ecf = ecureuilf.get(i);
						dist = ((fom.position.x - ecf.position.x) * (fom.position.x - ecf.position.x)) +
							   ((fom.position.y - ecf.position.y) * (fom.position.y - ecf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = ecf.position.x;
							target.y = ecf.position.y;
						}
					}
					
					fom.findPray(target);
				}
				
			}
		}
		/////////////////////////
		
		////////eat insect champi souris lapin ecureuil furet ?////////
		Iterator<FoxM> FOM = foxm.iterator();
		while(FOM.hasNext()){
			FoxM fom = FOM.next();
			Iterator<insect1M> i1M = insect1m.iterator();
			while(i1M.hasNext()){
				insect1M i1m = i1M.next();
				PVector i1mpos = i1m.position;
				PVector fompos = fom.position;
				float d = PVector.dist(i1mpos, fompos);
				if(fom.faim() == true){
					if(d < fom.getR()){
						fom.eatFood();
						i1M.remove();
						fom.resetEating();
					}
				}
			}
			Iterator<Champi> Ch = champi.iterator();
			while(Ch.hasNext()){
				Champi ch = Ch.next();
				PVector fompos = fom.position;
				PVector chpos = ch.position;
				float d = PVector.dist(chpos, fompos);
				if(fom.faim() == true){
					if(d < fom.getR()){
						fom.eatFood();
						//Ch.remove(); 
						fom.resetEating();
					}
				}
			}
			Iterator<SourisM> SoM = sourism.iterator();
			while(SoM.hasNext()){
				SourisM som = SoM.next();
				PVector fompos = fom.position;
				PVector sompos = som.position;
				float d = PVector.dist(sompos, fompos);
				if(fom.faim() == true){
					if(d < fom.getR()){
						fom.eatFood();
						SoM.remove(); 
						fom.resetEating();
					}
				}
			}
			Iterator<SourisF> SoF = sourisf.iterator();
			while(SoF.hasNext()){
				SourisF sof = SoF.next();
				PVector fompos = fom.position;
				PVector sofpos = sof.position;
				float d = PVector.dist(sofpos, fompos);
				if(fom.faim() == true){
					if(d < fom.getR()){
						fom.eatFood();
						SoF.remove(); 
						fom.resetEating();
					}
				}
			}
			Iterator<LapinM> LapM = lapinm.iterator();
			while(LapM.hasNext()){
				LapinM lapm = LapM.next();
				PVector fompos = fom.position;
				PVector lapmpos = lapm.position;
				float d = PVector.dist(lapmpos, fompos);
				if(fom.faim() == true){
					if(d < fom.getR()){
						fom.eatFood();
						LapM.remove(); 
						fom.resetEating();
					}
				}
			}
			Iterator<LapinF> LapF = lapinf.iterator();
			while(LapF.hasNext()){
				LapinF lapf = LapF.next();
				PVector fompos = fom.position;
				PVector lapfpos = lapf.position;
				float d = PVector.dist(lapfpos, fompos);
				if(fom.faim() == true){
					if(d < fom.getR()){
						fom.eatFood();
						LapF.remove(); 
						fom.resetEating();
					}
				}
			}

			
		}
		//////////////////////////
		
		///////FoxF//////////
		while(foxf.size() < 1){
			int totalfoxF = 1;
			for(int i = 0; i < totalfoxF; i++){
				Iterator<FoxNid> FON = foxnid.iterator();
				while(FON.hasNext()){
					FoxNid fon = FON.next();
					PVector l = new PVector(parent.random(fon.position.x, fon.position.x), parent.random(fon.position.y, fon.position.y));
					DNAfox dnafox = new DNAfox(parent);
					foxf.add(new FoxF(l,dnafox,parent));
				}
			}
		}
		
		Iterator<FoxF> FoF = foxf.iterator();
		while(FoF.hasNext()){
			FoxF fof = FoF.next();
			fof.display(parent);
			fof.run(parent);
			fof.boundaries();
			
			if(fof.eatingTime() == false ){
				//fof.wander(parent);
				fof.mvtUpdate();
			}
			
			if(fof.dead() == true){
				FoF.remove();
			}
			
			Iterator<tileWater> tileW = tilewater.iterator();
			while(tileW.hasNext()){
				tileWater tilew = tileW.next();
				PVector target = new PVector(tilew.position.x, tilew.position.y);
				if(fof.isTooClose(target)){
					fof.goAway(target);
				}
			}
			
		}
		
		///////find food insecte///////// ////ajout des autres proie à faire
		if(foxf.size() > 0){
			float currentSmallest;
			float dist;
			for(int a = foxf.size()-1; a >=0; a--){
				FoxF fof = foxf.get(a);
				
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(fof.faim() == false){
					fof.wander(parent);
				}
				if(fof.faim() == true){
					for(int b = insect1m.size()-1; b >=0; b--){
						insect1M i1m = insect1m.get(b);
						dist = ((fof.position.x - i1m.position.x) * (fof.position.x - i1m.position.x)) +
							   ((fof.position.y - i1m.position.y) * (fof.position.y - i1m.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = i1m.position.x;
							target.y = i1m.position.y;
						}
					}
					for(int c = champi.size()-1; c >=0; c--){
						Champi ch = champi.get(c);
						dist = ((fof.position.x - ch.position.x) * (fof.position.x - ch.position.x)) +
							   ((fof.position.y - ch.position.y) * (fof.position.y - ch.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = ch.position.x;
							target.y = ch.position.y;
						}
					}
					for(int d = sourism.size()-1; d >=0; d--){
						SourisM soum = sourism.get(d);
						dist = ((fof.position.x - soum.position.x) * (fof.position.x - soum.position.x)) +
							   ((fof.position.y - soum.position.y) * (fof.position.y - soum.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = soum.position.x;
							target.y = soum.position.y;
						}
					}
					for(int e = sourisf.size()-1; e >=0; e--){
						SourisF souf = sourisf.get(e);
						dist = ((fof.position.x - souf.position.x) * (fof.position.x - souf.position.x)) +
							   ((fof.position.y - souf.position.y) * (fof.position.y - souf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = souf.position.x;
							target.y = souf.position.y;
						}
					}
					for(int f = lapinm.size()-1; f >=0; f--){
						LapinM lam = lapinm.get(f);
						dist = ((fof.position.x - lam.position.x) * (fof.position.x - lam.position.x)) +
							   ((fof.position.y - lam.position.y) * (fof.position.y - lam.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = lam.position.x;
							target.y = lam.position.y;
						}
					}
					for(int g = lapinf.size()-1; g >=0; g--){
						LapinF laf = lapinf.get(g);
						dist = ((fof.position.x - laf.position.x) * (fof.position.x - laf.position.x)) +
							   ((fof.position.y - laf.position.y) * (fof.position.y - laf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = laf.position.x;
							target.y = laf.position.y;
						}
					}
					for(int h = ecureuilm.size()-1; h >=0; h--){
						EcureuilM ecm = ecureuilm.get(h);
						dist = ((fof.position.x - ecm.position.x) * (fof.position.x - ecm.position.x)) +
							   ((fof.position.y - ecm.position.y) * (fof.position.y - ecm.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = ecm.position.x;
							target.y = ecm.position.y;
						}
					}
					for(int i = ecureuilf.size()-1; i >=0; i--){
						EcureuilF ecf = ecureuilf.get(i);
						dist = ((fof.position.x - ecf.position.x) * (fof.position.x - ecf.position.x)) +
							   ((fof.position.y - ecf.position.y) * (fof.position.y - ecf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = ecf.position.x;
							target.y = ecf.position.y;
						}
					}

					fof.findPray(target);
				}
				
			}
		}
		/////////////////////////
		
		////////eat insect////////
		Iterator<FoxF> FOF = foxf.iterator();
		while(FOF.hasNext()){
			FoxF fof = FOF.next();
			Iterator<insect1M> i1M = insect1m.iterator();
			while(i1M.hasNext()){
				insect1M i1m = i1M.next();
				PVector i1mpos = i1m.position;
				PVector fofpos = fof.position;
				float d = PVector.dist(i1mpos, fofpos);
				if(fof.faim() == true){
					if(d < fof.getR()){
						fof.eatFood();
						i1M.remove();
						fof.resetEating();
					}
				}
			}
			Iterator<Champi> Ch = champi.iterator();
			while(Ch.hasNext()){
				Champi ch = Ch.next();
				PVector fofpos = fof.position;
				PVector chpos = ch.position;
				float d = PVector.dist(chpos, fofpos);
				if(fof.faim() == true){
					if(d < fof.getR()){
						fof.eatFood();
						//Ch.remove(); 
						fof.resetEating();
					}
				}
			}
			Iterator<SourisM> SoM = sourism.iterator();
			while(SoM.hasNext()){
				SourisM som = SoM.next();
				PVector fofpos = fof.position;
				PVector sompos = som.position;
				float d = PVector.dist(sompos, fofpos);
				if(fof.faim() == true){
					if(d < fof.getR()){
						fof.eatFood();
						SoM.remove(); 
						fof.resetEating();
					}
				}
			}
			Iterator<SourisF> SoF = sourisf.iterator();
			while(SoF.hasNext()){
				SourisF sof = SoF.next();
				PVector fofpos = fof.position;
				PVector sofpos = sof.position;
				float d = PVector.dist(sofpos, fofpos);
				if(fof.faim() == true){
					if(d < fof.getR()){
						fof.eatFood();
						SoF.remove(); 
						fof.resetEating();
					}
				}
			}
			Iterator<LapinM> LapM = lapinm.iterator();
			while(LapM.hasNext()){
				LapinM lapm = LapM.next();
				PVector fofpos = fof.position;
				PVector lapmpos = lapm.position;
				float d = PVector.dist(lapmpos, fofpos);
				if(fof.faim() == true){
					if(d < fof.getR()){
						fof.eatFood();
						LapM.remove(); 
						fof.resetEating();
					}
				}
			}
			Iterator<LapinF> LapF = lapinf.iterator();
			while(LapF.hasNext()){
				LapinF lapf = LapF.next();
				PVector fofpos = fof.position;
				PVector lapfpos = lapf.position;
				float d = PVector.dist(lapfpos, fofpos);
				if(fof.faim() == true){
					if(d < fof.getR()){
						fof.eatFood();
						LapF.remove(); 
						fof.resetEating();
					}
				}
			}

		}
		//////////////////////////
		
		//////reproduction//////
		
		//////find female///////
		if(foxf.size() >= 1){
			float currentSmallest;
			float dist;
			for(int a = foxm.size()-1; a >=0; a--){
				FoxM fom = foxm.get(a);
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(fom.reproduceTime() == false){
					fom.wander(parent);
				}
				if(fom.reproduceTime() == true){
					for(int b = foxf.size()-1; b >= 0; b--){
						FoxF fof = foxf.get(b);
						dist = ((fom.position.x - fof.position.x) * (fom.position.x - fof.position.x)) +
							   ((fom.position.y - fof.position.y) * (fom.position.y - fof.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = fof.position.x;
							target.y = fof.position.y;
						}
					}
					fom.findFemale(target);
				}
			}
		}
		
		/////reproduction///////
		for(int a = foxm.size()-1; a >= 0; a--){
			for(int b = foxf.size()-1; b >= 0; b--){
				for(int c = foxnid.size()-1; c >=0; c--){
					FoxM fm = foxm.get(a);
					FoxF ff = foxf.get(b);
					FoxNid nid = foxnid.get(c);
					PVector fmpos = fm.position;
					PVector ffpos = ff.position;
					PVector nidpos = nid.position;
					float d = PVector.dist(fmpos, ffpos);
					if(d < ff.getR() && ff.reproduceTime() == true){  /////a changer juste pour test
						DNAfox momgenes = fm.getDNAfox();
						DNAfox dadgenes = ff.getDNAfox();
						DNAfox childdna = momgenes.crossover(dadgenes, parent);
						//if(parent.random(1) < 0.9){
							if(parent.random(10) > 5 && foxm.size() < 20){
								foxm.add(new FoxM(nidpos, childdna, parent));
								ff.resetReproduce();
								fm.resetReproduce();
							}
							if(parent.random(10) < 5 && foxf.size() < 20){
								foxf.add(new FoxF(nidpos, childdna, parent));
								ff.resetReproduce();
								fm.resetReproduce();
							}
						//}
					}
				}
			}
		}

		
		//////////////////////////
		
		///////BLAIREAU///////////
		
		///////BlaireauNid//////////
		int totalblaireaunid = 1;
		while(blaireaunid.size() < totalblaireaunid){
			PVector l = new PVector();
			l.x = parent.random(worldW-3150 , worldW-50);
			l.y	= parent.random(worldH-3150 , worldH-50);
			boolean overlapping = false;
			for(int a = 0; a < tilewater.size(); a++){
				tileWater other = tilewater.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 60){
					overlapping = true;
					break;
				}
			}
			if(!overlapping){
				blaireaunid.add(new BlaireauNid(parent, l));
			}
			
		}
		
		Iterator<BlaireauNid> BN = blaireaunid.iterator();
		while(BN.hasNext()){
			BlaireauNid bn = BN.next();
			bn.display(parent);
		}
		/////////////////////////
		
		///////BlaireauxM//////////
		while(blaireaum.size() < 1){
			int totalblaireauM = 1;
			for(int i = 0; i < totalblaireauM; i++){
				Iterator<BlaireauNid> BLN = blaireaunid.iterator();
				while(BLN.hasNext()){
					BlaireauNid bln = BLN.next();
					PVector l = new PVector(parent.random(bln.position.x-50, bln.position.x+50), parent.random(bln.position.y-50, bln.position.y+50));
					DNAblaireau dnablaireau = new DNAblaireau(parent);
					blaireaum.add(new BlaireauM(l,dnablaireau,parent));
				}
			}
		}
		
		Iterator<BlaireauM> BLM = blaireaum.iterator();
		while(BLM.hasNext()){
			BlaireauM blm = BLM.next();
			blm.display(parent);
			blm.run(parent);
			blm.boundaries();
			
			if(blm.eatingTime() == false ){
				//blm.wander(parent);
				blm.mvtUpdate();
			}
			
			if(blm.dead() == true){
				BLM.remove();
			}
			
			Iterator<tileWater> tileW = tilewater.iterator();
			while(tileW.hasNext()){
				tileWater tilew = tileW.next();
				PVector target = new PVector(tilew.position.x, tilew.position.y);
				if(blm.isTooClose(target)){
					blm.goAway(target);
				}
			}
			
		}
		
		///////find food insecte champi red yellow berry chenille lapin souris ///////// 
		if(blaireaum.size() > 0){
			float currentSmallest;
			float dist;
			for(int a = blaireaum.size()-1; a >=0; a--){
				BlaireauM bm = blaireaum.get(a);
				
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(bm.faim() == false){
					bm.wander(parent);
				}
				if(bm.faim() == true){
					for(int b = insect1m.size()-1; b >=0; b--){
						insect1M i1m = insect1m.get(b);
						dist = ((bm.position.x - i1m.position.x) * (bm.position.x - i1m.position.x)) +
							   ((bm.position.y - i1m.position.y) * (bm.position.y - i1m.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = i1m.position.x;
							target.y = i1m.position.y;
						}
					}
					for(int c = champi.size()-1; c >=0; c--){
						Champi ch = champi.get(c);
						dist = ((bm.position.x - ch.position.x) * (bm.position.x - ch.position.x)) +
							   ((bm.position.y - ch.position.y) * (bm.position.y - ch.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = ch.position.x;
							target.y = ch.position.y;
						}
					}
					for(int d = redberry.size()-1; d >=0; d--){
						RedBerry rb = redberry.get(d);
						dist = ((bm.position.x - rb.position.x) * (bm.position.x - rb.position.x)) +
							   ((bm.position.y - rb.position.y) * (bm.position.y - rb.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = rb.position.x;
							target.y = rb.position.y;
						}
					}
					for(int e = yellowberry.size()-1; e >=0; e--){
						YellowBerry yb = yellowberry.get(e);
						dist = ((bm.position.x - yb.position.x) * (bm.position.x - yb.position.x)) +
							   ((bm.position.y - yb.position.y) * (bm.position.y - yb.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = yb.position.x;
							target.y = yb.position.y;
						}
					}
					for(int f = papillonbchenille.size()-1; f >=0; f--){
						PapillonBchenille pbc = papillonbchenille.get(f);
						dist = ((bm.position.x - pbc.position.x) * (bm.position.x - pbc.position.x)) +
							   ((bm.position.y - pbc.position.y) * (bm.position.y - pbc.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = pbc.position.x;
							target.y = pbc.position.y;
						}
					}
					for(int g = lapinm.size()-1; g >=0; g--){
						LapinM lm = lapinm.get(g);
						dist = ((bm.position.x - lm.position.x) * (bm.position.x - lm.position.x)) +
							   ((bm.position.y - lm.position.y) * (bm.position.y - lm.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = lm.position.x;
							target.y = lm.position.y;
						}
					}
					for(int h = lapinf.size()-1; h >=0; h--){
						LapinF lf = lapinf.get(h);
						dist = ((bm.position.x - lf.position.x) * (bm.position.x - lf.position.x)) +
							   ((bm.position.y - lf.position.y) * (bm.position.y - lf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = lf.position.x;
							target.y = lf.position.y;
						}
					}
					for(int i = sourism.size()-1; i >=0; i--){
						SourisM sm = sourism.get(i);
						dist = ((bm.position.x - sm.position.x) * (bm.position.x - sm.position.x)) +
							   ((bm.position.y - sm.position.y) * (bm.position.y - sm.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = sm.position.x;
							target.y = sm.position.y;
						}
					}
					for(int j = sourisf.size()-1; j >=0; j--){
						SourisF sf = sourisf.get(j);
						dist = ((bm.position.x - sf.position.x) * (bm.position.x - sf.position.x)) +
							   ((bm.position.y - sf.position.y) * (bm.position.y - sf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = sf.position.x;
							target.y = sf.position.y;
						}
					}
					bm.findPray(target);
				}
				
			}
		}
		/////////////////////////
		
		////////eat insect////////
		Iterator<BlaireauM> BM = blaireaum.iterator();
		while(BM.hasNext()){
			BlaireauM bm = BM.next();
			Iterator<insect1M> i1M = insect1m.iterator();
			while(i1M.hasNext()){
				insect1M i1m = i1M.next();
				PVector i1mpos = i1m.position;
				PVector bmpos = bm.position;
				float d = PVector.dist(i1mpos, bmpos);
				if(bm.faim() == true){
					if(d < bm.getR()){
						bm.eatFood();
						i1M.remove();
						bm.resetEating();
					}
				}
			}
			Iterator<Champi> CH = champi.iterator();
			while(CH.hasNext()){
				Champi ch = CH.next();
				PVector chpos = ch.position;
				PVector bmpos = bm.position;
				float d = PVector.dist(chpos, bmpos);
				if(bm.faim() == true){
					if(d < bm.getR()){
						bm.eatFood();
						//CH.remove(); pas de remove pour l'instant
						bm.resetEating();
					}
				}
			}
			Iterator<RedBerry> ReB = redberry.iterator();
			while(ReB.hasNext()){
				RedBerry reb = ReB.next();
				PVector rebpos = reb.position;
				PVector bmpos = bm.position;
				float d = PVector.dist(rebpos, bmpos);
				if(bm.faim() == true){
					if(d < bm.getR()){
						bm.eatFood();
						ReB.remove(); 
						bm.resetEating();
					}
				}
			}
			Iterator<YellowBerry> YeB = yellowberry.iterator();
			while(YeB.hasNext()){
				YellowBerry yeb = YeB.next();
				PVector yebpos = yeb.position;
				PVector bmpos = bm.position;
				float d = PVector.dist(yebpos, bmpos);
				if(bm.faim() == true){
					if(d < bm.getR()){
						bm.eatFood();
						YeB.remove(); 
						bm.resetEating();
					}
				}
			}
			Iterator<PapillonBchenille> PbC = papillonbchenille.iterator();
			while(PbC.hasNext()){
				PapillonBchenille pbc = PbC.next();
				PVector pbcpos = pbc.position;
				PVector bmpos = bm.position;
				float d = PVector.dist(pbcpos, bmpos);
				if(bm.faim() == true){
					if(d < bm.getR()){
						bm.eatFood();
						PbC.remove(); 
						bm.resetEating();
					}
				}
			}
			Iterator<LapinM> LapM = lapinm.iterator();
			while(LapM.hasNext()){
				LapinM lapm = LapM.next();
				PVector lapmpos = lapm.position;
				PVector bmpos = bm.position;
				float d = PVector.dist(lapmpos, bmpos);
				if(bm.faim() == true){
					if(d < bm.getR()){
						bm.eatFood();
						LapM.remove(); 
						bm.resetEating();
					}
				}
			}
			Iterator<LapinF> LapF = lapinf.iterator();
			while(LapF.hasNext()){
				LapinF lapf = LapF.next();
				PVector lappos = lapf.position;
				PVector bmpos = bm.position;
				float d = PVector.dist(lappos, bmpos);
				if(bm.faim() == true){
					if(d < bm.getR()){
						bm.eatFood();
						LapF.remove(); 
						bm.resetEating();
					}
				}
			}
			Iterator<SourisM> SoM = sourism.iterator();
			while(SoM.hasNext()){
				SourisM som = SoM.next();
				PVector sompos = som.position;
				PVector bmpos = bm.position;
				float d = PVector.dist(sompos, bmpos);
				if(bm.faim() == true){
					if(d < bm.getR()){
						bm.eatFood();
						SoM.remove(); 
						bm.resetEating();
					}
				}
			}
			Iterator<SourisF> SoF = sourisf.iterator();
			while(SoF.hasNext()){
				SourisF sof = SoF.next();
				PVector sofpos = sof.position;
				PVector bmpos = bm.position;
				float d = PVector.dist(sofpos, bmpos);
				if(bm.faim() == true){
					if(d < bm.getR()){
						bm.eatFood();
						SoF.remove(); 
						bm.resetEating();
					}
				}
			}
		}
		//////////////////////////

		
		//////////////////////////

		///////BlaireauxF//////////
		while(blaireauf.size() < 1){
			int totalblaireauf = 1;
			for(int i = 0; i < totalblaireauf; i++){
				Iterator<BlaireauNid> BLN = blaireaunid.iterator();
				while(BLN.hasNext()){
					BlaireauNid bln = BLN.next();
					PVector l = new PVector(parent.random(bln.position.x-50, bln.position.x+50), parent.random(bln.position.y-50, bln.position.y+50));
					DNAblaireau dnablaireau = new DNAblaireau(parent);
					blaireauf.add(new BlaireauF(l,dnablaireau,parent));
				}
			}
		}
		
		Iterator<BlaireauF> BLF = blaireauf.iterator();
		while(BLF.hasNext()){
			BlaireauF blf = BLF.next();
			blf.display(parent);
			blf.run(parent);
			blf.boundaries();
			
			if(blf.eatingTime() == false ){
				//blf.wander(parent);
				blf.mvtUpdate();
			}
			
			if(blf.dead() == true){
				BLF.remove();
			}
			
			Iterator<tileWater> tileW = tilewater.iterator();
			while(tileW.hasNext()){
				tileWater tilew = tileW.next();
				PVector target = new PVector(tilew.position.x, tilew.position.y);
				if(blf.isTooClose(target)){
					blf.goAway(target);
				}
			}
			
		}
		
		///////find food insecte champi red yellow berry chenille lapin souris///////// 
		if(blaireauf.size() > 0){
			float currentSmallest;
			float dist;
			for(int a = blaireauf.size()-1; a >=0; a--){
				BlaireauF bf = blaireauf.get(a);
				
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(bf.faim() == false){
					bf.wander(parent);
				}
				if(bf.faim() == true){
					for(int b = insect1m.size()-1; b >=0; b--){
						insect1M i1m = insect1m.get(b);
						dist = ((bf.position.x - i1m.position.x) * (bf.position.x - i1m.position.x)) +
							   ((bf.position.y - i1m.position.y) * (bf.position.y - i1m.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = i1m.position.x;
							target.y = i1m.position.y;
						}
					}
					for(int c = champi.size()-1; c >=0; c--){
						Champi ch = champi.get(c);
						dist = ((bf.position.x - ch.position.x) * (bf.position.x - ch.position.x)) +
							   ((bf.position.y - ch.position.y) * (bf.position.y - ch.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = ch.position.x;
							target.y = ch.position.y;
						}
					}
					for(int d = redberry.size()-1; d >=0; d--){
						RedBerry rb = redberry.get(d);
						dist = ((bf.position.x - rb.position.x) * (bf.position.x - rb.position.x)) +
							   ((bf.position.y - rb.position.y) * (bf.position.y - rb.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = rb.position.x;
							target.y = rb.position.y;
						}
					}
					for(int e = yellowberry.size()-1; e >=0; e--){
						YellowBerry yb = yellowberry.get(e);
						dist = ((bf.position.x - yb.position.x) * (bf.position.x - yb.position.x)) +
							   ((bf.position.y - yb.position.y) * (bf.position.y - yb.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = yb.position.x;
							target.y = yb.position.y;
						}
					}
					for(int f = papillonbchenille.size()-1; f >=0; f--){
						PapillonBchenille pbc = papillonbchenille.get(f);
						dist = ((bf.position.x - pbc.position.x) * (bf.position.x - pbc.position.x)) +
							   ((bf.position.y - pbc.position.y) * (bf.position.y - pbc.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = pbc.position.x;
							target.y = pbc.position.y;
						}
					}
					for(int g = lapinm.size()-1; g >=0; g--){
						LapinM lm = lapinm.get(g);
						dist = ((bf.position.x - lm.position.x) * (bf.position.x - lm.position.x)) +
							   ((bf.position.y - lm.position.y) * (bf.position.y - lm.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = lm.position.x;
							target.y = lm.position.y;
						}
					}
					for(int h = lapinf.size()-1; h >=0; h--){
						LapinF lf = lapinf.get(h);
						dist = ((bf.position.x - lf.position.x) * (bf.position.x - lf.position.x)) +
							   ((bf.position.y - lf.position.y) * (bf.position.y - lf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = lf.position.x;
							target.y = lf.position.y;
						}
					}
					for(int i = sourism.size()-1; i >=0; i--){
						SourisM sm = sourism.get(i);
						dist = ((bf.position.x - sm.position.x) * (bf.position.x - sm.position.x)) +
							   ((bf.position.y - sm.position.y) * (bf.position.y - sm.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = sm.position.x;
							target.y = sm.position.y;
						}
					}
					for(int j = sourisf.size()-1; j >=0; j--){
						SourisF sf = sourisf.get(j);
						dist = ((bf.position.x - sf.position.x) * (bf.position.x - sf.position.x)) +
							   ((bf.position.y - sf.position.y) * (bf.position.y - sf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = sf.position.x;
							target.y = sf.position.y;
						}
					}

					bf.findPray(target);
				}
				
			}
		}
		/////////////////////////
		
		////////eat insect////////
		Iterator<BlaireauF> BF = blaireauf.iterator();
		while(BF.hasNext()){
			BlaireauF bf = BF.next();
			Iterator<insect1M> i1M = insect1m.iterator();
			while(i1M.hasNext()){
				insect1M i1m = i1M.next();
				PVector i1mpos = i1m.position;
				PVector bfpos = bf.position;
				float d = PVector.dist(i1mpos, bfpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						i1M.remove();
						bf.resetEating();
					}
				}
			}
			Iterator<Champi> CH = champi.iterator();
			while(CH.hasNext()){
				Champi ch = CH.next();
				PVector chpos = ch.position;
				PVector bmpos = bf.position;
				float d = PVector.dist(chpos, bmpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						//CH.remove(); pas de remove pour l'instant
						bf.resetEating();
					}
				}
			}
			Iterator<RedBerry> ReB = redberry.iterator();
			while(ReB.hasNext()){
				RedBerry reb = ReB.next();
				PVector rebpos = reb.position;
				PVector bmpos = bf.position;
				float d = PVector.dist(rebpos, bmpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						ReB.remove(); 
						bf.resetEating();
					}
				}
			}
			Iterator<YellowBerry> YeB = yellowberry.iterator();
			while(YeB.hasNext()){
				YellowBerry yeb = YeB.next();
				PVector yebpos = yeb.position;
				PVector bmpos = bf.position;
				float d = PVector.dist(yebpos, bmpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						YeB.remove(); 
						bf.resetEating();
					}
				}
			}
			Iterator<PapillonBchenille> PbC = papillonbchenille.iterator();
			while(PbC.hasNext()){
				PapillonBchenille pbc = PbC.next();
				PVector pbcpos = pbc.position;
				PVector bmpos = bf.position;
				float d = PVector.dist(pbcpos, bmpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						PbC.remove(); 
						bf.resetEating();
					}
				}
			}
			Iterator<LapinM> LapM = lapinm.iterator();
			while(LapM.hasNext()){
				LapinM lapm = LapM.next();
				PVector lapmpos = lapm.position;
				PVector bmpos = bf.position;
				float d = PVector.dist(lapmpos, bmpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						LapM.remove(); 
						bf.resetEating();
					}
				}
			}
			Iterator<LapinF> LapF = lapinf.iterator();
			while(LapF.hasNext()){
				LapinF lapf = LapF.next();
				PVector lappos = lapf.position;
				PVector bmpos = bf.position;
				float d = PVector.dist(lappos, bmpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						LapF.remove(); 
						bf.resetEating();
					}
				}
			}
			Iterator<SourisM> SoM = sourism.iterator();
			while(SoM.hasNext()){
				SourisM som = SoM.next();
				PVector sompos = som.position;
				PVector bmpos = bf.position;
				float d = PVector.dist(sompos, bmpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						SoM.remove(); 
						bf.resetEating();
					}
				}
			}
			Iterator<SourisF> SoF = sourisf.iterator();
			while(SoF.hasNext()){
				SourisF sof = SoF.next();
				PVector sofpos = sof.position;
				PVector bmpos = bf.position;
				float d = PVector.dist(sofpos, bmpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						SoF.remove(); 
						bf.resetEating();
					}
				}
			}

		}
		//////////////////////////

		//////find female///////
		if(blaireauf.size() >= 1){
			float currentSmallest;
			float dist;
			for(int a = blaireaum.size()-1; a >=0; a--){
				BlaireauM bm = blaireaum.get(a);
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(bm.reproduceTime() == false){
					bm.wander(parent);
				}
				if(bm.reproduceTime() == true){
					for(int b = blaireauf.size()-1; b >= 0; b--){
						BlaireauF bf = blaireauf.get(b);
						dist = ((bm.position.x - bf.position.x) * (bm.position.x - bf.position.x)) +
							   ((bm.position.y - bf.position.y) * (bm.position.y - bf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = bf.position.x;
							target.y = bf.position.y;
						}
					}
					bm.findFemale(target);
				}
			}
		}
		
		/////reproduction///////
		for(int a = blaireaum.size()-1; a >= 0; a--){
			for(int b = blaireauf.size()-1; b >= 0; b--){
				for(int c = blaireaunid.size()-1; c >=0; c--){
					BlaireauM bm = blaireaum.get(a);
					BlaireauF bf = blaireauf.get(b);
					BlaireauNid nid = blaireaunid.get(c);
					PVector bmpos = bm.position;
					PVector bfpos = bf.position;
					PVector nidpos = nid.position;
					float d = PVector.dist(bmpos, bfpos);
					if(d < bf.getR() && bf.reproduceTime() == true){  /////a changer juste pour test
						DNAblaireau momgenes = bm.getDNAblaireau();
						DNAblaireau dadgenes = bf.getDNAblaireau();
						DNAblaireau childdna = momgenes.crossover(dadgenes, parent);
						//if(parent.random(1) < 0.9){
							if(parent.random(10) > 5 && blaireaum.size() < 20){
								blaireaum.add(new BlaireauM(nidpos, childdna, parent));
								bf.resetReproduce();
								bm.resetReproduce();
							}
							if(parent.random(10) < 5 && blaireauf.size() < 20){
								blaireauf.add(new BlaireauF(nidpos, childdna, parent));
								bf.resetReproduce();
								bm.resetReproduce();
							}
						//}
					}
				}
			}
		}

		
		//////////////////////////
		//////////////////////////
		
		//////BOAR////////////////
		
		//////MALE//////////////
		while(boarm.size() < 1){
			int totalboarm = 1;
			for(int i = 0; i < totalboarm; i++){
				PVector l = new PVector(parent.random(50, 3150), parent.random(50, 3150));
				DNAboar dnaboar = new DNAboar(parent);
				boarm.add(new BoarM(l,dnaboar,parent));
			}
		}

		Iterator<BoarM> BoM = boarm.iterator();
		while(BoM.hasNext()){
			BoarM bom = BoM.next();
			bom.display(parent);
			bom.run(parent);
			bom.boundaries();
			
			if(bom.eatingTime() == false ){
				//bom.wander(parent);
				bom.mvtUpdate();
			}
			
			if(bom.dead() == true){
				BoM.remove();
			}
			
			Iterator<tileWater> tileW = tilewater.iterator();
			while(tileW.hasNext()){
				tileWater tilew = tileW.next();
				PVector target = new PVector(tilew.position.x, tilew.position.y);
				if(bom.isTooClose(target)){
					bom.goAway(target);
				}
			}
			
		}
		
		///////find food insecte chenille champi red and yellow berry souris ///////// 
		if(boarm.size() > 0){
			float currentSmallest;
			float dist;
			for(int a = boarm.size()-1; a >=0; a--){
				BoarM bm = boarm.get(a);
				
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(bm.faim() == false){
					bm.wander(parent);
				}
				if(bm.faim() == true){
					for(int b = insect1m.size()-1; b >=0; b--){
						insect1M i1m = insect1m.get(b);
						dist = ((bm.position.x - i1m.position.x) * (bm.position.x - i1m.position.x)) +
							   ((bm.position.y - i1m.position.y) * (bm.position.y - i1m.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = i1m.position.x;
							target.y = i1m.position.y;
						}
					}
					for(int c = papillonbchenille.size()-1; c >=0; c--){
						PapillonBchenille pbc = papillonbchenille.get(c);
						dist = ((bm.position.x - pbc.position.x) * (bm.position.x - pbc.position.x)) +
							   ((bm.position.y - pbc.position.y) * (bm.position.y - pbc.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = pbc.position.x;
							target.y = pbc.position.y;
						}
					}
					for(int d = champi.size()-1; d >=0; d--){
						Champi ch = champi.get(d);
						dist = ((bm.position.x - ch.position.x) * (bm.position.x - ch.position.x)) +
							   ((bm.position.y - ch.position.y) * (bm.position.y - ch.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = ch.position.x;
							target.y = ch.position.y;
						}
					}
					for(int e = redberry.size()-1; e >=0; e--){
						RedBerry rb = redberry.get(e);
						dist = ((bm.position.x - rb.position.x) * (bm.position.x - rb.position.x)) +
							   ((bm.position.y - rb.position.y) * (bm.position.y - rb.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = rb.position.x;
							target.y = rb.position.y;
						}
					}
					for(int f = yellowberry.size()-1; f >=0; f--){
						YellowBerry yb = yellowberry.get(f);
						dist = ((bm.position.x - yb.position.x) * (bm.position.x - yb.position.x)) +
							   ((bm.position.y - yb.position.y) * (bm.position.y - yb.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = yb.position.x;
							target.y = yb.position.y;
						}
					}
					for(int g = sourism.size()-1; g >=0; g--){
						SourisM sm = sourism.get(g);
						dist = ((bm.position.x - sm.position.x) * (bm.position.x - sm.position.x)) +
							   ((bm.position.y - sm.position.y) * (bm.position.y - sm.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = sm.position.x;
							target.y = sm.position.y;
						}
					}
					for(int h = sourisf.size()-1; h >=0; h--){
						SourisF sf = sourisf.get(h);
						dist = ((bm.position.x - sf.position.x) * (bm.position.x - sf.position.x)) +
							   ((bm.position.y - sf.position.y) * (bm.position.y - sf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = sf.position.x;
							target.y = sf.position.y;
						}
					}

					bm.findPray(target);
				}
				
			}
		}
		/////////////////////////
		
		////////eat insect chenille champi red and yellow berry souris////////
		Iterator<BoarM> BoarM = boarm.iterator();
		while(BoarM.hasNext()){
			BoarM bm = BoarM.next();
			Iterator<insect1M> i1M = insect1m.iterator();
			while(i1M.hasNext()){
				insect1M i1m = i1M.next();
				PVector i1mpos = i1m.position;
				PVector bmpos = bm.position;
				float d = PVector.dist(i1mpos, bmpos);
				if(bm.faim() == true){
					if(d < bm.getR()){
						bm.eatFood();
						i1M.remove();
						bm.resetEating();
					}
				}
			}
			Iterator<PapillonBchenille> PBc = papillonbchenille.iterator();
			while(PBc.hasNext()){
				PapillonBchenille pbc = PBc.next();
				PVector pbcpos = pbc.position;
				PVector bmpos = bm.position;
				float d = PVector.dist(pbcpos, bmpos);
				if(bm.faim() == true){
					if(d < bm.getR()){
						bm.eatFood();
						PBc.remove();
						bm.resetEating();
					}
				}
			}
			Iterator<Champi> CH = champi.iterator();
			while(CH.hasNext()){
				Champi ch = CH.next();
				PVector chpos = ch.position;
				PVector bmpos = bm.position;
				float d = PVector.dist(chpos, bmpos);
				if(bm.faim() == true){
					if(d < bm.getR()){
						bm.eatFood();
						//CH.remove();
						bm.resetEating();
					}
				}
			}
			Iterator<RedBerry> ReB = redberry.iterator();
			while(ReB.hasNext()){
				RedBerry reb = ReB.next();
				PVector rebpos = reb.position;
				PVector bmpos = bm.position;
				float d = PVector.dist(rebpos, bmpos);
				if(bm.faim() == true){
					if(d < bm.getR()){
						bm.eatFood();
						ReB.remove();
						bm.resetEating();
					}
				}
			}
			Iterator<YellowBerry> YeB = yellowberry.iterator();
			while(YeB.hasNext()){
				YellowBerry yeb = YeB.next();
				PVector yebpos = yeb.position;
				PVector bmpos = bm.position;
				float d = PVector.dist(yebpos, bmpos);
				if(bm.faim() == true){
					if(d < bm.getR()){
						bm.eatFood();
						YeB.remove();
						bm.resetEating();
					}
				}
			}
			Iterator<SourisM> SoM = sourism.iterator();
			while(SoM.hasNext()){
				SourisM som = SoM.next();
				PVector sompos = som.position;
				PVector bmpos = bm.position;
				float d = PVector.dist(sompos, bmpos);
				if(bm.faim() == true){
					if(d < bm.getR()){
						bm.eatFood();
						SoM.remove();
						bm.resetEating();
					}
				}
			}
			Iterator<SourisF> SoF = sourisf.iterator();
			while(SoF.hasNext()){
				SourisF sof = SoF.next();
				PVector sofpos = sof.position;
				PVector bmpos = bm.position;
				float d = PVector.dist(sofpos, bmpos);
				if(bm.faim() == true){
					if(d < bm.getR()){
						bm.eatFood();
						SoF.remove();
						bm.resetEating();
					}
				}
			}
		}
		//////////////////////////


		/////////////////////////
		
		//////FEMALE//////////////
		while(boarf.size() < 1){
			int totalboarf = 1;
			for(int i = 0; i < totalboarf; i++){
				PVector l = new PVector(parent.random(50, 3150), parent.random(50, 3150));
				DNAboar dnaboar = new DNAboar(parent);
				boarf.add(new BoarF(l,dnaboar,parent));
			}
		}

		Iterator<BoarF> BoF = boarf.iterator();
		while(BoF.hasNext()){
			BoarF bof = BoF.next();
			bof.display(parent);
			bof.run(parent);
			bof.boundaries();
			
			if(bof.eatingTime() == false ){
				//bof.wander(parent);
				bof.mvtUpdate();
			}
			
			if(bof.dead() == true){
				BoF.remove();
			}
			
			Iterator<tileWater> tileW = tilewater.iterator();
			while(tileW.hasNext()){
				tileWater tilew = tileW.next();
				PVector target = new PVector(tilew.position.x, tilew.position.y);
				if(bof.isTooClose(target)){
					bof.goAway(target);
				}
			}
			
		}

		///////find food insecte chenille champi red and yellow berry souris///////// 
		if(boarf.size() > 0){
			float currentSmallest;
			float dist;
			for(int a = boarf.size()-1; a >=0; a--){
				BoarF bf = boarf.get(a);
				
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(bf.faim() == false){
					bf.wander(parent);
				}
				if(bf.faim() == true){
					for(int b = insect1m.size()-1; b >=0; b--){
						insect1M i1m = insect1m.get(b);
						dist = ((bf.position.x - i1m.position.x) * (bf.position.x - i1m.position.x)) +
							   ((bf.position.y - i1m.position.y) * (bf.position.y - i1m.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = i1m.position.x;
							target.y = i1m.position.y;
						}
					}
					for(int c = papillonbchenille.size()-1; c >=0; c--){
						PapillonBchenille pbc = papillonbchenille.get(c);
						dist = ((bf.position.x - pbc.position.x) * (bf.position.x - pbc.position.x)) +
							   ((bf.position.y - pbc.position.y) * (bf.position.y - pbc.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = pbc.position.x;
							target.y = pbc.position.y;
						}
					}
					for(int d = champi.size()-1; d >=0; d--){
						Champi ch = champi.get(d);
						dist = ((bf.position.x - ch.position.x) * (bf.position.x - ch.position.x)) +
							   ((bf.position.y - ch.position.y) * (bf.position.y - ch.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = ch.position.x;
							target.y = ch.position.y;
						}
					}
					for(int e = redberry.size()-1; e >=0; e--){
						RedBerry rb = redberry.get(e);
						dist = ((bf.position.x - rb.position.x) * (bf.position.x - rb.position.x)) +
							   ((bf.position.y - rb.position.y) * (bf.position.y - rb.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = rb.position.x;
							target.y = rb.position.y;
						}
					}
					for(int f = yellowberry.size()-1; f >=0; f--){
						YellowBerry yb = yellowberry.get(f);
						dist = ((bf.position.x - yb.position.x) * (bf.position.x - yb.position.x)) +
							   ((bf.position.y - yb.position.y) * (bf.position.y - yb.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = yb.position.x;
							target.y = yb.position.y;
						}
					}
					for(int g = sourism.size()-1; g >=0; g--){
						SourisM sm = sourism.get(g);
						dist = ((bf.position.x - sm.position.x) * (bf.position.x - sm.position.x)) +
							   ((bf.position.y - sm.position.y) * (bf.position.y - sm.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = sm.position.x;
							target.y = sm.position.y;
						}
					}
					for(int h = sourisf.size()-1; h >=0; h--){
						SourisF sf = sourisf.get(h);
						dist = ((bf.position.x - sf.position.x) * (bf.position.x - sf.position.x)) +
							   ((bf.position.y - sf.position.y) * (bf.position.y - sf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = sf.position.x;
							target.y = sf.position.y;
						}
					}

					bf.findPray(target);
				}
				
			}
		}
		/////////////////////////
		
		////////eat insect////////
		Iterator<BoarF> BoarF = boarf.iterator();
		while(BoarF.hasNext()){
			BoarF bf = BoarF.next();
			Iterator<insect1M> i1M = insect1m.iterator();
			while(i1M.hasNext()){
				insect1M i1m = i1M.next();
				PVector i1mpos = i1m.position;
				PVector bfpos = bf.position;
				float d = PVector.dist(i1mpos, bfpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						i1M.remove();
						bf.resetEating();
					}
				}
			}
			Iterator<PapillonBchenille> PBc = papillonbchenille.iterator();
			while(PBc.hasNext()){
				PapillonBchenille pbc = PBc.next();
				PVector pbcpos = pbc.position;
				PVector bmpos = bf.position;
				float d = PVector.dist(pbcpos, bmpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						PBc.remove();
						bf.resetEating();
					}
				}
			}
			Iterator<Champi> CH = champi.iterator();
			while(CH.hasNext()){
				Champi ch = CH.next();
				PVector chpos = ch.position;
				PVector bmpos = bf.position;
				float d = PVector.dist(chpos, bmpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						//CH.remove();
						bf.resetEating();
					}
				}
			}
			Iterator<RedBerry> ReB = redberry.iterator();
			while(ReB.hasNext()){
				RedBerry reb = ReB.next();
				PVector rebpos = reb.position;
				PVector bmpos = bf.position;
				float d = PVector.dist(rebpos, bmpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						ReB.remove();
						bf.resetEating();
					}
				}
			}
			Iterator<YellowBerry> YeB = yellowberry.iterator();
			while(YeB.hasNext()){
				YellowBerry yeb = YeB.next();
				PVector yebpos = yeb.position;
				PVector bmpos = bf.position;
				float d = PVector.dist(yebpos, bmpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						YeB.remove();
						bf.resetEating();
					}
				}
			}
			Iterator<SourisM> SoM = sourism.iterator();
			while(SoM.hasNext()){
				SourisM som = SoM.next();
				PVector sompos = som.position;
				PVector bmpos = bf.position;
				float d = PVector.dist(sompos, bmpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						SoM.remove();
						bf.resetEating();
					}
				}
			}
			Iterator<SourisF> SoF = sourisf.iterator();
			while(SoF.hasNext()){
				SourisF sof = SoF.next();
				PVector sofpos = sof.position;
				PVector bmpos = bf.position;
				float d = PVector.dist(sofpos, bmpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						SoF.remove();
						bf.resetEating();
					}
				}
			}

		}
		//////////////////////////
		
		//////find female///////
		if(boarf.size() >= 1){
			float currentSmallest;
			float dist;
			for(int a = boarm.size()-1; a >=0; a--){
				BoarM bm = boarm.get(a);
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(bm.reproduceTime() == false){
					bm.wander(parent);
				}
				if(bm.reproduceTime() == true){
					for(int b = boarf.size()-1; b >= 0; b--){
						BoarF bf = boarf.get(b);
						dist = ((bm.position.x - bf.position.x) * (bm.position.x - bf.position.x)) +
							   ((bm.position.y - bf.position.y) * (bm.position.y - bf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = bf.position.x;
							target.y = bf.position.y;
						}
					}
					bm.findFemale(target);
				}
			}
		}
		
		/////reproduction///////
		for(int a = boarm.size()-1; a >= 0; a--){
			for(int b = boarf.size()-1; b >= 0; b--){
				BoarM bm = boarm.get(a);
				BoarF bf = boarf.get(b);
				PVector bmpos = bm.position;
				PVector bfpos = bf.position;
				float d = PVector.dist(bmpos, bfpos);
				if(d < bf.getR() && bf.reproduceTime() == true){  /////a changer juste pour test
					DNAboar momgenes = bm.getDNAboar();
					DNAboar dadgenes = bf.getDNAboar();
					DNAboar childdna = momgenes.crossover(dadgenes, parent);
					//if(parent.random(1) < 0.9){
						if(parent.random(10) > 5 && boarm.size() < 20){
							boarm.add(new BoarM(bfpos, childdna, parent));
							bf.resetReproduce();
							bm.resetReproduce();
						}
						if(parent.random(10) < 5 && boarf.size() < 20){
							boarf.add(new BoarF(bfpos, childdna, parent));
							bf.resetReproduce();
							bm.resetReproduce();
						}
					//}
				}
				
			}
		}
		//////////////////////////
		//////////////////////////
		
		////////WOLF//////////////
		
		///////WolfNid//////////
		int totalwolfnid = 1;
		while(wolfnid.size() < totalwolfnid){
			PVector l = new PVector();
			l.x = parent.random(worldW-3150 , worldW-50);
			l.y	= parent.random(worldH-3150 , worldH-50);
			boolean overlapping = false;
			for(int a = 0; a < tilewater.size(); a++){
				tileWater other = tilewater.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 60){
					overlapping = true;
					break;
				}
			}
			if(!overlapping){
				wolfnid.add(new WolfNid(parent, l));
			}
			
		}
		
		Iterator<WolfNid> WN = wolfnid.iterator();
		while(WN.hasNext()){
			WolfNid wn = WN.next();
			wn.display(parent);
		}
		/////////////////////////

		//////MALE//////////////
		while(wolfm.size() < 1){
			int totalwolfm = 1;
			for(int i = 0; i < totalwolfm; i++){
				PVector l = new PVector(parent.random(50, 3150), parent.random(50, 3150));
				DNAwolf dnawolf = new DNAwolf(parent);
				wolfm.add(new WolfM(l,dnawolf,parent));
			}
		}

		Iterator<WolfM> WM = wolfm.iterator();
		while(WM.hasNext()){
			WolfM wm = WM.next();
			wm.display(parent);
			wm.run(parent);
			wm.boundaries();
			
			if(wm.eatingTime() == false ){
				//wm.wander(parent);
				wm.mvtUpdate();
			}
			
			if(wm.dead() == true){
				WM.remove();
			}
			
			Iterator<tileWater> tileW = tilewater.iterator();
			while(tileW.hasNext()){
				tileWater tilew = tileW.next();
				PVector target = new PVector(tilew.position.x, tilew.position.y);
				if(wm.isTooClose(target)){
					wm.goAway(target);
				}
			}
			
		}
		
		///////find food lapin souris ecureuil boar ///////// 
		if(wolfm.size() > 0){
			float currentSmallest;
			float dist;
			for(int a = wolfm.size()-1; a >=0; a--){
				WolfM wm = wolfm.get(a);
				
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(wm.faim() == false){
					wm.wander(parent);
				}
				if(wm.faim() == true){
					for(int b = lapinm.size()-1; b >=0; b--){
						LapinM lm = lapinm.get(b);
						dist = ((wm.position.x - lm.position.x) * (wm.position.x - lm.position.x)) +
							   ((wm.position.y - lm.position.y) * (wm.position.y - lm.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = lm.position.x;
							target.y = lm.position.y;
						}
					}
					for(int c = lapinf.size()-1; c >=0; c--){
						LapinF lf = lapinf.get(c);
						dist = ((wm.position.x - lf.position.x) * (wm.position.x - lf.position.x)) +
							   ((wm.position.y - lf.position.y) * (wm.position.y - lf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = lf.position.x;
							target.y = lf.position.y;
						}
					}
					for(int d = sourism.size()-1; d >=0; d--){
						SourisM sm = sourism.get(d);
						dist = ((wm.position.x - sm.position.x) * (wm.position.x - sm.position.x)) +
							   ((wm.position.y - sm.position.y) * (wm.position.y - sm.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = sm.position.x;
							target.y = sm.position.y;
						}
					}
					for(int e = sourisf.size()-1; e >=0; e--){
						SourisF sf = sourisf.get(e);
						dist = ((wm.position.x - sf.position.x) * (wm.position.x - sf.position.x)) +
							   ((wm.position.y - sf.position.y) * (wm.position.y - sf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = sf.position.x;
							target.y = sf.position.y;
						}
					}
					for(int f = ecureuilm.size()-1; f >=0; f--){
						EcureuilM em = ecureuilm.get(f);
						dist = ((wm.position.x - em.position.x) * (wm.position.x - em.position.x)) +
							   ((wm.position.y - em.position.y) * (wm.position.y - em.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = em.position.x;
							target.y = em.position.y;
						}
					}
					for(int g = ecureuilf.size()-1; g >=0; g--){
						EcureuilF ef = ecureuilf.get(g);
						dist = ((wm.position.x - ef.position.x) * (wm.position.x - ef.position.x)) +
							   ((wm.position.y - ef.position.y) * (wm.position.y - ef.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = ef.position.x;
							target.y = ef.position.y;
						}
					}
					for(int h = boarm.size()-1; h >=0; h--){
						BoarM bm = boarm.get(h);
						dist = ((wm.position.x - bm.position.x) * (wm.position.x - bm.position.x)) +
							   ((wm.position.y - bm.position.y) * (wm.position.y - bm.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = bm.position.x;
							target.y = bm.position.y;
						}
					}
					for(int i = boarf.size()-1; i >=0; i--){
						BoarF bf = boarf.get(i);
						dist = ((wm.position.x - bf.position.x) * (wm.position.x - bf.position.x)) +
							   ((wm.position.y - bf.position.y) * (wm.position.y - bf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = bf.position.x;
							target.y = bf.position.y;
						}
					}
					wm.findPray(target);
				}
				
			}
		}
		/////////////////////////
		
		////////eat lapin souris ecureuil boar////////
		Iterator<WolfM> Wom = wolfm.iterator();
		while(Wom.hasNext()){
			WolfM wm = Wom.next();
			Iterator<LapinM> lM = lapinm.iterator();
			while(lM.hasNext()){
				LapinM lm = lM.next();
				PVector lmpos = lm.position;
				PVector wmpos = wm.position;
				float d = PVector.dist(lmpos, wmpos);
				if(wm.faim() == true){
					if(d < wm.getR()){
						wm.eatFood();
						lM.remove();
						wm.resetEating();
					}
				}
			}
			Iterator<LapinF> lF = lapinf.iterator();
			while(lF.hasNext()){
				LapinF lf = lF.next();
				PVector lfpos = lf.position;
				PVector wmpos = wm.position;
				float d = PVector.dist(lfpos, wmpos);
				if(wm.faim() == true){
					if(d < wm.getR()){
						wm.eatFood();
						lF.remove();
						wm.resetEating();
					}
				}
			}
			Iterator<SourisM> SoM = sourism.iterator();
			while(SoM.hasNext()){
				SourisM som = SoM.next();
				PVector sompos = som.position;
				PVector wmpos = wm.position;
				float d = PVector.dist(sompos, wmpos);
				if(wm.faim() == true){
					if(d < wm.getR()){
						wm.eatFood();
						SoM.remove();
						wm.resetEating();
					}
				}
			}
			Iterator<SourisF> SoF = sourisf.iterator();
			while(SoF.hasNext()){
				SourisF sof = SoF.next();
				PVector sofpos = sof.position;
				PVector wmpos = wm.position;
				float d = PVector.dist(sofpos, wmpos);
				if(wm.faim() == true){
					if(d < wm.getR()){
						wm.eatFood();
						SoF.remove();
						wm.resetEating();
					}
				}
			}
			Iterator<EcureuilM> EcM = ecureuilm.iterator();
			while(EcM.hasNext()){
				EcureuilM ecm = EcM.next();
				PVector ecmpos = ecm.position;
				PVector wmpos = wm.position;
				float d = PVector.dist(ecmpos, wmpos);
				if(wm.faim() == true){
					if(d < wm.getR()){
						wm.eatFood();
						EcM.remove();
						wm.resetEating();
					}
				}
			}
			Iterator<EcureuilF> EcF = ecureuilf.iterator();
			while(EcF.hasNext()){
				EcureuilF ecf = EcF.next();
				PVector ecfpos = ecf.position;
				PVector wmpos = wm.position;
				float d = PVector.dist(ecfpos, wmpos);
				if(wm.faim() == true){
					if(d < wm.getR()){
						wm.eatFood();
						EcF.remove();
						wm.resetEating();
					}
				}
			}
			Iterator<BoarM> BoaM = boarm.iterator();
			while(BoaM.hasNext()){
				BoarM boam = BoaM.next();
				PVector boampos = boam.position;
				PVector wmpos = wm.position;
				float d = PVector.dist(boampos, wmpos);
				if(wm.faim() == true){
					if(d < wm.getR()){
						wm.eatFood();
						BoaM.remove();
						wm.resetEating();
					}
				}
			}
			Iterator<BoarF> BoaF = boarf.iterator();
			while(BoaF.hasNext()){
				BoarF boaf = BoaF.next();
				PVector boafpos = boaf.position;
				PVector wmpos = wm.position;
				float d = PVector.dist(boafpos, wmpos);
				if(wm.faim() == true){
					if(d < wm.getR()){
						wm.eatFood();
						BoaF.remove();
						wm.resetEating();
					}
				}
			}
		}
		//////////////////////////

		
		//////////////////////////

		//////FEMALE//////////////
		while(wolff.size() < 1){
			int totalwolff = 1;
			for(int i = 0; i < totalwolff; i++){
				PVector l = new PVector(parent.random(50, 3150), parent.random(50, 3150));
				DNAwolf dnawolf = new DNAwolf(parent);
				wolff.add(new WolfF(l,dnawolf,parent));
			}
		}

		Iterator<WolfF> WF = wolff.iterator();
		while(WF.hasNext()){
			WolfF wf = WF.next();
			wf.display(parent);
			wf.run(parent);
			wf.boundaries();
			
			if(wf.eatingTime() == false ){
				//wf.wander(parent);
				wf.mvtUpdate();
			}
			
			if(wf.dead() == true){
				WF.remove();
			}
			
			Iterator<tileWater> tileW = tilewater.iterator();
			while(tileW.hasNext()){
				tileWater tilew = tileW.next();
				PVector target = new PVector(tilew.position.x, tilew.position.y);
				if(wf.isTooClose(target)){
					wf.goAway(target);
				}
			}
			
		}
		
		//////////////////////////

		///////find food lapin souris ecureuil boar ////////
		if(wolff.size() > 0){
			float currentSmallest;
			float dist;
			for(int a = wolff.size()-1; a >=0; a--){
				WolfF wf = wolff.get(a);
				
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(wf.faim() == false){
					wf.wander(parent);
				}
				if(wf.faim() == true){
					for(int b = lapinm.size()-1; b >=0; b--){
						LapinM lm = lapinm.get(b);
						dist = ((wf.position.x - lm.position.x) * (wf.position.x - lm.position.x)) +
							   ((wf.position.y - lm.position.y) * (wf.position.y - lm.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = lm.position.x;
							target.y = lm.position.y;
						}
					}
					for(int c = lapinf.size()-1; c >=0; c--){
						LapinF lf = lapinf.get(c);
						dist = ((wf.position.x - lf.position.x) * (wf.position.x - lf.position.x)) +
							   ((wf.position.y - lf.position.y) * (wf.position.y - lf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = lf.position.x;
							target.y = lf.position.y;
						}
					}
					for(int d = sourism.size()-1; d >=0; d--){
						SourisM sm = sourism.get(d);
						dist = ((wf.position.x - sm.position.x) * (wf.position.x - sm.position.x)) +
							   ((wf.position.y - sm.position.y) * (wf.position.y - sm.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = sm.position.x;
							target.y = sm.position.y;
						}
					}
					for(int e = sourisf.size()-1; e >=0; e--){
						SourisF sf = sourisf.get(e);
						dist = ((wf.position.x - sf.position.x) * (wf.position.x - sf.position.x)) +
							   ((wf.position.y - sf.position.y) * (wf.position.y - sf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = sf.position.x;
							target.y = sf.position.y;
						}
					}
					for(int f = ecureuilm.size()-1; f >=0; f--){
						EcureuilM em = ecureuilm.get(f);
						dist = ((wf.position.x - em.position.x) * (wf.position.x - em.position.x)) +
							   ((wf.position.y - em.position.y) * (wf.position.y - em.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = em.position.x;
							target.y = em.position.y;
						}
					}
					for(int g = ecureuilf.size()-1; g >=0; g--){
						EcureuilF ef = ecureuilf.get(g);
						dist = ((wf.position.x - ef.position.x) * (wf.position.x - ef.position.x)) +
							   ((wf.position.y - ef.position.y) * (wf.position.y - ef.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = ef.position.x;
							target.y = ef.position.y;
						}
					}
					for(int h = boarm.size()-1; h >=0; h--){
						BoarM bm = boarm.get(h);
						dist = ((wf.position.x - bm.position.x) * (wf.position.x - bm.position.x)) +
							   ((wf.position.y - bm.position.y) * (wf.position.y - bm.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = bm.position.x;
							target.y = bm.position.y;
						}
					}
					for(int i = boarf.size()-1; i >=0; i--){
						BoarF bf = boarf.get(i);
						dist = ((wf.position.x - bf.position.x) * (wf.position.x - bf.position.x)) +
							   ((wf.position.y - bf.position.y) * (wf.position.y - bf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = bf.position.x;
							target.y = bf.position.y;
						}
					}

					wf.findPray(target);
				}
				
			}
		}
		/////////////////////////
		
		////////eat lapinm////////
		Iterator<WolfF> Wof = wolff.iterator();
		while(Wof.hasNext()){
			WolfF wf = Wof.next();
			Iterator<LapinM> lM = lapinm.iterator();
			while(lM.hasNext()){
				LapinM lm = lM.next();
				PVector lmpos = lm.position;
				PVector wfpos = wf.position;
				float d = PVector.dist(lmpos, wfpos);
				if(wf.faim() == true){
					if(d < wf.getR()){
						wf.eatFood();
						lM.remove();
						wf.resetEating();
					}
				}
			}
			Iterator<LapinF> lF = lapinf.iterator();
			while(lF.hasNext()){
				LapinF lf = lF.next();
				PVector lfpos = lf.position;
				PVector wmpos = wf.position;
				float d = PVector.dist(lfpos, wmpos);
				if(wf.faim() == true){
					if(d < wf.getR()){
						wf.eatFood();
						lF.remove();
						wf.resetEating();
					}
				}
			}
			Iterator<SourisM> SoM = sourism.iterator();
			while(SoM.hasNext()){
				SourisM som = SoM.next();
				PVector sompos = som.position;
				PVector wmpos = wf.position;
				float d = PVector.dist(sompos, wmpos);
				if(wf.faim() == true){
					if(d < wf.getR()){
						wf.eatFood();
						SoM.remove();
						wf.resetEating();
					}
				}
			}
			Iterator<SourisF> SoF = sourisf.iterator();
			while(SoF.hasNext()){
				SourisF sof = SoF.next();
				PVector sofpos = sof.position;
				PVector wmpos = wf.position;
				float d = PVector.dist(sofpos, wmpos);
				if(wf.faim() == true){
					if(d < wf.getR()){
						wf.eatFood();
						SoF.remove();
						wf.resetEating();
					}
				}
			}
			Iterator<EcureuilM> EcM = ecureuilm.iterator();
			while(EcM.hasNext()){
				EcureuilM ecm = EcM.next();
				PVector ecmpos = ecm.position;
				PVector wmpos = wf.position;
				float d = PVector.dist(ecmpos, wmpos);
				if(wf.faim() == true){
					if(d < wf.getR()){
						wf.eatFood();
						EcM.remove();
						wf.resetEating();
					}
				}
			}
			Iterator<EcureuilF> EcF = ecureuilf.iterator();
			while(EcF.hasNext()){
				EcureuilF ecf = EcF.next();
				PVector ecfpos = ecf.position;
				PVector wmpos = wf.position;
				float d = PVector.dist(ecfpos, wmpos);
				if(wf.faim() == true){
					if(d < wf.getR()){
						wf.eatFood();
						EcF.remove();
						wf.resetEating();
					}
				}
			}
			Iterator<BoarM> BoaM = boarm.iterator();
			while(BoaM.hasNext()){
				BoarM boam = BoaM.next();
				PVector boampos = boam.position;
				PVector wmpos = wf.position;
				float d = PVector.dist(boampos, wmpos);
				if(wf.faim() == true){
					if(d < wf.getR()){
						wf.eatFood();
						BoaM.remove();
						wf.resetEating();
					}
				}
			}
			Iterator<BoarF> BoaF = boarf.iterator();
			while(BoaF.hasNext()){
				BoarF boaf = BoaF.next();
				PVector boafpos = boaf.position;
				PVector wmpos = wf.position;
				float d = PVector.dist(boafpos, wmpos);
				if(wf.faim() == true){
					if(d < wf.getR()){
						wf.eatFood();
						BoaF.remove();
						wf.resetEating();
					}
				}
			}

		}
		//////////////////////////

		//////REPRODUCTION/////////
		
		//////find female///////
		if(wolff.size() >= 1){
			float currentSmallest;
			float dist;
			for(int a = wolfm.size()-1; a >=0; a--){
				WolfM wm = wolfm.get(a);
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(wm.reproduceTime() == false){
					wm.wander(parent);
				}
				if(wm.reproduceTime() == true){
					for(int b = wolff.size()-1; b >= 0; b--){
						WolfF wf = wolff.get(b);
						dist = ((wm.position.x - wf.position.x) * (wm.position.x - wf.position.x)) +
							   ((wm.position.y - wf.position.y) * (wm.position.y - wf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = wf.position.x;
							target.y = wf.position.y;
						}
					}
					wm.findFemale(target);
				}
			}
		}
		
		/////reproduction///////
		for(int a = wolfm.size()-1; a >= 0; a--){
			for(int b = wolff.size()-1; b >= 0; b--){
				WolfM wm = wolfm.get(a);
				WolfF wf = wolff.get(b);
				PVector wmpos = wm.position;
				PVector wfpos = wf.position;
				float d = PVector.dist(wmpos, wfpos);
				if(d < wf.getR() && wf.reproduceTime() == true){  /////a changer juste pour test
					DNAwolf momgenes = wm.getDNAwolf();
					DNAwolf dadgenes = wf.getDNAwolf();
					DNAwolf childdna = momgenes.crossover(dadgenes, parent);
					//if(parent.random(1) < 0.9){
						if(parent.random(10) > 5 && wolfm.size() < 20){
							wolfm.add(new WolfM(wfpos, childdna, parent));
							wf.resetReproduce();
							wm.resetReproduce();
						}
						if(parent.random(10) < 5 && wolff.size() < 20){
							wolff.add(new WolfF(wfpos, childdna, parent));
							wf.resetReproduce();
							wm.resetReproduce();
						}
					//}
				}
				
			}
		}
		//////////////////////////
		//////////////////////////

		////////BEAR//////////////
		
		///////bearNid//////////
		int totalbearnid = 1;
		while(bearnid.size() < totalbearnid){
			PVector l = new PVector();
			l.x = parent.random(worldW-3150 , worldW-50);
			l.y	= parent.random(worldH-3150 , worldH-50);
			boolean overlapping = false;
			for(int a = 0; a < tilewater.size(); a++){
				tileWater other = tilewater.get(a);
				float d = PApplet.dist(l.x, l.y, other.position.x, other.position.y);
				if(d < 60){
					overlapping = true;
					break;
				}
			}
			if(!overlapping){
				bearnid.add(new BearNid(parent, l));
			}
			
		}
		
		Iterator<BearNid> BeN = bearnid.iterator();
		while(BeN.hasNext()){
			BearNid ben = BeN.next();
			ben.display(parent);
		}
		/////////////////////////

		//////MALE//////////////
		while(bearm.size() < 1){
			int totalbearm = 1;
			for(int i = 0; i < totalbearm; i++){
				PVector l = new PVector(parent.random(50, 3150), parent.random(50, 3150));
				DNAbear dnabear = new DNAbear(parent);
				bearm.add(new BearM(l,dnabear,parent));
			}
		}

		Iterator<BearM> BeM = bearm.iterator();
		while(BeM.hasNext()){
			BearM bem = BeM.next();
			bem.display(parent);
			bem.run(parent);
			bem.boundaries();
			
			if(bem.eatingTime() == false ){
				//bem.wander(parent);
				bem.mvtUpdate();
			}
			
			if(bem.dead() == true){
				BeM.remove();
			}
			
			Iterator<tileWater> tileW = tilewater.iterator();
			while(tileW.hasNext()){
				tileWater tilew = tileW.next();
				PVector target = new PVector(tilew.position.x, tilew.position.y);
				if(bem.isTooClose(target)){
					bem.goAway(target);
				}
			}
			
		}

		///////find food red yellow berry champi insect papillon chenille souris lapin///////// ////ajout des autres proie à faire
		if(bearm.size() > 0){
			float currentSmallest;
			float dist;
			for(int a = bearm.size()-1; a >=0; a--){
				BearM bm = bearm.get(a);
				
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(bm.faim() == false){
					bm.wander(parent);
				}
				if(bm.faim() == true){
					for(int b = redberry.size()-1; b >=0; b--){
						RedBerry rb = redberry.get(b);
						dist = ((bm.position.x - rb.position.x) * (bm.position.x - rb.position.x)) +
							   ((bm.position.y - rb.position.y) * (bm.position.y - rb.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = rb.position.x;
							target.y = rb.position.y;
						}
					}
					for(int c = yellowberry.size()-1; c >=0; c--){
						YellowBerry yb = yellowberry.get(c);
						dist = ((bm.position.x - yb.position.x) * (bm.position.x - yb.position.x)) +
							   ((bm.position.y - yb.position.y) * (bm.position.y - yb.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = yb.position.x;
							target.y = yb.position.y;
						}
					}
					for(int d = champi.size()-1; d >=0; d--){
						Champi ch = champi.get(d);
						dist = ((bm.position.x - ch.position.x) * (bm.position.x - ch.position.x)) +
							   ((bm.position.y - ch.position.y) * (bm.position.y - ch.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = ch.position.x;
							target.y = ch.position.y;
						}
					}
					for(int e = insect1m.size()-1; e >=0; e--){
						insect1M i1m = insect1m.get(e);
						dist = ((bm.position.x - i1m.position.x) * (bm.position.x - i1m.position.x)) +
							   ((bm.position.y - i1m.position.y) * (bm.position.y - i1m.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = i1m.position.x;
							target.y = i1m.position.y;
						}
					}
					for(int f = papillonb.size()-1 ; f >=0; f--){
						PapillonB pb = papillonb.get(f);
						dist = ((bm.position.x - pb.position.x) * (bm.position.x - pb.position.x)) +
							   ((bm.position.y - pb.position.y) * (bm.position.y - pb.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = pb.position.x;
							target.y = pb.position.y;
						}
					}
					for(int g = papillonbchenille.size()-1; g >=0; g--){
						PapillonBchenille pbc = papillonbchenille.get(g);
						dist = ((bm.position.x - pbc.position.x) * (bm.position.x - pbc.position.x)) +
							   ((bm.position.y - pbc.position.y) * (bm.position.y - pbc.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = pbc.position.x;
							target.y = pbc.position.y;
						}
					}
					for(int h = sourism.size()-1; h >=0; h--){
						SourisM sm = sourism.get(h);
						dist = ((bm.position.x - sm.position.x) * (bm.position.x - sm.position.x)) +
							   ((bm.position.y - sm.position.y) * (bm.position.y - sm.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = sm.position.x;
							target.y = sm.position.y;
						}
					}
					for(int i = sourisf.size()-1; i >=0; i--){
						SourisF sf = sourisf.get(i);
						dist = ((bm.position.x - sf.position.x) * (bm.position.x - sf.position.x)) +
							   ((bm.position.y - sf.position.y) * (bm.position.y - sf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = sf.position.x;
							target.y = sf.position.y;
						}
					}
					for(int j = lapinm.size()-1; j >=0; j--){
						LapinM lm = lapinm.get(j);
						dist = ((bm.position.x - lm.position.x) * (bm.position.x - lm.position.x)) +
							   ((bm.position.y - lm.position.y) * (bm.position.y - lm.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = lm.position.x;
							target.y = lm.position.y;
						}
					}
					for(int k = lapinf.size()-1; k >=0; k--){
						LapinF lf = lapinf.get(k);
						dist = ((bm.position.x - lf.position.x) * (bm.position.x - lf.position.x)) +
							   ((bm.position.y - lf.position.y) * (bm.position.y - lf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = lf.position.x;
							target.y = lf.position.y;
						}
					}
					bm.findPray(target);
				}
				
			}
		}
		/////////////////////////
		
		////////eat redberry////////
		Iterator<BearM> Bm = bearm.iterator();
		while(Bm.hasNext()){
			BearM bm = Bm.next();
			Iterator<RedBerry> ReB = redberry.iterator();
			while(ReB.hasNext()){
				RedBerry reb = ReB.next();
				PVector rbpos = reb.position;
				PVector bmpos = bm.position;
				float d = PVector.dist(rbpos, bmpos);
				if(bm.faim() == true){
					if(d < bm.getR()){
						bm.eatFood();
						ReB.remove();
						bm.resetEating();
					}
				}
			}
			Iterator<YellowBerry> YeB = yellowberry.iterator();
			while(YeB.hasNext()){
				YellowBerry yeb = YeB.next();
				PVector ybpos = yeb.position;
				PVector bmpos = bm.position;
				float d = PVector.dist(ybpos, bmpos);
				if(bm.faim() == true){
					if(d < bm.getR()){
						bm.eatFood();
						YeB.remove();
						bm.resetEating();
					}
				}
			}
			Iterator<Champi> Ch = champi.iterator();
			while(Ch.hasNext()){
				Champi ch = Ch.next();
				PVector chpos = ch.position;
				PVector bmpos = bm.position;
				float d = PVector.dist(chpos, bmpos);
				if(bm.faim() == true){
					if(d < bm.getR()){
						bm.eatFood();
						//Ch.remove();
						bm.resetEating();
					}
				}
			}
			Iterator<insect1M> i1M = insect1m.iterator();
			while(i1M.hasNext()){
				insect1M i1m = i1M.next();
				PVector i1mpos = i1m.position;
				PVector bmpos = bm.position;
				float d = PVector.dist(i1mpos, bmpos);
				if(bm.faim() == true){
					if(d < bm.getR()){
						bm.eatFood();
						i1M.remove();
						bm.resetEating();
					}
				}
			}
			Iterator<PapillonB> PaB = papillonb.iterator();
			while(PaB.hasNext()){
				PapillonB pab = PaB.next();
				PVector pabpos = pab.position;
				PVector bmpos = bm.position;
				float d = PVector.dist(pabpos, bmpos);
				if(bm.faim() == true){
					if(d < bm.getR()){
						bm.eatFood();
						PaB.remove();
						bm.resetEating();
					}
				}
			}
			Iterator<PapillonBchenille> PaBc = papillonbchenille.iterator();
			while(PaBc.hasNext()){
				PapillonBchenille pabc = PaBc.next();
				PVector pabcpos = pabc.position;
				PVector bmpos = bm.position;
				float d = PVector.dist(pabcpos, bmpos);
				if(bm.faim() == true){
					if(d < bm.getR()){
						bm.eatFood();
						PaBc.remove();
						bm.resetEating();
					}
				}
			}
			Iterator<SourisM> SoM = sourism.iterator();
			while(SoM.hasNext()){
				SourisM som = SoM.next();
				PVector sompos = som.position;
				PVector bmpos = bm.position;
				float d = PVector.dist(sompos, bmpos);
				if(bm.faim() == true){
					if(d < bm.getR()){
						bm.eatFood();
						SoM.remove();
						bm.resetEating();
					}
				}
			}
			Iterator<SourisF> SoF = sourisf.iterator();
			while(SoF.hasNext()){
				SourisF sof = SoF.next();
				PVector sofpos = sof.position;
				PVector bmpos = bm.position;
				float d = PVector.dist(sofpos, bmpos);
				if(bm.faim() == true){
					if(d < bm.getR()){
						bm.eatFood();
						SoF.remove();
						bm.resetEating();
					}
				}
			}
			Iterator<LapinM> LapM = lapinm.iterator();
			while(LapM.hasNext()){
				LapinM lapm = LapM.next();
				PVector lapmpos = lapm.position;
				PVector bmpos = bm.position;
				float d = PVector.dist(lapmpos, bmpos);
				if(bm.faim() == true){
					if(d < bm.getR()){
						bm.eatFood();
						LapM.remove();
						bm.resetEating();
					}
				}
			}
			Iterator<LapinF> LapF = lapinf.iterator();
			while(LapF.hasNext()){
				LapinF lapf = LapF.next();
				PVector lapfpos = lapf.position;
				PVector bmpos = bm.position;
				float d = PVector.dist(lapfpos, bmpos);
				if(bm.faim() == true){
					if(d < bm.getR()){
						bm.eatFood();
						LapF.remove();
						bm.resetEating();
					}
				}
			}



		}
		//////////////////////////


		//////FEMALE//////////////
		while(bearf.size() < 1){
			int totalbearf = 1;
			for(int i = 0; i < totalbearf; i++){
				PVector l = new PVector(parent.random(50, 3150), parent.random(50, 3150));
				DNAbear dnabear = new DNAbear(parent);
				bearf.add(new BearF(l,dnabear,parent));
			}
		}

		Iterator<BearF> BeF = bearf.iterator();
		while(BeF.hasNext()){
			BearF bef = BeF.next();
			bef.display(parent);
			bef.run(parent);
			bef.boundaries();
			
			if(bef.eatingTime() == false ){
				//bef.wander(parent);
				bef.mvtUpdate();
			}
			
			if(bef.dead() == true){
				BeF.remove();
			}
			
			Iterator<tileWater> tileW = tilewater.iterator();
			while(tileW.hasNext()){
				tileWater tilew = tileW.next();
				PVector target = new PVector(tilew.position.x, tilew.position.y);
				if(bef.isTooClose(target)){
					bef.goAway(target);
				}
			}
			
		}
		
		///////find food redberry///////// ////ajout des autres proie à faire
		if(bearf.size() > 0){
			float currentSmallest;
			float dist;
			for(int a = bearf.size()-1; a >=0; a--){
				BearF bf = bearf.get(a);
				
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(bf.faim() == false){
					bf.wander(parent);
				}
				if(bf.faim() == true){
					for(int b = redberry.size()-1; b >=0; b--){
						RedBerry rb = redberry.get(b);
						dist = ((bf.position.x - rb.position.x) * (bf.position.x - rb.position.x)) +
							   ((bf.position.y - rb.position.y) * (bf.position.y - rb.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = rb.position.x;
							target.y = rb.position.y;
						}
					}
					for(int c = yellowberry.size()-1; c >=0; c--){
						YellowBerry yb = yellowberry.get(c);
						dist = ((bf.position.x - yb.position.x) * (bf.position.x - yb.position.x)) +
							   ((bf.position.y - yb.position.y) * (bf.position.y - yb.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = yb.position.x;
							target.y = yb.position.y;
						}
					}
					for(int d = champi.size()-1; d >=0; d--){
						Champi ch = champi.get(d);
						dist = ((bf.position.x - ch.position.x) * (bf.position.x - ch.position.x)) +
							   ((bf.position.y - ch.position.y) * (bf.position.y - ch.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = ch.position.x;
							target.y = ch.position.y;
						}
					}
					for(int e = insect1m.size()-1; e >=0; e--){
						insect1M i1m = insect1m.get(e);
						dist = ((bf.position.x - i1m.position.x) * (bf.position.x - i1m.position.x)) +
							   ((bf.position.y - i1m.position.y) * (bf.position.y - i1m.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = i1m.position.x;
							target.y = i1m.position.y;
						}
					}
					for(int f = papillonb.size()-1 ; f >=0; f--){
						PapillonB pb = papillonb.get(f);
						dist = ((bf.position.x - pb.position.x) * (bf.position.x - pb.position.x)) +
							   ((bf.position.y - pb.position.y) * (bf.position.y - pb.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = pb.position.x;
							target.y = pb.position.y;
						}
					}
					for(int g = papillonbchenille.size()-1; g >=0; g--){
						PapillonBchenille pbc = papillonbchenille.get(g);
						dist = ((bf.position.x - pbc.position.x) * (bf.position.x - pbc.position.x)) +
							   ((bf.position.y - pbc.position.y) * (bf.position.y - pbc.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = pbc.position.x;
							target.y = pbc.position.y;
						}
					}
					for(int h = sourism.size()-1; h >=0; h--){
						SourisM sm = sourism.get(h);
						dist = ((bf.position.x - sm.position.x) * (bf.position.x - sm.position.x)) +
							   ((bf.position.y - sm.position.y) * (bf.position.y - sm.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = sm.position.x;
							target.y = sm.position.y;
						}
					}
					for(int i = sourisf.size()-1; i >=0; i--){
						SourisF sf = sourisf.get(i);
						dist = ((bf.position.x - sf.position.x) * (bf.position.x - sf.position.x)) +
							   ((bf.position.y - sf.position.y) * (bf.position.y - sf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = sf.position.x;
							target.y = sf.position.y;
						}
					}
					for(int j = lapinm.size()-1; j >=0; j--){
						LapinM lm = lapinm.get(j);
						dist = ((bf.position.x - lm.position.x) * (bf.position.x - lm.position.x)) +
							   ((bf.position.y - lm.position.y) * (bf.position.y - lm.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = lm.position.x;
							target.y = lm.position.y;
						}
					}
					for(int k = lapinf.size()-1; k >=0; k--){
						LapinF lf = lapinf.get(k);
						dist = ((bf.position.x - lf.position.x) * (bf.position.x - lf.position.x)) +
							   ((bf.position.y - lf.position.y) * (bf.position.y - lf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = lf.position.x;
							target.y = lf.position.y;
						}
					}

					bf.findPray(target);
				}
				
			}
		}
		/////////////////////////
		
		////////eat redberry////////
		Iterator<BearF> Bf = bearf.iterator();
		while(Bf.hasNext()){
			BearF bf = Bf.next();
			Iterator<RedBerry> ReB = redberry.iterator();
			while(ReB.hasNext()){
				RedBerry reb = ReB.next();
				PVector rbpos = reb.position;
				PVector bfpos = bf.position;
				float d = PVector.dist(rbpos, bfpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						ReB.remove();
						bf.resetEating();
					}
				}
			}
			Iterator<YellowBerry> YeB = yellowberry.iterator();
			while(YeB.hasNext()){
				YellowBerry yeb = YeB.next();
				PVector ybpos = yeb.position;
				PVector bfpos = bf.position;
				float d = PVector.dist(ybpos, bfpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						YeB.remove();
						bf.resetEating();
					}
				}
			}
			Iterator<Champi> Ch = champi.iterator();
			while(Ch.hasNext()){
				Champi ch = Ch.next();
				PVector chpos = ch.position;
				PVector bmpos = bf.position;
				float d = PVector.dist(chpos, bmpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						//Ch.remove();
						bf.resetEating();
					}
				}
			}
			Iterator<insect1M> i1M = insect1m.iterator();
			while(i1M.hasNext()){
				insect1M i1m = i1M.next();
				PVector i1mpos = i1m.position;
				PVector bmpos = bf.position;
				float d = PVector.dist(i1mpos, bmpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						i1M.remove();
						bf.resetEating();
					}
				}
			}
			Iterator<PapillonB> PaB = papillonb.iterator();
			while(PaB.hasNext()){
				PapillonB pab = PaB.next();
				PVector pabpos = pab.position;
				PVector bmpos = bf.position;
				float d = PVector.dist(pabpos, bmpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						PaB.remove();
						bf.resetEating();
					}
				}
			}
			Iterator<PapillonBchenille> PaBc = papillonbchenille.iterator();
			while(PaBc.hasNext()){
				PapillonBchenille pabc = PaBc.next();
				PVector pabcpos = pabc.position;
				PVector bmpos = bf.position;
				float d = PVector.dist(pabcpos, bmpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						PaBc.remove();
						bf.resetEating();
					}
				}
			}
			Iterator<SourisM> SoM = sourism.iterator();
			while(SoM.hasNext()){
				SourisM som = SoM.next();
				PVector sompos = som.position;
				PVector bmpos = bf.position;
				float d = PVector.dist(sompos, bmpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						SoM.remove();
						bf.resetEating();
					}
				}
			}
			Iterator<SourisF> SoF = sourisf.iterator();
			while(SoF.hasNext()){
				SourisF sof = SoF.next();
				PVector sofpos = sof.position;
				PVector bmpos = bf.position;
				float d = PVector.dist(sofpos, bmpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						SoF.remove();
						bf.resetEating();
					}
				}
			}
			Iterator<LapinM> LapM = lapinm.iterator();
			while(LapM.hasNext()){
				LapinM lapm = LapM.next();
				PVector lapmpos = lapm.position;
				PVector bmpos = bf.position;
				float d = PVector.dist(lapmpos, bmpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						LapM.remove();
						bf.resetEating();
					}
				}
			}
			Iterator<LapinF> LapF = lapinf.iterator();
			while(LapF.hasNext()){
				LapinF lapf = LapF.next();
				PVector lapfpos = lapf.position;
				PVector bmpos = bf.position;
				float d = PVector.dist(lapfpos, bmpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						LapF.remove();
						bf.resetEating();
					}
				}
			}
		}
		//////////////////////////
		
		/*
		////////eat yellowberry////////
		Iterator<BearF> Bef = bearf.iterator();
		while(Bef.hasNext()){
			BearF bf = Bef.next();
			Iterator<YellowBerry> YeB = yellowberry.iterator();
			while(YeB.hasNext()){
				YellowBerry yeb = YeB.next();
				PVector ybpos = yeb.position;
				PVector bfpos = bf.position;
				float d = PVector.dist(ybpos, bfpos);
				if(bf.faim() == true){
					if(d < bf.getR()){
						bf.eatFood();
						YeB.remove();
						bf.resetEating();
					}
				}
			}
		}
		//////////////////////////
		*/

		//////find female///////
		if(bearf.size() >= 1){
			float currentSmallest;
			float dist;
			for(int a = bearm.size()-1; a >=0; a--){
				BearM bm = bearm.get(a);
				PVector target = new PVector(0,0);
				currentSmallest = (worldH * worldH) + (worldW * worldW);
				if(bm.reproduceTime() == false){
					bm.wander(parent);
				}
				if(bm.reproduceTime() == true){
					for(int b = bearf.size()-1; b >= 0; b--){
						BearF bf = bearf.get(b);
						dist = ((bm.position.x - bf.position.x) * (bm.position.x - bf.position.x)) +
							   ((bm.position.y - bf.position.y) * (bm.position.y - bf.position.y));
						if( dist < currentSmallest){
							currentSmallest = dist;
							target.x = bf.position.x;
							target.y = bf.position.y;
						}
					}
					bm.findFemale(target);
				}
			}
		}
		
		/////reproduction///////
		for(int a = bearm.size()-1; a >= 0; a--){
			for(int b = bearf.size()-1; b >= 0; b--){
				BearM bm = bearm.get(a);
				BearF bf = bearf.get(b);
				PVector bmpos = bm.position;
				PVector bfpos = bf.position;
				float d = PVector.dist(bmpos, bfpos);
				if(d < bf.getR() && bf.reproduceTime() == true){  /////a changer juste pour test
					DNAbear momgenes = bm.getDNAbear();
					DNAbear dadgenes = bf.getDNAbear();
					DNAbear childdna = momgenes.crossover(dadgenes, parent);
					//if(parent.random(1) < 0.9){
						if(parent.random(10) > 5 && bearm.size() < 20){
							bearm.add(new BearM(bfpos, childdna, parent));
							bf.resetReproduce();
							bm.resetReproduce();
						}
						if(parent.random(10) < 5 && bearf.size() < 20){
							bearf.add(new BearF(bfpos, childdna, parent));
							bf.resetReproduce();
							bm.resetReproduce();
						}
					//}
				}
				
			}
		}
		//////////////////////////
		//////////////////////////


		//////////////////////////
		//////////////////////////
		
		/////////////////////
		
		
		////////////////////////
		
		/////////////////////////////////////
		/////////////////////////////////////
		/////les arbres sont visible a la fin pour apparaitre dessus tout le reste////
		Iterator<FruitTree> FT = fruittree.iterator();
		while(FT.hasNext()){
			FruitTree ft = FT.next();
			ft.display(parent);
		}
		
		Iterator<Feuillu> F = feuillu.iterator();
		while(F.hasNext()){
			Feuillu f = F.next();
			f.display(parent);
		}
		//////////////////////////////////////
		//////////////////////////////////////
		
		
		parent.popMatrix();
		
		player.PlayerMvt(parent);
		player.run(parent);
		
		parent.fill(255,0,0);
		parent.text("player x " + player.position.x + "\n" + "player y " + player.position.y, 10, 10);
		
		parent.text("redberry " + redberry.size(), 10, 35);
		
		parent.text("tilegrassl " + tilegrassl.size(), 10, 55);
		parent.text("tilegrassd " + tilegrassd.size(), 10, 65);
		parent.text("tilewater " + tilewater.size(), 10, 75);
		
		parent.text("papillonB " + papillonb.size(), 10, 85);
		parent.text("papillonB egg " + papillonbegg.size(), 10, 95);
		parent.text("papillonB chenille " + papillonbchenille.size(), 10, 105);
		
		parent.text("insect " + insect1m.size(), 10, 115);
		
		parent.text("sourisM " + sourism.size(), 10, 135);
		parent.text("sourisF " + sourisf.size(), 10, 145);
		
		parent.text("lapinM " + lapinm.size(), 10, 165);
		parent.text("lapinF " + lapinf.size(), 10, 175);	
		
		parent.text("ecureuil nid " + ecureuilnid.size(), 10, 195);
		parent.text("ecureuilM " + ecureuilm.size(), 10, 205);
		parent.text("ecureuilF " + ecureuilf.size(), 10, 215);
		
		parent.text("furet nid " + furetnid.size(), 10, 235);
		parent.text("furetM " + furetm.size(), 10, 245);
		parent.text("furetF " + furetf.size(), 10, 255);
		
		parent.text("blaireau nid " + blaireaunid.size(), 10, 275);
		parent.text("blaireauM " + blaireaum.size(), 10, 285);
		parent.text("blaireauF " + blaireauf.size(), 10, 295);
		
		parent.text("wolf nid " + wolfnid.size(), 10, 315);
		parent.text("wolfM " + wolfm.size(), 10, 325);
		parent.text("wolfF " + wolff.size(), 10, 335);
		
		parent.text("boarM " + boarm.size(), 10, 355);
		parent.text("boarF " + boarf.size(), 10, 365);
		
		parent.text("fox nid " + foxnid.size(), 10, 385);
		parent.text("foxM " + foxm.size(), 10, 395);
		parent.text("foxF " + foxf.size(), 10, 405);
		
		parent.text("bearM " + bearm.size(), 10, 425);
		parent.text("bearF " + bearf.size(), 10, 435);
		
		
		
		parent.text("fps " + parent.frameRate, 10, 505);
		
	}
}
