package voiture;
import map.MapCalcul;


import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VoitureTest {
	
	private Voiture v;
	
	@Before 
	public void setUp() {
	v = new Voiture(new Point(0, 0), new Point(1,1), 0, Color.BLUE, new MapCalcul(50, 100, 100), new ArrayList<Point>());
	}

	@Test
	public void testPointDepart() {
		Point tPDepart = new Point(0, 0);
		assertEquals(tPDepart, v.getDepart());
		
		v.setDepart(new Point(2, 2));
		assertNotSame(tPDepart, v.getDepart());
		
	}
	
	@Test
	public void testPointArrivee() {
		Point tPArrivee = new Point (1,1);
		assertEquals(tPArrivee, v.getArrive());
		
		v.setArrive(new Point (2,2));
		assertNotSame(tPArrivee, v.getArrive());
	}
	
	@Test
	public void testVitesse() {
		int tVitesse = 0;
		assertEquals(tVitesse, v.getVitesse());
		
		v.setVitesse(10);
		assertNotSame(tVitesse, v.getVitesse());
	}
	
	@Test
	public void testCouleur() {
		Color tCouleur = Color.BLUE;
		assertEquals(tCouleur, v.getCouleur());
		
		v.setCouleur(Color.RED);
		assertNotSame(tCouleur, v.getCouleur());
	}
	
	
	
	@Test
	public void testChemin() {
		ArrayList<Point> tChemin = new ArrayList<Point>();
		assertEquals(tChemin, v.getChemin());
		
		ArrayList<Point> tCheminBis= new ArrayList<Point>();
		tCheminBis.add(new Point(3,3));
		v.setChemin(tCheminBis);
		assertNotSame(tChemin, v.getChemin());
	}
	
	@Test
	public void testTaille() {
		assertEquals(v.getMap().getTaille(), 50);
	}
	
	
	
	@Test
	public void testCoorGrilleToPx() {
		assertEquals(new Point(0,0), v.getDepart()); // On verifie que le point de depart est bien celui defini par le constructeur
		
		v.setDepart(new Point(10, 10));
		Point tPointRes = new Point(20, 20);
		assertEquals(tPointRes, v.CoorGrilleToPx(v.getDepart()));
	}
	
	@Test
	public void testCoorPxToGrille() { // Test de la fonction CoorPxToGrille()
		v.setDepart(new Point(110,110));
		Point tPointRes = new Point(55,55);
		assertEquals(tPointRes, v.CoorPxToGrille());
	}
	
	@Test 
	public void testCoorPxToGrilleArg() { // Test de la fonction CoorPxToGrille(Point p)
		v.setDepart(new Point(110,110));
		Point tPointRes = new Point(55,55);
		assertEquals(tPointRes, v.CoorPxToGrille(v.getDepart()));
	}
	
	@Test
	public void testRandomCouleur() {
		v.couleurAlea();
		
		assertTrue(v.getCouleur().getBlue() <= 255);
		assertTrue(v.getCouleur().getGreen() <= 255);
		assertTrue(v.getCouleur().getRed() <= 255);
	}
	
	@Test
	public void testAvancerHaut() {
		assertEquals(new Point(0,0), v.getDepart());
		
		Point tPointRes = new Point(0,-2);
		v.avancerHaut();
		assertEquals(tPointRes, v.getDepart());
	}
	
	@Test
	public void testAvancerBas() {
		assertEquals(new Point(0,0), v.getDepart());
		
		Point tPointRes = new Point(0,2);
		v.avancerBas();
		assertEquals(tPointRes, v.getDepart());
	}
	
	@Test
	public void testAvancerDroite() {
		assertEquals(new Point(0,0), v.getDepart());
		
		Point tPointRes = new Point(2,0);
		v.avancerDroite();
		assertEquals(tPointRes, v.getDepart());
	}
	
	@Test
	public void testAvancerGauche() {
		assertEquals(new Point(0,0), v.getDepart());
		
		Point tPointRes = new Point(-2,0);
		v.avancerGauche();
		assertEquals(tPointRes, v.getDepart());
	}
	
	@Test
	public void testIterateur() {
		assertEquals(1, v.getIterateur());
		
		v.setIterateur(3);
		assertEquals(3, v.getIterateur());
	}
	
	
	@After
	public void tearDown() throws Exception {
	}
	
	

}
