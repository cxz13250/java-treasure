package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * @Date: Created in 2018/8/17
 * @Modified By: *
 */
public class LeetCode315 {

    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        int leftCount=0;
        int count=0;
        public TreeNode(int i){
            val=i;
            count=1;
        }
        public int getCount(){
            return leftCount+count;
        }
    }

    // BST
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res=new ArrayList<>();
        if (nums==null||nums.length==0){
            return res;
        }
        TreeNode root=new TreeNode(nums[nums.length-1]);
        res.add(0);
        for (int i=nums.length-2;i>=0;i--){
            res.add(0,insert(root, nums[i]));
        }
        return res;
    }

    public int insert(TreeNode node,int val){
        if (node.val==val){
            node.count++;
            return node.leftCount;
        }else if (node.val>val){
            node.leftCount++;
            if (node.left==null){
                node.left=new TreeNode(val);
                return 0;
            }
            return insert(node.left, val);
        }else {
            if (node.right==null){
                node.right=new TreeNode(val);
                return node.getCount();
            }
            return node.getCount()+insert(node.right, val);
        }
    }

    public static void main(String[] args) {
        LeetCode315 l=new LeetCode315();
        System.out.println(l.countSmaller(new int[]{5,2,6,1}));
    }
}
