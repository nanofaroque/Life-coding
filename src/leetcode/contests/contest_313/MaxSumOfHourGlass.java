package leetcode.contests.contest_313;

public class MaxSumOfHourGlass {
    public int maxSum(int[][] grid) {
        int R= grid.length;
        if(R==0) return 0;
        int C=grid[0].length;
        int max=0;

        for (int i = 1; i < R-1; i++) {
            for (int j = 1; j < C-1; j++) {
                int sum=grid[i][j]+
                        grid[i-1][j-1]+grid[i-1][j]+grid[i-1][j+1]+
                        grid[i+1][j-1]+grid[i+1][j]+grid[i+1][j+1];
                max=Math.max(sum,max);
            }
        }

        return max;
    }
}
