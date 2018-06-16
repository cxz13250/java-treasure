package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ROKG
 * @Description 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * @Date: Created in 下午1:21 2018/6/7
 * @Modified By:
 */
public class LeetCode40 {

    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list=new ArrayList<>();
        check(candidates,target,0,list);
        return result;
    }

    public void check(int[] candidates, int target,int index,List<Integer> list){
        if (target==0){
            result.add(new ArrayList<>(list));
            return;
        }else if (target<0){
            return;
        }
        for (int i=index;i<candidates.length;i++){
            list.add(candidates[i]);
            check(candidates,target-candidates[i],i+1,list);
            list.remove(list.size()-1);
            while (i < candidates.length - 1
                 && candidates[i] == candidates[i + 1]){
                i ++;
            }
        }
    }
}
