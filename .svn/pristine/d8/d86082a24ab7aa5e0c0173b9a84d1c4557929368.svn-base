package thread;

import java.awt.Point;

import java.util.ArrayList;
import java.util.Iterator;

import fenetre.Fenetre;

import voiture.Voiture;

import map.MapCalcul;
import map.MapGraphique;


import aStar.ChoixChemin;

/**
 * @author Lapenta Giuseppe
 *
 */
public class MonThread extends Thread{


	private MapCalcul mapCalcul;
	private MapGraphique mapGraphique ;
	private ArrayList<Voiture> listeVoiture;
	private boolean isRunnable;
	private double vitesse = (1.0 / 25) * 1000;
	private int cptAccident;
	private Fenetre fenetre;
	//initialisation de tout ce qu'on a besoin, principalement les voiture, et la map
	/**
	 * Constructeur
	 * @param mapCalcul la carte partie Calcul
	 * @param mapGraphique la carte partie Graphique
	 * @param fenetre la fenetre
	 * @param listeVoiture la liste des voitures
	 */
	public MonThread(MapCalcul mapCalcul, MapGraphique mapGraphique, Fenetre fenetre,ArrayList<Voiture> listeVoiture){
		this.mapCalcul = mapCalcul;
		this.mapGraphique = mapGraphique;
		this.listeVoiture = listeVoiture; // la liste de voiture mis a jour.
		this.isRunnable = true;
		this.fenetre = fenetre;
	}
	/**
	 * a l'execution, defini le deplacement des voiture
	 * 
	 */
	@Override
	public void run() {
		Iterator<Voiture> iVoit;

		while(listeVoiture.size() >= 1){ //Boucle infini, pour que l'animation ne s'arrete pas
			mapGraphique.repaint();
			iVoit  = listeVoiture.iterator();
			while(iVoit.hasNext() && isRunnable == true){
				//on parcour la liste de toute les voitures,
				Voiture calc = (Voiture) iVoit.next(); 

				if(calc.getChemin().size() >= 1 && calc.getChemin().size() > calc.getIterateur() ){ // si on est pas arrivé au point d'arrivé 
					if(isNextVoiture(calc.getChemin().get(calc.getIterateur())) == false){ 
						mapCalcul.setPosVoiture((int)calc.CoorPxToGrille().getX(), (int)calc.CoorPxToGrille().getY(),false); // on met la position actuel de la voiture courante à faux

						choixDirection(calc.getChemin().get(calc.getIterateur()), calc);

						calc.setIterateur(calc.getIterateur()+1);

						mapCalcul.setPosVoiture((int)calc.CoorPxToGrille().getX(), (int)calc.CoorPxToGrille().getY(),true); // on met la position actuel de la voiture courante à faux

					}else{ // on recalcul le chemin de la voiture
						cptAccident = (cptAccident + 1);
						fenetre.setCptAcc("Compteur accident :" +(int) cptAccident/2);
						recalculCheminWith0(calc);
						if(calc.getChemin().size() < 1){
							recalculChemin(calc);
						}
					}
				}

				if(calc.CoorPxToGrille().equals(calc.getArrive())){ //si la voiture est a l'arrivé on la supprimer
					this.modifieVoiture(calc);

				}
			}

			mapGraphique.repaint();
			try {
				Thread.sleep((int)vitesse);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	/**
	 * Initialise si le thread peut etre executer ou non
	 * @param bool vrai ou faux
	 */
	public void setIsRunnable(boolean bool){
		this.isRunnable = bool;
	}
	/**
	 * Choix de la direction de la voiture. Et ajoute la cordonnées de la voiture dans la matrice de position des voitures
	 * @param point prochain point
	 * @param voiture la voiture courante
	 */
	private void choixDirection(Point point,Voiture voiture){
		//si il n'y pas de voiture au prochain point on peut avancer

		if((int) point.getX() == voiture.CoorPxToGrille().getX() + 1){ // Avance à droite
			voiture.avancerDroite();// on fait avancer la voiture à droite

		}
		else if((int) point.getY() == voiture.CoorPxToGrille().getY() + 1){// on avance en bas
			voiture.avancerBas();

		}
		else if((int) point.getX() == voiture.CoorPxToGrille().getX() - 1){ // on avance à gauche
			voiture.avancerGauche();

		}
		else if((int) point.getY() == voiture.CoorPxToGrille().getY() - 1){ // on avance en haut
			voiture.avancerHaut();


		}


	}
	/**
	 * Recalcule le chemin d'une voiture passé en parametre
	 * Cette méthode change le coeficient de la map puis remet l'ancienne valeur afin de forcer l'algorithme de
	 * trajet à prendre un autre chemin
	 * @param calc la voiture passé en parametre
	 */
	private void recalculCheminWith0(Voiture calc){

		int oldCoef; // ancien coefficient

		Point point = new Point((int)calc.getChemin().get(calc.getIterateur()).getX() , (int)calc.getChemin().get(calc.getIterateur()).getY()); // coordonnée du prochain point

		int[][] map = mapCalcul.getMonde(); 

		oldCoef = mapCalcul.getMonde()[(int) point.getX()][(int) point.getY()]; // on sauvegarde l'ancien coefficient
		map[(int) point.getX()][(int) point.getY()] = 0; // on met le point suivant à 0
		mapCalcul.setMonde(map); // on change la map
		ChoixChemin chemin = new ChoixChemin(calc.CoorPxToGrille(), calc.getArrive(), mapCalcul);
		calc.getChemin().clear(); // on efface la liste de chemin courant
		calc.setIterateur(1); // on met l'iterateur sur le  premier point
		calc.setChemin(chemin.getChemin()); //on met la nouvelle liste de chemin dans la liste de hemin de la voiture passé en parametre
		map[(int) point.getX()][(int) point.getY()] = oldCoef; // on rénitinialise l'ancien coefficent
		mapCalcul.setMonde(map); // on rechange la map

	}

	/**
	 * Cette methode recalcul le chemin entre le point Courant et le d'arrivé, 
	 * cette methode evite un bug lier a l'iterateur et permet a toute les voiture de bien fonctionner
	 * 
	 * @param calc
	 */
	void recalculChemin(Voiture calc){

		ChoixChemin chemin = new ChoixChemin(calc.CoorPxToGrille(), calc.getArrive(), mapCalcul);
		calc.getChemin().clear(); // on efface la liste de chemin courant
		calc.setIterateur(1); // on met l'iterateur sur le  premier point
		calc.setChemin(chemin.getChemin()); //on met la nouvelle liste de chemin dans la liste de hemin de la voiture passé en parametre

	}

	/**
	 * Méthode qui teste s'il y a une voiture au prochaine point
	 * @param point le prochain point de passage de la voiture
	 * @return vrai si une voiture est au prochain point , faux sinon
	 */
	private boolean isNextVoiture(Point point){
		if(mapCalcul.getPosVoiture()[(int)point.getX()][(int)point.getY()] == true){
			return true;
		}else{
			return false;
		}

	}

	public boolean getIsRunnable(){
		return isRunnable;
	}
	public int getVitesse() {
		return (int)vitesse;
	}
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
	public MapCalcul getMapCalcul() {
		return mapCalcul;
	}
	public void setMapCalcul(MapCalcul mapCalcul) {
		this.mapCalcul = mapCalcul;
	}
	public MapGraphique getMapGraphique() {
		return mapGraphique;
	}
	public void setMapGraphique(MapGraphique mapGraphique) {
		this.mapGraphique = mapGraphique;
	}
	public ArrayList<Voiture> getListeVoiture() {
		return listeVoiture;
	}
	public void setListeVoiture(ArrayList<Voiture> listeVoiture) {
		this.listeVoiture = listeVoiture;
	}

	/**
	 * Modifie les champs d'une voiture pour la redessiner à un autre emplacement sans la retirer de la liste de voiture 
	 * permet d'éviter les erreurs de concurrences
	 * @param calc la voiture à modifier
	 * @return la voiture modifier
	 */
	private  Voiture modifieVoiture(Voiture calc){
		int monde[][] = mapCalcul.getMonde();

		int departX = 0;
		int departY = 0;
		int arriveX = 0;
		int arriveY= 0;

		java.util.Random rand = new java.util.Random();



		arriveX = rand.nextInt(mapCalcul.getMonde().length-1);
		arriveY = rand.nextInt(mapCalcul.getMonde().length-1);

		if(monde[departX][departY] > 0 && monde[arriveX][arriveY] > 0){ // s'il y a un coefficient au coordonnées d'arrivées
			Point depart = new Point(calc.getArrive());
			Point arrive = new Point(arriveX, arriveY);
			ArrayList<Point> chemin = new ChoixChemin(depart, arrive, mapCalcul).getChemin();
			do{
				if(chemin.size() > 0){
					depart = calc.CoorGrilleToPx(depart); // on fait une conversion des coordonées de depart pour que la voiture soit plassé correctement
					calc.setDepart(depart);
					calc.setArrive(arrive);
					calc.setChemin(chemin);
					calc.setIterateur(1); // fait redemarer l iterateur de la voiture 
				}else{
					arriveX = rand.nextInt(mapCalcul.getMonde().length-1);
					arriveY = rand.nextInt(mapCalcul.getMonde().length-1);
					arrive = new Point(arriveX, arriveY);
					chemin = new ChoixChemin(depart, arrive, mapCalcul).getChemin();
				}

			}while(chemin.size() <= 0);
		}
		return calc;
	}
}





