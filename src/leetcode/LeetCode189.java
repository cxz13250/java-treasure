package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * @Date: Created in 上午12:04 2018/5/8
 * @Modified By:
 */
public class LeetCode189 {

    public  void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,nums.length-k-1);
        reverse(nums,nums.length-k,nums.length-1);
        reverse(nums,0,nums.length-1);
    }

    public void reverse(int nums[],int i,int j){
        while (i < j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
    }
}
