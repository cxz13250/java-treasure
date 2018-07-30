package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 * 例如：
 * [2,3,4]，中位数是 3
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 * 给出一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 * @Date: Created in 2018/7/27
 * @Modified By:
 */
public class LeetCode480 {

    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] result=new double[nums.length-k+1];
        List<Long> list=new ArrayList<>();
        for (int i=0;i<nums.length-k+1;i++){
            if (i==0) {
                for (int j = i; j < i + k; j++) {
                    list.add(Long.valueOf(nums[j]));
                }
            }else {
                list.remove(Long.valueOf(nums[i-1]));
                list.add(Long.valueOf(nums[i+k-1]));
            }
            Collections.sort(list);
            if (k%2==0){
                result[i]=(double)(list.get(k/2-1)+list.get(k/2))/2;
            }else {
                result[i]=list.get(k/2);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={1,3,-1,-3,5,3,6,7};
        double[] dd=medianSlidingWindow(nums,3);
        for (double d:dd){
            System.out.println(d);
        }
    }
}
