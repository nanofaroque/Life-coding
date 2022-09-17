package effort_2022;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_22 {
    List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        if (n == 0) return result;
        dfs(2 * n, 0, new StringBuilder());
        return result;
    }

    private void dfs(int totalPairs, int idx, StringBuilder sb) {

        if (idx >= totalPairs) {
            if (valid(sb)) {
                result.add(sb.toString());
            }
            return;
        }

        sb.append('(');
        dfs(totalPairs, idx + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
        dfs(totalPairs, idx + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    private boolean valid(StringBuilder sb) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (!stack.isEmpty()) {
                if (c == ')' && stack.peek() == '(') {
                    stack.poll();
                } else stack.push(c);
            }

        }
        return stack.isEmpty();
    }
}
