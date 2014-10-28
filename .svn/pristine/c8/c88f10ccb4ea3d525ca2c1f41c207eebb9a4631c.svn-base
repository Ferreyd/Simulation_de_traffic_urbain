package voiture;

import java.awt.Color;
import map.MapCalcul;

import java.awt.Point;
import java.util.ArrayList;



/**
 * 
 * Modelisation d'une voiture
 *
 */
/**
 * @author Lapenta Giuseppe
 *
 */
public class Voiture {//extends JComponent{
	/**
	 * Point de depart de la voiture
	 */
	protected Point depart;
	/**
	 * Point d'arrive
	 */
	protected Point arrive;
	/**
	 * Vitesse
	 */
	protected int vitesse;
	/**
	 * couleur
	 */
	private Color couleur;

	MapCalcul mapCalcul;
	ArrayList<Point> chemin;
	int iterateur;
	MapCalcul map;
	public int getIterateur() {
		return iterateur;
	}
	public void setIterateur(int iterateur) {
		this.iterateur = iterateur;
	}
	/*
	 * Getteurs and Setteurs
	 */
	public Point getDepart() {return depart;}
	public  void setDepart(Point depart) {
		this.depart = depart;
	}

	public Point getArrive() {return arrive;}
	public void setArrive(Point arrive) {this.arrive = arrive;}
	public int getVitesse() {return vitesse;}
	public void setVitesse(int vitesse) {this.vitesse = vitesse;}
	public Color getCouleur() {return couleur;}
	public void setCouleur(Color couleur) {this.couleur = couleur;}	
	/**
	 * Constructeur 
	 * 
	 * @param depart Point de depart
	 * @param arrive Point d'arrive
	 * @param vitesse Vitesse initiale de la voiture
	 * @param couleur Couleur de la voiture
	 * @param map Carte sur laquelle la voiture va evoluer
	 * @param chemin Liste de points determiannt le chemin de la voiture
	 */
	public Voiture(Point depart, Point arrive, int vitesse, Color couleur,  MapCalcul map, ArrayList<Point> chemin) {


		this.iterateur = 1;
		this.vitesse = vitesse;
		this.couleur = couleur;
		this.map = map;
		this.chemin = chemin;
		this.mapCalcul = map;
		this.depart = new Point((int)this.CoorGrilleToPx(depart).getX(),(int)this.CoorGrilleToPx(depart).getY());
		this.arrive = arrive;

	}
	public ArrayList<Point> getChemin() {
		return chemin;
	}
	public void setChemin(ArrayList<Point> chemin) {
		this.chemin = chemin;
	}


	public MapCalcul getMap() {
		return map;
	}

	/**
	 * Convertit les coordonnées de la grille en pixel
	 * @param depart Point de depart de la voiture
	 * @return Point de depart convertit en pixel
	 */
	public Point CoorGrilleToPx(Point depart){
		return new Point((int)(depart.getX())*(int)(mapCalcul.getTaillePx()/mapCalcul.getTaille()),
				(int) (depart.getY())*(int)(mapCalcul.getTaillePx()/mapCalcul.getTaille()));
	}


	/**
	 * Convertit les coordonnées de  pixel en grille
	 * @return Point de depart convertit en grille
	 */
	public Point CoorPxToGrille(){

		return new Point((int) (this.getDepart().getX())/ (int)(mapCalcul.getTaillePx()/mapCalcul.getTaille()), 
				(int)((this.getDepart().getY()) / (int)((mapCalcul.getTaillePx())/mapCalcul.getTaille())) );

	}
	/**
	 * Convertit les coordonnées de  pixel en grille avec un point mmis en paramettre
	 * @param Point a convertir
	 * @return Point convertit en grille
	 */
	public Point CoorPxToGrille(Point point){

		return new Point((int) (this.getDepart().getX())/ (int)(mapCalcul.getTaillePx()/mapCalcul.getTaille()), (int)((this.getDepart().getY()) / (int)((mapCalcul.getTaillePx())/mapCalcul.getTaille())) );

	}


	/**
	 * Cree une couleur aleatoire
	 */
	public void couleurAlea(){
		int R = 0;
		int G = 0;
		int B = 0;
		java.util.Random rand = new java.util.Random();
		R = rand.nextInt(256);
		G = rand.nextInt(256);
		B = rand.nextInt(256);
		couleur = new Color(R,G,B);
	}


	/**
	 * Fait avancer la voiture a droite
	 */
	public void avancerDroite(){

		this.setDepart(new Point((int)this.getDepart().getX()+(mapCalcul.getTaillePx())/mapCalcul.getTaille(),(int) this.getDepart().getY()));

	}
	
	/**
	 * Fait avancer la voiture a gauche
	 */
	public void avancerGauche(){

		this.setDepart(new Point((int)this.getDepart().getX() - (mapCalcul.getTaillePx())/mapCalcul.getTaille(),(int) this.getDepart().getY()));


	}
	
	/**
	 * Fait avancer la voiture an haut
	 */
	public void avancerHaut(){

		this.setDepart(new Point((int)this.getDepart().getX(),(int) this.getDepart().getY() - (mapCalcul.getTaillePx())/mapCalcul.getTaille()));

	}
	
	/**
	 * Fait avancer la voiture en bas
	 */
	public void avancerBas(){

		this.setDepart(new Point((int)this.getDepart().getX(),(int) this.getDepart().getY() + (mapCalcul.getTaillePx())/mapCalcul.getTaille()));

	}

}