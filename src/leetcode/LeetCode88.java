package leetcode;

/**
 * @Author ROKG
 * @Description 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * @Date: Created in 下午11:21 2018/4/25
 * @Modified By:
 */
public class LeetCode88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0){
            for(int i=0;i<n;i++){
                nums1[i]=nums2[i];
            }
        }
        if(n==0){
            return;
        }
        int p=m-1;
        int q=n-1;
        int index=m+n-1;
        while (index>0){
            int max;
            if(p<0){
                max=nums2[q--];
            }else if(q<0) {
                max=nums1[p--];
            }else if(nums1[p]>nums2[q]){
                max=nums1[p--];
            }else {
                max=nums2[q--];
            }
            nums1[index--]=max;
        }
    }
}
