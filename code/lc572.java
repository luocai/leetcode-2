package code;
/*
 * 572. Subtree of Another Tree
 * 题意：判断一棵树是否为另外一棵树的子树
 * 难度：Easy
 * 分类：Tree
 * 思路：两种方法，一种是先序遍历，然后比较字符串即可，注意每个节点开始前加个字符，null也要加进去。
 *      另一种递归的方法。
 * Tips：
 */
public class lc572 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 递归
     public boolean isSubtree(TreeNode s, TreeNode t) {
        
        if(s == null)
            return false;
        
        boolean res = solution(s,t);
        
        return res || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    public boolean solution(TreeNode s, TreeNode t){
        if(s == null && t == null)
            return true;
        if(s == null || t == null || s.val != t.val)
            return false;
        
        return solution(s.left, t.left) && solution(s.right, t.right);
    }
    
    

    public boolean isSubtree2(TreeNode s, TreeNode t) {
        StringBuilder tree1 = new StringBuilder();
        StringBuilder tree2 = new StringBuilder();
        helper2(s, tree1);
        helper2(s, tree2);
        return tree1.toString().contains(tree2.toString());
    }
    public void helper2(TreeNode node, StringBuilder res){
        if(node==null)
            res.append(",#");   //先放','表示一个新节点的开始，#代表null
        else {
            res.append( ","+node.val );
            helper2(node.left, res);
            helper2(node.right, res);
        }
    }

}
