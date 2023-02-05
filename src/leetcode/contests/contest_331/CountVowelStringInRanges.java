package leetcode.contests.contest_331;

public class CountVowelStringInRanges {
    public static void main(String[] args) {
        vowelStrings(new String[]{"aba","bcb","ece","aa","e"},new int[][] {{}});
    }
    public static int[] vowelStrings(String[] words, int[][] queries) {
        int[] data=new int[words.length+2];

        for(int i=0;i<words.length;i++){
            char eChar=words[i].charAt(words[i].length()-1);
            char sChar=words[i].charAt(0);
            if(isVowel(eChar) && isVowel(sChar)){
                data[i+1]=1;
            }
        }

        int[] leftSum=new int[data.length];

        for(int i=1;i< data.length-1;i++){
            if(data[i]==1){
                leftSum[i]+=leftSum[i-1]+1;
            }else{
                leftSum[i]=leftSum[i-1];
            }
        }
        int[] result=new int[queries.length];
        int i=0;
        for (int[] q:queries){
            int left=q[0]+1;
            int right=q[1]+1;

            result[i++]=leftSum[right]-leftSum[left-1];
        }
        return result;
    }

    private static boolean isVowel(char x) {
        if (x == 'a' || x == 'e' || x == 'i' ||
                x == 'o' || x == 'u') return true;
        return false;
    }
}
