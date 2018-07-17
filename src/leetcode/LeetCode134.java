package leetcode;

/**
 * @Author ROKG
 * @Description 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * @Date: Created in 2018/7/17
 * @Modified By:
 */
public class LeetCode134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i=0;i<gas.length;i++){
            if (checkArriveOrNot(i,gas,cost)){
                return i;
            }
        }
        return -1;
    }

    public boolean checkArriveOrNot(int start, int[] gas, int[] cost){
        int count=0;
        int total=gas.length;
        while (total>0){
            count+=gas[start];
            if (count<cost[start]){
                return false;
            }else {
                count-=cost[start];
            }
            if (++start>=gas.length){
                start=0;
            }
            total--;
        }
        return true;
    }
}
