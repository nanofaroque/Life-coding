package dailycodings;

import com.sun.tools.javac.util.Pair;
import leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class DailyCoding_1020 {
    static Map<Integer,TreeNode> map=new HashMap<>();
    public static void main(String[] args) {
        TreeNode node=new TreeNode(10);
        node.left=new TreeNode(5);
        node.right=new TreeNode(12);
        node.right.left=new TreeNode(11);
        node.right.right=new TreeNode(15);
        int k=20;
        Pair<TreeNode,TreeNode> res= findNodePair(node,20);
        System.out.println(res.fst.val);
        System.out.println(res.snd.val);
    }

    private static Pair<TreeNode,TreeNode> findNodePair(TreeNode node, int k) {
        System.out.println("Value: "+node.val);
        if(node==null) {
             return null;
        }
        if(map.containsKey(k-node.val)){
            return new Pair<>(node,map.get(k-node.val));
        }
        map.put(node.val,node);
        Pair<TreeNode,TreeNode> res = null;
        if(node.left!=null){
            res= findNodePair(node.left,k);
        }
        if(node.right!=null)
            res=  findNodePair(node.right,k);
        return res;
    }
}
