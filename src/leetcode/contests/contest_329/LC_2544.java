package leetcode.contests.contest_329;

import java.util.ArrayList;
import java.util.List;

public class LC_2544 {
    public int alternateDigitSum(int n) {
        List<Integer> list = new ArrayList<>();

        while (n > 0) {
            int rem = n % 10;
            n = n / 10;
            list.add(rem);
        }
        int total = 0;
        int mul = 1;
        for (int i = list.size() - 1; i >= 0; i--) {
            total += list.get(i) * mul;
            mul = mul * (-1);
        }
        return total;
    }
}
