package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个整数数组 nums ，你可以对它进行一些操作。
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * nums的长度最大为20000。
 * 每个整数nums[i]的大小都在[1, 10000]范围内。
 * @Date: Created in 下午11:44 2018/9/18
 * @Modified By: *
 */
public class LeetCode740 {

    // res[i] 表示删除所有小于等于i的数字得到的最大点数
    public int deleteAndEarn(int[] nums) {
        int[] res=new int[10001];
        int[] count=new int[10001];
        for (int num:nums){
            count[num]++;
        }
        res[1]=count[1]*1;
        for (int i=2;i<=10000;i++){
            res[i]=Math.max(res[i-1],res[i-2]+count[i]*i);
        }
        return res[10000];
    }
}
