package editeur;

import interpreteur.InterpreteurDeMap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;
import javax.swing.JPanel;

import map.MapCalcul;

import elementgraphique.Ligne;
import elementgraphique.Route;


/**
 * @author Lapenta Giuseppe
 *
 */
public class FenetreEditeur extends JFrame implements MouseListener, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mapEdit = new JPanel();
	private JButton allD = new JButton("Toute Direction");
	private JButton NSE = new JButton("NSE ");
	private JButton NSO = new JButton("NS O");
	private JButton NS = new JButton("NS  ");
	private JButton NEO = new JButton("N EO");
	private JButton NE = new JButton("N E ");
	private JButton NO = new JButton("N  O");
	private JButton N = new JButton("N   ");
	private JButton SEO = new JButton(" SEO");
	private JButton  SE = new JButton(" SE ");
	private JButton SO = new JButton(" S O");
	private JButton S = new JButton(" S  ");
	private JButton EO = new JButton("  EO");
	private JButton E = new JButton("  E ");
	private JButton O = new JButton("   O");
	private JButton noDir = new JButton("Suppr Route");
	private Route route ;

	private JButton finish = new JButton("J'ai fini!");
	private int direction = 15;
	private JPanel boutons = new JPanel();
	private MapCalcul mapCalcul;
	private int map[][];
	private JPanel boutonDir = new JPanel();
	private JTextField popUpTailleMatrice = new JTextField("inserer Taille Matrice");
	private JTextField popUpPx = new JTextField("inserer Taille Pixel");
	private JButton ok = new JButton("ok");
	private int taillePx;
	private int tailleMatrice;
	private Point pointClique;
	JButton charger = new JButton("Charger");

	public FenetreEditeur(){
		LayoutManager overlay = new OverlayLayout(mapEdit);
		mapEdit.setLayout(overlay);

		this.setSize(500,500);
		this.setLayout(new BorderLayout());
		this.setTitle("Simulation");

		this.setLayout(new BorderLayout());
		popUpTailleMatrice.addMouseListener(this);
		popUpPx.addMouseListener(this);
		boutons.setLayout(new GridLayout());
		boutonDir.setLayout(new GridLayout(16, 1));
		allD.addActionListener(this);
		ok.addActionListener(this);
		finish.addActionListener(this);
		addAll();
		boutonDir.setVisible(true);
		boutons.setVisible(true);
		boutons.add(finish);
		boutons.add(charger);
		charger.addActionListener(this);
		this.add(boutonDir, BorderLayout.EAST);
		this.add(boutons, BorderLayout.SOUTH);
		this.setVisible(true);
		this.pack();

	}

	/**
	 * Ajoute tout les bouton et les action listener associé
	 * pour avoir du code plus propre
	 */
	void addAll(){
		boutons.add(ok);
		boutons.add(popUpPx);
		boutons.add(popUpTailleMatrice);
		boutonDir.add(allD);
		boutonDir.add(noDir);
		boutonDir.add(NSE);
		boutonDir.add(N);
		boutonDir.add(E);
		boutonDir.add(S);
		boutonDir.add(O);
		boutonDir.add(NS);
		boutonDir.add(NO);
		boutonDir.add(NE);
		boutonDir.add(EO);
		boutonDir.add(SEO);
		boutonDir.add(SO);
		boutonDir.add(NEO);
		boutonDir.add(NSO);
		boutonDir.add(NSE);
		boutonDir.add(SE);
		activeButtons(false);
		noDir.addActionListener(this);
		allD.addActionListener(this);
		NSE.addActionListener(this);
		N.addActionListener(this);
		E.addActionListener(this);
		S.addActionListener(this);
		O.addActionListener(this);
		NS.addActionListener(this);
		NO.addActionListener(this);
		NE.addActionListener(this);
		EO.addActionListener(this);
		SEO.addActionListener(this);
		SO.addActionListener(this);
		NEO.addActionListener(this);
		NSO.addActionListener(this);
		SE.addActionListener(this);
		NSE.addActionListener(this);
	}
	/**
	 * Active les bouton ou pas de l'editeur, permet uen gestion centralisé
	 * @param faux
	 */
	void activeButtons(boolean faux) {
		allD.setEnabled(faux);
		NSE.setEnabled(faux);
		N.setEnabled(faux);
		E.setEnabled(faux);
		S.setEnabled(faux);
		O.setEnabled(faux);
		NS.setEnabled(faux);
		NO.setEnabled(faux);
		NE.setEnabled(faux);
		EO.setEnabled(faux);
		SEO.setEnabled(faux);
		SO.setEnabled(faux);
		NEO.setEnabled(faux);
		NSO.setEnabled(faux);
		NSE.setEnabled(faux);
		SE.setEnabled(faux);
		noDir.setEnabled(faux);
		finish.setEnabled(faux);
	}

	/**
	 * Cette Methode permet de bien mettre la route par rapport a la Grille dessiner
	 * @param p
	 * @return Point
	 */
	public Point replaceRoute(Point p){
		int taille = mapCalcul.getTaillePx()/mapCalcul.getTaille();
		return new Point((int)CoorPxToGrille(p).getX() * taille,(int) CoorPxToGrille(p).getY() * taille);
	}


	public Point CoorPxToGrille(Point getDepart){


		return new Point((int)(getDepart.getX())/ (int)(mapCalcul.getTaillePx()/mapCalcul.getTaille()), (int)((getDepart.getY()) / (int)((mapCalcul.getTaillePx())/mapCalcul.getTaille())) );


	}
	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand() == "Suppr Route"){
			direction = 0;
		}
		if(arg0.getActionCommand() == "Toute Direction"){
			direction = 15;
		}if(arg0.getActionCommand() == "NSE "){
			direction = 14;
		}if(arg0.getActionCommand() == "NS O"){
			direction = 13;
		}if(arg0.getActionCommand() == "NS  "){
			direction = 12;
		}if(arg0.getActionCommand() == "N EO"){
			direction = 11;
		}if(arg0.getActionCommand() == "N E "){
			direction = 10;
		}if(arg0.getActionCommand() == "N  O"){
			direction = 9;
		}if(arg0.getActionCommand() == "N   "){
			direction = 8;
		}if(arg0.getActionCommand() == " SEO"){
			direction = 7;
		}if(arg0.getActionCommand() == " SE "){
			direction = 6;
		}if(arg0.getActionCommand() == " S O"){
			direction = 5;
		}if(arg0.getActionCommand() == " S  "){
			direction = 4;
		}if(arg0.getActionCommand() == "  EO"){
			direction = 3;
		}if(arg0.getActionCommand() == "  E "){
			direction = 2;
		}if(arg0.getActionCommand() == "   O"){
			direction = 1;
		}

		//Permet de sauvegarder la MAP créer
		if(arg0.getActionCommand() == "J'ai fini!"){
			//To do sauvergarder
			FileWriter writer = null;
			String texte =	new String();
			String Newligne=System.getProperty("line.separator"); 
			for(int i = 0; i < map.length; i++){
				for(int j = 0; j < map.length; j++){
					texte += Integer.toString(map[j][i]);
					texte += " ";

				}
				texte += Newligne;
			}
			try{

				writer = new FileWriter("Map.txt");
				writer.write(texte,0,texte.length());
			}catch(IOException ex){
				ex.printStackTrace();
			}finally{
				if(writer != null){
					try {
						writer.close();
						JDialog popUp = new JDialog();
						JLabel popUpT = new JLabel();

						popUpT.setBackground(Color.white);
						popUpT.setText("Fichier bien sauvergarder, vous pouvez maintenant le charger dans la fenetre principale");
						popUp.add(popUpT);
						popUp.setVisible(true);
						popUp.pack();
					} catch (IOException e) {

						e.printStackTrace();
					}
				}
			}

		}
		if(arg0.getActionCommand() == "Charger"){

			JFileChooser choixFichier = new JFileChooser("Carte");

			int valeur = choixFichier.showOpenDialog(this);
			if(valeur == JFileChooser.APPROVE_OPTION){
				File fichierChoisis = choixFichier.getSelectedFile();
				InterpreteurDeMap interpreteur = new InterpreteurDeMap(); // on crée un nouvel interpreteur
				try{
					map = interpreteur.creationMap(fichierChoisis); // on met la map dans un fichier temporaire
				}catch(Exception e){
					JDialog popUp = new JDialog();
					JLabel popUpT = new JLabel();

					popUpT.setBackground(Color.white);
					popUpT.setText("Ton fichier n'est pas Valide!!");
					popUp.add(popUpT);
					popUp.setVisible(true);
					popUp.pack();
				}


				try{

					String nbrPx = popUpPx.getText();
					taillePx = Integer.parseInt(nbrPx);
					popUpPx.setEnabled(false);
					popUpTailleMatrice.setEnabled(false);
					mapCalcul = new MapCalcul(interpreteur.getTailleColonnee(), 0, taillePx);
					mapCalcul.setMonde(map);
					Dimension dim = new Dimension(taillePx,taillePx);
					mapEdit.setPreferredSize(dim);
					this.setSize(taillePx - this.getWidth()  + this.getWidth(), taillePx - this.getHeight() + this.getHeight());

					int boucle = (mapCalcul.getTaillePx()) / mapCalcul.getTaille();
					//on fait une grille afficher en arriere plan pour plus de clarté
					for(int i = 0; i<= mapCalcul.getTaillePx(); i = i+boucle){ 
						mapEdit.add(new Ligne(i, 0, i ,mapCalcul.getTaillePx()));
					}									
					for(int j = 0; j<= mapCalcul.getTaillePx(); j= j+boucle){
						mapEdit.add(new Ligne(0, j,(mapCalcul.getTaillePx()),j));
					}
					activeButtons(true);
					ok.setEnabled(false);
					mapEdit.addMouseListener(this);

					route = new Route(mapCalcul,true);
					mapEdit.add(route);
					mapEdit.setVisible(true);
					mapEdit.setBackground(Color.white);



					mapEdit.repaint();
					this.add(mapEdit, BorderLayout.CENTER);

					this.repaint();
					this.validate();
					this.pack();

				}catch(Exception e){
					JDialog popUp = new JDialog();
					JLabel popUpT = new JLabel();

					popUpT.setBackground(Color.white);
					popUpT.setText("Ta surement du oublier un truc, la taille en Pixel je me trompe?");
					popUp.add(popUpT);
					popUp.setVisible(true);
					popUp.pack();
				}
			}
		}
		//aprés avoir entré la taille de pixel et le nombre de carreau en largeur
		//on genere la matrice, et creer un mapcalcul a la bonne taille
		if(arg0.getActionCommand() == "ok"){
			try{
				String nbr = popUpTailleMatrice.getText();
				String nbrPx = popUpPx.getText();
				taillePx = Integer.parseInt(nbrPx);
				tailleMatrice = Integer.parseInt(nbr);
				if(taillePx > 10 && tailleMatrice > 1){
					ok.setEnabled(false);



					Dimension dim = new Dimension(taillePx, taillePx);
					mapEdit.addMouseListener(this);
					mapCalcul = new MapCalcul(tailleMatrice, 0, taillePx);
					mapEdit.setBackground(Color.white);
					popUpPx.setEnabled(false);
					popUpTailleMatrice.setEnabled(false);
					int boucle = (mapCalcul.getTaillePx()) / mapCalcul.getTaille();
					//on fait une grille afficher en arriere plan pour plus de clarté
					for(int i = 0; i<= mapCalcul.getTaillePx(); i = i+boucle){ 
						mapEdit.add(new Ligne(i, 0, i ,mapCalcul.getTaillePx()));
					}									
					for(int j = 0; j<= mapCalcul.getTaillePx(); j= j+boucle){
						mapEdit.add(new Ligne(0, j,(mapCalcul.getTaillePx()),j));
					}
					mapEdit.setPreferredSize(dim);
					this.setSize(taillePx - this.getWidth()  + this.getWidth(), taillePx - this.getHeight() + this.getHeight());


					map = new int[mapCalcul.getTaille()][mapCalcul.getTaille()];
					init(map);
					route = new Route(mapCalcul,true);

					this.add(mapEdit, BorderLayout.CENTER);
					mapEdit.add(route);
					mapEdit.setVisible(true);
					mapEdit.repaint();

					activeButtons(true);
					this.repaint();
					this.validate();
					this.pack();
				}
			}catch(Exception e){
				JDialog popUp = new JDialog();
				JLabel popUpT = new JLabel();

				popUpT.setBackground(Color.white);
				popUpT.setText("Il me faut une taille en Pixel et une taille de matrice!");
				popUp.add(popUpT);
				popUp.setVisible(true);
				popUp.pack();
			}
		}
	}


	/* 
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {



	}


	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent arg0) {
		if(arg0.getComponent() == mapEdit){
			pointClique = replaceRoute( arg0.getPoint());


		}
		if(arg0.getComponent() == popUpPx){
			popUpPx.setText(null);
		}
		if(arg0.getComponent() == popUpTailleMatrice ){
			popUpTailleMatrice.setText(null);
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if(arg0.getComponent() == mapEdit){

			Point pointCliqueFinal = replaceRoute( arg0.getPoint());
			Point pDeb = new Point((int)CoorPxToGrille(pointClique).getX(),(int)CoorPxToGrille(pointClique).getY());
			Point pFin = new Point((int)CoorPxToGrille(pointCliqueFinal).getX(),(int)CoorPxToGrille(pointCliqueFinal).getY());
			if((int) pDeb.getX() < mapCalcul.getTaille() && (int) pFin.getY() < mapCalcul.getTaille() && (int) pFin.getX() < mapCalcul.getTaille() && (int) pFin.getY() < mapCalcul.getTaille() ){
				if(pDeb.getX() < pFin.getX() && pDeb.getY() == pFin.getY()){
					for(int i = (int)pDeb.getX(); i <= (int)pFin.getX(); i++ ){
						map[i][(int)pDeb.getY()] = direction;
						mapCalcul.setMonde(map);
						mapEdit.repaint();
					}
				}
				if(pDeb.getY() < pFin.getY() && pDeb.getX() == pFin.getX()){
					for(int i = (int)pDeb.getY(); i <= (int)pFin.getY(); i++ ){
						map[(int)pDeb.getX()][i] = direction;
						mapCalcul.setMonde(map);
						mapEdit.repaint();
					}

				}
				if(pDeb.getX() > pFin.getX() && pDeb.getY() == pFin.getY()){
					for(int i = (int)pDeb.getX(); i >= (int)pFin.getX(); i-- ){
						map[i][(int)pDeb.getY()] = direction;
						mapCalcul.setMonde(map);
						mapEdit.repaint();
					}

				}
				if(pDeb.getY() > pFin.getY() && pDeb.getX() == pFin.getX()){
					for(int i = (int)pDeb.getY(); i >= (int)pFin.getY(); i--){
						map[(int)pDeb.getX()][i] = direction;
						mapCalcul.setMonde(map);
						mapEdit.repaint();
					}

				}
				if(pDeb.getY() == pFin.getY() && pDeb.getX() == pFin.getX() ){
					map[(int)pDeb.getX()][(int)pDeb.getY()] = direction;
					mapCalcul.setMonde(map);
					mapEdit.repaint();
				}
			}	

		}
	}


	/**
	 * On met des 0 dans toute la map
	 * @param map
	 */
	void init(int[][] map){

		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map.length; j++){
				map[i][j] = 0;
			}
		}






	}






}
