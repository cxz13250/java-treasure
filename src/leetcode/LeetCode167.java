package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * @Date: Created in 下午8:04 2018/7/29
 * @Modified By:
 */
public class LeetCode167 {

    public int[] twoSum(int[] numbers, int target) {
        int[] result=new int[2];
        int i=0,j=numbers.length-1;
        while (numbers[i]+numbers[j]!=target){
            if (numbers[i]+numbers[j]>target){
                j--;
                while (i<j&&numbers[j]==numbers[j+1]){
                    j--;
                }
            }else {
                i++;
                while (i<j&&numbers[i]==numbers[i-1]){
                    i++;
                }
            }
        }
        result[0]=i+1;
        result[1]=j+1;
        return result;
    }
}
