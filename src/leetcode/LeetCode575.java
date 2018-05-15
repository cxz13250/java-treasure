package leetcode;

import java.util.HashSet;

/**
 * @Author ROKG
 * @Description 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 * @Date: Created in 下午3:06 2018/5/1
 * @Modified By:
 */
public class LeetCode575 {

    public int distributeCandies(int[] candies) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<candies.length;i++){
            if(!set.contains(candies[i])){
                set.add(candies[i]);
            }
        }
        if(set.size()<=candies.length/2){
            return set.size();
        }else {
            return candies.length/2;
        }
    }
}
