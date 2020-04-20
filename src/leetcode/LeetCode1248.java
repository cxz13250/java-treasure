package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给你一个整数数组 nums 和一个整数 k。如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 请返回这个数组中「优美子数组」的数目。
 * @Date: Created in 上午12:49 2020/4/21
 * @Modified By:
 */
public class LeetCode1248 {

    public static int numberOfSubarrays(int[] nums, int k) {
        int res=0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==1){
                list.add(i);
            }
        }
        if(list.size()<k){
            return 0;
        }
        int l=0;
        int r=k-1;
        while(r<list.size()){
            int pre = l>0?list.get(l-1):-1;
            int next = r<list.size()-1?list.get(r+1):nums.length;
            res+=(list.get(l)-pre)*(next-list.get(r));
            r++;
            l++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 3;
        System.out.println(numberOfSubarrays(nums, k));
    }
}
