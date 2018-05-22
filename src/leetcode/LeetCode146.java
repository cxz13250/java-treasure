package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * @Date: Created in 下午6:44 2018/5/22
 * @Modified By: *
 */
public class LeetCode146 {

    class CacheNode{
        CacheNode pre;
        CacheNode next;
        int key;
        int value;
        CacheNode(int key,int value){
            this.key=key;
            this.value=value;
        }
    }

    class LRUCache {

        int max;
        int count;
        Map<Integer,CacheNode> map=new HashMap<>();
        CacheNode head;
        CacheNode tail;

        public LRUCache(int capacity) {
            count=0;
            max=capacity;
            head=new CacheNode(-1,-1);
            tail=new CacheNode(-1,-1);
            head.next=tail;
            tail.pre=head;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                CacheNode node=map.get(key);
                moveToHead(node);
                return node.value;
            }else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)){
                CacheNode node=map.get(key);
                node.value=value;
                moveToHead(node);
                map.put(key,node);
            }else {
                CacheNode node=new CacheNode(key,value);
                if (count<max){
                    addToHead(node);
                    count++;
                }else {
                    map.remove(tail.pre.key);
                    removeNode(tail.pre);
                    addToHead(node);
                }
                map.put(key,node);
            }
        }

        public void moveToHead(CacheNode node){
            removeNode(node);
            addToHead(node);
        }

        public void removeNode(CacheNode node){
            node.pre.next=node.next;
            node.next.pre=node.pre;
        }

        public void addToHead(CacheNode node){
            node.next=head.next;
            head.next.pre=node;
            head.next=node;
            node.pre=head;
        }
    }

    public void Test(){
        LRUCache l=new LRUCache(2);
        l.put(1,1);
        l.put(2,2);
        System.out.println(l.get(1));
        l.put(3,3);
        System.out.println(l.get(2));
        l.put(4,4);
        System.out.println(l.get(1));
        System.out.println(l.get(3));
        System.out.println(l.get(4));
    }

    public static void main(String[] args) {
        LeetCode146 t=new LeetCode146();
        t.Test();
    }
}
