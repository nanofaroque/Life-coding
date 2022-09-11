package leetcode.contests.contest_310;

import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        LongestIncreasingSubsequence lis=new LongestIncreasingSubsequence();
        lis.lengthOfLIS(new int[]{4,2,1,4,3,4,5,8,15},3);
        lis.lengthOfLIS(new int[]{5,4,7,4,10,17,14},7);
    }
    public int lengthOfLIS(int[] nums, int k) {
        int r=nums.length+1;
        int c=nums.length;
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<c;i++){
            map.put(0+"-"+i,1);
        }
        int max=0;
        for(int i=1;i<r;i++){
            int val= map.get((i-1)+"-"+(i-1));
            for(int j=i-1;j<c;j++){
                    if(j==i-1){
                        map.put(i+"-"+j,map.get(i+"-"+j));
                        continue;
                    }
                    int curr=nums[i-1];
                    int found=nums[j];
                    int up = map.get((i-1)+"-"+j);
                    if(found > curr && found-curr <= k){
                        int temp=Math.max(val+1,up);
                        map.put(i+"-"+j,temp);
                    }else{
                        map.put(i+"-"+j,up);
                    }
                    max=Math.max(map.get(i+"-"+j),max);
            }
        }

        System.out.println(max);
        return max;
    }
}
