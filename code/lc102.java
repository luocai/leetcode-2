package code;
/*
 * 102. Binary Tree Level Order Traversal
 * 题意：二叉树层次遍历
 * 难度：Medium
 * 分类：Tree, Breadth-first Search
 * 思路：用一个队列
 * Tips：如何判断遍历完一层了？pop的时候先看下size
 */
import java.util.*;

public class lc102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        
        if(root == null)
            return res;
        LinkedList<TreeNode> queue = new LinkedList();
        
        queue.add(root);
        int size = 1;
        List<Integer> tres = new ArrayList();
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            size--;
            tres.add(node.val);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
            if(size == 0){
                
                res.add(tres);
                tres = new ArrayList();
                size = queue.size();
            }
            
        }
        
        return res;
    }
}
