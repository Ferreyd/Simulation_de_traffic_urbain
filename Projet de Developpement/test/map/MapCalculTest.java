package map;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import voiture.Voiture;

public class MapCalculTest {
	
	private MapCalcul mc;

	@Before
	public void setUp() throws Exception {
		mc = new MapCalcul(1000, 100, 50); // Creation d'une map de taille 1000, avec 100 voitures, et avec des carreaux de taille 50
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCptAcc() {
		int tCptAcc = 0;
		assertEquals(tCptAcc, mc.getCptAcc());
		
		mc.setCptAcc(31);
		assertNotSame(tCptAcc, mc.getCptAcc());
		assertEquals(31, mc.getCptAcc());
	}
	
	@Test
	public void testTaillePx() {
		int tTaillePx = 50;
		assertEquals(tTaillePx, mc.getTaillePx());
		
		mc.setTaillePx(100);
		assertNotSame(tTaillePx, mc.getTaillePx());
		assertEquals(100, mc.getTaillePx());
	}
	
	@Test
	public void testTaile() {
		int tTaille = 1000;
		assertEquals(tTaille, mc.getTaille());
		
		mc.setTaille(500);
		assertNotSame(tTaille, mc.getTaille());
		assertEquals(500, mc.getTaille());
	}
	
	
	@Test 
	public void testInitiMap() {
		mc.setTaille(-3);
		mc.initiMap();
		assertArrayEquals(new int[1000][1000], mc.getMap());
		
		mc = new MapCalcul(8,50,50);
		mc.initiMap();
		
		int[][] tMonde = new int[][] {
				{15, 15, 15, 15, 15, 15, 15, 15},
				{15, 0, 0, 0, 15, 0, 0, 0},
				{15, 0, 0, 0, 15, 0, 0, 0},
				{15, 0, 0, 0, 15, 0, 0, 0},
				{15, 15, 15, 15, 15, 15, 15, 15},
				{15, 0, 0, 0, 15, 0, 0, 0},
				{15, 0, 0, 0, 15, 0, 0, 0},
				{15, 0, 0, 0, 15, 0, 0, 0}
		};
		assertArrayEquals(tMonde, mc.getMap());	
		
		mc.setMap(tMonde);
		assertArrayEquals(tMonde, mc.getMap());
	}
	
	@Test
	public void testNbrVoiture() {
		int tNbrVoiture = 100;
		assertEquals(tNbrVoiture, mc.getNbrVoiture());
		
		mc.setNbrVoiture(50);
		assertNotSame(tNbrVoiture, mc.getNbrVoiture());
	}
	
	@Test
	public void testFuncNbrVoiture() {
		mc.initiMap();
		ArrayList<Voiture> tListeVoiture = mc.nbrVoiture();
		assertEquals(mc.getNbrVoiture(), tListeVoiture.size());
	}
	

}
