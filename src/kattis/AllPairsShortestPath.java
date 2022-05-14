package kattis;

public class AllPairsShortestPath {
    public static void main(String[] args) {
        int INF = 9999;
        int[][] graph = new int[][]{
                {0, 2, INF, INF},
                {INF, 0, 2, INF},
                {INF, INF, 0, INF},
                {INF, INF, 1, 0}
        };
        int N = 4;
        int[][] distance = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                distance[i][j] = graph[i][j];
            }
        }
        update(distance, graph, N);
        printSolution(distance, N);
        int[][] queries = new int[][]{
                {0, 2}, {1, 2}, {3, 0},{3,3}
        };
        for(int[] q:queries)
            System.out.println(distance[q[0]][q[1]]);
    }

    static void printSolution(int dist[][], int V) {
        System.out.println("The following matrix shows the shortest " +
                "distances between every pair of vertices");
        int INF = 9999;
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

    private static void update(int[][] dist, int[][] graph, int N) {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }

}
