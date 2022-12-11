package leetcode.contests.contest_323;

import java.util.*;

public class LC_2501 {
    public static void main(String[] args) {
        LC_2501 p = new LC_2501();
        int r = p.longestSquareStreak(new int[]{4, 3, 6, 16, 8, 2});
        System.out.println(r);
        int rr = p.longestSquareStreak(new int[]{2,3,5,6,7});
        System.out.println(rr);
    }

    HashMap<Integer, Integer> cache;
    Set<Integer> data;

    public int longestSquareStreak(int[] nums) {
        cache = new HashMap<>();
        data=new HashSet<>();
        for(int num:nums) data.add(num);
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int res=-1;
        for (int num : nums) {
            int val = calculate(num, max);
            cache.put(num, val);
            res=Math.max(val,res);
        }

        return res==1?-1:res;
    }

    private int calculate(int n, int max) {
        if (n > max) {
            return 0;
        }
        if (cache.containsKey(n)) return cache.get(n);
        if(data.contains(n*n)){
            int val = calculate(n * n, max) + 1;
            cache.put(n, val);
            return val;
        }

        return 1;
    }
}
