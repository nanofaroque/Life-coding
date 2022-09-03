package effort_2022;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC_78 {
     Set<List<Integer>> set;
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list=new ArrayList<>();
        set=new HashSet<>();
        
        backtrack(list, 0,nums, nums.length);
        List<List<Integer>> result=new ArrayList<>();
        return new ArrayList<>(set);
        
    }
    
     private void backtrack(List<Integer> list,int pos, int[] nums, int n){
        if(n==pos){
            set.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[pos]);
        backtrack(list,pos+1,nums, n);
        list.remove(list.size()-1);
        backtrack(list,pos+1, nums, n);
    }
}
