package effort_2022;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_150 {
    public int evalRPN(String[] tokens) {

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            if (isSign(str)) {
                int first = stack.poll();
                int second = stack.poll();
                if (str.equalsIgnoreCase("*")) {
                    stack.push(first * second);
                } else if (str.equalsIgnoreCase("/")) {
                    stack.push(second / first);
                } else if (str.equalsIgnoreCase("+")) {
                    stack.push(first + second);
                } else if (str.equalsIgnoreCase("-")) {
                    stack.push(second - first);
                }
            } else stack.push(Integer.parseInt(str));
        }
        return stack.peek();
    }

    private boolean isSign(String str) {
        if (str.length() > 1) return false;
        if (str.equalsIgnoreCase("*") ||
                str.equalsIgnoreCase("+") ||
                str.equalsIgnoreCase("/") ||
                str.equalsIgnoreCase("-")) {
            return true;
        }
        return false;
    }
}
