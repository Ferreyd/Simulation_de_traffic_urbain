package simulation;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class FeuTricolor extends Signal implements ActionListener{

	private boolean passe;
	private Timer timer;
	
	/**
	 * Constructeur
	 * 
	 * @param position position du feu
	 * @param dir direction
	 * @param passe si les voitures peuvent passer ou non
	 */
	FeuTricolor(Point position, int dir,boolean passe) {
		super(position, dir);
		timer = new Timer(3000,this);
		timer.start();
		
		this.passe=passe;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Change l'Etat du feu
	 */
	public void changerEtat(){
		if (passe==true){
			passe=false;
		}
		
		else{
			passe=true;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		changerEtat();
	}
	
	public boolean isPasse() {
		return passe;
	}

	public void setPasse(boolean passe) {
		this.passe = passe;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

}
