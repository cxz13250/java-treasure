package leetcode;

/**
 * @Author ROKG
 * @Description 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 * @Date: Created in 下午2:28 2018/7/22
 * @Modified By: *
 */
public class LeetCode477 {

    public int totalHammingDistance(int[] nums) {
        int count=0;
        for (int i=0;i<nums.length-1;i++){
            for (int j=i+1;j<nums.length;j++){
                count+=HammingDistance(nums[i], nums[j]);
            }
        }
        return count;
    }

    //位运算计算海明距离
    public int HammingDistance(int num1, int num2){
       int num=num1 ^ num2;
       int count=0;
       for (int i=1;i<32;i++){
           count += 1 & num;
           num = num >> 1;
       }
       return count;
    }

    //对于每个元素二进制的第位，为1的元素数*为0的元素数，就是海明距离该位上为1的数量
    public int totalHammingDistance2(int[] nums) {
        int count=0;
        for (int i=0;i<32;i++){
            int bitCount=0;
            for (int j=0;j<nums.length;j++){
                bitCount += (nums[j]>>i) & 1;
            }
            count += (nums.length-bitCount)*bitCount;
        }
        return count;
    }
}
