package effort_2022;

import java.util.Arrays;

public class LC_518 {
    public static void main(String[] args) {
        LC_518 p = new LC_518();
        int res = p.change(5, new int[]{1, 2, 5});
        System.out.println(res);
    }

    public int change(int amount, int[] coins) {
        int[] cache = new int[amount + 1];
        Arrays.sort(coins);
        cache[0]=1;
        for (int coin:coins) {
            for (int amt = coin; amt <= amount ; amt++) {
                if(coin>amount) continue;
                cache[amt]+=cache[amt-coin];
            }
        }
        return cache[amount];
    }
}
