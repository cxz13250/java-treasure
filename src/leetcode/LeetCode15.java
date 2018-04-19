package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ROKG
 * @Description 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组
 * @Date: Created in 下午8:45 2018/4/16
 * @Modified By:
 */
public class LeetCode15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ins=new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){
            while (i>1&&nums[i]==nums[i-1]&&i<nums.length-2){
                i++;
            }
            int j=i+1;
            int k=nums.length-1;
            while (j<k) {
                int a = nums[i];
                int b = nums[j];
                int c = nums[k];
                int sum = a + b + c;
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(a);
                    temp.add(b);
                    temp.add(c);
                    ins.add(temp);
                    j++;
                    k--;
                while (j<k&&nums[k]==nums[k+1]){
                    k--;
                }
                while (j<k&&nums[j]==nums[j-1]){
                    j++;
                }
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return ins.stream().distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] nums={-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
