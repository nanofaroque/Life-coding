package effort_2022;

import java.util.HashMap;
import java.util.Map;

public class LC_128 {
    public static void main(String[] args) {
        LC_128 p = new LC_128();
        p.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});
    }

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> valToPos = new HashMap<>();

        Map<Integer, Integer> countCache = new HashMap<>();
        if (nums.length == 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            valToPos.put(nums[i], i);
        }
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int res = dfs(valToPos, countCache, nums[i]);
            max = Math.max(max, res);
        }
        return max;
    }

    private int dfs(
            Map<Integer, Integer> valToPos,
            Map<Integer, Integer> countCache,
            int val) {
        if (!valToPos.containsKey(val)) {
            countCache.put(val, 0);
        }
        if (countCache.containsKey(val)) return countCache.get(val);
        if (valToPos.containsKey(val)) {
            int temp = 1 + dfs(valToPos, countCache, val + 1);
            countCache.put(val, temp);
        }
        return countCache.get(val);
    }
}
