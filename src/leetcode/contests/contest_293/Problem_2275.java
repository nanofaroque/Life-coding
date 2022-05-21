package leetcode.contests.contest_293;

import java.util.Arrays;

public class Problem_2275 {
    public static void main(String[] args) {
        Problem_2275 p = new Problem_2275();
        int max = p.largestCombination(new int[]{8, 8});
        System.out.println(Integer.MAX_VALUE & 16);
        System.out.println(max);
    }


    public int largestCombination(int[] candidates) {
        int num = 1 << 24;
        int[] bits = new int[24];
        for (int candidate : candidates) {

            int result = num | candidate;
            for (int i = 1; i < 25; i++) {
                if ((result & 1) == 1) {
                    System.out.println("1: " + i);
                    bits[i-1] += 1;
                }
                result >>= 1;

            }
        }
        return Arrays.stream(bits).max().getAsInt();
    }
}
