package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 你的面前有一堵方形的、由多行砖块组成的砖墙。 这些砖块高度相同但是宽度不同。你现在要画一条自顶向下的、穿过最少砖块的垂线。
 * 砖墙由行的列表表示。 每一行都是一个代表从左至右每块砖的宽度的整数列表。
 * 如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你需要找出怎样画才能使这条线穿过的砖块数量最少，并且返回穿过的砖块数量。
 * 你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 * @Date: Created in 下午10:17 2018/8/15
 * @Modified By: *
 */
public class LeetCode554 {

    public static int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> map=new HashMap<>();
        int res=wall.size();
        for (int i=0;i<wall.size();i++){
            int temp=0;
            for (int j=0;j<wall.get(i).size()-1;j++){
                temp+=wall.get(i).get(j);
                int num=map.getOrDefault(temp,0);
                map.put(temp,++num);
                res=Math.min(res,wall.size()-num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists=new ArrayList<List<Integer>>(){
            {
                add(new ArrayList<Integer>(){
                    {
                        add(1);
                        add(2);
                        add(2);
                        add(1);
                    }
                });
                add(new ArrayList<Integer>(){
                    {
                        add(3);
                        add(1);
                        add(2);
                    }
                });
                add(new ArrayList<Integer>(){
                    {
                        add(1);
                        add(3);
                        add(2);
                    }
                });
                add(new ArrayList<Integer>(){
                    {
                        add(2);
                        add(4);
                    }
                });
                add(new ArrayList<Integer>(){
                    {
                        add(3);
                        add(1);
                        add(2);
                    }
                });
                add(new ArrayList<Integer>(){
                    {
                        add(1);
                        add(3);
                        add(1);
                        add(1);
                    }
                });
            }
        };
        System.out.println(leastBricks(lists));
    }
}
