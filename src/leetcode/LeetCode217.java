package leetcode;

import java.util.HashSet;

/**
 * @Author ROKG
 * @Description 给定一个整数数组，判断是否存在重复元素。如果任何值在数组中出现至少两次，函数应该返回 true。如果每个元素都不相同，则返回 false。
 * @Date: Created in 下午11:56 2018/4/29
 * @Modified By:
 */
public class LeetCode217 {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if (!set.contains(nums[i])){
                set.add(nums[i]);
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
