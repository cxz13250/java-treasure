package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 全排列
 * @Date: Created in 下午9:01 2018/4/19
 * @Modified By:
 */
public class LeetCode46 {

    static List<List<Integer>> result=new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> temp=new ArrayList<>();
        check(temp,nums);
        return result;
    }

    public static void check(List<Integer> list,int[] nums){
        if(list.size()==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            check(list,nums);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(permute(nums));
    }
}
