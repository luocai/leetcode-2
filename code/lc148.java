package code;
/*
 * 148. Sort List
 * 题意：链表排序
 * 难度：Medium
 * 分类：Linked List, Sort
 * 思路：快慢指针把链表分成两半，在merge两个链表
 * Tips：空间复杂度不是O(1)的，但是几个高票答案都是这样写的，面试给出这样的代码应该也够了
 */
public class lc148 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    // 经典的呢 , 注意如何寻找链表的终点
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null)
            return head;
        
        ListNode slow = head ,fast = head;
        while(fast.next != null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
       // 1 2 3 4 5
        
        ListNode rhead = slow.next;
        slow.next = null ; // 断开
        
       
        ListNode left = sortList(head);
        ListNode right = sortList(rhead);
      
        
        return merge(left, right);
        
    }
    
    public ListNode merge(ListNode l, ListNode r){
        
        ListNode res = new ListNode(0);
        ListNode cur = res;
        
        while(l!= null && r != null){
            if(l.val < r.val){
                cur.next = l;
                l = l.next;
                cur = cur.next;
               
            }else{
                cur.next = r;
                r = r.next;
                cur = cur.next;
               
            }
        }
        
        if(l != null)
            cur.next = l;
        if(r != null)
            cur.next = r;
        
      
        return res.next;
        
    }

---------------------
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null)
            return head;
        
        ListNode slow = head, fast = head,pre = null;
        //链表拆两半
        while(fast!= null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //断开
        pre.next = null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        return merge(l1,l2);
    }
    
    public ListNode merge(ListNode left, ListNode right){
        //这个技巧
        ListNode res = new ListNode(0);
        ListNode cur = res;
        
        while(left != null & right != null){
            
            if(left.val < right.val){
                cur.next = left;
                cur = cur.next;
                left = left.next;
            }else{
                cur.next = right;
                cur = cur.next;
                right = right.next;
            }
            
        }
        //和数组的差别，这里是if
        if(left != null){
            cur.next = left;
        }
        if(right != null){
            cur.next = right;
        }
        return res.next;
    }
}
