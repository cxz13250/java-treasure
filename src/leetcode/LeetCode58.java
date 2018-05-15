package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 * @Date: Created in 下午11:58 2018/5/14
 * @Modified By:
 */
public class LeetCode58 {

    public int lengthOfLastWord(String s) {
        if (s==null||s.trim().length()==0){
            return 0;
        }
        String[] strings=s.split(" ");
        return strings[strings.length-1].length();
    }
}
