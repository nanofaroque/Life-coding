package leetcode.contests.contest_315;

public class CountSubArraysWithFixedBounds {
    public static void main(String[] args) {
        CountSubArraysWithFixedBounds p = new CountSubArraysWithFixedBounds();
        long res = p.countSubarrays(new int[]{35054,398719,945315,945315,820417,945315,35054,945315,171832,945315,35054,109750,790964,441974,552913},
        35054,
        945315);
        //System.out.println(res);
    }

    class MaxSegmentTree {
        int[] arr;
        int[][] res;
        MaxSegmentTree(int[] arr) {
            this.arr = arr;
            buildTree();
        }

        private void buildTree() {
            res = new int[arr.length * 2][2];
            int len = arr.length;
            for (int i = 0; i < arr.length; i++) {
                res[len + i] = new int[]{arr[i], arr[i]};
            }
            res[0][0] = Integer.MAX_VALUE;
            int n = len - 1;
            while (n >= 0) {
                res[n] = new int[]{
                        Math.min(res[2 * n][0], res[2 * n + 1][0]),
                        Math.max(res[2 * n][1], res[2 * n + 1][1])};
                n = n - 1;
            }
        }

        int[] find(int left, int right) {
            left = arr.length + left;
            right = arr.length + right;
            if (left == right) return res[left];
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            while (left <= right) {
                if (left == right) {
                    max = Math.max(max, res[left][1]);
                    min = Math.max(min, res[left][0]);
                }
                if (left % 2 != 0) {
                    max = Math.max(res[left][1], max);
                    min = Math.min(res[left][0], min);
                    left += 1;
                }
                if (right % 2 == 0) {
                    max = Math.max(res[right][1], max);
                    min = Math.min(res[right][0], min);
                    right -= 1;
                }
                left = left / 2;
                right = right / 2;
            }

            return new int[]{min, max};
        }

    }

    public long countSubarrays(int[] nums, int minK, int maxK) {
        MaxSegmentTree m = new MaxSegmentTree(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int[] res = m.find(i, j);
                if (res[0] == minK && res[1] == maxK) count++;
            }
        }
        System.out.println(count);
        return count;
    }
}
