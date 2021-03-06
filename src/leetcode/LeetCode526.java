package leetcode;

/**
 * @Author ROKG
 * @Description 假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：
 * 第 i 位的数字能被 i 整除
 * i 能被第 i 位上的数字整除
 * 现在给定一个整数 N，请问可以构造多少个优美的排列？
 * @Date: Created in 2018/8/6
 * @Modified By: *
 */
public class LeetCode526 {

    //递归回溯
    public static int countArrangement(int N) {
        int[] nums=new int[N+1];
        return check(nums,1);
    }

    public static int check(int[] nums,int index){
        if (index==nums.length){
            return 1;
        }
        int total=0;
        for (int i=1;i<nums.length;i++){
            if (nums[i]!=1){
                if (i%index==0 || index%i==0){
                    int[] newNums=nums.clone();
                    newNums[i]=1;
                    total+=check(newNums,index+1);
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(countArrangement(2));
    }
}
