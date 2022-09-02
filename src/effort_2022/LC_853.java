package effort_2022;

import java.util.*;

public class LC_853 {
    public static void main(String[] args) {
        LC_853 p = new LC_853();
        //p.carFleet(12,new int[]{10,8,0,5,3},new int[]{2,4,1,1,3});
        int result = p.carFleet(10, new int[]{ 6, 8}, new int[]{3, 2});
        System.out.println(result);
    }

    class Car {
        int pos;
        int speed;

        Car(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        // 0 3 5 8 10

        //
        int n = speed.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < n; i++) {
            pq.add(new int[]{position[i], speed[i]});
        }

        TreeMap<Double, List<Integer>> timeTaken = new TreeMap<Double, List<Integer>>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            int s = target - position[i];
            int v = speed[i];
            double t = (double) s / v;

            timeTaken.compute(t, (k, val) -> val == null ? new ArrayList<>() : val).add(position[i]);
        }

        System.out.println(timeTaken);
        int total = 0;
        for (Map.Entry<Double, List<Integer>> e : timeTaken.entrySet()) {
            List<Integer> cars = e.getValue();
            Collections.sort(e.getValue(), Collections.reverseOrder());
            int currPos = cars.get(0);
            boolean isProcess = false;
            while (!pq.isEmpty() && pq.peek()[0] <= currPos) {
                pq.poll();
                isProcess = true;
            }
            if (isProcess)
                total += 1;

        }


        return total;
    }
}
