package leetcode.contests.contest_307;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class LargestPalindromicNumber {
    public String largestPalindromic(String num) {
        TreeMap<Integer, Integer> counter = new TreeMap<>(Comparator.reverseOrder());
        for (char c : num.toCharArray()) {
            int val = Character.getNumericValue(c);
            counter.compute(val, (k, v) -> v == null ? 1 : v + 1);
        }
        System.out.println(counter);
        StringBuilder center = new StringBuilder();
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();

            int rem = val % 2;
            int n = val / 2;
            if (key == 0 && center.length() == 0 && left.length() > 0) {
                center.append(key);
                if (rem == 0) {
                    n--;
                }
            }
            if (key == 0 && center.length() == 0 && left.length() == 0) {
                return "0";
            }
            if (key == 0 && left.length() == 0) {
                continue;
            }
            if (rem == 1) {
                if (center.length() == 0) {
                    center.append(key);
                }
            }
            if (n > 0) {
                while (n > 0) {
                    left.append(key);
                    right.append(key);
                    n--;
                }
            }
        }
        return left.append(center).append(right.reverse()).toString();
    }
}
