package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * @Date: Created in 下午1:33 2018/5/5
 * @Modified By:
 */
public class LeetCode118 {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>(numRows);
        for(int i=0;i<numRows;i++){
            if(i==0){
                List<Integer> list=new ArrayList<>();
                list.add(1);
                result.add(list);
            }else {
                List<Integer> list=new ArrayList<>(i+1);
                list.add(1);
                List<Integer> temp=result.get(i-1);
                for(int j=1;j<i;j++){
                    list.add(temp.get(j-1)+temp.get(j));
                }
                list.add(1);
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
