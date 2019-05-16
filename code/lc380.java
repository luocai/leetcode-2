package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/*
 * 380. Insert Delete GetRandom O(1)
 * 题意：设计一个数据结构，插入，删除，随机获得一个元素 这三个操作的复杂度都为O(1)
 * 难度：Medium
 * 分类：Array, Hash Table, Design
 * 思路：List 的插入和删除都是O(1), 通过hashmap绑定来使得Get也为O(1)
 * Tips：
 */
public class lc380 {
    
     // map用来存 value, index
    Map<Integer,Integer> map ;
    // list 存值
    List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap();
        list = new ArrayList();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        
        if(map.containsKey(val))
            return false;
        
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        
        if(!map.containsKey(val))
            return false;
        
        //保存这个值的位置
        int tindex = map.get(val);
        // 交换当前值和 末尾值，保证删除 o1
        int temp = list.get(tindex);
        list.set(tindex,list.get(list.size()-1));
        list.set(list.size()-1, temp);
        
        //解除了在map，list中的绑定
        map.put(list.get(tindex),tindex);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int max = list.size();
        int min = 0;
        int index = (int)(Math.random()*(max-min)) + min;
        return list.get(index);
    }
}




------------------------------------
    public class RandomizedSet {

        HashMap<Integer, Integer> valToInd;
        List<Integer> list;
        int ind = 0;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            valToInd = new HashMap<>();
            list = new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(valToInd.containsKey(val)) return false;
            list.add(val);
            valToInd.put(val,list.size()-1);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            int ind = valToInd.getOrDefault(val,-1);
            if(ind == -1) return false;
            Collections.swap(list,ind,list.size()-1);
            int swappedWith = list.get(ind);
            valToInd.put(swappedWith,ind);
            list.remove(list.size()-1);
            valToInd.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int max = list.size();
            int min = 0;
            int ind = (int)(Math.random() * (max - min) + min);
            return list.get(ind);
        }
    }
}
