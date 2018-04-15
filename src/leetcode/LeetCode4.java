package leetcode;

/**
 * @Author ROKG
 * @Description 有两个大小为 m 和 n 的排序数组 nums1 和 nums2 。请找出两个排序数组的中位数并且总的运行时间复杂度为 O(log (m+n)) 。
 * @Date: Created in 下午9:54 2018/4/10
 * @Modified By:
 */
public class LeetCode4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length=nums1.length+nums2.length;
        int result[]=new int[length];
        int i=0;
        int j=0;
        for(int k=0;k<length;k++){
            if(i<nums1.length&&j<nums2.length) {
                if (nums1[i] <= nums2[j]) {
                    result[k] = nums1[i];
                    i++;
                } else {
                    result[k] = nums2[j];
                    j++;
                }
            }else if(i<nums1.length&&j>=nums2.length) {
                result[k]=nums1[i];
                i++;
            }else if(i>=nums1.length&&j<nums2.length){
                result[k]=nums2[j];
                j++;
            }
        }
        if(length%2==0){
            return ((double)(result[length/2-1]+result[length/2]))/2;
        }else {
            return result[length/2];
        }
    }

    public static void main(String[] args) {
        int nums1[]={1,2};
        int nums2[]={3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
