/**
 * 
 */
package fenetre;

import interpreteur.InterpreteurDeMap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import thread.MonThread;

import editeur.FenetreEditeur;


import map.MapCalcul;
import map.MapGraphique;


/**
 * @author Lapenta Giuseppe
 *
 */
public class Fenetre extends JFrame implements ActionListener , ChangeListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MapCalcul mapCalcul;
	MapGraphique mapGraphique;
	thread.MonThread t;
	boolean direction = false;
	private static int VITESSE_MIN = 0;
	private static int VITESSE_INIT = 25;
	private static int VITESSE_MAX = 50;
	private JButton stop = new JButton("Stop");
	private JButton fichier = new JButton("Carte");
	private JSlider vitesse = new JSlider(JSlider.HORIZONTAL , VITESSE_MIN , VITESSE_MAX , VITESSE_INIT);
	JButton editeurMap = new JButton("Editeur");
	private JTextField nbrVoiture = new JTextField();
	private static JButton start = new JButton("Demarrer");
	private JButton pause = new JButton("Pause");
	private JLabel cptAcc ;
	private JCheckBox dir = new JCheckBox("Direction");

	public Fenetre(){
		this.setLayout(new BorderLayout());
		this.setTitle("Simulation");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Mise en place cptr accident
		cptAcc = new JLabel("compteur chemin recalculé : 0 ");
		this.setLayout(new BorderLayout());
		JPanel boutons = new JPanel();
		nbrVoiture.setText("inserer nombre de voiture");
		vitesse.addChangeListener(this);
		
		nbrVoiture.addMouseListener( new  MouseAdapter(){
		
			 public void mousePressed(MouseEvent e) {
			     nbrVoiture.setText(null);
			   }

		});
		boutons.setLayout(new BoxLayout(boutons, BoxLayout.X_AXIS));

		//Turn on labels at major tick marks.
		
		vitesse.setMajorTickSpacing(10);
		vitesse.setMinorTickSpacing(1);
		vitesse.setPaintTicks(true);
		vitesse.setPaintLabels(true);
		//mise en place listener et bouton
		boutons.add(dir);
		boutons.add(start);
		boutons.add(pause);
		boutons.add(stop);
		boutons.add(vitesse);
		boutons.add(nbrVoiture);
		boutons.add(fichier);
		boutons.add(editeurMap);
		dir.addActionListener(this);
		start.addActionListener(this);
		pause.addActionListener(this);
		stop.addActionListener(this);
		fichier.addActionListener(this);
		editeurMap.addActionListener(this);
		//vitesse.addChangeListener(ecouteurSlider);
		nbrVoiture.addActionListener(this);
		this.setJButtonDisabled();
		cptAcc.setVisible(true);
		this.add(cptAcc, BorderLayout.PAGE_START);
		this.add(boutons, BorderLayout.PAGE_END);

		this.setVisible(true);
		this.pack();

	}
	public JLabel getCptAcc() {
		return cptAcc;
	}
	public void setCptAcc(JLabel cptAcc) {
		this.cptAcc = cptAcc;
	}
	public void setCptAcc(String s) {this.cptAcc.setText(s);}

	public JButton getPause() {return pause;}
	public void setPause(JButton pause) {this.pause = pause;}

	void setJButtonDisabled(){
		stop.setEnabled(false);
		vitesse.setEnabled(false);
		pause.setEnabled(false);
		start.setEnabled(false);

	}
	void setJButtonEnable(){
		stop.setEnabled(true);
		pause.setEnabled(true);
		
		
	}
	public JButton getStop() {
		return stop;
	}
	public void setStop(JButton stop) {
		this.stop = stop;
	}
	public JButton getFichier() {
		return fichier;
	}
	public void setFichier(JButton fichier) {
		this.fichier = fichier;
	}
	public JTextField getNbrVoiture() {
		return nbrVoiture;
	}
	
	public void setText(JButton pause, String s){pause.setText(s);}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * Classe qui permet d'avoir des écouteur pour les différents boutons et JTextField
		 */

		if(e.getActionCommand() == "Editeur"){
			
			@SuppressWarnings("unused")
			FenetreEditeur fenetre = new FenetreEditeur();
			
			 
		}
		if(e.getActionCommand() == "Direction"){
			
			this.direction = true;
			
			 
		}

		// TODO Auto-generated method stub
		if(e.getActionCommand() == "Demarrer"){
			
			this.t = new MonThread(mapCalcul, mapGraphique,this, mapGraphique.getListVoit().getListeVoiture());
			t.start();
			start.setEnabled(false);
			
			vitesse.setEnabled(true);
			this.setJButtonEnable();
			
		}
		if(e.getActionCommand() == "Editeur"){
			 @SuppressWarnings("unused")
			FenetreEditeur fenetre = new FenetreEditeur();
			
			 
		}
		if(e.getActionCommand() == "Pause"){
			t.setIsRunnable(false);
			pause.setText("Reprendre");
		}	
		if(e.getActionCommand() == "Reprendre"){
			t.setIsRunnable(true);
			pause.setText("Pause");

		}
		if(e.getActionCommand() == "Stop"){
			t.stop();
			this.dispose();
			@SuppressWarnings("unused")
			Fenetre fenetre = new Fenetre();
		}
		if(e.getActionCommand() == "Carte"){ //a modifier


			JFileChooser choixFichier = new JFileChooser("Carte");
			int valeur = choixFichier.showOpenDialog(this);
			if(valeur == JFileChooser.APPROVE_OPTION){
				File fichierChoisis = choixFichier.getSelectedFile();
				InterpreteurDeMap interpreteur = new InterpreteurDeMap(); // on crée un nouvel interpreteur
				int mondeTemp[][] = interpreteur.creationMap(fichierChoisis); // on met la map dans un fichier temporaire
				
				String nb = nbrVoiture.getText();
			
				try{
					mapCalcul = new MapCalcul(interpreteur.getTailleColonnee(), Integer.parseInt(nb), Constant.taillePx);
					mapGraphique = new MapGraphique(mapCalcul,direction);
					mapGraphique.removeAll();
					mapCalcul.setMonde(mondeTemp); // on met la nouvelle map
					mapGraphique.init(mapCalcul); //On initier la Map graphique par rapport a MapCalcul
					mapGraphique.repaint();
					Dimension dim = new Dimension(Constant.taillePx, Constant.taillePx);
					mapGraphique.setPreferredSize(dim);
					fichier.setEnabled(false);
					dir.setEnabled(false);
					nbrVoiture.setEnabled(false);
					
					this.getContentPane().add(mapGraphique, BorderLayout.CENTER);

					start.setEnabled(true);
					this.validate();
					this.repaint();
					this.pack();
				}catch(Exception ex){
					JDialog popUp = new JDialog();
					JLabel popUpT = new JLabel();
					
					popUpT.setBackground(Color.white);
					popUpT.setText("il faut inserer un numero!!");
					popUp.add(popUpT);
					popUp.setVisible(true);
					popUp.pack();

				}

			



				//}
			}
			
		}

		// TODO Auto-generated method stub

	}
	/**
	 * Permet de changer le temps d'attente du thread
	 * on prend l'inverse de la valeur du slider puis on multiplie par 100 afin d'avoir un temps d'attente acceptable.
	 * On prend l'inverse afin d'inverser les valeurs obtenue par le slider (gauche pour petite vitesse et droite pour haute vitesse)
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		int vit = vitesse.getValue(); // on passe la vitesse relevée dans une variable afin d'éviter la division par 0
		if(vit == 0){
			vit = 1; // on evite la division par 0
		}
		double v = 1.0 / vit; 
		v = v * 1000;
		t.setVitesse((int)v);
		
	}

}
