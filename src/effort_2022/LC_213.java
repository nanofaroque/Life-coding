package effort_2022;

public class LC_213 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        int[] cache1 = new int[len];
        cache1[0] = nums[0];

        for (int i = 1; i < len - 1; i++) {
            if (i == 1) {
                cache1[i] = Math.max(cache1[i - 1], nums[i]);
            } else {
                cache1[i] = Math.max(nums[i] + cache1[i - 2], cache1[i - 1]);
            }
        }
        cache1[len - 1] = cache1[len - 2];


        int[] cache2 = new int[len];
        cache2[0] = 0;

        for (int i = 1; i < len; i++) {
            if (i == 1) {
                cache2[i] = Math.max(cache2[i - 1], nums[i]);
            } else {
                cache2[i] = Math.max(nums[i] + cache2[i - 2], cache2[i - 1]);
            }
        }
        return Math.max(cache1[len - 1], cache2[len - 1]);
    }
}
