/*
 * Clase que representa a una arista.
 * @author : Victor Rosales Jaimes
 */
public class Arista implements Comparable<Arista>{

    /* Primer vértice de una arista */
    private Vertice extremoA;
    /* Segundo vértice de una arista */
    private Vertice extremoB;
    /* Peso de la arista */
    private int peso;

    /*
     * Constructor de la clase.
     * Crea una  Arista.
     */
    public Arista(Vertice extremoA, Vertice extremoB,int peso){
        this.extremoA = extremoA;
        this.extremoB = extremoB;
        this.peso = peso;
    }

    /*
     * Regresa el extremo A de una arista.
     * @return el extremo A de una arista.
     */
    public Vertice getExtremoA(){
        return extremoA;
    }

    /*
     * Regresa el extremo B de una arista.
     * @return el extremo B de una arista.
     */
    public Vertice getExtremoB(){
        return extremoB;
    }

    /*
     * Regresa el peso de la arista.
     * @return el peso de la arista
     */
    public int getPeso(){
        return peso;
    }

    /*
     * Regresa la representación en cadena de una arista.
     * @return la representación en cadena de una arista.
     */
    @Override public String toString(){
        String arista = "(" + extremoA.toString() + ","
                            + extremoB.toString() + ":"
                            + String.valueOf(peso) + ")";
        return arista;
    }

    /**
     * Determina cual es la relación entre el peso de
     * dos aristas.
     * @param a, arista con la que se va a comparar.
     * @return regresa 1 si es mayor, 0 su es igual y
     * -1 si es menor.
     */
    @Override
    public int compareTo(Arista a){
        if(peso < a.getPeso())
            return -1;
        else if(peso > a.getPeso())
            return 1;
        else
            return 0;

    }
}
