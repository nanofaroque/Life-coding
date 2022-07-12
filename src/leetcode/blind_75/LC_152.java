package leetcode.blind_75;

public class LC_152 {
    public static void main(String[] args) {
        LC_152 p = new LC_152();
        int result = p.maxProduct(new int[]{2, 3, -2, 4});
        System.out.println(result);
    }

    public int maxProduct(int[] nums) {

        if (nums.length == 0) return 0;

        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int best = maxSoFar;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int temp = Math.max(num, Math.max(num * maxSoFar, num * minSoFar));// We needed to know the previous maxSoFar. so we kept the current maxSoFar in a temp
            minSoFar = Math.min(num, Math.min(num * maxSoFar, num * minSoFar));
            maxSoFar = temp;
            best = Math.max(best, maxSoFar);
        }
        return best;
    }
}
