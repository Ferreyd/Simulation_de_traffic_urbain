package map;
import java.awt.Color;




/**
 * 
 * Modelisation d'une Map modéle MVC : Model
 *
 */
public abstract class  Monde{
	/**
	 * Initialisation de la matrice monde : 
	 * 1 = 0001 c a d : direction Ouest possible
	 * 2 = 0010 c a d : direction Sud possible
	 * ...
	 * 10 = 1010 c a d : direction Nord et Sud possible.
	 * etc...
	 */
	protected int taille; //nombre de carré d'un coté, Hauteur = largeur
	protected int[][] monde; //matrice de int
	protected boolean[][] posVoiture; //matrice de boolean définissant si une voiture se trouve aux coordonnées x,y
	private Color couleurGrille;
	int nbrVoiture;
	/*
	 * Getteur and setteur
	 */
	/**
	 * Retourne le nombre de voiture
	 * @return le nombre de voiture
	 */
	int getNbrVoiture(){return nbrVoiture; }
	/**
	 * Initialise le nombre de voiture
	 * @param nbr le nombre de voiture
	 */
	public void setNbrVoiture(int nbr) {this.nbrVoiture = nbr;}
	/**
	 * La taille de la map
	 * @return la taille de la map
	 */
	public int getTaille() { return taille;}
	/**
	 * Initialise la taille de la carte
	 * @param taille la taille de la carte
	 */
	public void setTaille(int taille) {this.taille = taille;}

	/**
	 * Retourne le nombre de voiture
	 * @return le nombre de voiture
	 */
	public int[][] getMonde() {return monde;}
	/**
	 * Initialise une carte pour la simulation
	 * @param monde le monde a simuler
	 */
	public void setMonde(int[][] monde) {this.monde = monde;}

	/**
	 * Retourne le nombre de voiture
	 * @return le nombre de voiture
	 */
	public boolean[][] getPosVoiture() {return posVoiture;}
	/**
	 * Initialise la map de position des voitures
	 * @param posVoiture la map de position des voitures
	 */
	public void setPosVoiture(boolean[][] posVoiture) {	this.posVoiture = posVoiture;}
	/**
	 * initalise la position de la voiture a des coordonnées précise
	 * @param x abscisse
	 * @param y ordonnée
	 * @param val boolean a mettre
	 */
	public void setPosVoiture(int x, int y, boolean val){ this.posVoiture[x][y] = val;}
	/**
	 * Retourne le nombre de voiture
	 * @return le nombre de voiture
	 */
	public Color getCouleurGrille() {
		return couleurGrille;
	}
	/**
	 * Initialise la couleur de la grille
	 * @param couleurGrille couleur a donner a la grille
	 */
	public void setCouleurGrille(Color couleurGrille) {
		this.couleurGrille = couleurGrille;
	}










}
