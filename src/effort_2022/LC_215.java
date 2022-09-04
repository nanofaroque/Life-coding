package effort_2022;

import java.util.PriorityQueue;

public class LC_215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.poll();
    }
}
