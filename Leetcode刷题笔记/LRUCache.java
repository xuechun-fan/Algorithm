package LeetCode刷题;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Description:
 */
class LRUCache {
    Map<Integer, Node> map;
    Deque<Node> deque;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.deque = new LinkedList<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        //  如果存在，不仅需要返回该key对应的value,还要将该node提到链表的头部
        Node tmp = map.get(key);
        deque.remove(tmp);
        deque.offerFirst(tmp);
        return tmp.value;
    }

    public void put(int key, int value) {
        //  如果当前key在map中已经存在
        if(map.containsKey(key)){
            //  修改该Node的值
            Node node = map.get(key).update(value);
            map.replace(key, node);
            deque.remove(node);
            deque.offerFirst(node);
            return;
        }
        //  当前key不存在，则需要插入
        //  先判断容量
        if(deque.size()>=capacity){
            Node delete = deque.pollLast();
            map.remove(delete.key);
        }
        Node node = new Node(key, value);
        deque.offerFirst(node);
        map.put(key, node);
    }

    static class Node{
        int key;
        int value;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
        public Node update(int val){
            this.value = val;
            return this;
        }
    }
    public static void printStatic(){
        System.out.println("static");
        printStatic1();
    }

    public static void printStatic1(){
        System.out.println("static");
    }
    public void print(){
        System.out.println("static");

    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        int res;
        lRUCache.put(2, 1); // 缓存是 {1=1, 2=2}
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.put(4, 1); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        res = lRUCache.get(1);    // 返回 1
        System.out.println(res);
        res = lRUCache.get(2);    // 返回 -1 (未找到)
        System.out.println(res);
        res = lRUCache.get(1);    // 返回 -1 (未找到)
        System.out.println(res);
        res = lRUCache.get(3);    // 返回 3
        System.out.println(res);
        res = lRUCache.get(4);    // 返回 4
        System.out.println(res);
    }
}