package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。
 * 编写一个算法来重建这个队列。
 * @Date: Created in 下午11:47 2018/7/26
 * @Modified By:
 */
public class LeetCode406 {

    //先对people排序，第一位数从大到小，第二位数从小到大排列，以第二位数作为下标，插入到结果中
    public static int[][] reconstructQueue(int[][] people) {
        if (people.length == 0){
            return new int[0][2];
        }
        PriorityQueue<int[]> queue  = new PriorityQueue<int[]>(people.length,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o2[0]-o1[0];
            }
        });
        for (int[] p : people){
            queue.offer(p);
        }
        int[][] result=new int[people.length][2];
        LinkedList<int[]> list=new LinkedList<>();
        while (!queue.isEmpty()){
            int[] temp=queue.poll();
            list.add(temp[1],temp);
        }
        for (int i=0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] i={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(reconstructQueue(i));
    }
}
