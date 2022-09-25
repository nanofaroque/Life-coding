<<<<<<< HEAD
package leetcode.contests.contest_312;public class AllGoodIndices {
=======
package leetcode.contests.contest_312;

import others.MasterPrinter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllGoodIndices {
    public static void main(String[] args) {
        AllGoodIndices p = new AllGoodIndices();
        p.goodIndices(new int[]{2, 1, 1, 1, 3, 4, 1}, 2);
        p.goodIndices(new int[]{2, 1, 1, 2}, 2);
        p.goodIndices(new int[]{878724, 201541, 179099, 98437, 35765, 327555, 475851, 598885, 849470, 943442},
                4);

        p.goodIndices(new int[]{478184, 863008, 716977, 921182, 182844, 350527, 541165, 881224},
                1);
    }

    public List<Integer> goodIndices(int[] nums, int k) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        if (k == 0) {
            res.add(1);
            return res;
        }

        int[] left = new int[len];
        int[] right = new int[len];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i < len; i++) {
            if (nums[i] >= nums[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] >= nums[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        MasterPrinter.printArray(left);

        for (int idx = k; idx < len - k; idx++) {
            if (left[idx + k] - left[idx + 1] == k - 1 && right[idx - k] - right[idx - 1] == k - 1) {
                res.add(idx);
            }
        }
        MasterPrinter.printArray(right);
        return res;
    }
>>>>>>> c796046 (contest 132)
}
