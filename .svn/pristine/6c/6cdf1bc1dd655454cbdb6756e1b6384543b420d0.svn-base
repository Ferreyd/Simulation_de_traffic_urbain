package aStar;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import map.Monde;

/**
 * Cette classe est appelee par les autres pour acceder à l'algorithme A* de facon simple.
 * 
 * Elle s'utilise de la façon suivante :
 * On appelle le constructeur avec la map, le point de depart et le point d arrive.
 * 
 * @author Nicolas-Portable
 *
 *
 */
public class ChoixChemin {

	/**
	 * Point de depart de la voiture
	 */
	private Point depart;
	/**
	 * Point d'arrive de la voiture
	 */
	private Point arrive;

	/**
	 * Matrice avec les coeficients nécéssaire pour diriger la voiture
	 */
	private Monde monde;
	/**
	 * Constructeur de la classe ChoixDirection permettant d'appeler l'algorithme A*
	 * @param depart Le point de depart de la voiture 
	 * @param arrive Le point d arrive de la voiture
	 * @param monde La map du simulateur
	 */
	public ChoixChemin(Point depart, Point arrive, Monde monde) {
		this.depart = depart;
		this.arrive = arrive;
		this.monde = monde;
	}

	private SuccessorComputer<Point> successorComputer = new SuccessorComputer<Point>() {
		/**
		 * Doit renvoyer les points a gauche, a droite, en haut en bas du noeud passé en paramètre
		 * en supprimant la position du noeud parent de ce noeud
		 * 
		 * @param node le noeud dont on cherche les voisins
		 * @return la liste des voisins du noeud diminué de la position du parent
		 */
		@Override
		public Collection<Point> computeSuccessor(final Node<Point> node) {
			
			final List<Point> resultat = new ArrayList<Point>();
			
			final Point index = node.getIndex();
			final int x = (int) index.getX();
			final int y = (int) index.getY();
			int coef = -1;
			
			//Si le point n'est pas dans la map
		if(x >= monde.getMonde().length || x < 0 || y >= monde.getMonde().length || y < 0){ 
		
				resultat.remove(node.getParent().getIndex());
				return resultat; // on enleve le point de la liste de points
			}
			
			try{
				coef = monde.getMonde()[x][y];
			}catch(Exception e){
				System.out.println(" Erreur : Point non correcte");
				System.out.println("Depart : x = " + x + " y = " + y + " coef = " + coef);
				System.out.println("Peut etre une erreur dans le point de depart ou d'arrive.");
			}
				
			/**
			 * 
			 * coefficient possible
			 * 1  ==> 0001 Ouest
			 * 2  ==> 0010 Est
			 * 3  ==> 0011 Est et Ouest
			 * 4  ==> 0100 Sud
			 * 5  ==> 0101 Sud et Ouest
			 * 6  ==> 0110 Sud et Est
			 * 7  ==> 0111 Sud et Est et Ouest
			 * 8  ==> 1000 Nord
			 * 9  ==> 1001 Nord et Ouest
			 * 10 ==> 1010 Nord et Est
			 * 11 ==> 1011 Nord et Est et Ouest
			 * 12 ==> 1100 Nord et Sud
			 * 13 ==> 1101 Nord et Sud et Ouest
			 * 14 ==> 1110 Nord et Sud et Est
			 * 15 ==> 1111 Nord et Sud et Est et Ouest
			 */
			if(coef > 0 && coef < 16 && node != null){// si la case possede un coefficient
				// deplacement à l'ouest 1,3,5,6,7,9,11,13,15
				if (x <= monde.getTaille() && 
						(coef == 1 || coef == 3 || coef == 5 || coef == 7 || coef == 9 || coef == 11 || coef == 13 || coef == 15)) { 
					resultat.add(new Point(x - 1, y));
				}
				// deplacement à l'est 2,3,6,7,10,11,14,15
				if (x >= 0 && 
						(coef == 2 || coef == 3 || coef == 6 || coef == 7 || coef == 10 || coef == 11 || coef == 14 || coef == 15)) {
					resultat.add(new Point(x + 1, y));
				}
				// deplacement au sud 4,5,6,7,12,13,14,15
				if (y >= 0 && 
						(coef == 4 || coef == 5 || coef == 6 || coef == 7 || coef == 12 || coef == 13 || coef == 14 || coef == 15)) { 
					resultat.add(new Point(x, y + 1));
				}
				// deplacement au nord 8,9,10,11,12,13,14,15
				if (y <= monde.getTaille() && 
						(coef == 8 || coef == 9 || coef == 10 || coef == 11 || coef == 12 || coef == 13 || coef == 14 || coef == 15)) { 
					resultat.add(new Point(x, y - 1));
				}
				if(node.getParent() != null) {
					resultat.remove(node.getParent().getIndex());
				}
			}
			if(coef == 0){
				try{
					resultat.remove(node.getParent().getIndex());
				}catch(Exception e){
					e.getStackTrace();
				}
				
			}
			return resultat;
		}
	};

	final NodeFactory<Point> nodeFactory = new NodeFactory<Point>() {
		@Override
		/**
		 * Renvoit la distance réel entre les 2 index, sachant que ce sont des index consecutifs. En gros l'idée,
		 *  est que si les 2 index sont identiques , la méthode renvoit 0 Si le 2eme index est accessible, 
		 *  on renvoit un chiffre représentant la difficulité d'accès >= 1 Si le 2emem index est inaccessible, 
		 *  on renvoit Double.MAX_VALUE Attention, le parentIndex peut etre null
		 */
		protected double computeReel(final Point parentIndex, final Point index) {
			try{
				
				if(index.getX() > monde.getTaille() || index.getY() > monde.getTaille()){
					return 0;
				}
				if(parentIndex != null && parentIndex.equals(index)) {
					return 0;
				}
				if((int)index.getX() <= monde.getMonde().length){
					// s'il y a coefficient aux coordonées de l'index
	
					if(
							index.getX() < 0 ||	index.getX() > monde.getTaille() ||
							index.getY() < 0 ||	index.getY() > monde.getTaille()
					        ){ // si on est en dehors de la matrice
						
					}
					else if(
							(monde.getMonde()[(int)index.getX()][(int)index.getY()]) > 0 ||
							(monde.getMonde()[(int)index.getX()][(int)index.getY()]) < 16
							){
	
						return 1;
					}
				}
			}catch(Exception e){
				
			}

			return Double.MAX_VALUE;
		}

		@Override
		protected double computeTheorique(final Point index, final Point goal) {
			// Distance de manhattan
			return Math.abs(index.getX()-goal.getX()) + Math.abs(index.getY()-goal.getY());
		}
	};

	/**
	 *  Méthode qui permet d'avoir le trajet de la voiture
	 * @return Une ArrayList<Point> tracant le chemin de la voiture dans la matrice
	 */
	public ArrayList<Point> getChemin(){
		Astar<Point> astart = new Astar<Point>(successorComputer, nodeFactory, monde);
		ArrayList<Point> result = astart.compute(depart, arrive);
		return result;
	}


	


}
