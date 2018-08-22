package leetcode;

/**
 * @Author ROKG
 * @Description 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 * @Date: Created in 2018/8/17
 * @Modified By:
 */
public class LeetCode321 {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] max = null;
        for (int i=Math.max(0, k-nums2.length);i<=Math.min(nums1.length, k);i++){
            int[] merged=merge(getMax(nums1, i), getMax(nums2, k-i));
            if (max==null || greater(merged, 0, max, 0)){
                max=merged;
            }
        }
        return max;
    }

    public int[] getMax(int[] nums, int k){
        int[] res=new int[k];
        for (int i=0,j=0;i<nums.length;i++){
            while (j>0&&nums.length-i>k-j&&res[j-1]<nums[i]){
                j--;
            }
            if (j<k){
                res[j++]=nums[i];
            }
        }
        return res;
    }

    public int[] merge(int[] nums1, int[] nums2){
        int[] res=new int[nums1.length+nums2.length];
        for (int i=0,j=0,k=0;k<res.length;k++){
            res[k]=greater(nums1, i, nums2, j)?nums1[i++]:nums2[j++];
        }
        return res;
    }

    public boolean greater(int[] nums1, int i, int[] nums2, int j){
        while (i<nums1.length&&j<nums2.length&&nums1[i]==nums2[j]){
            i++;
            j++;
        }
        return j==nums2.length||(i<nums1.length&&nums1[i]<nums2[j]);
    }
}
