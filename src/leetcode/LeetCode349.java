package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定两个数组，写一个函数来计算它们的交集。
 * @Date: Created in 下午2:01 2018/5/11
 * @Modified By:
 */
public class LeetCode349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>();
        for (int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        List<Integer> integers=new ArrayList<>();
        for (int i=0;i<nums2.length;i++){
            if (set.contains(nums2[i])&&!integers.contains(nums2[i])){
                integers.add(nums2[i]);
            }
        }
        int[] result=new int[integers.size()];
        for (int i=0;i<integers.size();i++){
            result[i]=integers.get(i);
        }
        return result;
    }
}
