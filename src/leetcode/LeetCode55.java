package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个非负整数数组，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * @Date: Created in 下午10:29 2018/5/7
 * @Modified By:
 */
public class LeetCode55 {

    public boolean canJump(int[] nums) {
        int temp=0;
        for(int i=0;i<nums.length;i++){
            if(i>temp){
                return false;
            }
            temp=Math.max(temp,i+nums[i]);
        }
        return true;
    }
}
