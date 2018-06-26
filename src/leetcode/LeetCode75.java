package leetcode;

import com.sun.xml.internal.ws.handler.HandlerException;

/**
 * @Author ROKG
 * @Description 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * @Date: Created in 下午5:07 2018/6/21
 * @Modified By:
 */
public class LeetCode75 {

    public void sortColors(int[] nums) {
        int count0=0;
        int count1=0;
        int count2=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                count0++;
            }
            if (nums[i]==1){
                count1++;
            }
            if (nums[i]==2){
                count2++;
            }
        }
        int index=0;
        while (count0-->0){
            nums[index++]=0;
        }
        while (count1-->0){
            nums[index++]=1;
        }
        while (count2-->0){
            nums[index++]=2;
        }
    }

    public void sortColors2(int[] nums){
        int index0=0;
        int index2=nums.length-1;
        int index=0;
        while (index<=index2){
            if (nums[index]==0){
                swap(nums,index,index0);
                index0++;
                index++;
            }else if (nums[index]==2){
                swap(nums,index,index2);
                index2--;
            }else {
                index++;
            }
        }
    }

    public void swap(int nums[],int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }

    public static void main(String[] args) {
        String foo1 = args[1];
        String foo2 = args[2];
        String foo3 = args[3];
    }
}
