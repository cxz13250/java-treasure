package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个非负整数 num。 对于范围 0 ≤ i ≤ num 中的每个数字 i ，计算其二进制数中的1的数目并将它们作为数组返回。
 * @Date: Created in 下午11:01 2018/7/4
 * @Modified By: *
 */
public class LeetCode338 {

    public int[] countBits(int num) {
        int[] result=new int[num+1];
        if (num==0){
            return result;
        }
        int count=0;
        int index=1;
        while (count<=num){
            int temp=index;
            for (int i=0;i<temp;i++){
                result[index++]=result[i]+1;
                if (index>num){
                    return result;
                }
            }
        }
        return result;
    }
}
