package leetcode.contests.contest_315;

import java.util.HashSet;
import java.util.Set;

public class DistinctInteger {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set=new HashSet<>();

        for(int n:nums){
            set.add(n);
            set.add(reverse(n));
        }
        return set.size();
    }
    static int reverse(int num)
    {
        int rev_num = 0;
        while (num > 0) {
            rev_num = rev_num * 10 + num % 10;
            num = num / 10;
        }
        return rev_num;
    }
}
