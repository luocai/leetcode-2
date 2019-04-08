package code;
/*
 * 124. Binary Tree Maximum Path Sum
 * 题意：二叉树中找和最大的路径
 * 难度：Hard
 * 分类：Tree, Depth-first Search
 * 思路：因为二叉树只有两个节点，一条路径可以想象成倒V字，从低层的某个节点一路向上，到达一个顶点，再一路向下，理解了这一点，整道题就好解了。
 * Tips：用了一个全局变量存储最后结果，因为函数返回的是直线路径上的最优解，而不是V字路径最优解
 *      lc112, lc113, lc437, lc129, lc124, lc337, lc543
 */
public class lc124 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    
     /**
    对于任意一个节点, 如果最大和路径包含该节点, 那么只可能是两种情况:
    1. 其左右子树中所构成的和路径值较大的那个加上该节点的值后向父节点回溯构成最大路径
    2. 左右子树都在最大路径中, 加上该节点的值构成了最终的最大路径
    **/
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        solution(root);
        
        return res;
    }
    
    public int solution(TreeNode root){
        
        if(root == null)
            return 0;
        
        int left = Math.max(0,solution(root.left)); // 如果左右为负，那么路径不包括他们
        int right = Math.max(0,solution(root.right));
        
        //左右子树都在最大路径中, 加上该节点的值构成了最终的最大路径
        res = Math.max(res, root.val + left+right); //该节点是路径上的最高层节点
        
        // 其左右子树中所构成的和路径值较大的那个加上该节点的值后向父节点回溯构成最大路径
        return root.val + Math.max(left, right);
        
    }
    

}
