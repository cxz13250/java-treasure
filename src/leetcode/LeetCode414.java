package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)
 * @Date: Created in 上午11:08 2018/4/27
 * @Modified By:
 */
public class LeetCode414 {

    public static int thirdMax(int[] nums) {
        Integer first=null;
        Integer second=null;
        Integer third=null;
        for(int i=0;i<nums.length;i++){
            if(first==null||nums[i]>first){
                third=second;
                second=first;
                first=nums[i];
            }else if(nums[i]<first&&(second==null||nums[i]>second)){
                third=second;
                second=nums[i];
            }else if(second!=null&&third==null||(nums[i]<second&&nums[i]>third)){
                third=nums[i];
            }
        }
        if(nums.length<3||third==null){
            return first;
        }else{
            return third;
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,-2147483648};
        System.out.println(thirdMax(nums));
    }
}
