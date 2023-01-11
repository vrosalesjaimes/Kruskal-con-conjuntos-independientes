import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase ejecutable
 * @author: Victor Rosales Jaimes.
 */

 public class Kruskal{

    /**
	 * Lee el archivo con la información de una gráfica.
	 * @param archivo, el archivo a leer.
	 * @return una grafica.
	 */
	public static Grafica leeArchivo(String archivo){
        Conjunto<Arista> aristas = new Conjunto<Arista>(); 
        Conjunto<Vertice> vertices = new Conjunto<Vertice>();
		Arista a = null;
		try {
			BufferedReader br = new BufferedReader(
					                new InputStreamReader(
							            new FileInputStream(archivo)));
			String linea = "";
			boolean contador = true;
			while((linea = br.readLine()) != null){
				if (contador) {
					vertices = determinaVertices(linea);
					contador = false;
				}else 
					a = determinaArista(linea, vertices);
                    aristas.agrega(a);
			}
			br.close();
		}catch(Exception e) {
			System.out.println("Ha ocurrido un error al leer el archivo");
			System.exit(-1);
		}
        Grafica grafica = new Grafica(vertices, aristas);
		return grafica;
	}

    /**
	 * A partir de una cadena se determinan los vértices para construir una grafica
	 * @param linea, la linea donde estan todos los vértices separados por comas.
	 * @return un conjunto con los vértices de un gráfica.
	 */
	private static Conjunto<Vertice> determinaVertices(String linea){
		Conjunto<Vertice> vertices = new Conjunto<>();
		String[] str = linea.split(",");
		for (String s: str) {
			int valor = Integer.valueOf(s.trim());
            Vertice v = new Vertice(valor);
			vertices.agrega(v);
		}
		return vertices;
	}

    /**
     * A partir de una cadena se determina un arista
     * @param linea, linea  a leer.
     * @return una arista con la información de línea.
     */
    private static Arista determinaArista(String linea, Conjunto<Vertice> vertices){
        String[] l = linea.split(":");
        int peso = Integer.valueOf(l[1].trim());
        String l1 = l[0];
        String[] l2 = l1.split(",");
        int A = Integer.valueOf(l2[0].trim());
        int B = Integer.valueOf(l2[1].trim());

        Vertice vA = busca(vertices,A);
        Vertice vB = busca(vertices,B);

        Arista a = new Arista(vertices.get(vA), vertices.get(vB), peso);

        return a;
    }

    /** 
     * Busca un vértice en un conjunto
     */
    private static Vertice busca(Conjunto<Vertice> vertice,int elemento){
        ArrayList<Vertice> vertices = vertice.enLista();
        for(Vertice v: vertices){
            if(v.getElemento()== elemento)
                return v;
        }
        return null;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre del archivo");
		String nombre = sc.nextLine().trim();
        
        try{
            Grafica grafica = leeArchivo(nombre);
            Conjunto<Arista> arbol = grafica.Kruskal();
            System.out.println("Arbol de peso mínimo: " +arbol.toString());
        }catch(Exception e) {
			System.exit(-1);
		}
    }
 }
