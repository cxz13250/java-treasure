package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 输入一个按升序排序的整数数组（可能包含重复数字），你需要将它们分割成几个子序列，其中每个子序列至少包含三个连续整数。
 * 返回你是否能做出这样的分割？
 * @Date: Created in 下午2:49 2018/9/14
 * @Modified By: *
 */
public class LeetCode659 {

    // need用以记录下一个可以放到序列中的数以及可以放的个数
    // 对于num如果need中的值大于0，则说明可以直接放到已有的序列中
    // 如果等于0，说明需要新开一个序列，则寻找num+1和num+2数量是否满足
    public static boolean isPossible(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        Map<Integer, Integer> need=new HashMap<>();
        for (int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for (int num:nums){
            if (map.get(num)==0){
                continue;
            }else if (need.getOrDefault(num,0)>0){
                need.put(num,need.get(num)-1);
                need.put(num+1,need.getOrDefault(num+1,0)+1);
            }else if (map.getOrDefault(num+1,0)>0&&map.getOrDefault(num+2,0)>0){
                map.put(num+1,map.get(num+1)-1);
                map.put(num+2,map.get(num+2)-1);
                need.put(num+3,need.getOrDefault(num+3,0)+1);
            }else {
                return false;
            }
            map.put(num,map.get(num)-1);
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(isPossible(new int[]{1,2,3,3,4,4,5,5}));
        System.out.println(isPossible(new int[]{1,2,3,4,4,5}));
        System.out.println(isPossible(new int[]{2,2,2,3,4,6,7,8,9,9}));
    }
}
