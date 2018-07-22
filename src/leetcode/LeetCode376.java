package leetcode;

/**
 * @Author ROKG
 * @Description 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。
 * 少于两个元素的序列也是摆动序列。
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，
 * 第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 * @Date: Created in 下午4:54 2018/7/22
 * @Modified By: *
 */
public class LeetCode376 {

    //寻找拐点
    public int wiggleMaxLength(int[] nums) {
        if (nums.length<=1){
            return nums.length;
        }
        int res=0;
        Boolean flag=null; //true增，false减
        int pre=nums[0];
        for (int i=1;i<nums.length;i++){
            if (nums[i]==pre){
                continue;
            }
            if (flag==null || flag!=nums[i]>pre){
                flag=nums[i]>pre;
                res++;
            }
            pre=nums[i];
        }
        return res;
    }

    //up[i]表示以上升结尾到i结束的序列长度，down[i]表示以下降结尾到i结束的序列长度
    public int wiggleMaxLength2(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int[] up=new int[nums.length];
        int[] down=new int[nums.length];
        up[0]=1;
        down[0]=1;
        for (int i=1;i<nums.length;i++){
            if (nums[i]>nums[i-1]){
                up[i]=down[i-1]+1;
                down[i]=down[i-1];
            }else if (nums[i]<nums[i-1]){
                down[i]=up[i-1]+1;
                up[i]=up[i-1];
            }else {
                down[i]=down[i-1];
                up[i]=up[i-1];
            }
        }
        return Math.max(up[nums.length-1],down[nums.length-1]);
    }
}
