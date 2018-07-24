package leetcode;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * @Author ROKG
 * @Description 给出二叉树的根，找出出现次数最多的子树元素和。一个结点的子树元素和定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * 然后求出出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的元素（不限顺序）。
 * @Date: Created in 2018/7/24
 * @Modified By:
 */
public class LeetCode508 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Map<Integer,Integer> map=new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root==null){
            return new int[0];
        }
        getSum(root);
        PriorityQueue<Map.Entry<Integer,Integer>> queue=new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            queue.offer(entry);
        }
        int size=queue.peek().getValue();
        List<Integer> list=new ArrayList<>();
        while (!queue.isEmpty()&&queue.peek().getValue()==size){
            list.add(queue.poll().getKey());
        }
        int[] res=new int[list.size()];
        for (int i=0;i<res.length;i++){
            res[i]=list.get(i);
        }
        return res;
    }

    public int getSum(TreeNode node){
        if (node==null){
            return 0;
        }else {
            int res=node.val+getSum(node.left)+getSum(node.right);
            map.put(res,map.getOrDefault(res,0)+1);
            return res;
        }
    }

    public static void main(String[] args) {
        LeetCode508 k=new LeetCode508();
        TreeNode node=new TreeNode(2);
        node.left=new TreeNode(5);
        node.right=new TreeNode(-5);
        System.out.println(k.findFrequentTreeSum(node));
    }
}
