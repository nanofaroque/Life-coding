package leetcode.contests.contest_310;

import java.util.Arrays;
import java.util.PriorityQueue;


public class DivideIntervals {
    public static void main(String[] args) {
        DivideIntervals d = new DivideIntervals();
        int res = d.minGroups(new int[][]{{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}});
        System.out.println(res);
    }

    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        for (int[] in : intervals) {
            int start = in[0];
            int end = in[1];
            if (!minPQ.isEmpty() && start > minPQ.peek()) {
                minPQ.poll();
            }
            minPQ.offer(end);
        }
        return minPQ.size();
    }
}
