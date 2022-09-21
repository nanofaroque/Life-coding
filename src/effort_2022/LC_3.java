package effort_2022;

import java.util.HashMap;
import java.util.Map;

public class LC_3 {
    public static void main(String[] args) {
        LC_3 p = new LC_3();
        p.lengthOfLongestSubstring("au");
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)return 0;
        int lastPosition=-1;
        Map<Character,Integer> map=new HashMap<>();
        int max=1;
        for (int i = 0; i < s.length(); i++) {
            while (i < s.length() && !map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i),i);
                i++;
            }

            if(i>=s.length()){
                max=Math.max(i-lastPosition,max);
            }else lastPosition=map.get(s.charAt(i));
            max=Math.max(i-lastPosition,max);
            if(i< s.length())
                map.put(s.charAt(i),i);
        }
        return max;
    }
}
