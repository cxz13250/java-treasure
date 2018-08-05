package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 * @Date: Created in 下午10:55 2018/8/4
 * @Modified By: *
 */
public class LeetCode410 {

    public int splitArray(int[] nums, int m) {
        int max=0;
        long sum=0;
        for (int num:nums){
            max=Math.max(max,num);
            sum+=num;
        }
        if (m==1){
            return (int)sum;
        }
        long l=max,r=sum;
        while (l<=r){
            long mid=(l+r)/2;
            if (check(mid,nums,m)){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return (int)l;
    }

    public boolean check(long target, int[] nums, int m){
        long cur=0;
        int count=1;
        for (int num:nums){
            cur+=num;
            if (cur>target){
                cur=num;
                count++;
                if (count>m){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums={7,2,5,10,8};
        LeetCode410 l=new LeetCode410();
        System.out.println(l.splitArray(nums,2));
    }
}
