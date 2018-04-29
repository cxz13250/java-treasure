package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定两个数组，写一个方法来计算它们的交集。
 * @Date: Created in 上午11:05 2018/4/28
 * @Modified By:
 */
public class LeetCode350 {

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> integers=new ArrayList<>();
        int i=0;
        int j=0;
        while (i<nums1.length&&j<nums2.length){
            if(nums1[i]==nums2[j]){
                integers.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                i++;
            }
        }
        int[] result=new int[integers.size()];
        for(int index=0;index<integers.size();i++){
            result[index]=integers.get(index);
        }
        return result;
    }

    public static void main(String[] args) {
        int nums1[]={1};
        int nums2[]={1};
        System.out.println(intersect(nums1,nums2));
    }
}
