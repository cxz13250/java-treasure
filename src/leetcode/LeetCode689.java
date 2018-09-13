package leetcode;

/**
 * @Author ROKG
 * @Description 给定数组 nums 由正整数组成，找到三个互不重叠的子数组的最大和。
 * 每个子数组的长度为k，我们要使这3*k个项的和最大化。
 * 返回每个区间起始索引的列表（索引从 0 开始）。如果有多个结果，返回字典序最小的一个。
 * @Date: Created in 2018/9/12
 * @Modified By: *
 */
public class LeetCode689 {

    // sum[i]表示nums中从下标i开始向后k个元素和
    // left[i]表示sum[i]左边最大的下标
    // right[i]表示sum[i]右边最大的下标
    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] res=new int[3];
        int n=nums.length;
        int[] sum=new int[n-k+1];
        int total=0;
        for (int i=0;i<nums.length;i++){
            total+=nums[i];
            if (i>=k){
                total-=nums[i-k];
            }
            if (i>=k-1){
                sum[i-k+1]=total;
            }
        }
        int[] left=new int[n-k+1];
        left[0]=0;
        for (int i=1;i<left.length;i++){
            left[i]=sum[left[i-1]]>=sum[i]?left[i-1]:i;   // 必须要有等号，需满足相等时取字典序小的那个
        }
        int[] right=new int[n-k+1];
        right[right.length-1]=right.length-1;
        for (int i=right.length-2;i>=0;i--){
            right[i]=sum[right[i+1]]>=sum[i]?right[i+1]:i;
        }
        res[0]=0;
        res[1]=k;
        res[2]=2*k;
        for (int i=k;i<sum.length-k;i++){
            if (sum[left[i-k]]+sum[i]+sum[right[i+k]]>sum[res[0]]+sum[res[1]]+sum[res[2]]){   // 第二个数组下标取i时，检查left[i-k]，因为需满足互不重叠
                res[0]=left[i-k];
                res[1]=i;
                res[2]=right[i+k];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res=maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1}, 2);
        System.out.println(res[0]+" "+res[1]+" "+res[2]);
    }
}
