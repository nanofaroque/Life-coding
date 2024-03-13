package prep_2024;

public class LCS {
    public static void main(String[] args) {
        LCS lcs = new LCS();
        int res = lcs.longestCommonSubsequence("abcde","ace");
        System.out.println(res);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        //    a b c d e
        //  a 1 1 1 1 1
        //  c 1 1 2 2 2
        //  e 1 1 2 2 3
        // fillup with 0
        // no match - find max of rightup and leftdown
        // match - diag + 1

        int col = text1.length();
        int row = text2.length();

        int[][] cache = new int[row+1][col+1];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(text1.charAt(j)!=text2.charAt(i)){
                    cache[i+1][j+1]=Math.max(cache[i][j+1],cache[i+1][j]);
                }else{
                    cache[i+1][j+1]=cache[i][j]+1;
                }
            }
        }
        return cache[row][col];
    }
}
