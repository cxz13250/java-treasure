package leetcode;


import java.util.LinkedList;

/**
 * @Author ROKG
 * @Description 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口最大值。
 * @Date: Created in 下午9:45 2018/8/9
 * @Modified By: *
 */
public class LeetCode239 {

    //链表头结点记录当前出现的最大元素下标，窗口右移时，判断链首元素的下标是否在窗口之外，是则溢出从表尾开始删除比新元素小的元素
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0 || nums.length<k){
            return new int[0];
        }
        LinkedList<Integer> windows=new LinkedList();
        int[] res=new int[nums.length-k+1];
        for (int i=0;i<nums.length;i++){
            int cur=nums[i];
            if (!windows.isEmpty()&&windows.getFirst()<=i-k){
                windows.removeFirst();
            }
            while (!windows.isEmpty()&&cur>nums[windows.getLast()]){
                windows.removeLast();
            }
            windows.addLast(i);
            if (i>=k-1){
                res[i-k+1]=nums[windows.getFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode239 l = new LeetCode239();
//        System.out.println(l.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));
        System.out.println();
    }
}
