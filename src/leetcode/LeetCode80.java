package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * @Date: Created in 下午12:58 2018/5/24
 * @Modified By: *
 */
public class LeetCode80 {

    public int removeDuplicates(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int result=1;
        int pre=nums[0];
        boolean allowSame=true;
        for (int i=1;i<nums.length;i++){
            if (nums[i]==pre){
                if (allowSame) {
                    nums[result++]=nums[i];
                    allowSame = false;
                }
            }else {
                pre=nums[i];
                nums[result++]=pre;
                allowSame=true;
            }
        }
        return result;
    }
}
