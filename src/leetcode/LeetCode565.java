package leetcode;

import java.util.HashSet;

/**
 * @Author ROKG
 * @Description 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到并返回最大的集合S，S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
 * 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
 * @Date: Created in 上午12:11 2018/8/16
 * @Modified By: *
 */
public class LeetCode565 {

    HashSet<Integer> set=new HashSet<>();

    public int arrayNesting(int[] nums) {
        int res=0;
        for (int i=0;i<nums.length;i++){
            res=Math.max(res,check(nums,i));
        }
        return res;
    }

    public int check(int nums[],int k){
        int res=0;
        while (!set.contains(k)){
            set.add(k);
            k=nums[k];
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode565 l=new LeetCode565();
        System.out.println(l.arrayNesting(new int[]{5,4,0,3,1,6,2}));
    }
}
