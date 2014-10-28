/**
 * 
 */
package elementgraphique;


import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.JComponent;

import map.MapCalcul;

/**
 * @author Lapenta Giuseppe
 *
 */
@SuppressWarnings("serial")
public class Route extends JComponent {
	int x;
	int y;
	int direction;
	MapCalcul mapCalcul;
	BufferedImage img;
	boolean fleche;
	BufferedImage N;
	BufferedImage S;
	BufferedImage E;
	BufferedImage O;
	BufferedImage NS;
	BufferedImage NE;
	BufferedImage NO;
	BufferedImage SE;
	BufferedImage SO;
	BufferedImage EO;
	BufferedImage NSE;
	BufferedImage NSO;
	BufferedImage NEO;
	BufferedImage SEO;
	BufferedImage NSEO;
	static BufferedImage finalImage;
	int taille;


	/**
	 * Constructeur
	 * @param mapCalcul Carte partie calcul
	 * @param fleche presence de fleche ou non
	 */
	public Route(MapCalcul mapCalcul, boolean fleche){
		
		this.mapCalcul = mapCalcul;
		this.fleche = fleche;
		taille = mapCalcul.getTaillePx()/mapCalcul.getTaille();
		if(fleche == true){
			initBufferedImage();
		}

	}


	
	public void  paintComponent(Graphics g){
		super.paintComponent(g);
		
		Graphics2D gr = (Graphics2D) g;
		if(fleche == true){
			
			for(int i = 0 ; i< mapCalcul.getTaille(); i++){
				for(int j = 0; j <mapCalcul.getTaille(); j++){
					direction = mapCalcul.getMonde()[i][j];
					if(direction > 0){
						Point p = CoorGrilleToPx(new Point(i, j));
						chargerImage(direction);
						img = scaleImage(img, taille, taille);
					
						gr.drawImage(finalImage,(int)p.getX(), (int)p.getY(),taille, taille, this);
					}
						
					
				}
			}
		}else{
			Color gris = new Color(125, 125, 125, 100);
			for(int i = 0 ; i< mapCalcul.getTaille(); i++){
				for(int j = 0; j <mapCalcul.getTaille(); j++){
					direction = mapCalcul.getMonde()[i][j];
					if(direction > 0){
						Point p = CoorGrilleToPx(new Point(i, j));
						gr.setColor(gris);
						gr.fillRect((int)p.getX(),(int)p.getY(), (mapCalcul.getTaillePx())/mapCalcul.getTaille() ,(mapCalcul.getTaillePx())/mapCalcul.getTaille());
					}
				}
			}

		}

	
}
	/**
	 * Convertit les coordonnées de  pixel en grille
	 * @return Point de depart convertit en grille
	 */
	Point CoorGrilleToPx(Point p){
		int taille = mapCalcul.getTaillePx()/mapCalcul.getTaille();
		return new Point((int)p.getX() * taille,(int) p.getY() * taille);

	}
	/**
	 * Initialise toute les image de direction en une seul methode
	 */
	public void initBufferedImage(){

		try {
			O = ImageIO.read(new File("Ressource\\Gauche.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//E
		try {
			E = ImageIO.read(new File("Ressource\\Droite.png"));				
		} catch (IOException e) {
			e.printStackTrace();
		}
		//EO
		try {
			EO = ImageIO.read(new File("Ressource\\GaucheDroite.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		//S
		try {
			S = ImageIO.read(new File("Ressource\\Bas.png"));				
		} catch (IOException e) {
			e.printStackTrace();
		}
		//SO
		try {
			SO = ImageIO.read(new File("Ressource\\BasGauche.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//SE
		try {
			SE = ImageIO.read(new File("Ressource\\BasDroite.png"));		
		} catch (IOException e) {
			e.printStackTrace();
		}
		//SEO
		try {
			SEO = ImageIO.read(new File("Ressource\\BasGaucheDroite.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		//N
		try {
			N = ImageIO.read(new File("Ressource\\Haut.png"));				
		} catch (IOException e) {
			e.printStackTrace();
		}
		//NO
		try {
			NO = ImageIO.read(new File("Ressource\\GaucheHaut.png"));				
		} catch (IOException e) {
			e.printStackTrace();
		}
		//NE
		try {
			NE = ImageIO.read(new File("Ressource\\HautDroite.png"));				
		} catch (IOException e) {
			e.printStackTrace();
		}
		//NEO
		try {
			NEO = ImageIO.read(new File("Ressource\\GaucheHautDroite.png"));				
		} catch (IOException e) {
			e.printStackTrace();
		}
		//NS
		try {
			NS = ImageIO.read(new File("Ressource\\HautBas.png"));				
		} catch (IOException e) {
			e.printStackTrace();
		}
		//NSO
		try {
			NSO = ImageIO.read(new File("Ressource\\BasGaucheHaut.png"));				
		} catch (IOException e) {
			e.printStackTrace();
		}
		//NSE
		try {
			NSE = ImageIO.read(new File("Ressource\\BasDroiteHaut.png"));				
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ALL d
		try {
			NSEO = ImageIO.read(new File("Ressource\\AllD.png"));				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


 /**
  * retourne une image de la taille que l'on souhaite, c'est pour l'adapter a la map
  * @param source
  * @param width
  * @param height
  * @return
  */
	public static BufferedImage scaleImage(Image source, int width, int height) {
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = (Graphics2D) img.getGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(source, 0, 0, width, height, null);
		g.dispose();
		return img;
	}
	
	/**
	 * Selon la direction mis en param, on charge la bonne image de direction dans le FinalImage
	 * @param direction
	 */
	public void chargerImage(int direction){


		switch(direction){ //to do perf charger tte image dabord
		case 1 : //O 
			finalImage =  O;
			break;
		case 2 ://E
			finalImage = E;
			break;
		case 3://EO
			finalImage = EO;
			break;
		case 4://S
			finalImage = S;
			break;
		case 5://SO
			finalImage = SO;
			break;
		case 6://SE
			finalImage = SE;
			break;
		case 7://SEO
			finalImage = SEO;
			break;
		case 8://N
			finalImage = N;
			break;
		case 9://NO
			finalImage = NO;
			break;
		case 10://NE/todo
			finalImage = NE;
			break;
		case 11://NEO
			finalImage = NEO;
			break;
		case 12://NS
			finalImage = NS;
			break;
		case 13: //NSO
			finalImage = NSO;
			break;
		case 14: //NSE//todo
			finalImage = NSE;
			break;
		case 15: // ALL d
			finalImage = NSEO;
		}

	}

}
