package leetcode;

/**
 * @Author ROKG
 * @Description 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * @Date: Created in 下午1:59 2018/6/2
 * @Modified By:
 */
public class LeetCode31 {

    public void nextPermutation(int[] nums) {
        int pre=-1,post=-1;
        for (int i=0;i<nums.length-1;i++){
            if (nums[i]<nums[i+1]){
                pre=i;
            }
        }
        if (pre<0){
            reverse(nums,0,nums.length-1);
            return;
        }
        for (int i=pre+1;i<nums.length;i++){
            if (nums[pre]<nums[i]){
                post=i;
            }
        }
        int temp=nums[pre];
        nums[pre]=nums[post];
        nums[post]=temp;
        reverse(nums,pre+1,nums.length-1);
    }

    public void reverse(int[] nums,int start,int end){
        while (start<end){
            int temp= nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
