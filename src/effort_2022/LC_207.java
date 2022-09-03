package effort_2022;

import java.util.*;

public class LC_207 {
    public static void main(String[] args) {
        LC_207 p = new LC_207();
        boolean b = p.canFinish(5,
                new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}});
        System.out.println(b);
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1) return true;
        if (prerequisites.length == 0) return true;
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> g = new HashMap<>();

        for (int[] pre : prerequisites) {
            int parent = pre[0];
            int child = pre[1];
            g.compute(parent, (k, v) -> v == null ? new ArrayList<>() : v).add(child);
            inDegree.compute(child, (k, v) -> v == null ? 1 : v + 1);
            inDegree.compute(parent, (k, v) -> v == null ? 0 : v);
        }

        Queue<Integer> q = new LinkedList<>();
        for (Map.Entry<Integer, Integer> e : inDegree.entrySet()) {
            if (e.getValue() == 0) {
                q.add(e.getKey());
            }
        }
        int e = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (g.get(cur) != null) {
                    List<Integer> ch = g.get(cur);
                    for (int val : ch) {
                        int degree = inDegree.get(val);
                        if (degree - 1 == 0) {
                            q.add(val);
                        }
                        inDegree.put(val, degree - 1);
                        e += 1;
                    }
                }
            }
        }
        if (e < prerequisites.length) return false;
        return e == prerequisites.length;
    }
}
