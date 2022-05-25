package leetcode.blind_75;

import java.util.HashMap;
import java.util.Map;

public class Problem_3 {
    public static void main(String[] args) {
        Problem_3 p = new Problem_3();
        int res = p.lengthOfLongestSubstring("abba");
        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)return 0;
        int pos=-1;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            int c = (int)s.charAt(i);
            if (!map.isEmpty() && map.containsKey(c)) {
                int prev = map.get(c);
                pos=Math.max(prev,pos);

            }
            max = Math.max(max, i - pos);
            map.put(c, i);
        }
        return Math.max(max,(s.length()-1-pos));
    }
}
