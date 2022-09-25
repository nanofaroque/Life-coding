package leetcode.contests.contest_312;

import java.util.*;

public class NumberOfGoodPaths {
    public static void main(String[] args) {
        NumberOfGoodPaths p = new NumberOfGoodPaths();
        int total = p.numberOfGoodPaths(new int[]{1, 3, 2, 1, 3},
                new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}});
        System.out.println(total);
    }
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < vals.length; i++) {
            map.compute(vals[i], (k, v) -> v == null ? new ArrayList<>() : v).add(i);
        }

        List<Integer>[] g = new ArrayList[vals.length];
        for (int i = 0; i < vals.length; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            // only add valid paths
            if (vals[e[0]] >= vals[e[1]]) {
                g[e[0]].add(e[1]);
            }
            if (vals[e[1]] >= vals[e[0]]) {
                g[e[1]].add(e[0]);
            }
        }
        int[] parent = new int[vals.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        UF uf = new UF(parent);
        int ans = 0;
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            for (int p : e.getValue()) { // get all the position with certain value
                for (int k : g[p]) {
                    uf.union(p, k); // add all the valid nodes
                }
            }
            // in this small union compute result
            Map<Integer, Integer> groups = new HashMap<>();
            for (int p : e.getValue()) {
                int x = uf.find(p);
                groups.put(x, groups.getOrDefault(x, 0) + 1);
            }
            // add the contribution of each single node
            ans += e.getValue().size();

            // if we have a group with more than one node, then the group can contribute n(n-1) / 2
            for (Map.Entry<Integer, Integer> k : groups.entrySet()) {
                int size = k.getValue();
                if (size >= 2) {
                    ans += (size * (size - 1)) / 2;
                }
            }
        }
        return ans;

    }

    class UF {
        int[] parent;
        int[] rank;

        UF(int[] parent) {
            this.parent = parent;
            this.rank = new int[parent.length];
        }

        int find(int x) {
            if (x == parent[x]) return x;
            else return find(parent[x]);
        }

        void union(int x, int y) {
            int rX = find(x);
            int rY = find(y);
            if (rX == rY) return;

            if (rank[rX] <= rank[rY]) {
                parent[rX] = rY;
            } else parent[rY] = rX;

            if (rank[rX] == rank[rY]) {
                rank[rY]++;
            }
        }
    }
}
