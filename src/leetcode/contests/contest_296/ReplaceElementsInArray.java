package leetcode.contests.contest_296;

import java.util.HashMap;
import java.util.Map;

public class ReplaceElementsInArray {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int[] ops : operations) {
            int loc = map.get(ops[0]);
            nums[loc] = ops[1];
            map.put(ops[1], loc);
        }
        return nums;
    }
}
