<<<<<<< HEAD
package leetcode.contests.contest_312;public class LongestSubArrayWithMaxBitWiseAnd {
=======
package leetcode.contests.contest_312;

import java.util.Arrays;

public class LongestSubArrayWithMaxBitWiseAnd {
    public int longestSubarray(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int len = nums.length;
        if (len == 1) return 1;
        if (len == 0) return 0;
        int res = 1;
        for (int i = 0; i < len; i++) {

            if (nums[i] == max) {
                int local = 1;
                int right = i + 1;
                int left = i - 1;
                while (right < len && nums[right] == max) {
                    local++;
                    right++;
                }
                while (left >= 0 && nums[left] == max) {
                    local++;
                    left--;
                }
                res = Math.max(res, local);
            }
            if (res >= len / 2) break;

        }
        return res;
    }
>>>>>>> c796046 (contest 132)
}
