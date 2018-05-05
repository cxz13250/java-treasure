package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 * @Date: Created in 下午3:45 2018/5/2
 * @Modified By:
 */
public class LeetCode637 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Map<Integer,List<Long>> map=new HashMap<>();

    public List<Double> averageOfLevels(TreeNode root) {
        check(root,0);
        List<Double> result=new ArrayList<>();
        for (Integer key:map.keySet()){
            List<Long> list=map.get(key);
            result.add((double)list.get(1)/(double)list.get(0));
        }
        return result;
    }

    public void check(TreeNode node,int height){
        if(node==null){
            return;
        }else {
            if(map.containsKey(height)){
                List<Long> list=map.get(height);
                if(list.isEmpty()){
                    list.add(1L);
                    list.add(Long.valueOf(node.val));
                }else {
                    list.set(0,list.get(0)+1);
                    list.set(1,list.get(1)+node.val);
                }
                map.put(height,list);
            }else {
                List<Long> list=new ArrayList<>();
                list.add(1L);
                list.add(Long.valueOf(node.val));
                map.put(height,list);
            }
            check(node.left,height+1);
            check(node.right,height+1);
        }
    }

    public static void main(String[] args) {
        int s=2147483647;
        System.out.println(s);
    }
}
