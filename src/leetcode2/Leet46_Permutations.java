package leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 不含重复数字的全排列
 * @Date: Created in 下午12:58 2024/1/27
 * @Modified By:
 */
public class Leet46_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, new boolean[nums.length], result, new ArrayList<>());
        return result;
    }

    public void dfs(int[] nums, boolean[] visited, List<List<Integer>> result, List<Integer> tmp) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            tmp.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, result, tmp);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
        }
    }
}
