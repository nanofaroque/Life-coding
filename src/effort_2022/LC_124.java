public class LC_124 {
    static int gMax;
    public int maxPathSum(TreeNode root) {
        gMax=Integer.MIN_VALUE;
        dfs(root);
        return gMax;
    }
    
    private int dfs(TreeNode root){
        if(root==null) return Integer.MIN_VALUE;
        
        int left=dfs(root.left);
        int right=dfs(root.right);
        int total=0;
        
        total=(left==Integer.MIN_VALUE?0:left)
            +(right==Integer.MIN_VALUE?0:right)
                +root.val;
        gMax=Math.max(gMax,total);
        
        int lMax=Math.max((left==Integer.MIN_VALUE?0:left)+root.val,
                          (right==Integer.MIN_VALUE?0:right)+root.val
                         );
        System.out.println("Lmax: "+lMax);
        gMax=Math.max(gMax,lMax);
        System.out.println("gMax: "+gMax);
        gMax=Math.max(gMax,Math.max(root.val, lMax));
        return Math.max(root.val, lMax);
    }
}
