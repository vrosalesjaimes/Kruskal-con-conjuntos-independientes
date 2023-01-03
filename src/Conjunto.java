import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/*
 * Clase que representa a un conjunto.
 * @author : Victor Rosales Jaimes
 */
public class Conjunto<T> {
    
    /* El conjunto de elementos */
    private HashMap<T,T> conjunto;

    /**
     * Crea un nuevo conjunto.
     */
    public Conjunto(){
        conjunto = new HashMap<T,T>();
    }

    /**
     * Regresa los elementos del conjunto
     */
    public HashMap<T,T> getElementos(){
        return conjunto;
    }

    /**
     * Agrega un elemento al conjunto, si es nulo
     * simplemente lo ignora.
     */
    public void agrega(T elemento){
        if(elemento != null)
            conjunto.put(elemento, elemento);
    }

    /**
     * Regresa un elemento
     * @param elemento, el elemento a buscar.
     */
    public T get(T elemento){
        return conjunto.get(elemento);
    }

    /**
     * Regresa la intersección del conjunto y el conjunto recibido.
     * @param conjunto el conjunto que queremos intersectar con éste.
     * @return la intersección del conjunto y el conjunto recibido.
     */
    public Conjunto<T> interseccion(Conjunto<T> conjuntoB){
        Conjunto<T> interseccion = new Conjunto<T>();

        Set<T> llaves = conjunto.keySet();

        for(T elemento: llaves){
            if(conjuntoB.getElementos().get(elemento) != null)
                interseccion.agrega(elemento);
        }   

        return interseccion;
    }

    /**
     * Regresa la unión del conjunto y el conjunto recibido.
     * @param conjunto el conjunto que queremos unir con éste.
     * @return la unión del conjunto y el conjunto recibido.
     */
    public Conjunto<T> union(Conjunto<T> conjuntoB){

        Conjunto<T> union = new Conjunto<T>();

        for(T elemento: conjunto.keySet()){
            union.agrega(elemento);;
        }

        for(T elemento: conjuntoB.getElementos().keySet()){
            union.agrega(elemento);
        }

        return union;
    }

    /**
     * Convierte el conjunto en una lista.
     * @return una lista con los elementos del conjunto.
     */
    public ArrayList<T> enLista(){
        ArrayList<T> lista = new ArrayList<T>();

        for(T elemento: conjunto.keySet()){
            lista.add(elemento);
        }

        return lista;
    }

    /**
     * Regresa el tamaño del conjunto
     */
    public int getTamano(){
        return conjunto.size();
    }

    /**
     * Determina si dos conjuntos son iguales.
     */
    public boolean equals(Conjunto<T> A){
        for(T elemento: conjunto.keySet()){
            if(A.get(elemento) == null)
                return false;
        }
        return true;
    }

    /**
     * Regresa una representación en cadena del conjunto.
     * @return una representación en cadena del conjunto.
     */
    @Override 
    public String toString() {
        String s = "{";

        int i = conjunto.size();
        int aux = 1;

        for(T elemento: conjunto.keySet()){
            if(aux < i)
                s += elemento.toString() + ",";
            else
                s += elemento.toString();
            aux++;
        }

        return s + "}";
    }
}
