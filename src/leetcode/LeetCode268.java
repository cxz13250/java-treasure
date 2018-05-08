package leetcode;

/**
 * @Author ROKG
 * @Description 给出一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * @Date: Created in 下午4:23 2018/5/8
 * @Modified By:
 */
public class LeetCode268{

    public int missingNumber(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int sum=0;
        int total=nums.length*(nums.length+1)/2;
        for (int i:nums){
            sum+=i;
        }
        return total-sum;
    }
}
