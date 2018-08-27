package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 * @Date: Created in 下午4:07 2018/8/12
 * @Modified By: **
 */
public class LeetCode327 {

    // 先求出前缀和数组sum，然后进行归并排序，将sum分为两部分，使左右变为有序的
    // 之后使用二指针法，找出左区间内sum[i]对应的区间rl~rr，其中rl为第一个sum[rl]-sum[u]>=lower的下标，rr为第一个sum[rr]-sum[i]>upper的下标。
    // 则贡献区间数为rr-rl个
    public int countRangeSum(int[] nums, int lower, int upper) {
        long sum[]=new long[nums.length+1];
        for (int i=0;i<nums.length;i++){
            sum[i+1]=nums[i]+sum[i];
        }
        return sort(sum,0,nums.length+1,lower,upper);
    }

    public int sort(long sum[], int l, int r, int lower, int upper){
        if (r-l<=1){
            return 0;
        }
        int mid=(r+l)>>1;
        long temp[]=new long[r-l];
        int count= sort(sum,l,mid,lower,upper) + sort(sum,mid,r,lower,upper);
        int rl=mid,rr=mid,j=mid;
        for (int i=l,k=0;i<mid;i++) {
            if (rl<r && sum[rl]-sum[i]<=upper){
                while (rl<r&&sum[rl]-sum[i]<lower){
                    rl++;
                }
                while (rr<r&&sum[rr]-sum[i]<=upper){
                    rr++;
                }
                count+=rr-rl;
            }
            while (j<r&&sum[j]<sum[i]){
                temp[k++]=sum[j++];
            }
            temp[k++]=sum[i];
        }
        System.arraycopy(temp, 0, sum, l, j-l);
        return count;
    }

    public static void main(String[] args) {
        LeetCode327 l=new LeetCode327();
        System.out.println(l.countRangeSum(new int[]{-2,5,-1}, -2, 2));
    }
}
