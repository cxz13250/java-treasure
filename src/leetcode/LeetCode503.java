package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 * @Date: Created in 下午1:17 2018/5/27
 * @Modified By:
 */
public class LeetCode503 {

    public int[] nextGreaterElements(int[] nums) {
        int[] result=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            int temp=nums[i];
            int index=i+1;
            while (index%nums.length!=i&&nums[index%nums.length]<=temp){
                index++;
            }
            if (index%nums.length==i){
                result[i]=-1;
            }else {
                result[i]=nums[index%nums.length];
            }
        }
        return result;
    }
}
