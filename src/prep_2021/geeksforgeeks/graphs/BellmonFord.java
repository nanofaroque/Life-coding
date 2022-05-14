package prep_2021.geeksforgeeks.graphs;

import others.MasterPrinter;

import java.util.Arrays;

public class BellmonFord {
    int V,E;
    Edge[] edges;
    public BellmonFord(int v, int e) {
        this.V=v;
        this.E=e;
        edges=new Edge[e];
        for (int i = 0; i < e; i++) {
            edges[i]=new Edge(i,i, Integer.MAX_VALUE);
        }
    }

    class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        BellmonFord graph=new BellmonFord(5,8);

        // add edge 0-1 (or A-B in above figure)
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = -1;

        // add edge 0-2 (or A-C in above figure)
        graph.edges[1].src = 0;
        graph.edges[1].dest = 2;
        graph.edges[1].weight = 4;

        // add edge 1-2 (or B-C in above figure)
        graph.edges[2].src = 1;
        graph.edges[2].dest = 2;
        graph.edges[2].weight = 3;

        // add edge 1-3 (or B-D in above figure)
        graph.edges[3].src = 1;
        graph.edges[3].dest = 3;
        graph.edges[3].weight = 2;

        // add edge 1-4 (or A-E in above figure)
        graph.edges[4].src = 1;
        graph.edges[4].dest = 4;
        graph.edges[4].weight = 2;

        // add edge 3-2 (or D-C in above figure)
        graph.edges[5].src = 3;
        graph.edges[5].dest = 2;
        graph.edges[5].weight = 5;

        // add edge 3-1 (or D-B in above figure)
        graph.edges[6].src = 3;
        graph.edges[6].dest = 1;
        graph.edges[6].weight = 1;

        // add edge 4-3 (or E-D in above figure)
        graph.edges[7].src = 4;
        graph.edges[7].dest = 3;
        graph.edges[7].weight = -3;
        int[] result= graph.bellmonFord(graph,0);
        MasterPrinter.printArray(result);
    }

    private int[] bellmonFord(BellmonFord graph, int src) {
        int[] distance=new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src]=0;

        for (int itr = 0; itr < V-1; itr++) {
            for(Edge edge:graph.edges){
                int source=edge.src;
                int destination=edge.dest;
                int weight=edge.weight;

                int curValInSource=distance[source];
                distance[destination]=Math.min(curValInSource+weight,distance[destination]);
            }
        }
        return distance;
    }
}
