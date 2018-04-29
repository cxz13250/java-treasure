package leetcode;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午10:04 2018/4/21
 * @Modified By:
 */
public class LeetCode27 {

    public int removeElement(int[] nums, int val) {
        int temp=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[temp]=nums[i];
                temp++;
            }
        }
        return temp;
    }

    public static void main(String[] args) {

    }
}
