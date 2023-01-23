package leetcode.contests.contest_329;

import java.util.Arrays;

public class LC_2545 {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> b[k] - a[k]);
        return score;
    }
}
