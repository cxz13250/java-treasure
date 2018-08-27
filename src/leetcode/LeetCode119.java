package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * @Date: Created in 2018/8/27
 * @Modified By: *
 */
public class LeetCode119 {

    // 每次将数组向右移一位，计算从下标1到len-1的元素的新值
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<=rowIndex;i++){
            list.add(0,1);
            for (int j=1;j<list.size()-1;j++){
                list.set(j,list.get(j)+list.get(j+1));
            }
        }
        return list;
    }
}
