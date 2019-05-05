package code;
/*
 * 234. Palindrome Linked List
 * 题意：判断链表是否是回文的
 * 难度：Easy
 * 分类：LinkedList, Two Pointers
 * 思路：反转一半就行了，避免了空间开销
 * Tips：很好的题，考了 Two Pointers, 还考了链表反转
 */
public class lc234 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 反转后半段就行啦
    public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null)
            return true;
        
        ListNode slow = head, fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
   
        ListNode h = reverse(slow.next);
   
        //注意截断
        slow.next = null;
        while(head != null && h != null){
            if(head.val != h.val){  
                 return false;
            }

            head = head.next;
            h = h.next;
        }
        return true;
        
    }
    
    public ListNode reverse(ListNode head){
        
        if(head == null)
            return null;
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
    
    
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = reverse(slow.next,null);
        slow.next = null;       //注意截断一下
        while(head2!=null&&head!=null){
            if(head2.val!=head.val)
                return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head, ListNode pre){
        ListNode next = head.next;
        head.next = pre;
        if(next==null)
            return head;
        return reverse(next, head);
    }
}

