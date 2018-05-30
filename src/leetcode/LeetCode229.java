package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * 说明: 要求算法的时间复杂度为O(n)，空间复杂度为O(1)。
 * @Date: Created in 下午2:27 2018/5/28
 * @Modified By:
 */
public class LeetCode229 {

    public List<Integer> majorityElement(int[] nums) {
        int num1=-1,num2=-1;
        int count1=0,count2=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==num1){
                count1++;
            }else if (nums[i]==num2){
                count2++;
            }else {
                if (count1==0){
                    num1=nums[i];
                    count1=0;
                }else if (count2==0){
                    num2=nums[i];
                    count2=0;
                }else {
                    count1--;
                    count2--;
                }
            }
        }
        count1=0;
        count2=0;
        for (int i:nums){
            if (i==num1){
                count1++;
            }else if (i==num2){
                count2++;
            }
        }
        List<Integer> result=new ArrayList<>();
        if (count1>nums.length/3){
            result.add(num1);
        }
        if (count2>nums.length/3){
            result.add(num2);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
