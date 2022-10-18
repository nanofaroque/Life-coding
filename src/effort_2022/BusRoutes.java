package effort_2022;

import java.util.*;

public class BusRoutes {
    public static void main(String[] args) {
        BusRoutes busRoutes=new BusRoutes();
        //int res= busRoutes.numBusesToDestination(new int[][]{{1,2,7},{3,6,7}},1,6);
        int res= busRoutes.numBusesToDestination(new int[][]{{1,7},{3,5}},5,5);
        System.out.println(res);
    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target)return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int idx = 0;
        for (int[] bus : routes) {
            for (int station : bus) {
                map.compute(station, (k, v) -> v == null ? new ArrayList<>() : v).add(idx);
            }
            idx++;
        }
        System.out.println(map);
        int min = Integer.MAX_VALUE;
        for (int start : map.get(source)) {
            int res = bfs(start, map, routes, target);
            min = Math.min(min, res);
        }
        return min == Integer.MAX_VALUE ? -1 : min;

    }

    private int bfs(int stop, Map<Integer, List<Integer>> map, int[][] routes, int target) {
        Queue<Integer> queue = new LinkedList<>();
        int change = 0;
        queue.offer(stop);
        boolean[] visited = new boolean[routes.length];
        while (!queue.isEmpty()) {
            int size = queue.size();
            change++;
            for (int i = 0; i < size; i++) {
                // get the bus
                int bus = queue.poll();
                if (visited[bus]) continue;
                // find all the stations for that bus
                for (int s : routes[bus]) {
                    if (s == target) return change;
                    // where passenger can go from that buss
                    for (int val : map.get(s)) {
                        queue.add(val);
                    }
                }
                visited[bus] = true;
            }


        }
        return Integer.MAX_VALUE;
    }
}
