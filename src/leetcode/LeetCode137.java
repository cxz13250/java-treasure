package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * @Date: Created in 下午10:09 2018/5/22
 * @Modified By:
 */
public class LeetCode137 {

    public static int singleNumber(int[] nums) {
        int result=0;
        for (int i=0;i<32;i++){
            int temp= (1 << i);
            int count=0;
            for (int num:nums){
                if ((num&temp)!=0){
                    count++;
                }
            }
            if (count%3!=0){
                result += temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={0,1,0,1,0,1,99};
        System.out.println(singleNumber(nums));
    }

}
