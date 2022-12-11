package leetcode.contests.contest_323;

import java.util.Collections;
import java.util.PriorityQueue;

public class LC_2500 {
    public static void main(String[] args) {
        int[][] grid=new int[][]{
                {1,2,4},
                {3,3,1}
        };
        LC_2500 p=new LC_2500();
        p.deleteGreatestValue(grid);
    }
    public int deleteGreatestValue(int[][] grid) {

        int len = grid.length;
        PriorityQueue<Integer>[] arr = new PriorityQueue[len];

        for (int i = 0; i < len; i++) {
            arr[i] = new PriorityQueue<>(Collections.reverseOrder());
        }
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                arr[r].add(grid[r][c]);
            }
        }
        int total = 0;
        int itr = arr[0].size();
        for (int i = 0; i < itr; i++) {
            int t = Integer.MIN_VALUE;

            for (int j = 0; j < len; j++) {
                t = Math.max(t, arr[j].poll());
            }
            total += t;

        }

        return total;
    }
}
