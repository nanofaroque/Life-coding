package leetcode.contests.contest_310;

import java.util.HashSet;
import java.util.Set;

public class OptimalPartition {
    public static void main(String[] args) {
        OptimalPartition p=new OptimalPartition();
        //int res= p.partitionString("hdklqkcssgxlvehva");
        //int res= p.partitionString("ssssss");
        int res= p.partitionString("abacaba");
        System.out.println(res);
    }
    public int partitionString(String s) {
        if(s.length()==0) return 0;
        int idx=0;

        int partition=0;
        while(idx<s.length()){
            Set<Character> set=new HashSet<>();
            while (idx<s.length()){
                char c=s.charAt(idx);
                if(set.contains(c)){
                    partition++;
                    break;
                }else{
                    set.add(c);
                }
                idx++;
            }

        }
        return partition+1;

    }
}
