package leetcode.contests.contest_293;

public class Problem_2275 {
    public static void main(String[] args) {
        Problem_2275 p = new Problem_2275();
        int max= p.largestCombination(new int[]{8,8});
        System.out.println(Integer.MAX_VALUE & 16);
        System.out.println(max);
    }


    public int largestCombination(int[] candidates) {
        int max=0;
        int num=1<<24;
        int[] bits=new int[24];
        for(int candidate:candidates){

            int result= num|candidate;
            String binaryString = Integer.toBinaryString(result);
            System.out.println(binaryString);
            for(int i=1;i<binaryString.length();i++){
                char c=binaryString.charAt(i);
                if(c=='1'){
                    bits[i-1]+=1;
                }
            }
        }
        for (int j:bits) {
            max=Math.max(j,max);
        }
        return max;
    }

    private void recurse(int[] candidates, int start, int val, int length, int count) {
        if (start >= length) return;
        if ((val & candidates[start]) > 0) {
            max = Math.max(count, max);
            recurse(candidates, start + 1, (val & candidates[start]), length, count + 1);

        }
        recurse(candidates, start + 1, val, length, count);
    }
}
