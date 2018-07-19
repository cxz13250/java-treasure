package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 * @Date: Created in 下午2:28 2018/6/29
 * @Modified By: *
 */
public class LeetCode89 {

    public List<Integer> grayCode(int n) {
        List<Integer> result=new ArrayList<>();
        result.add(0);
        for (int i=0;i<n;i++){
            int temp=i<<1;
            for (int j=result.size()-1;j>=0;j--){
                result.add(result.get(j)+temp);
            }
        }
        return result;
    }


    public List<Integer> grayCode2(int n) {
        List<Integer> result=new ArrayList<>();
        for (int i=0;i< 1<<n;i++){
            int temp=i>>1;
            result.add(temp^i);
        }
        return result;
    }
}
