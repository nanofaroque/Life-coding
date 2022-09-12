package effort_2022;

import java.util.*;

public class LC_261 {
    public static void main(String[] args) {
        LC_261 p = new LC_261();
        //p.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}});
        p.validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}});
    }

    public boolean validTree(int n, int[][] edges) {

        if (n == 1 && edges.length == 0) return true;
        if (edges.length == 0 || n <= 0) return false;

        Map<Integer, Integer> visited = new HashMap<>();

        Set<Integer>[] graph = new HashSet[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }


        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited.put(0, -1);
        int removedEdge = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int pulled = q.poll();

                for (int data : graph[pulled]) {
                    if (visited.containsKey(data)) return false;
                    else {
                        q.add(data);
                        visited.put(data, data);
                        graph[data].remove(pulled);
                        removedEdge++;
                    }
                }
            }
        }
        if (removedEdge != edges.length) return false;
        if (visited.size() < n) return false;
        return true;
    }
}
