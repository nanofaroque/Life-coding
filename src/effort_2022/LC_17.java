package effort_2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_17 {
    public static void main(String[] args) {
        LC_17 p = new LC_17();
        p.letterCombinations("23");
    }

    static Map<Character, String> keys = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        keys = new HashMap<>();
        keys.put('1', "");
        keys.put('2', "abc");
        keys.put('3', "def");
        keys.put('4', "ghi");
        keys.put('5', "jkl");
        keys.put('6', "mno");
        keys.put('7', "pqrs");
        keys.put('8', "tuv");
        keys.put('9', "wxyz");

        dfs(digits, digits.length(), 0, new StringBuilder(), result);
        return result;

    }

    private void dfs(String digits, int length, int curr, StringBuilder sb, List<String> result) {
        if (curr == length) {
            System.out.println(sb.toString());
            result.add(sb.toString());
            return;
        }

        String letters = keys.get(digits.charAt(curr));
        for (char ch : letters.toCharArray()) {
            sb.append(ch);
            dfs(digits, length, curr + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
