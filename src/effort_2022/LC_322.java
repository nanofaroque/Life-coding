package effort_2022;

import java.util.Arrays;

public class LC_322 {
    public static void main(String[] args) {
        LC_322 p=new LC_322();
        int result =p.coinChange(new int[]{186,419,83,408},
        6249);
        System.out.println(result);
    }
    public int coinChange(int[] coins, int amount) {
        int max=amount+1;
        int[] dp=new int[amount+1];
        Arrays.fill(dp, max);
        dp[0]=0;

        for(int i=1;i<= amount;i++){
            for(int j=0;j<coins.length;j++){
                int coin=coins[j];

                if(coin>i) continue;
                else{
                    dp[i]=Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }
        //MasterPrinter.printArray(result);
        return dp[amount] > amount ? -1 : dp[amount];

    }
}
