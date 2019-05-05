// 利用二叉搜索树的性质
class Solution {
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        solution(root,p,q);
        return res;
    }
    
    public void solution(TreeNode root, TreeNode p, TreeNode q){
   
        if((root.val - p.val) * ( root.val - q.val) <= 0){
            res = root;
            return;
        }else if(root.val < p.val && root.val < q.val){
            solution(root.right, p ,q);
        }else{
            solution(root.left, p ,q);
        }
        
    }
}
