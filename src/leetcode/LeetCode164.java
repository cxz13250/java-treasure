package leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author ROKG
 * @Description 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。如果数组元素个数小于 2，则返回 0。
 * @Date: Created in 下午12:04 2018/5/31
 * @Modified By:
 */
public class LeetCode164 {

    public static int maximumGap(int[] nums) {
        if (nums.length==0||nums.length==1){
            return 0;
        }
        int max=0;
        for (int i:nums){
            max=Math.max(max,i);
        }
        Map<Integer,Integer> map=new TreeMap<>();
        for (int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int result=0;
        int pre=-1;
        for (Integer i:map.keySet()){
            if (pre==-1){
                pre=i;
            }else {
                result=Math.max(i-pre,result);
                pre=i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={3,6,9,1};
        System.out.println(maximumGap(nums));
    }
}
