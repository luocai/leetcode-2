package code;
/*
 * 141. Linked List Cycle
 * 题意：链表是否有环
 * 难度：Easy
 * 分类：Linked List, Two Pointers
 * 思路：快慢指针
 *      lc142
 */
public class lc141 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
        
   public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null && fast.next != null){
            
            if(fast == slow){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
           
        }
        
        return false;
    }
}
