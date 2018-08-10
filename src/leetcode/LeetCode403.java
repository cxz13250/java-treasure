package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author ROKG
 * @Description 一只青蛙想要过河。 假定河流被等分为 x 个单元格，并且在每一个单元格内都有可能放有一石子（也有可能没有）。 青蛙可以跳上石头，但是不可以跳入水中。
 * 给定石子的位置列表（用单元格序号升序表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一个石子上）。 开始时， 青蛙默认已站在第一个石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格1跳至单元格2）。
 * 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
 * @Date: Created in 2018/8/10
 * @Modified By: *
 */
public class LeetCode403 {

    public boolean canCross(int[] stones) {
        if (stones==null || stones.length==0){
            return false;
        }
        if (stones.length==1){
            return true;
        }
        if (stones[1]>1){
            return false;
        }
        if (stones.length==2){
            return true;
        }
        HashSet<Integer> set=new HashSet<>();
        for (int i=0;i<stones.length;i++){
            if (i>3&&stones[i]>2*stones[i-1]){
                return false;
            }
            set.add(stones[i]);
        }
        return check(set,stones[stones.length-1],1,1);
    }

    public boolean check(HashSet<Integer> set, int end, int pos,int jump){
        if (pos+jump==end || pos+jump-1==end || pos+jump+1==end){
            return true;
        }
        if (set.contains(pos+jump+1)){
            if (check(set, end, pos+jump+1, jump+1)){
                return true;
            }
        }
        if (set.contains(pos+jump)) {
            if (check(set, end, pos + jump, jump)) {
                return true;
            }
        }
        if (jump>1&&set.contains(pos+jump-1)){
            if (check(set, end, pos+jump-1,jump-1)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
