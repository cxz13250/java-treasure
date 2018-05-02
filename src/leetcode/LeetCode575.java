package leetcode;

import java.util.HashSet;

/**
 * @Author ROKG
 * @Description
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
