package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * @Date: Created in 下午5:52 2018/5/3
 * @Modified By:
 */
public class LeetCode78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        result.add(new ArrayList<>());
        for(int num:nums){
            int length=result.size();
            for(int i=0;i<length;i++){
                List<Integer> list=new ArrayList<>(result.get(i));
                list.add(num);
                result.add(list);
            }
        }
        return result;
    }
}
