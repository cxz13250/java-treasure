package leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午1:49 2024/2/13
 * @Modified By:
 */
public class Leet78_Subset {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), 0, nums);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> temp, int index, int[] nums) {
        if (index > nums.length) {
            return;
        }
        result.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(result, temp, i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Leet78_Subset().subsets(new int[]{1, 2, 3}));
    }
}
