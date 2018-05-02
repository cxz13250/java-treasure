package leetcode;

/**
 * @Author ROKG
 * @Description 在一个给定的数组nums中，总是存在一个最大元素 。
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * 如果是，则返回最大元素的索引，否则返回-1。
 * @Date: Created in 上午12:14 2018/5/1
 * @Modified By:
 */
public class LeetCode747 {

    public int dominantIndex(int[] nums) {
        int max=0;
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
                index=i;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(max<2*nums[i]&&i!=index){
                return -1;
            }
        }
        return index;
    }
}
