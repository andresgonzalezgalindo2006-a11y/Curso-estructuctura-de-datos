package util;

public class GestorRutas {

    private int[][] matriz;

    public GestorRutas() {

        matriz = new int[5][5];
    }

    public void conectar(
            int a,
            int b,
            int distancia) {

        matriz[a][b] = distancia;

        matriz[b][a] = distancia;
    }

    //falta el dijkstra
}