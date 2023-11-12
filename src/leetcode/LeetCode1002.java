package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 你可以按任意顺序返回答案。
 * @Date: Created in 下午11:52 2020/6/17
 * @Modified By:
 */
public class LeetCode1002 {

    public List<String> commonChars(String[] A) {
        String flag=A[0];
        for (int i=1;i<A.length;i++){
            flag=compare(flag, A[i]);
        }
        List<String> res=new ArrayList<>();
        for (char c:flag.toCharArray()){
            res.add(String.valueOf(c));
        }
        return res;
    }

    public String compare(String s1,String s2){
        int[] flag1=new int[26];
        int[] flag2=new int[26];
        for (char c:s1.toCharArray()){
            flag1[c-'a']++;
        }
        for (char c:s2.toCharArray()){
            flag2[c-'a']++;
        }
        for (int i=0;i<26;i++){
            flag1[i]=Math.min(flag1[i],flag2[i]);
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<26;i++){
            for (int j=0;j<flag1[i];j++){
                sb.append((char)('a'+i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode1002 l = new LeetCode1002();
        String[] A={"bella","label","roller"};
        System.out.println(l.commonChars(A));
    }
}
