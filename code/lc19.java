package code;
/*
 * 19. Remove Nth Node From End of List
 * 题意：删除链表中倒数第n个节点
 * 难度：Medium
 * 分类：Linked List, Two Pointers
 * 思路：快慢指针，快指针达到链表尾部时，慢指针所在位置即为操作的节点
 * 注意：看清题意，是倒数第n个，且复杂度为n
 */
public class lc19 {
     public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode p = head;
        ListNode q = head;
        
        while(n > 0 && p != null){
            p = p.next;
            n--;
        }
        if(n != 0)
            return null;
        // 此处要注意
        if(p == null){
            return head.next;
        }
        while(p.next != null){
            p = p.next;
            q = q.next;
        }
        
        q.next = q.next.next;
        
        return head;
    }
}
