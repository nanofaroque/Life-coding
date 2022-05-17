package leetcode.contests.contest_293;

public class Problem_2275 {
    public static void main(String[] args) {
        Problem_2275 p = new Problem_2275();
        p.largestCombination(new int[]{8,8});
        System.out.println(Integer.MAX_VALUE & 16);
        System.out.println(max);
    }

    private static int max;

    public int largestCombination(int[] candidates) {
        int val = Integer.MAX_VALUE;
        int start = 0;
        recurse(candidates, start, val, candidates.length, 1);
        return max;
    }

    private void recurse(int[] candidates, int start, int val, int length, int count) {
        if (start >= length) return;
        if ((val & candidates[start]) > 0) {
            max = Math.max(count, max);
            recurse(candidates, start + 1, (val & candidates[start]), length, count + 1);

        }
        recurse(candidates, start + 1, val, length, count);
    }
}
