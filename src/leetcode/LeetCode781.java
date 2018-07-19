package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
 * 返回森林中兔子的最少数量。
 * @Date: Created in 2018/7/19
 * @Modified By:
 */
public class LeetCode781 {

    public int numRabbits(int[] answers) {
        int count=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i:answers){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getKey()==0){
                count+=entry.getValue();
            }else if (entry.getValue()<=entry.getKey()){
                count += entry.getKey() + 1;
            }else if (entry.getValue()>entry.getKey()){
                int k=entry.getKey();
                int v=entry.getValue();
                count+=v%(k+1)!=0?(k+1)*(v/(k+1)+1):v;
            }
        }
        return count;
    }
}
