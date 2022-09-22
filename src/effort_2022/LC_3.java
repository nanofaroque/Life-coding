package effort_2022;

import java.util.HashMap;
import java.util.Map;

public class LC_3 {
    public static void main(String[] args) {
        LC_3 p = new LC_3();
        int res = p.lengthOfLongestSubstring("aab");
        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) >= prev) { // since map contains all the character, we might go back.
                    // need to check forward only
                    prev = map.get(c) + 1;
                }
            }
            max = Math.max(max, i - prev + 1);
            map.put(c, i);
        }
        return max;
    }
}
