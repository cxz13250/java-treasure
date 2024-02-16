package leetcode2;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午9:12 2024/2/3
 * @Modified By:
 */
public class Leet53_MaxSubArray {

    // f(i) = max{f(i-1) + nums(i), num(i)}
    public int maxSubArray(int[] nums) {
        int fi = 0;
        int max = nums[0];
        for (int x : nums) {
            fi = Math.max(fi + x, x);
            max = Math.max(max, fi);
        }
        return max;
    }

    // 先遍历数组，得到前缀和
    // 再遍历前缀和，记录最小前缀和，和最大值
    // 遍历到sum[i]时，更新最大值 = max{当前最大值,max{sum[i],sum[i]-最小前缀和}}，并更新最小前缀和
    public int maxSubArray2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum[i] = i > 0 ? sum[i -1] + nums[i] : nums[i];
        }
        int min = sum[0];
        int max = sum[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, Math.max(sum[i], sum[i] - min));
            min = Math.min(min, sum[i]);
        }
        return max;
    }
}
