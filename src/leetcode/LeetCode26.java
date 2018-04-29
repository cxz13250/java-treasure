package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * @Date: Created in 下午12:15 2018/4/21
 * @Modified By:
 */
public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        int temp=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[temp]=nums[i];
                temp++;
            }
        }
        return temp;
    }

    public static void main(String[] args) {

    }
}
