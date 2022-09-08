package effort_2022;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_1530 {
    public static void main(String[] args) {
        LC_1530 p=new LC_1530();
        //p.countPairs()
        int result= p.dist("01","1");
        System.out.println(result);
    }

    List<String> leaf;
    public int countPairs(TreeNode root, int distance) {
        StringBuilder sb=new StringBuilder();
        Map<Integer,String> map=new HashMap<>();
        leaf=new ArrayList<>();
        backtrack(sb,map,root);
        int count=0;
        for (int i = 0; i < leaf.size()-1; i++) {
            for (int j = i+1; j <leaf.size() ; j++) {
                int far=dist(leaf.get(i),leaf.get(j));
                if(far<=distance) count++;
            }
        }
        return count;
    }

    private int dist(String x, String y) {
        int i=0;
        while (i<x.length() && i<y.length()){
            if(x.charAt(i)!=y.charAt(i)){
                break;
            }
            i++;
        }
        return (x.length()-i)+(y.length()-i);
    }

    private void backtrack(StringBuilder sb, Map<Integer, String> map, TreeNode root) {
        if(root.left==null && root.right==null){
            System.out.println(sb.toString());
            leaf.add(sb.toString());
            map.put(root.val,sb.toString());
            return;
        }

        if(root.left!=null){
            sb.append('0');
            backtrack(sb,map,root.left);
            sb.deleteCharAt(sb.length()-1);
        }
        if(root.right!=null){
            sb.append('1');
            backtrack(sb,map,root.right);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
