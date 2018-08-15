package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 * @Date: Created in 下午4:07 2018/8/12
 * @Modified By: **
 */
public class LeetCode327 {

    public int countRangeSum(int[] nums, int lower, int upper) {
        long sum[]=new long[nums.length+1];
        for (int i=1;i<=nums.length;i++){
            sum[i]=nums[i-1]+sum[i-1];
        }
        return check(sum,new long[sum.length],0,sum.length-1,lower,upper);
    }

    public int check(long sum[],long help[],int low,int high,int lower,int upper){
        if (low>=high){
            return 0;
        }
        int mid=(high-low+1)/2+low;
        int count=check(sum,help,low,mid-1,lower,upper) + check(sum,help,mid,high,lower,upper);
        int start=mid,end=mid;
        for (int i=low;i<mid;i++) {
            while (start<=high&&sum[start]-sum[i]<lower){
                start++;
            }
            while (end<=high&&sum[end]-sum[i]<=upper){
                end++;
            }
            count+=end-start;
        }
        merge(sum,help,low,mid,high);
        return count;
    }


    public void merge(long sum[],long help[],int low,int high,int mid){
        int left=low,right=mid,index=low;
        while (left<mid&&right<=high){
            if (sum[left]<=sum[right]){
                help[index++]=sum[left++];
            }else {
                help[index++]=sum[right++];
            }
        }
        while (left<mid){
            help[index++]=sum[left++];
        }
        while (right<=high){
            help[index++]=sum[right++];
        }
        System.arraycopy(help,low,sum,low,high-low+1);
    }

}
