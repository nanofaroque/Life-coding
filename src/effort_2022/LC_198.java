package effort_2022;

public class LC_198 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        int[] cache = new int[len];
        cache[0] = nums[0];

        for (int i = 1; i < len; i++) {
            if (i == 1) {
                cache[i] = Math.max(cache[i - 1], nums[i]);
            } else {
                cache[i] = Math.max(nums[i] + cache[i - 2], cache[i - 1]);
            }
        }
        return cache[len - 1];
    }
}
