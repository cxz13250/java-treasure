package leetcode;

import dataStructure.array.Base;

/**
 * @Author ROKG
 * @Description 给定一个数组 nums, 编写一个函数将所有 0 移动到它的末尾，同时保持非零元素的相对顺序。
 * @Date: Created in 下午5:56 2018/4/30
 * @Modified By:
 */
public class LeetCode283 {

    public void moveZeroes(int[] nums) {
        boolean flag=false;
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j]==0){
                    Base.swap(nums,j,j+1);
                    flag=true;
                }
            }
            if(!flag){
                break;
            }else {
                flag=false;
            }
        }
    }
}
