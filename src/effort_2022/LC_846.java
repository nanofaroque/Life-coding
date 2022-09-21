package effort_2022;

import java.util.PriorityQueue;

public class LC_846 {
    public static void main(String[] args) {
        LC_846 p = new LC_846();
        boolean res = p.isNStraightHand(new int[]{1, 1, 2, 2, 3, 3}, 2);
        System.out.println(res);
        System.out.println(res);
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : hand)
            pq.add(i);
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            for (int i = 1; i < groupSize; i++) {
                if (!pq.remove(curr + i))
                    return false;
            }
        }
        return true;
    }
}
