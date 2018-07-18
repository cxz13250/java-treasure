package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。要求返回这个链表的深度拷贝。
 * @Date: Created in 2018/7/18
 * @Modified By:
 */
public class LeetCode138 {

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    Map<RandomListNode,RandomListNode> map = new HashMap<>();

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head==null){
            return null;
        }
        RandomListNode node=new RandomListNode(head.label);
        if (map.containsKey(head)){
            return map.get(head);
        }else {
            map.put(head,node);
        }
        node.next=copyRandomList(head.next);
        node.random=copyRandomList(head.random);
        return node;
    }
}
