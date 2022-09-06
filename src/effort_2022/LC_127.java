package effort_2022;

import java.util.*;

public class LC_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<String>(wordList);

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 0;
        boolean found = false;
        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            Set<String> child = new HashSet<>();
            for (int i = 0; i < size; i++) {
                String str = q.poll();
                if (str.equals(endWord)) {
                    found = true;
                    return level;
                }
                ;
                findAllChilds(str, dict, child, new StringBuilder(str), 0);
            }
            for (String str : child) {
                System.out.println(str);
                dict.remove(str);
                q.add(str);
            }
        }
        return found == true ? level : 0;
    }

    private void findAllChilds(String start, Set<String> dict, Set<String> child, StringBuilder sb, int pos) {
        //System.out.println("pos: "+pos+"-"+sb.toString());
        if (pos == start.length()) {
            return;
        }
        char curr = sb.charAt(pos);
        for (char c = 'a'; c <= 'z'; c++) {
            sb.setCharAt(pos, c);
            if (dict.contains(sb.toString())) {
                child.add(sb.toString());
            }
        }
        sb.setCharAt(pos, curr);
        pos += 1;
        findAllChilds(start, dict, child, sb, pos);
    }
}
