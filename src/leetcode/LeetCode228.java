package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 * @Date: Created in 下午2:51 2018/5/31
 * @Modified By:
 */
public class LeetCode228 {

    public static List<String> summaryRanges(int[] nums) {
        List<String> result=new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            StringBuilder sb=new StringBuilder();
            int temp=nums[i];
            int start=i;
            sb.append(nums[i]);
            while (i<nums.length-1&&nums[i+1]==++temp){
                i++;
            }
            if (i>start){
                sb.append("->"+nums[i]);
            }
            result.add(sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));
    }
}
