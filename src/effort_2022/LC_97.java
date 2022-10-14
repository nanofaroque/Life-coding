package effort_2022;

public class LC_97 {
    private String s1;
    private String s2;
    private String s3;

    private Boolean[][] memo;

    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        memo = new Boolean[s1.length() + 1][s2.length() + 1];

        if (s1.length() + s2.length() != s3.length()) return false;
        return backtrack(s1.length(), s2.length(),s3.length());
    }

    private boolean backtrack(int len1, int len2, int len3) {
        //int len3=len1+len2;
        if (len1 == 0 && len2 == 0) return true;
        if (memo[len1][len2] != null) return memo[len1][len2];

        if(len1>0 && s3.charAt(len3-1)==s1.charAt(len1-1)){
            if(backtrack(len1-1,len2,len3-1)){
                memo[len1][len2]=true;
                return true;
            }
        }
        if (len2 > 0 && s3.charAt(len3 - 1) == s2.charAt(len2 - 1)) {
            if (backtrack(len1, len2 - 1,len3-1)) {
                memo[len1][len2] = true;
                return true;
            }
        }
        return false;
    }
}
