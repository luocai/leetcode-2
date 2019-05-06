package code;

import java.util.HashMap;

/*
 * 437. Path Sum III
 * 题意：树中有几条节点和为sum的路径
 * 难度：Easy
 * 分类：Tree
 * 思路：两种方法，一种类似数组中连续和为k的解法，hashmap. 另一种方法是递归
 * Tips：自己写的自顶向下的 dfs 会出现重复情况，父节点算一次，父节点的父节点也调用它算了一次，注意这种情况。应对方法是写两个函数，在不同的地方调用。
 *       递归的时候用减是否==0的方式，而不是+==sum的方式
 *       和lc560有共同的思想，每个节点只需遍历一遍就可以了
 *       虽然是Easy题，做好也不简单
 *       lc112, lc113, lc437, lc129, lc124, lc337
 *       lc303, lc437, lc560
 */
public class lc437 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // 双重递归 
    int res = 0;
    public int pathSum(TreeNode root, int sum) {
        
        if(root == null)
            return 0;
        
        sum(root, sum);
        
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        
        return res;
    }
    
    public void sum(TreeNode root, int sum){
        
        if(root == null)
            return;
        
        sum -= root.val;
        
        if(sum == 0)
            res++;
        
        sum(root.left, sum);
        sum(root.right ,sum);
        
    }

    //另一种写法
    public static int pathSum(TreeNode root, int sum) { //该节点作为起点
        if (root == null) return 0;
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public static int dfs(TreeNode root, int sum) { //一条路径向下走
        if (root == null) return 0;
        if (root.val == sum) return 1 + dfs(root.left, sum - root.val) + dfs(root.right, sum - root.val);//不要直接返回1，因为可能后边节点，或节点和为0
        return dfs(root.left, sum - root.val) + dfs(root.right, sum - root.val);
    }


    public static int pathSum2(TreeNode root, int sum) {//类似连续和为k的解法
        if (root == null) return 0;
        HashMap<Integer, Integer> hs = new HashMap<>();
        hs.put(0, 1);
        return helper(root, sum, hs, 0);
    }
    public static int helper(TreeNode root, int sum, HashMap<Integer, Integer> hs, int cur_sum) {
        if (root == null)
            return 0;
        cur_sum += root.val;
        int res = hs.getOrDefault(cur_sum - sum, 0);    //该节点作为尾节点的解的个数
        hs.put(cur_sum, hs.getOrDefault(cur_sum, 0)+1);     //注意与上一句顺序
        res += helper(root.left, sum, hs, cur_sum);     //加上孩子节点的解
        res += helper(root.right, sum, hs, cur_sum);
        hs.put(cur_sum, hs.get(cur_sum)-1);
        return res;
    }
}

