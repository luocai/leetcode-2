package code;
/*
 * 98. Validate Binary Search Tree
 * 题意：判断是否为二叉搜索树
 * 难度：Medium
 * 分类：Tree, Depth-first Search
 * 思路：两种方法，一种递归；另一种中序遍历的思路；
 * Tips：递归时注意设置最大最小两个参数，因为节点间val限制会传递的
 */
import java.util.Stack;

public class lc98 {
    public static void main(String[] args) {
        TreeNode tn1 = new TreeNode(0);
        tn1.left = new TreeNode(-1);
        //System.out.println(isValidBST(tn1));
        System.out.println(isValidBST2(tn1));
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
   TreeNode last = null;
    public boolean isValidBST(TreeNode root) {
        
        if(root == null)
            return true;
        
        boolean res = isValidBST(root.left);
        
        if(last != null && root.val <= last.val){
            return false;
        }
        
        last = root;
        return res && isValidBST(root.right);
        
    }
    
}
