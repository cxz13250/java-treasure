package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * @Date: Created in 下午8:20 2018/5/25
 * @Modified By: *
 */
public class LeetCode41 {

    public int firstMissingPositive(int[] nums) {
        int i=0;
        //依次将各元素调整到对应的索引位上
        while (i<nums.length){
            int index=nums[i]-1;
            if (index>nums.length-1||index<0){
                i++;
            }else {
                if (nums[i]==nums[index]||nums[i]==i+1){
                    i++;
                }else {
                    int temp=nums[index];
                    nums[index]=nums[i];
                    nums[i]=temp;
                }
            }
        }
        for (int j=0;j<nums.length;j++){
            if (nums[j]!=j+1){
                return j+1;
            }
        }
        return nums.length+1;
    }
}
