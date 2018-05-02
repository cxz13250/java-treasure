package leetcode;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午7:17 2018/5/1
 * @Modified By:
 */
public class LeetCode453 {

    public static int minMoves(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        long sum=nums[0];
        long max=nums[0];
        for(int i=1;i<nums.length;i++){
            sum+=nums[i];
            max=Math.max(nums[i],max);
        }
        long total=max*nums.length;
        long temp=total-sum;
        long step=nums.length-1;
        if(temp%step==0){
            return (int)((total-sum)/step);
        }else{
            return (int)((temp+nums.length)/step);
        }
    }

    public static void main(String[] args) {
        int nums[]={-2147483648,-1};
        System.out.println(minMoves(nums));
    }
}
