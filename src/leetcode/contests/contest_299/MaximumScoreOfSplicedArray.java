package leetcode.contests.contest_299;

public class MaximumScoreOfSplicedArray {
    public static void main(String[] args) {
        MaximumScoreOfSplicedArray maxi = new MaximumScoreOfSplicedArray();
        maxi.maximumsSplicedArrayByUsingSegmentTree(new int[]{60, 60, 60}, new int[]{10, 90, 10});
    }

    public int maximumsSplicedArrayByUsingSegmentTree(int[] nums1, int[] nums2) {
        SegmentTree st1 = new SegmentTree(nums1);
        //int[] res1 = st1.result;
        //MasterPrinter.printArray(res1);

        SegmentTree st2 = new SegmentTree(nums2);
        //int[] res2 = st2.result;
        //MasterPrinter.printArray(res2);

        //int s = st2.rangeSum(4, 4);
        //System.out.println(s);

        int len = nums1.length;
        int totalSum1 = st1.rangeSum(0, len - 1);
        int totalSum2 = st2.rangeSum(0, len - 1);
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                int left = j;
                int right = j + i;
                System.out.println("left: " + left);
                System.out.println("right: " + right);

                int first = st1.rangeSum(left, right);
                int second = st2.rangeSum(left, right);

                int ns1 = totalSum1 - first + second;
                int ns2 = totalSum2 - second + first;
                max = Math.max(max, Math.max(ns1, ns2));

            }
        }

        System.out.println("max: " + max);
        return max;
    }

    class SegmentTree {
        int[] input;
        int[] result;

        SegmentTree(int[] input) {
            this.input = input;
            this.result = new int[input.length * 2];
            buildTree(input, result);
        }

        int rangeSum(int left, int right) {
            left += input.length;
            right += input.length;
            int total = 0;
            while (left < right) {
                if (left % 2 != 0) {
                    total += result[left];
                    left++;
                }
                if (right % 2 == 0) {
                    total += result[right];
                    right--;
                }
                left /= 2;
                right /= 2;
            }
            total += left == right ? result[left] : 0;
            return total;
        }

    }

    private void buildTree(int[] input, int[] result) {
        int len = input.length;
        // 1 2 3
        // 0 0 0 0 0 0
        for (int i = 0; i < len; i++) {
            result[len + i] = input[i];
        }

        for (int i = len - 1; i >= 0; i--) {
            result[i] = result[2 * i] + result[2 * i + 1];

        }

    }
}
