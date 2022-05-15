package leetcode.contests.contest_293;

import java.util.*;

public class Problem_2273 {
    public static void main(String[] args) {
        Problem_2273 p = new Problem_2273();
        p.removeAnagrams(new String[]{"abba", "baba", "bbaa", "cd", "cd"});
    }

    public List<String> removeAnagrams(String[] words) {
        LinkedList<String> set = new LinkedList<>();
        for (String str : words) {
            char newCharArray[] = str.toCharArray();
            Arrays.sort(newCharArray);
            if (set.size() == 0) {
                set.add(str);
            } else {
                String last = set.getLast();
                char lastCharArray[] = last.toCharArray();
                Arrays.sort(lastCharArray);
                if (new String(lastCharArray).equalsIgnoreCase(new String(newCharArray))) {
                    continue;
                }
                set.add(str);
            }
        }
        return set;
    }
}
