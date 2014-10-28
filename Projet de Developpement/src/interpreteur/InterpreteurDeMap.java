package interpreteur;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class InterpreteurDeMap {

	private int tailleLigne = 0;
	private int tailleColonne = 0;
	private int maxColonne = 0;


	public InterpreteurDeMap(){

	}

	/**
	 * Prend le chemin vers la map en paremetre et retourne la matrice d'int passé en parametre.
	 * @param fichier Le fichier a analyser
	 * @return matrice int[][]
	 */
	@SuppressWarnings({ "resource" })
	public int[][] creationMap(File fichier){
		String strLigne = "";
		@SuppressWarnings("unused")
		String strColonne = "";
		int colonne = 0;
		int ligne = 0;
		Scanner scanner1 = null;
		Scanner scanner2 = null;
		try {
			scanner1 = new Scanner(new FileReader(fichier));
			scanner2 = new Scanner(new FileReader(fichier));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while(scanner1.hasNextLine()){ // boucle nécéssaire pour connaitre la taille de la matrice monde.
			strLigne = scanner1.nextLine();
			
			Scanner s = new Scanner(strLigne);
			
			while(s.hasNext()){
				strColonne = s.next();
				tailleColonne++;
				if(tailleColonne >= maxColonne){
					maxColonne = tailleColonne;
				}
			}

			tailleColonne = 0;
			tailleLigne++;
		}
		int monde[][] = new int[tailleLigne][maxColonne]; // création de  la matrice, x +1 car on part de 1

		while(scanner2.hasNextLine()) { // tant qu'il y a des lignes
			strLigne = scanner2.nextLine(); // je prend une ligne
			Scanner s = new Scanner(strLigne); // je crée un nouveau scanner sur la string
			while(s.hasNextInt()){ // tant qu'il existe un entier sur cette ligne
				monde[colonne][ligne] = s.nextInt(); // on met cet entier dans la matrice
				colonne++; // on change de colonne
			}
			colonne = 0;
			ligne++; // on change de ligne
		}
		return monde;

	}

	/**
	 * Donne la longueur
	 * @return la longueur
	 */
	public int getTailleLigne() {
		return tailleLigne;
	}

	/**
	 * Initialise la taille d'une ligne
	 * @param taille
	 */
	public void setTailleLigne(int taille) {
		this.tailleLigne = taille;
	}
	
	/**
	 * donne la largeur
	 * @return la largeur
	 */
	public int getTailleColonnee() {
		return maxColonne;
	}

	/**
	 * Initialise la taille d'une colonne
	 * @param taille
	 */
	public void setTailleColonne(int taille) {
		this.maxColonne = taille;
	}
}


