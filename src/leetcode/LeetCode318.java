package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。
 * 你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 * @Date: Created in 下午11:25 2018/5/31
 * @Modified By:
 */
public class LeetCode318 {

    public int maxProduct(String[] words) {
        int[] bit=new int[words.length];
        for (int i=0;i<words.length;i++){
            String s=words[i];
            for (int j=0;j<s.length();j++){
                char cc=s.charAt(j);
                bit[i]|= 1<< cc-'a';
            }
        }
        int result=0;
        for (int i=0;i<words.length-1;i++){
            for (int j=i+1;j<words.length;j++){
                if ((bit[i]&bit[j])==0){
                    result=Math.max(result,words[i].length()*words[j].length());
                }
            }
        }
        return result;
    }
}
