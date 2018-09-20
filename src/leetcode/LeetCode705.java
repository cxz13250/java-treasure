package leetcode;

import java.util.Arrays;

/**
 * @Author ROKG
 * @Description 不使用任何内建的哈希表库设计一个哈希集合
 * 具体地说，你的设计应该包含以下的功能
 * add(value)：向哈希集合中插入一个值。
 * contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 * @Date: Created in 下午4:46 2018/9/16
 * @Modified By:
 */
public class LeetCode705 {

    class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
        }
    }

    int length=16;

    Node[] nodes=new Node[16];

    /** Initialize your data structure here. */
    public LeetCode705() {
        Arrays.fill(nodes,null);
    }

    public void add(int key) {
        int index=getIndex(key);
        Node node=nodes[index];
        if (node==null){
            node=new Node(key);
            nodes[index]=node;
        }else {
            Node tmp=node;
            while (tmp.next!=null){
                if (tmp.val==key){
                    return;
                }
                tmp=tmp.next;
            }
            if (tmp.val==key){
                return;
            }
            tmp.next=new Node(key);
        }
    }

    public void remove(int key) {
        int index=getIndex(key);
        Node node=nodes[index];
        if (node!=null) {
            if (node.val==key){
                nodes[index]=node.next;
                return;
            }
            Node cur=node;
            Node tmp=node;
            while (tmp!=null&&tmp.val!=key){
                cur=tmp;
                tmp=tmp.next;
            }
            if (tmp!=null){
                cur.next=tmp.next;
            }
        }
    }

    /** Returns true if this set did not already contain the specified element */
    public boolean contains(int key) {
        int index=getIndex(key);
        Node node=nodes[index];
        if (node==null){
            return false;
        }else {
            Node tmp=node;
            while (tmp!=null&&tmp.val!=key){
                tmp=tmp.next;
            }
            return tmp!=null;
        }
    }

    public int getIndex(int key){
        return key&(length-1);
    }

}
