package code;
/*
 * 114. Flatten Binary Tree to Linked List
 * 题意：二叉树转链表
 * 难度：Medium
 * 分类：Tree, Depth-first Search
 * 思路：就是节点间连接换一下，理清思路就行了，类似中序遍历
 * Tips：
 */
public class lc114 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //注意思路
    public void flatten(TreeNode root) {
        
        if(root == null)
            return;
        
        if(root.left != null){
            flatten(root.left);
        }
        
        if(root.right != null){
            flatten(root.right);
        }
        
        TreeNode node = root.right; //暂时保存右子树
        root.right = root.left; // 把左子树变成右子树
        root.left = null;
        
        // 刚接上的右子树一直向右走
        while(root.right != null){
            root = root.right;
        }
        
        //指向原来的右节点
        root.right = node;
        root.left = null;
        
    }
}
