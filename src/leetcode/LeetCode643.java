package leetcode;

/**
 * @Author ROKG
 * @Description 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * @Date: Created in 2018/8/16
 * @Modified By:
 */
public class LeetCode643 {

    public static double findMaxAverage(int[] nums, int k) {
        int res=0;
        int count=0;
        for (int i=0;i<k;i++){
            count+=nums[i];
        }
        res=count;
        int start=0;
        for (int i=k;i<nums.length;i++){
            count=count+nums[i]-nums[start];
            res=Math.max(res, count);
            start++;
        }
        return res/(double)k;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{0,4,0,3,2}, 1));
    }
}
