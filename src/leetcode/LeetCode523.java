package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
 * @Date: Created in 2018/8/7
 * @Modified By:
 */
public class LeetCode523 {

    public static boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length<2){
            return false;
        }
        if (k==0){
            int count=0;
            for (int i=0;i<nums.length;i++){
                if (nums[i]==0){
                    count++;
                    if (count==2){
                        return true;
                    }
                }else {
                    count=0;
                }
            }
            return false;
        }else {
            int count[] = new int[nums.length];
            count[0] = nums[0];
            for (int i = 1; i < count.length; i++) {
                count[i] = nums[i] + count[i - 1];
            }
            for (int i=1;i<count.length;i++) {
                if (count[i] % k == 0) {
                    return true;
                }
            }
            for (int i = 0; i < count.length - 2; i++) {
                for (int j = i + 2; j < count.length; j++) {
                    if ((count[j] - count[i]) % k == 0) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{1},1));
    }
}
