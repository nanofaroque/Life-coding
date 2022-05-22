package leetcode.contests.contest_293;

import java.util.PriorityQueue;

public class CountIntegerInterval {
    public static void main(String[] args) {
        CountIntegerInterval cii = new CountIntegerInterval();
    }
    PriorityQueue<int[]> pq;
    public CountIntegerInterval() {
        pq=new PriorityQueue<>((a,b)->a[0]-b[0]);

    }

    public void add(int left, int right) {
        pq.offer(new int[]{left,right,right-left+1});

    }

    public int count() {
        return 0;

    }
}
