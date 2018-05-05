package leetcode;

/**
 * @Author ROKG
 * @Description 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * @Date: Created in 下午9:25 2018/5/2
 * @Modified By:
 */
public class LeetCode108 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root=check(nums,0,nums.length-1);
        return root;
    }

    public TreeNode check(int[] nums,int left,int right){
        if(left>right){
            return null;
        }else if(left==right){
            return new TreeNode(nums[left]);
        }else {
            int mid = (left + right) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = check(nums, left, mid - 1);
            node.right = check(nums, mid + 1, right);
            return node;
        }
    }

    public static void main(String[] args) {

    }
}
