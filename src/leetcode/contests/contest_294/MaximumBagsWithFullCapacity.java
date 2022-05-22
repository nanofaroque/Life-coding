package leetcode.contests.contest_294;

import java.util.Arrays;

public class MaximumBagsWithFullCapacity {
    public static void main(String[] args) {
        MaximumBagsWithFullCapacity mc = new MaximumBagsWithFullCapacity();
        int result = mc.maximumBags(new int[]{2, 3, 4, 5},
                new int[]{1, 2, 4, 4}, 2);

    }

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] diff = new int[rocks.length];
        for (int i = 0; i < rocks.length; i++) {
            diff[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(diff);

        for (int i = 0; i < diff.length; i++) {
            if (additionalRocks == 0) {
                return i;
            }
            if (additionalRocks >= diff[i]) {
                additionalRocks -= diff[i];
            } else {
                return i;
            }
        }
        return capacity.length;
    }
}
