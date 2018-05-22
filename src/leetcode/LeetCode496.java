package leetcode;

/**
 * @Author ROKG
 * @Description 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * @Date: Created in 上午9:54 2018/5/18
 * @Modified By:
 */
public class LeetCode496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result=new int[nums1.length];
        for (int i=0;i<nums1.length;i++){
            for (int j=0;j<nums2.length;j++){
                if (nums2[j]==nums1[i]){
                    while (j<nums2.length&&nums2[j]<=nums1[i]){
                        j++;
                    }
                    if (j==nums2.length){
                        result[i]=-1;
                        break;
                    }else {
                        result[i]=nums2[j];
                    }
                }
            }
        }
        return result;
    }
}
