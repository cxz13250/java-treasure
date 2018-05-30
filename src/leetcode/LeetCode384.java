package leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author ROKG
 * @Description 打乱一个没有重复元素的数组。
 * @Date: Created in 下午6:36 2018/5/26
 * @Modified By:
 */
public class LeetCode384 {

    class Solution {

        private int[] initial;

        private int[] result;

        public Solution(int[] nums) {
            initial=Arrays.copyOf(nums,nums.length);
            result=nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            result=Arrays.copyOf(initial,initial.length);
            return result;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            for (int i=0;i<result.length;i++){
                int index=new Random().nextInt(i+1);

                int temp=result[i];
                result[i]=result[index];
                result[index]=temp;
            }
            return result;
        }
    }
}
