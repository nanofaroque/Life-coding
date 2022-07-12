package leetcode.contests.contest_299;

import java.util.*;

public class LC_2322 {
    /**
     * Problem Statement:
     * https://leetcode.com/contest/weekly-contest-299/problems/minimum-score-after-removals-on-a-tree
     * <p>
     * <p>
     * There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.
     * <p>
     * You are given a 0-indexed integer array nums of length n where nums[i] represents the value of the ith node. You are also given a 2D integer array edges of length n - 1 where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
     * <p>
     * Remove two distinct edges of the tree to form three connected components. For a pair of removed edges, the following steps are defined:
     * <p>
     * Get the XOR of all the values of the nodes for each of the three components respectively.
     * The difference between the largest XOR value and the smallest XOR value is the score of the pair.
     * <p>
     * For example, say the three components have the node values: [4,5,7], [1,9], and [3,3,3]. The three XOR values are 4 ^ 5 ^ 7 = 6, 1 ^ 9 = 8, and 3 ^ 3 ^ 3 = 3. The largest XOR value is 8 and the smallest XOR value is 3. The score is then 8 - 3 = 5.
     * <p>
     * Return the minimum score of any possible pair of edge removals on the given tree.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,5,5,4,11], edges = [[0,1],[1,2],[1,3],[3,4]]
     * Output: 9
     * Explanation: The diagram above shows a way to make a pair of removals.
     * - The 1st component has nodes [1,3,4] with values [5,4,11]. Its XOR value is 5 ^ 4 ^ 11 = 10.
     * - The 2nd component has node [0] with value [1]. Its XOR value is 1 = 1.
     * - The 3rd component has node [2] with value [5]. Its XOR value is 5 = 5.
     * The score is the difference between the largest and smallest XOR value which is 10 - 1 = 9.
     * It can be shown that no other pair of removals will obtain a smaller score than 9.
     * <p>
     * Example 2:
     * <p>
     * Input: nums = [5,5,2,4,4,2], edges = [[0,1],[1,2],[5,2],[4,3],[1,3]]
     * Output: 0
     * Explanation: The diagram above shows a way to make a pair of removals.
     * - The 1st component has nodes [3,4] with values [4,4]. Its XOR value is 4 ^ 4 = 0.
     * - The 2nd component has nodes [1,0] with values [5,5]. Its XOR value is 5 ^ 5 = 0.
     * - The 3rd component has nodes [2,5] with values [2,2]. Its XOR value is 2 ^ 2 = 0.
     * The score is the difference between the largest and smallest XOR value which is 0 - 0 = 0.
     * We cannot obtain a smaller score than 0.
     * <p>
     * <p>
     * <p>
     * Constraints:
     * <p>
     * n == nums.length
     * 3 <= n <= 1000
     * 1 <= nums[i] <= 108
     * edges.length == n - 1
     * edges[i].length == 2
     * 0 <= ai, bi < n
     * ai != bi
     * edges represents a valid tree.
     */

    public static void main(String[] args) {
        LC_2322 p = new LC_2322();

        int res= p.minimumScore(new int[]{1, 5, 5, 4, 11},
                new int[][]{{0, 1}, {1, 2}, {1, 3}, {3, 4}});
        System.out.println(res);
    }

    public int minimumScore(int[] nums, int[][] edges) {

        Set<Integer>[] graph = new HashSet[nums.length];
        for (int i = 0; i < nums.length; i++) {
            graph[i] = new HashSet<>();
        }
        buildGraph(graph, edges);

        int E = edges.length;
        int V = nums.length;
        int gMin=Integer.MAX_VALUE;
        for (int i = 0; i < E - 1; i++) {
            for (int j = i + 1; j < E; j++) {

                int src = edges[i][0];
                int dst = edges[i][1];

                graph[src].remove(dst);
                graph[dst].remove(src);

                int ssrc = edges[j][0];
                int sdst = edges[j][1];

                graph[ssrc].remove(sdst);
                graph[sdst].remove(ssrc);
                boolean[] visited = new boolean[V];
                TreeSet<Integer> result = new TreeSet<>();

                bfs(nums, src, graph, visited, result);
                bfs(nums, dst, graph, visited, result);
                bfs(nums, ssrc, graph, visited, result);
                bfs(nums, sdst, graph, visited, result);
                System.out.println(result);

                graph[src].add(dst);
                graph[dst].add(src);
                graph[ssrc].add(sdst);
                graph[sdst].add(ssrc);

                int max=result.last();
                int min=result.first();
                gMin=Math.min(gMin,(max-min));
            }
        }
        return gMin;
    }

    private void bfs(int[] nums, int root, Set<Integer>[] graph, boolean[] visited, TreeSet<Integer> result) {
        if (visited[root]) return;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(root);
        int xor = nums[root];
        //System.out.println(xor);
        while (!q.isEmpty()) {
            int data = q.poll();
            if (visited[data]) continue;
            visited[data] = true;

            for (int child : graph[data]) {
                if (!visited[child]) {
                    //System.out.println("xor:"+xor +" child: "+nums[child]);
                    xor = xor ^ nums[child];
                    q.add(child);
                }
            }
        }
        result.add(xor);

    }

    private void buildGraph(Set<Integer>[] graph, int[][] edges) {
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
    }
}
