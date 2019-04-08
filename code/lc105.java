package code;
/*
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * 题意：根据先序和中序，构造二叉树
 * 难度：Medium
 * 分类：Array, Tree, Depth-first Search
 * 思路：通过递归的方式，找左节点和右节点
 * Tips：思路记一下，自己想不起来。递归的方法，每次把inorder数组分为两半，设置一个pre_index，每次根据pre_index建立节点，向下递归。
 */
public class lc105 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        buildTree(preorder,inorder);
    }
    
    // 常规
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return solution(preorder, 0, inorder, 0, inorder.length-1);
    }
    
    public TreeNode solution(int[] pre, int index, int[] in, int is, int ie){
        
        //注意边界条件
        if(index == pre.length || is > ie){
            return null;
        }
        
        TreeNode node = new TreeNode(pre[index]);
        
        //找到在中序数组中根节点的位置
        int mark = 0;
        for(int i = is;i <= ie; i++){
            if(pre[index] == in[i]){
                break;
            }else{
                mark++;
            }
        }
        
        node.left = solution(pre, index+1, in, is, is+mark-1);
        node.right = solution(pre, index+mark+1, in, is+mark+1, ie);
        
        return node;
    }
}
