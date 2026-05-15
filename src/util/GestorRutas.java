package util;

import java.util.Arrays;

public class GestorRutas {

    private static final int N = 5;

    private final int[][] grafo;

    private final String[] nombres;

    public GestorRutas() {

        grafo = new int[N][N];

        nombres = new String[] {
                "Ingeniería",
                "Biblioteca",
                "Cafetería",
                "Rectoría",
                "Laboratorios"
        };
    }

    public void conectar(
            int a,
            int b,
            int distancia) {

        grafo[a][b] = distancia;

        grafo[b][a] = distancia;
    }

    public void dijkstra(
            int origen,
            int destino) {

        int[] dist = new int[N];

        int[] padre = new int[N];

        boolean[] visitado = new boolean[N];

        Arrays.fill(dist, Integer.MAX_VALUE);

        Arrays.fill(padre, -1);

        dist[origen] = 0;

        for (int i = 0; i < N; i++) {

            int u = minimo(
                    dist,
                    visitado);

            visitado[u] = true;

            for (int v = 0; v < N; v++) {

                if (grafo[u][v] > 0
                        && !visitado[v]
                        && dist[u] + grafo[u][v] < dist[v]) {

                    dist[v] =
                            dist[u] + grafo[u][v];

                    padre[v] = u;
                }
            }
        }

        imprimirRuta(
                padre,
                destino);

        System.out.println(
                "\nDistancia total: "
                        + dist[destino]
                        + " metros");
    }

    private int minimo(
            int[] dist,
            boolean[] visitado) {

        int min = Integer.MAX_VALUE;

        int indice = -1;

        for (int i = 0; i < N; i++) {

            if (!visitado[i]
                    && dist[i] < min) {

                min = dist[i];

                indice = i;
            }
        }

        return indice;
    }

    private void imprimirRuta(
            int[] padre,
            int actual) {

        if (actual == -1) return;

        imprimirRuta(
                padre,
                padre[actual]);

        System.out.print(
                nombres[actual] + " -> ");
    }
}