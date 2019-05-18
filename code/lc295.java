package code;

import java.util.PriorityQueue;
/*
 * 295. Find Median from Data Stream
 * 题意：流数据中找中位数
 * 难度：Hard
 * 分类：
 * 思路：用两个优先队列，一个保存左半边最大值，一个保存右半边最小值
 *      保持左半边最多比右半边多一个数
 * Tips：
 */
public class lc295 {
    
      // 用两个优先队列
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    int flag = 0; // 标志位，判断加入哪个堆
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue();
        maxHeap = new PriorityQueue(new Comparator<Integer>(){
            
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
    }
    
    public void addNum(int num) {
        
        if(flag == 0){
            // 先放入小根堆，然后取出堆顶（最小的） 放入大根堆
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
            flag = 1;
            
        }else{
            //先放入大根堆，然后取出堆顶（最大的）  放入小根堆
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            flag = 0;
        }
        //这种机制保证了 小根堆都是大的那一半，大根堆都是小的那一半
        
    }
    
    public double findMedian() {
        
        if(flag == 1){
            return maxHeap.peek();
        }else{
            return (maxHeap.peek()+minHeap.peek()) / 2.0;
        }
    }
    
    
    ----------------------------------------------------
    class MedianFinder {
        PriorityQueue<Integer> pq1;    //默认是最小，右半边
        PriorityQueue<Integer> pq2;    //左半边

        /** initialize your data structure here. */
        public MedianFinder() {
            this.pq1 = new PriorityQueue();
            this.pq2 = new PriorityQueue();
        }

        public void addNum(int num) {
            pq1.add(num);   //两个队列都过一遍
            pq2.add(-pq1.poll());
            if (pq1.size() < pq2.size())    //如果中位数是一个数，就存在左半边
                pq1.add(-pq2.poll());
        }

        public double findMedian() {
            if(pq1.size()==pq2.size()+1) return pq1.peek();
            return -((double)(-pq1.peek()+pq2.peek()))/2;
        }
    }
}
