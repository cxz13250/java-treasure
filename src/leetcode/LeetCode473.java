package leetcode;

/**
 * @Author ROKG
 * @Description 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
 * @Date: Created in 下午5:12 2018/5/4
 * @Modified By:
 */
public class LeetCode473 {

    public boolean makesquare(int[] nums) {
        int total=0;
        for (int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        if (total%4!=0){
            return false;
        }
        return check(nums,new int[4],0,total/4);
    }

    public boolean check(int[] nums,int[] sum,int index,int edge){
        if(nums.length<4 || index>nums.length){
            return false;
        }
        if(index==nums.length){
            if(sum[0]==edge && sum[1]==edge && sum[2]==edge && sum[3]==edge)
                return true;
            else
                return false;
        }
        for (int i=0;i<sum.length;i++){
            if(sum[i]+nums[index]<=edge){
                sum[i]+=nums[index];
                if(check(nums,sum,index+1,edge)){
                    return true;
                }
                sum[i]-=nums[index];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode473 t=new LeetCode473();
        int[] nums={1,1,2,2,2};
        System.out.println(t.makesquare(nums));
    }
}
