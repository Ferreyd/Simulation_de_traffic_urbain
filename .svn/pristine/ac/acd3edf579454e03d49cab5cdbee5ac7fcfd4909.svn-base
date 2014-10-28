package map;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import voiture.Voiture;
import aStar.ChoixChemin;


/**
 * 
 * Controleur Map
 *
 */
public class MapCalcul extends Monde {

	private int cptAcc;
	private int taillePx;
	private int nbrVoiture;

	/**
	 * Initalialisation des matrices du monde et de la positon des voitures.
	 * @param taille taille de la matrice
	 * @param nbrVoiture nombre de voiture
	 * @param taillePx taille en pixel
	 */
	public MapCalcul(int taille, int nbrVoiture, int taillePx){
		this.cptAcc = 0;
		this.taillePx = taillePx;
		this.nbrVoiture = nbrVoiture;
		this.taille = taille;
		this.monde = new int[taille][taille];
		this.posVoiture = new boolean[taille][taille];

		for(int i = 0; i< monde.length; i++){
			for(int j = 0; j < taille ; j++){
				this.monde[i][j] = 0; 
				this.posVoiture[i][j] = false; // par défaut , aucune voiture ne se trouve sur la map

			}

		}
	}
	
	
	/**
	 * Genere automatiquement une map de test
	 */
public void initiMap(){
		
		int j = 0;
		int k = 0;
		while(j <= this.taille - 1){
			
			for(int i = 1; i <= this.taille - 1; i++){
				monde[i][j]= 15;
			}
			j = j+4;
		}
		while(k <= this.taille - 1){
			
			for(int l = 0; l <= this.taille - 1; l++){
				monde[k][l]= 15;
			}
			k= k+4;
		}
	}
	public int getCptAcc() {
		return cptAcc;
	}

	public void setCptAcc(int cptAcc) {
		this.cptAcc = cptAcc;
	}

	public int getTaillePx() {
		return taillePx;
	}

	public void setTaillePx(int taillePx) {
		this.taillePx = taillePx;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int[][] getMap() {
		return monde;
	}
	
	public void setMap(int[][] monde){
		this.monde = monde;
	}
	
	
	

	
 /**
  * creer une liste de voiture de la taille voulu ayant toute un point de depart et d'arrivé different
  * @return ListeVoiture
  */
	public ArrayList<Voiture> nbrVoiture(){
		ArrayList<Voiture> listeVoiture = new ArrayList<Voiture>();

		int monde[][] = this.getMonde();

		Voiture voiture;
		int aleaX = 0;
		int aleaY = 0;
		int aleap3X = 0;
		int aleap3Y= 0;
		java.util.Random rand = new java.util.Random();

		while(listeVoiture.size() < nbrVoiture){

			aleaX = rand.nextInt(this.getTaille()-1);
			aleaY = rand.nextInt(this.getTaille()-1);
			
			aleap3X = rand.nextInt(this.getTaille()-1);
			aleap3Y = rand.nextInt(this.getTaille()-1);
			if(monde[aleaX][aleaY] > 0 && monde[aleap3X][aleap3Y] > 0){ // s'il y a un coefficent à la case tiré au hasard
				Point p1 = new Point(aleaX, aleaY);
				Point p3 = new Point(aleap3X, aleap3Y);
				ArrayList<Point> chemin = new ChoixChemin(p1, p3, this).getChemin();

				if(chemin.size() > 0){ // si le chemin que doit prendre la voiture n'est pas vide
					voiture = new Voiture(p1, p3 ,50, Color.red, this, new ChoixChemin(p1, p3, this).getChemin());
					voiture.couleurAlea();
					listeVoiture.add(voiture);	

				}
			}
		}
		return listeVoiture;
	}

	public int getNbrVoiture() {
		return nbrVoiture;
	}

	public void setNbrVoiture(int nbrVoiture) {
		this.nbrVoiture = nbrVoiture;
	}
}

