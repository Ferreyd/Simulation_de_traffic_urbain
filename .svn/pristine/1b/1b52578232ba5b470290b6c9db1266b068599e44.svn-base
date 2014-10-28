package aStar;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import map.Monde;

/**
 * Algorithme de calcul du chemin le plus court via l'algorithme A*
 *
 * L'implémentation est basée en partie sur : 
 * {@link http://code.google.com/p/a-star/source/browse/trunk/java/AStar.java?r=8}
 *
 * @author Moloch
 * @since 1.0
 * @version 1.0
 * @param <T>
 *            le type d'index associé à l'algorithme
 */
public class Astar<T> {

    private final SuccessorComputer<T> successorComputer;
    private final NodeFactory<T> nodeFactory;

    private final Queue<Node<T>> paths = new PriorityQueue<Node<T>>();
    private final Map<T, Double> distancesMinimum = new HashMap<T, Double>();
    
    private Monde monde;
    
    private int compteur = 0;

    /**
     * Instancie un nouveau calculateur de chemin par algorithme A*
     *
     * @param successorComputer
     *            le fournisseur de l'algorithme calculant les successeurs
     * @param nodeFactory
     *            le créateur du noeud
     */
    public Astar(final SuccessorComputer<T> successorComputer, final NodeFactory<T> nodeFactory, Monde monde) {
        if (nodeFactory == null || successorComputer == null) {
            throw new IllegalArgumentException("Les 2 paramètres de A* doivent etre non null");
        }
        this.successorComputer = successorComputer;
        this.nodeFactory = nodeFactory;
        this.monde = monde;
    }

    /**
     * Rempli les paths possibles autour du noeud spécifié
     *
     * @param node
     *            le noeud autour duquel on teste les voies
     * @param goal
     *            la destination finale
     */
    private void expand(final Node<T> node, final T goal) {
        final T p = node.getIndex();
        Point p1 = (Point) p;
        final Double minimum = distancesMinimum.get(p);

        final double nodeF = node.getF();
        if ((minimum == null || minimum > nodeF)) {
            distancesMinimum.put(p, nodeF);
            final Collection<T> successorsCollection = successorComputer.computeSuccessor(node);
            for (final T t : successorsCollection) {
            	if(p1.getX() < monde.getTaille() && p1.getY() < monde.getTaille()){
            		final Node<T> newNode = nodeFactory.instanciateNode(node, t, goal);
                    if (newNode != null) {
                        paths.add(newNode);
                    }
            	}
            }

        }
    }

    /**
     * Renvoit la liste des noeuds représentant le parcours optimisé par A*
     *
     * @param start
     *            le point de départ
     * @param goal
     *            le point d'arrivée espéré
     * @return la liste des index dans l'ordre représentant le trajet entre les
     *         2 points
     */
    public ArrayList<T> compute(final T start, final T goal) {
    	Point s = (Point) start; // cast de start en point afin d'avoir les positions du point de depart
    	int matrice[][] = this.monde.getMonde(); // on prend la matrice
    	@SuppressWarnings("unused")
		int coef = matrice[(int) s.getX()][(int) s.getY()]; // on prend le coefficient
    	
        final Node<T> root = nodeFactory.instanciateNode(null, start, goal);
        @SuppressWarnings("unused")
		ArrayList<T> exit = new ArrayList<T>();
        expand(root, goal);
        // boucle qui compte le nombre de calcul, si trop grand il s'arrete. Permet d'éviter les calculs infinis.
        while (true) {
        	compteur++;
        if(compteur >= 100000000){
        		
        		//return exit;
        	}
        	
            final Node<T> p = paths.poll();
            if (p == null) {
                return new ArrayList<T>();
            }
            final T last = p.getIndex();

            if (last.equals(goal)) {
                final ArrayList<T> result = new ArrayList<T>();
                for (Node<T> i = p; i != null; i = i.getParent()) {
                    result.add(0, i.getIndex()); // on place au premier element de la liste chaque index(Point x,y).
                }
                return result;
            }
            expand(p, goal);
        }
    }
}

