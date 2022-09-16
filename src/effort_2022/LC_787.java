package effort_2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC_787 {
    public static void main(String[] args) {
        LC_787 p = new LC_787();
       /* p.findCheapestPrice(4,new int[][]{
                {0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}
        },0,3,1);*/
     /*   p.findCheapestPrice(3,new int[][]{
                {0,1,2},{1,2,1},{2,0,10}},
        1,
        2,
        1);*/
        p.findCheapestPrice(4, new int[][]{
                        {0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}},
                0,
                3,
                1);
    }

    public int findCheapestPrice(int n,
                                 int[][] flights,
                                 int src,
                                 int dst,
                                 int k) {

        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int s = flights[i][0];
            int dest = flights[i][1];
            int cost = flights[i][2];
            graph[s].add(new int[]{dest, cost});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.add(new int[]{src, 0, 0});

        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;

        int[] currentStops = new int[n];
        Arrays.fill(currentStops, Integer.MAX_VALUE);
        currentStops[src] = 0;


        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] curr = queue.poll();

            //int[] info = queue.poll();
            int node = curr[0], stops = curr[1], cost = curr[2];


            if (node == dst) {
                return cost;
            }
            if (stops == k + 1) {
                continue;
            }
            for (int[] next : graph[node]) {
                int nextCity = next[0];
                int nextPrice = next[1];

                int total = cost + nextPrice;

                //if(total>distances[nextCity]) continue;
                if (total < distances[nextCity]) {
                    distances[nextCity] = total;
                    currentStops[nextCity] = stops;
                    queue.add(new int[]{nextCity, curr[1] + 1, total});
                } else if (stops < currentStops[nextCity]) {
                    queue.add(new int[]{nextCity, curr[1] + 1, total});
                }
            }
        }
        return distances[dst] == Integer.MAX_VALUE ? -1 : distances[dst];
    }
}
