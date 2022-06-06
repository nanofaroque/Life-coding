package leetcode.contests.contest_296;

public class MinMaxGame {
    public int minMaxGame(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        while (n > 1) {
            int[] newNums = new int[n / 2];
            n /= 2;

            for (int i = 0; i < newNums.length; i++) {
                if (i % 2 == 0) {
                    newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            nums = newNums;
            //MasterPrinter.printArray(nums);
        }

        return nums[0];
    }

}
