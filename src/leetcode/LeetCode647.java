package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * @Date: Created in 下午11:13 2018/8/12
 * @Modified By:
 */
public class LeetCode647 {

    public int countSubstrings(String s) {
        if (s==null || s.length()==0){
            return 0;
        }
        int count=0;
        for (int i=0;i<s.length();i++){
            for (int j=i;j<s.length();j++){
                if (checkPalindromeExpand(s,i,j)){
                    count++;
                }
            }
        }
        return count;
    }

    public boolean checkPalindromeExpand(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
