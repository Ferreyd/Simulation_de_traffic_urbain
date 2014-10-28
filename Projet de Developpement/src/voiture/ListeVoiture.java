/**
 * 
 */
package voiture;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComponent;

import map.MapCalcul;

/**
 * @author Lapenta Giuseppe
 *
 */
public class ListeVoiture extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4484592121585737735L;
	ArrayList<Voiture> listeVoiture;
	MapCalcul mapCalcul;

	/**
	 * Constructeur
	 * @param mapCalcul Cate partie calcul
	 */
	public ListeVoiture(MapCalcul mapCalcul){
		listeVoiture = mapCalcul.nbrVoiture();
		this.mapCalcul = mapCalcul;
	}
	/**
	 * Liste de couleur des voitures
	 * @return la liste des couleurs des voitures 
	 */
	public ArrayList<Color> couleur(){
		ArrayList<Color> couleur = new ArrayList<Color>();
		for(Voiture voit : listeVoiture){
			couleur.add(voit.getCouleur());
		}
		return couleur;

	}
	/**
	 * Liste des points d'arrivé
	 * @return la liste de spoint d'arrivés
	 */
	public ArrayList<Point> pArrive(){
		ArrayList<Point> pArrive = new ArrayList<Point>();

		for(Voiture voit : listeVoiture){
			pArrive.add(voit.getArrive());
		}
		return pArrive;
	}

	public ArrayList<Voiture> getListeVoiture(){
		return listeVoiture;
	}

	public void  paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D gr = (Graphics2D) g;

		Iterator<Voiture> iVoit  = listeVoiture.iterator();

		while(iVoit.hasNext()){ 

			Voiture voit = (Voiture) iVoit.next();

			gr.setColor(voit.getCouleur());
			gr.setBackground(voit.getCouleur());
			gr.fillRect((int)voit.getDepart().getX(),(int)voit.getDepart().getY(), (mapCalcul.getTaillePx())/mapCalcul.getTaille() ,(mapCalcul.getTaillePx())/mapCalcul.getTaille());
			gr.fillOval((int)voit.CoorGrilleToPx(voit.getArrive()).getX(), (int)voit.CoorGrilleToPx(voit.getArrive()).getY(), (mapCalcul.getTaillePx()/mapCalcul.getTaille()) /2 ,(mapCalcul.getTaillePx()/mapCalcul.getTaille()) /2);

		}

	}

}
