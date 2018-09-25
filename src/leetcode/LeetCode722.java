package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给一个 C++ 程序，删除程序中的注释。这个程序source是一个数组，其中source[i]表示第i行源码。 这表示每行源码由\n分隔。
 * @Date: Created in 2018/9/25
 * @Modified By: *
 */
public class LeetCode722 {

    public static List<String> removeComments(String[] source) {
        List<String> res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        boolean hasLeft=false;  // 多行注释
        for (String s:source){
            for (int i=0;i<s.length();i++){
                if (hasLeft){
                    if (s.charAt(i)=='*'&&i<s.length()-1&&s.charAt(i+1)=='/'){
                        hasLeft=false;
                        i++;
                    }
                }else {
                    if (s.charAt(i)=='/'&&i<s.length()-1&&s.charAt(i+1)=='/'){
                        break;
                    }else if (s.charAt(i)=='/'&&i<s.length()-1&&s.charAt(i+1)=='*'){
                        hasLeft=true;
                        i++;
                    }else {
                        sb.append(s.charAt(i));
                    }
                }
            }
            if (!hasLeft&&sb.length()>0){
                res.add(sb.toString());
                sb=new StringBuilder();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(removeComments(new String[]{"a//*b//*c","blank","d/*/e/*/f"}));
    }
}
