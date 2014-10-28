package elementgraphique;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import java.awt.geom.Line2D;

import javax.swing.JComponent;



public class Ligne extends JComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5366088572063284316L;
	Point p1;
	Point p2;
	protected Color couleurTrait = Color.black;

	/**
	 * Constructeur
	 * @param p1 Point de depart
	 * @param p2 Point d'arrive
	 */
	Ligne(Point p1, Point p2){
		super();
		this.p1 = p1;
		this.p2 = p2;

	}
	/**
	 * Constructeur
	 * @param abs1 abscisse 1
	 * @param ord1 ordonnée 1
	 * @param abs2 abscisse 2
	 * @param ord2 ordonnée 2
	 */
	public Ligne(int abs1, int ord1, int abs2, int ord2){
		this.p1 = new Point(abs1, ord1);
		this.p2 = new Point(abs2, ord2);
	}



	@Override
	public void  paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(couleurTrait);
		Graphics2D gr = (Graphics2D) g;
		gr.draw(new Line2D.Double(p1.getX(),p1.getY(),p2.getX(),p2.getY()));
	}

	public Color getCouleurTrait() {
		return couleurTrait;
	}

	public void setCouleurTrait(Color couleurTrait) {
		this.couleurTrait = couleurTrait;
	}

}
