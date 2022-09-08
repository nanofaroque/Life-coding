package effort_2022;

public class LC_125 {
    public boolean isPalindrome(String s) {
        String lc = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char c : lc.toCharArray()) {
            if (Character.isLetter(c) || Character.isDigit(c)) {
                sb.append(c);
            }
        }
        int right = sb.length() - 1;
        int left = 0;
        System.out.println(sb.toString());
        while (left <= right) {
            if (sb.charAt(left) != sb.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
