package leetcode;

import java.util.Stack;

/**
 * @Author ROKG
 * @Description 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：
 * 当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 * @Date: Created in 下午1:52 2018/7/21
 * @Modified By: *
 */
public class LeetCode456 {

    //固定23,寻找1
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int third=Integer.MIN_VALUE;
        for (int i=nums.length-1;i>-1;i--){
            if (nums[i]<third){
                return true;
            }
            while (!stack.isEmpty()&&nums[i]>stack.peek()){
                third=stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
