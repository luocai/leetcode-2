package code;
/*
 * 146. LRU Cache
 * 题意：首先理解LRU思想，最久未被访问过的，最先被替换
 * 难度：Hard
 * 分类：Design
 * 思路：hashmap + 双向链表。hashmap实现了O(1)的get，双向链表实现O(1)的put
 * Tips：能想到双向链表，就不难了
 */
import java.util.HashMap;

class Node {
    int key;
    int value;
    Node pre;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
public class LRUCache {

    HashMap<Integer, Node> map;
    int capicity, count;
    Node head, tail;  // map + 双向链表

    public LRUCache(int capacity) {
        this.capicity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0); // 首尾节点，不存储数据
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;
    }

    public void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(Node node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    public int get(int key) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        }
        return -1;
    }

    public void put(int key, int value) {
        //如果有该点，则取出，然后修改，并放到首部
        if (map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else { // 如果没有，则放入，记得判断容量哦
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capicity) { // 判断容量
                count++;
                addToHead(node);
            } else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }
}

