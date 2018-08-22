package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author ROKG
 * @Description 城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。现在，假设您获得了城市风光照片（图A）上显示的所有建筑物的位置和高度，请编写一个程序以输出由这些建筑物形成的天际线。
 * @Date: Created in 2018/8/22
 * @Modified By: *
 */
public class LeetCode218 {

    // 先对所有点做排序，横坐标从小到大，横坐标相等按高度从大到小
    // 遍历排序后的结果，如果是左边的点进入堆，如果是右边的点则删除左边的点，如果本次的高度遇上此遍历的点的高度不等，则说明出现拐点，本次点进入结果集
    public List<int[]> getSkyline(int[][] buildings) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> b-a);
        List<int[]> list=new ArrayList<>();
        for (int i=0;i<buildings.length;i++){
            int[] nums=buildings[i];
            list.add(new int[]{nums[0],nums[2]});
            list.add(new int[]{nums[1],-nums[2]});
        }
        Collections.sort(list, (a,b)-> {
            if (a[0]==b[0]){
                return b[1]-a[1];
            }else {
                return a[0]-b[0];
            }
        });
        List<int[]> res=new ArrayList<>();
        int pre=0,cur=0;
        for (int[] nums:list){
            if (nums[1]>0){
                queue.offer(nums[1]);
                cur=queue.peek();
            }else {
                queue.remove(-nums[1]);
                cur=(queue.peek()==null?0:queue.peek());
            }
            if (cur!=pre){
                res.add(new int[]{nums[0],cur});
                pre=cur;
            }
        }
        return res;
    }
}
