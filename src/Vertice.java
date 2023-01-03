/*
 * Clase que representa a un vértice.
 * @author : Victor Rosales Jaimes
 */
public class Vertice {

    /* Elemento de un vértice */
    private int elemento;
    /* Conjunto en donde se encuentra */
    Conjunto<Vertice> conjunto;

    /*
     * Constructor de la clase Vértice.
     * Crea un objeto de tipo Vértice.
     */
    public Vertice(int elemento){
        this.elemento = elemento;
        this.conjunto = null;
    }

    /*
     * Regresa el elemento de un vértice.
     * @return el elemento de un vértice.
     */
    public int getElemento(){
        return elemento;
    }

    /**
     * Regresa el conjunto en donde se encuentra el vértice.
     * @return el conjunto en donde se encuentra el vértice.
     */
    public Conjunto<Vertice> getConjunto(){
        return conjunto;
    }

    /**
     * Reemplaza el valor de conjunto de un vértice.
     * @param el nuevo conjunto del vértice.
     */
    public void setConjunto(Conjunto<Vertice> conjunto){
        this.conjunto = conjunto;
    }

    /*
     * Regresa la representación en cadena de un vértice.
     * @return la representación en cadena de un vértice.
     */
    @Override public String toString(){
        String vertice = String.valueOf(elemento);
        return vertice;
    }

    /**
     * Determina si dos vértices son iguales.
     */
    public boolean equals(Vertice v){
        return elemento == v.getElemento();
    }

}
