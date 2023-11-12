package leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午2:58 2023/11/4
 * @Modified By:
 */
public class Leet39_CombinedSum {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, result, new ArrayList<>(), 0, 0);
        return result;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> tmpList,
                    Integer tmpSum, int index) {
        if (tmpSum == target) {
            result.add(new ArrayList<>(tmpList));
            return;
        }
        if (tmpSum > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            tmpList.add(candidates[i]);
            dfs(candidates, target, result, tmpList, tmpSum + candidates[i], i);
            tmpList.remove(tmpList.size() - 1);
            while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new Leet39_CombinedSum().combinationSum(new int[]{2,3,6,7},7));
    }
}
