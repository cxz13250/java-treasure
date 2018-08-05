package leetcode;

/**
 * @Author ROKG
 * @Description 给定一组含有正整数和负整数的数组。如果某个索引中的 n 是正数的，则向前移动 n 个索引。相反，如果是负数(-n)，则向后移动 n 个索引。
 * 假设数组首尾相接。判断数组中是否有环。环中至少包含 2 个元素。环中的元素一律“向前”或者一律“向后”。
 * @Date: Created in 上午1:18 2018/8/5
 * @Modified By: *
 */
public class LeetCode457 {

    public boolean circularArrayLoop(int[] nums) {
        boolean res=false;
        for (int i=0;i<nums.length;i++){
            int j=i,k=getNext(j,nums);
            while (nums[i]*nums[j]>0&&nums[i]*nums[k]>0&&nums[i]*nums[getNext(k,nums)]>0){
                if (j==k){
                    if (j==getNext(j,nums)){
                        break;
                    }
                    return true;
                }
                j=getNext(j,nums);
                k=getNext(getNext(k,nums),nums);
            }
        }
        return res;
    }

    public int getNext(int i,int[] nums){
        int n=nums.length;
        int next=i+nums[i];
        return next>=0?next%n:n+next%n;
    }
}
