package code;
/*
 * 103. Binary Tree Zigzag Level Order Traversal
 * 题意：蛇形层次遍历
 * 难度：Medium
 * 分类：Stack, Tree, Breadth-first Search
 * 思路：层次遍历，加了个flag每次是在list头添加或尾添加
 * Tips：Bingo!
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class lc103 {

    //巧妙哟
     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null)
            return res;
        
        LinkedList<TreeNode> queue = new LinkedList();
        
        //null表示每一层的分界线
        queue.add(null);
        queue.add(root);
        
        //标志往左还是往右
        boolean flag = true; 
        while(queue.size() > 1){
            //取出队头
            TreeNode node = queue.poll();
            
            //是null说明一层结束了，要开始取数据了
            if(node == null){
                List<Integer> tr = new ArrayList();
                Iterator<TreeNode> it = null;
                
                if(flag)
                    it = queue.iterator();
                else
                    it = queue.descendingIterator();
                
                //取数据
                while(it.hasNext()){
                    tr.add(it.next().val);
                }
                
                res.add(tr);
                //不要忘记增加标志位
                queue.add(null);
                flag = !flag;
                
            }else{
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
        }
        return res;
    }
    
    
    ------------------------------
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new ArrayDeque();
        q.add(root);
        boolean flag = true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> ls = new ArrayList<>();
            while(size>0){
                TreeNode temp = q.remove();
                if(flag) ls.add(temp.val);
                else ls.add(0,temp.val);    //在头部添加
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
                size--;
            }
            res.add(ls);
            flag = !flag;
        }
        return res;
    }
}
