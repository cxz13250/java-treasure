package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 * @Date: Created in 下午11:36 2018/5/2
 * @Modified By: *
 */
public class LeetCode401 {

    public List<String> readBinaryWatch(int num) {
        List<String> result=new ArrayList<>();
        for (int i=0;i<12;i++){
            for (int j=0;j<60;j++){
                if(Integer.bitCount(i)+Integer.bitCount(j)==num){
                    result.add(String.format("%d:%02d",i,j));
                }
            }
        }
        return result;
    }
}
