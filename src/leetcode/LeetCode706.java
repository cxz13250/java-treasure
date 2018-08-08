package leetcode;

import dataStructure.link.LinkedList;

import java.util.Arrays;

/**
 * @Author ROKG
 * @Description 不使用任何内建的哈希表库设计一个哈希映射
 * 具体地说，你的设计应该包含以下的功能
 * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 * get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 * remove(key)：如果映射中存在这个键，删除这个数值对。
 * @Date: Created in 2018/8/8
 * @Modified By:
 */
public class LeetCode706 {

    static class MyHashMap {

        class Node{
            int key;
            int val;
            Node next;
            Node() {}
            Node(int key,int val){
                this.key=key;
                this.val=val;
            }
        }

        int size=16;

        Node[] data=new Node[16];

        /** Initialize your data structure here. */
        public MyHashMap() {
            Arrays.fill(data,null);
        }

        /** value will always be positive. */
        public void put(int key, int value) {
            int index=hash(key);
            Node node=data[index];
            if (node==null){
                Node newNode=new Node(key,value);
                data[index]=newNode;
            }else {
                Node n=node;
                while (n.next!=null){
                    if (n.key==key){
                        n.val=value;
                        return;
                    }
                    n=n.next;
                }
                if (n.key==key){
                    n.val=value;
                    return;
                }
                n.next=new Node(key,value);
            }
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int index=hash(key);
            Node node=data[index];
            if (node==null){
                return -1;
            }else {
                Node n=node;
                while (n!=null&&n.key!=key){
                    n=n.next;
                }
                if (n==null){
                    return -1;
                }else {
                    return n.val;
                }
            }
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int index=hash(key);
            Node node=data[index];
            if (node==null) {
                return;
            }else {
                Node n=node;
                if (n.key==key){
                    data[index]=n.next;
                }else {
                    Node cur=n.next;
                    if (cur==null){
                        return;
                    }
                    while (cur!=null&&cur.key!=key){
                        n=cur;
                        cur=cur.next;
                    }
                    if (cur==null){
                        return;
                    }else {
                        n.next=cur.next;
                    }
                }
            }
        }

        public int hash(int key){
            return key&(size-1);
        }
    }

    public static void main(String[] args) {
        MyHashMap m=new MyHashMap();
        m.put(1,1);
        m.put(2,2);
        System.out.println(m.get(1));
        System.out.println(m.get(3));
        m.put(2,1);
        System.out.println(m.get(2));
        m.remove(2);
        System.out.println(m.get(2));
        m.put(33,67);
        m.put(33,87);
        System.out.println(m.get(33));
    }
}
