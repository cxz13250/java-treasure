package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * @Date: Created in 下午3:09 2018/6/2
 * @Modified By:
 */
public class LeetCode654 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums,0,nums.length-1);
    }

    public static TreeNode buildTree(int[] nums,int start,int end){
        if (start>end){
            return null;
        }
        if (start==end){
            return new TreeNode(nums[start]);
        }
        int max=0;
        int index=0;
        for (int i=start;i<=end;i++){
            if (nums[i]>max){
                max=nums[i];
                index=i;
            }
        }
        TreeNode node=new TreeNode(max);
        node.left=index>start?buildTree(nums,start,index-1):null;
        node.right=index<end?buildTree(nums,index+1,end):null;
        return node;
    }

    public static void main(String[] args) {
        int[] nums={3,2,1,6,0,5};
        TreeNode node=constructMaximumBinaryTree(nums);
        System.out.println(node.val);
    }
}
