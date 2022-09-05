package effort_2022;

import java.util.Arrays;

public class LC_746 {
    public static void main(String[] args) {
        LC_746 p = new LC_746();
        p.minCostClimbingStairs(new int[]{0, 0, 1, 1});
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] result = new int[cost.length];
        Arrays.fill(result, 0);
        for (int i = 2; i < cost.length; i++) {
            result[i] = cost[i - 1] + result[i - 1];
            result[i] = Math.min(result[i], (cost[i - 2] + result[i - 2]));
        }
        return result[cost.length - 1];
    }
}
