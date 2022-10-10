package leetcode.contests.contest_314;

public class PathInMatrixDivisibleByK {
    public static void main(String[] args) {
        PathInMatrixDivisibleByK p = new PathInMatrixDivisibleByK();
        //int result= p.numberOfPaths(new int[][]{{5,2,4},{3,0,5},{0,7,2}},3);
        //int result= p.numberOfPaths(new int[][]{{0}},1);
        int result = p.numberOfPaths(new int[][]{{1, 5, 3, 7, 3, 2, 3, 5}},
                29);
        System.out.println(result);
    }

    int MOD = 1000000007;
    int[][][] dp;

    public int numberOfPaths(int[][] grid, int k) {
        this.dp = new int[grid.length][grid[0].length][k + 1];
        return (int) (numPossiblePathsWithSum(grid, 0, 0, 0, k) % MOD);
    }

    public int numPossiblePathsWithSum(int[][] grid, int i, int j, int sum, int k) {
        if (i >= grid.length || j >= grid[0].length) return 0;
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            if ((grid[i][j] + sum) % k == 0) return 1;
            else return 0;
        }
        if (dp[i][j][sum] != 0) return dp[i][j][sum];

        int down = 0, right = 0;
        // down
        if (i + 1 < grid.length)
            down = numPossiblePathsWithSum(grid, i + 1, j, (sum + grid[i][j]) % k, k);
        // right
        if (j + 1 < grid[0].length)
            right = numPossiblePathsWithSum(grid, i, j + 1, (sum + grid[i][j]) % k, k);

        dp[i][j][sum] = (down + right) % 1000000007;

        return (down + right) % 1000000007;
    }
}
