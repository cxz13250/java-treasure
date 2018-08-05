package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ROKG
 * @Description 给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。
 * 找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。
 * 你能在O(n)的时间解决这个问题吗？
 * @Date: Created in 下午11:19 2018/8/3
 * @Modified By: *
 */
public class LeetCode421 {

    public int findMaximumXOR(int[] nums) {
        int max=0,mask=0;
        for (int i=31;i>=0;i--){
            mask = mask | (1 << i);
            Set<Integer> set =new HashSet<>();
            for (int num:nums){
                set.add(num & mask);
            }
            int temp = max | (1<<i);
            for (int pre:set){
                if (set.contains(pre^temp)){
                    max=temp;
                    break;
                }
            }
        }
        return max;
    }
}
