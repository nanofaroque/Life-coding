package effort_2022;

public class LC_5 {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c);
            sb.append('#');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());

        String max = "";

        for (int i = 1; i < sb.length(); i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < sb.length()) {
                if (sb.charAt(left) != sb.charAt(right)) break;
                left--;
                right++;
            }
            String res = sb.substring(left + 1, right).toString().replaceAll("#", "");
            System.out.println(res);
            //System.out.println(sb.substring(left+1,right).toString());
            if (res.length() > max.length()) {
                max = res;
            }
        }
        return max;
    }
}
