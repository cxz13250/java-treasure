package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
 * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
 * 最终结果按照字典顺序输出。
 * @Date: Created in 2018/8/8
 * @Modified By:
 */
public class LeetCode830 {

    public static List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();
        if (S==null || S.length()==0){
            return result;
        }
        int count=1;
        int start=0;
        for (int i=1;i<S.length();i++){
            if (S.charAt(i)==S.charAt(i-1)){
                count++;
            }else {
                if (count>=3){
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(i-1);
                    result.add(list);
                }
                count=1;
                start=i;
            }
        }
        if (count>=3){
            List<Integer> list = new ArrayList<>();
            list.add(start);
            list.add(S.length()-1);
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(largeGroupPositions("aaa"));
    }
}
