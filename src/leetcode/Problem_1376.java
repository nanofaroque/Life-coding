package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_1376 {
    public static void main(String[] args) {
        Problem_1376 p = new Problem_1376();

        p.numOfMinutes(6, 2, new int[]{2, 2, -1, 2, 2, 2}, new int[]{0, 0, 1, 0, 0, 0});
    }

    int max = 0;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        max = 0;
        int len = manager.length;
        List<Integer>[] graph = new ArrayList[len + 1];

        for (int i = 0; i <= len; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < manager.length; i++) {
            int mgr = manager[i];
            if (mgr == -1) {
                graph[len].add(i);
            } else
                graph[mgr].add(i);
        }
        int root = headID;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{root, informTime[headID]});
        bfs(graph, queue, informTime);
        System.out.println(max);
        return max;
    }

    public void bfs(List<Integer>[] graph, Queue<int[]> queue, int[] informTime) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] mgr = queue.poll();
                max = Math.max(max, mgr[1]);
                for (int employee : graph[mgr[0]]) {
                    queue.add(new int[]{employee, mgr[1] + informTime[employee]});
                }
            }
        }
    }
}
