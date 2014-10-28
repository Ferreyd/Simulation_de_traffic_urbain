package simulation;

import java.awt.Point;


/**
 * 
 * Modelisation des signalisation (feu rouge, stop etc...)
 *
 */
public class Signal {
	/**
	 * Point de depart de la voiture
	 */
	Point position;
	/**
	 * direction de la signalisation Nord, Sus, Est, Ouest
	 */
	int dir;
	/**
	 * Constructeur d'une signalisation prend une position et une direction
	 * @param position position sur la map
	 * @param dir dans quel direction prend elle effet un entier converti en binaire ex : 1 pour 0001 donc Ouest
	 */
	Signal(Point position, int dir){
		this.position = position;
		this.dir = dir;
	}
	public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
		this.position = position;
	}
	public int getDir() {
		return dir;
	}
	public void setDir(int dir) {
		this.dir = dir;
	}
}
