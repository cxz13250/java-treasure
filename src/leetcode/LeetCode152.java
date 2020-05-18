package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * @Date: Created in 下午11:34 2018/4/30
 * @Modified By:
 */
public class LeetCode152 {

    //O(n^2)
    public static int maxProduct(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int max=0;
        for(int i=0;i<nums.length;i++){
            int temp=nums[i];
            max=Math.max(temp,max);
            for(int j=i+1;j<nums.length;j++){
                temp*=nums[j];
                max=Math.max(temp,max);
            }
        }
        return max;
    }

    //O(n)
    public static int maxProduct2(int[] nums) {
        int min[]=new int[nums.length];
        int max[]=new int[nums.length];
        int result;
        result=min[0]=max[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            min[i]=Math.min(nums[i],Math.min(min[i-1]*nums[i],max[i-1]*nums[i]));
            max[i]=Math.max(nums[i],Math.max(min[i-1]*nums[i],max[i-1]*nums[i]));
            result=Math.max(max[i],result);
        }
        return result;

    }

    public static void main(String[] args) {
        int nums[]={2,3,-2,4};
        System.out.println(maxProduct2(nums));
    }
}


