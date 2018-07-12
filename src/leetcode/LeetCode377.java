package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 * @Date: Created in 下午11:53 2018/7/10
 * @Modified By: *
 */
public class LeetCode377 {

    public int combinationSum4(int[] nums, int target) {
        int[] result=new int[target+1];
        for (int i=1;i<=target;i++){
            for (int n:nums){
                if (n>i){
                    continue;
                }else if (n==i){
                    result[i]++;
                }else {
                    result[i]+=result[i-n];
                }
            }
        }
        return result[target];
    }
}
