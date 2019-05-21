 
    // 层次遍历，每次取每层最右边的
    public List<Integer> rightSideView(TreeNode root) {
       
        
        List<Integer> res = new ArrayList();
        if(root == null)
            return res;
        
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        
        int size = 1;
        
        while(!queue.isEmpty()){
            TreeNode node = queue.pollLast();
            size--;
            
            if(node.left != null)
                queue.addFirst(node.left);
            if(node.right != null)
                queue.addFirst(node.right);
            
            if(size == 0){
                res.add(node.val);
                
                size = queue.size();
            }
        }
        return res;
    }
