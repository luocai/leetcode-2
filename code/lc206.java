package code;
/*
 * 206. Reverse Linked List
 * 题意：链表反转
 * 难度：Easy
 * 分类：Linked List
 * 思路：2中方法：设置一个快走一步的快指针，注意赋值操作顺序。还有一种递归的方法。
 * Tips：递归的方法有点绕，多看下
 */
public class lc206 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 三个指针
     public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        
        ListNode pre = null, p = head, q = head.next;
        while(q != null){
            p.next = pre;
            pre = p;
            p = q;
            q = q.next;
        }
        p.next = pre;
        return p;
    }

    
   // 递归
   public ListNode reverseList(ListNode head) {
        return solution(null, head);
    }
    
    public ListNode solution(ListNode pre, ListNode cur){
        if(cur == null)
            return pre;
        
         ListNode next = cur.next;
    
         cur.next = pre;
         pre = cur;
         cur = next;

         return solution(pre,cur);
    }
}
