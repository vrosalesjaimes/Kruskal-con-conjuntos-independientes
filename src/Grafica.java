import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/*
 * Clase que representa a una gráfica.
 * @author : Victor Rosales Jaimes
 */
public class Grafica{

    /* Conjunto de vértices de la gráfica */
    Conjunto<Vertice> vertices;
    /* Conjunto de aristas de la gráfica */
    Conjunto<Arista> aristas;

    /**
    * Construye una grafica
    */
    public Grafica(Conjunto<Vertice> vertices, Conjunto<Arista> aristas){
        this.vertices = vertices;
        this.aristas = aristas;
    }

    /**
     * Regresa los conjuntos iniciales para el algoritmo de Kruskal.
     * @return lista de conjuntos unitarios disjuntos.
     */
    private ArrayList<Conjunto> conjuntosIniciales(){
        ArrayList<Vertice> V = vertices.enLista();
        ArrayList<Conjunto>  conjuntos = new ArrayList<>();

        for(Vertice v: V){
            Conjunto<Vertice> c = new Conjunto<>();
            c.agrega(v);
            v.setConjunto(c);
            conjuntos.add(c);
        }
        return conjuntos;
    }

    /**
     * Ordena una lista de aristas de acuerdo a su peso.
     * @param aristas, la lista de aristas a ordenar.
     */
    private void ordena(ArrayList<Arista> aristas){
        Collections.sort(aristas,(x,y) -> x.compareTo(y));
    }

    /**
     * Implementación del algoritmo de Kruskal para encontrar
     * el árbol generador de peso mínimo.
     */
    public Conjunto<Arista> Kruskal(){
        Conjunto<Arista> arbol = new Conjunto<Arista>();

        ArrayList<Arista> colaDePrioridades = aristas.enLista();
        ordena(colaDePrioridades);
       
        String s = colaDePrioridades.toString();
        System.out.println("Cola de prioridades inicial: "+s);

        ArrayList<Conjunto> conjuntos = conjuntosIniciales();
        imprime(conjuntos);
        int i = colaDePrioridades.size();

        int tamanoArbol = 0;
        int tamanoVerties = vertices.getTamano();

        for(int j = 0; j < i;  j++){
            Arista a = colaDePrioridades.get(0);

	        Vertice extremoA = a.getExtremoA();
	        Vertice extremoB = a.getExtremoB();

	        Conjunto<Vertice> cA = extremoA.getConjunto();
	        Conjunto<Vertice> cB = extremoB.getConjunto();

	        Conjunto<Vertice> intersecion = cA.interseccion(cB);
	        Conjunto<Vertice> union = cA.union(cB);
            
	        if (intersecion.getTamano() == 0){
		        arbol.agrega(a);
                tamanoArbol++;

		        extremoA.setConjunto(union);
                cambioConjunto(cA, union);
		        extremoB.setConjunto(union);
                cambioConjunto(cB, union);

		        union.agrega(extremoA);
		        union.agrega(extremoB);

		        conjuntos.remove(cA);
		        conjuntos.remove(cB);
		        conjuntos.add(union);
	        }

	        colaDePrioridades.remove(0);
	        imprime(conjuntos); 

            if(tamanoArbol == tamanoVerties-1)
                return arbol;
        }

        return arbol;
    }

    /**
     * Cambia el conjunto a que pertenecen los vertices de un conjunto.
     * @param vertices, los vertices a los que cambiaremos su conjunto.
     * @param union, el nuevo conjunto de los vertices.
     */
    private void cambioConjunto(Conjunto<Vertice> vertices, Conjunto<Vertice> union){
        for(Vertice v: vertices.enLista()){
            v.setConjunto(union);
        }
    }

    /*
     * Imprime una lista de conjuntos
     */
    private void imprime(ArrayList<Conjunto> l){
        String s = "";
        int i = l.size();
        int j = 1;
        for(Conjunto elemento:l){
            if(j < i)
                s += elemento.toString() + ",";
            else
                s += elemento.toString();
            j++;
        }
        System.out.println(s);
    }
}
