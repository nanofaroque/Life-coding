package leetcode.contests.contest_314;

import java.util.Stack;

public class Robot {
    public static void main(String[] args) {
        Robot r = new Robot();
        String res = r.robotWithString("zza");
        System.out.println(res);
    }

    public String robotWithString(String s) {
        int[] fre = new int[26];
        for (int i = 0; i < s.length(); i++) {
            fre[s.charAt(i) - 'a'] += 1;
        }

        Stack<Character> stack = new Stack<>();

        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            stack.add(c);
            fre[c - 'a'] -= 1;

            while (!stack.isEmpty() && stack.peek() <= minFrequency(fre)) {
                ans.append(stack.pop());
            }
        }
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.toString();
    }

    private Character minFrequency(int[] fre) {
        for (int i = 0; i < 26; i++) {
            if (fre[i] != 0) {
                return (char) (i + 'a');
            }
        }
        return 'A';
    }
}
