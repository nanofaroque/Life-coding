package prep_2024;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        int res = c.coinChange(new int[]{2}, 3);
        System.out.println(res);
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int amt = 1; amt <= amount; amt++) {
            for (int coin : coins) {
                if (coin > amt) continue;
                else {
                    dp[amt] = Math.min(dp[amt], dp[amt - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
