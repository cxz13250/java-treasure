package leetcode;

import java.util.Vector;

/**
 * @Author ROKG
 * @Description 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * @Date: Created in 下午11:08 2018/4/24
 * @Modified By:
 */
public class LeetCode567 {

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int[] count = new int[26];
        for(int i = 0; i < s1.length(); i++){
            count[s1.charAt(i) - 'a'] ++;
            count[s2.charAt(i) - 'a'] --;
        }
        if(helper(count)){
            return true;
        }
        for(int i = s1.length(); i < s2.length(); i++){
            count[s2.charAt(i) - 'a'] --;
            count[s2.charAt(i - s1.length()) - 'a'] ++;
            if(helper(count)){
                return true;
            }
        }
        return false;
    }
    public boolean helper(int[] count){
        for(int num : count){
            if(num != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode567 t=new LeetCode567();
        System.out.println(t.checkInclusion("ab","eidbaooo"));
    }
}
