//斗转星移：保留m前驱，不断抛出后面节点，插入到m前驱之后。
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        //dummy 假的， 辅助用的
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        //前驱节点
        ListNode pre = dummy;
        
        for(int i = 1; i < m; i++){
            pre = pre.next;
        }
        
        //1   2 3 4 5
        //1   3 2 4 5
        //1   4 3 2 5
        ListNode cur = pre.next;
        
        // cur一直指向 i位置, cur.next就是
        for(int i = m; i < n; i++){
            ListNode next = cur.next; //3  //4
            // 仿佛形成一个环 , 每次反转 （m, i+1）??
            cur.next = next.next; //2 -> 4  //2->5   // 连接 i和 i+1位
            next.next = pre.next; // 3 -> 2 // 4->3
            pre.next = next; // 1 -> 3 // 1->4
        }
        
        return dummy.next;
    }
    
