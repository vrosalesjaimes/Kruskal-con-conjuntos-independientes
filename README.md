# Kruskal con conjuntos  independientes
El algoritmo de Kruskal es un algoritmo de la teoría de grafos para encontrar un árbol recubridor mínimo en un grafo conexo y ponderado. Es decir, busca un subconjunto de aristas que, formando un árbol, incluyen todos los vértices y donde el valor de la suma de todas las aristas del árbol es el mínimo.
# Instrucciones
Dada una gráfica $G$ con $n$ vértices y e aristas con pesos positivos, encontrar un árbol generador de peso mínimo de dicha gráfica. Encontrarlo con el algoritmo de Kruskal utilizando Conjuntos ajenos con unión por tamaño para la construcción de dicho árbol.

El programa a implementar recibe como entrada en los argumentos de la línea de comandos (ejecutando desde la carpeta *src*) un archivo de texto tal que:
- En la primera línea tendrá todos los vértices que forman a $G$, separados por una coma (’,’).
- En las siguientes líneas irán pares de vértices, separados por una coma (’,’), que indicará en las aristas de $G$, seguido de dos puntos (‘ : ’) para indicar el peso de la arista.

Ejemplo de archivo de entrada:

    1,2,3,4,5,6,7,8 
    1,2:1
    5,6:3
    7,8:4   
    4,3:5
    6,1:4
    6,7:1
    3,8:3
    5,4:2
    4,2:9
    3,7:1
    2,6:3
    7,5:5
    8,4:1

La salida debe de ser en línea de comandos y debe de imprimir en cada iteración el cambio de los conjuntos ajenos, al final deberá mostrar el árbol generador de peso mínimo de forma similar en que se presentaron las aristas en la entrada (listadas una arista por región), así como mostrar el conjunto ajeno resultante.
Ejemplo de salida:

    Cola de prioridades inicial: [(6,7:1), (8,4:1), (1,2:1), (3,7:1), (5,4:2), (2,6:3), (5,6:3), (3,8:3), (6,1:4), (7,8:4), (7,5:5), (4,3:5), (4,2:9)]
    {6},{1},{8},{4},{2},{5},{3},{7}
    {1},{8},{4},{2},{5},{3},{6,7}
    {1},{2},{5},{3},{6,7},{8,4}
    {5},{3},{6,7},{8,4},{1,2}
    {5},{8,4},{1,2},{6,3,7}
    {1,2},{6,3,7},{8,4,5}
    {8,4,5},{6,1,2,3,7}
    {6,1,8,4,5,2,3,7}
    Arbol de peso mínimo: {(2,6:3),(1,2:1),(3,7:1),(5,4:2),(5,6:3),(6,7:1),(8,4:1)}


# Repositorio
Se puede clonar el repositorio con el comando

    git clone https://github.com/vrosalesjaimes/Kruskal-con-conjuntos-independientes.git

# Ejecución
Desde la carpeta *src*, para compilar usamos el comando

    javac Kruskal.java
Para ejecutar usamos el comando

    javac Kruskal.java
Nos pedirá el nombre del archivo luego de ejecutar el comando

# 
[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com)
