package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * @Date: Created in 下午3:42 2018/5/11
 * @Modified By:
 */
public class LeetCode136 {

    // 异或运算，a ^ a =0, a ^ b ^ c = a ^ c ^ b
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i:nums){
            result = result ^ i;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
