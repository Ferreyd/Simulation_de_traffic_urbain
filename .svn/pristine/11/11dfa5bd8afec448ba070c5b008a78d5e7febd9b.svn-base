package map;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JComponent;
import javax.swing.OverlayLayout;
import javax.swing.JPanel;


import elementgraphique.Ligne;
import elementgraphique.Route;
import fenetre.Fenetre;
import voiture.ListeVoiture;


/**
 * 
 * Modelisation d'une Map : View
 *
 */
/**
 * @author Lapenta Giuseppe
 *
 */
public class MapGraphique extends JPanel{



	private static final long serialVersionUID = 3230617590777220387L;

	private Dimension dimension;
	private ListeVoiture listVoit;
	private int taillepx;
	boolean direction;

	/**
	 * Constructeur de la map partie Graphique
	 * @param mapCalcul la map partie calcul
	 * @param direction affichage ou non des fleches sur les cases de la map
	 */
	public MapGraphique(MapCalcul mapCalcul, boolean direction){

		this.taillepx = mapCalcul.getTaillePx();
		this.setSize(taillepx+20,taillepx+90); //pour avoir de la marge
		dimension = this.getSize();
		this.setSize(dimension);
		this.setLocation(0,0);
		this.setSize(this.getHeight(), this.getWidth());
		LayoutManager overlay = new OverlayLayout(this);
		this.setLayout(overlay);
		this.direction = direction;
		
		this.setVisible(true);

	}
	/**
	 * Getteurs and Setteurs
	 */
	public ListeVoiture getListVoit(){ return listVoit; }
	public Dimension getDimension() {return dimension;}
	public void setDimension(Dimension dimension) {this.dimension = dimension;}





	/**
	 * Initialisation des de l'objet map Graphique en fonction de Map calcul.
	 * dessine les lignes, ajoute les route avec direction ou pas et ajoute les cercle d'arrivé
	 * @param MapCalcul tailleMap
	 * 
	 */
	public void init(MapCalcul mapCalcul){

		listVoit = new ListeVoiture(mapCalcul);
		Route route = new Route(mapCalcul,direction);

		this.setBackground(Color.white);
		int[][] monde = mapCalcul.getMonde();
		int boucle = (this.taillepx) / mapCalcul.getTaille();
		for(int i = 0; i<= (this.taillepx); i = i+boucle){ //on fait une grille. pour l'instant les valeurs sont entiere
			this.add(new Ligne(i, 0, i ,(this.taillepx)));
			// il faudra a terme tout mettre en asbolu par rapport 
		}									//a la taille de la fenetre
		for(int j = 0; j<= (this.taillepx); j= j+boucle){

			this.add(new Ligne(0, j,(this.taillepx),j));
		}
		
		for(int i = 0; i< monde.length; i++){
			for(int j = 0; j < monde.length ; j++){
				
				mapCalcul.getPosVoiture()[i][j] = false; // par défaut , aucune voiture ne se trouve sur la map

			}
		}
		
		this.add(route);
		this.add(listVoit);
		this.setComponentZOrder(route, 3);
		this.setComponentZOrder(listVoit, 1);
		
		this.repaint();
		this.setVisible(true);

	}

	public JPanel getMap() {
		return this;
	}

	/**
	 * regenere en entier la Map graphique, a utiliser avec parsimonie pour bonne performance
	 */
	public  void update(){this.updateUI();}

	/**
	 * Ajoute le JComponent a l'objet map grahique
	 * @param JComponent v1
	 */
	public void addMap(JComponent v1){
		this.add(v1);
		System.out.println(v1);
		this.repaint();

	}
	/**
	 * supprime un JComponent de la map
	 * @param v1
	 */
	public void removeMap(JComponent v1){ this.remove(v1); }
	/**
	 * supprime la map
	 */
	public void remove(){ this.removeAll(); }

	/**
	 * Le projet de lance avec cette méthode
	 * @param args
	 */
	public static void main(String args[]) {

		@SuppressWarnings("unused")
		Fenetre fenetre = new Fenetre();
		

	}



}
