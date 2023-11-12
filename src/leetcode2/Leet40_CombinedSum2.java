package leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午4:21 2023/10/21
 * @Modified By:
 */
public class Leet40_CombinedSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, result, new ArrayList<>(), 0, new boolean[candidates.length], 0);
        return result;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> tmpList,
                    Integer tmpSum, boolean[] flag, int index) {
        if (tmpSum == target) {
            result.add(new ArrayList<>(tmpList));
            return;
        }
        if (tmpSum > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (flag[i]) {
                continue;
            }
            flag[i] = true;
            tmpList.add(candidates[i]);
            dfs(candidates, target, result, tmpList, tmpSum + candidates[i], flag, i + 1);
            flag[i] = false;
            tmpList.remove(tmpList.size() - 1);
            while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Leet40_CombinedSum2().combinationSum2(new int[]{2,3,6,7},7));
    }
}
