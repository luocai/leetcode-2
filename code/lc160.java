package code;
/*
 * 160. Intersection of Two Linked Lists
 * 题意：求两个链表的交叉点
 * 难度：Easy
 * 分类：LinkedList
 * 思路：两种方法：1.找出两个链表的长度差x，长的先走x步； 2.走完一个链表，走另一个链表，两个cur都走了两个链表长度的和步
 * Tips：两种方法的本质是一样的其实，都是找到了步数差，都遍历了两遍
 */
public class lc160 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    // 让一个先走 两个链表的差值，再一起走
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //若两链表有一个为空，都不可能相交，输出为null
        if(headA == null || headB == null)
            return null;
        
        // 分别计算两个链表的长度
        int la =getLen(headA);
        int lb =getLen(headB);
        
        // 让长的先走 abs(la-lb) ， 然后再一起走
        if(la < lb){
            for(int i = 0; i < lb-la; i++){
                headB = headB.next;
            }
        }else{
            for(int i = 0;i  < la-lb; i++){
                headA = headA.next;
            }
        }
        
        while(headA != null && headB != null){
             if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    
    public int getLen(ListNode list){
        int len = 0;
        
        while(list != null){
            list = list.next;
            len++;
        }
        return len;
    }
}
