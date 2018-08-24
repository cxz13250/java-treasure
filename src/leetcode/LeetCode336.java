package leetcode;

import employee.PalindromeOn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 * @Date: Created in 2018/8/23
 * @Modified By:
 */
public class LeetCode336 {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        for (int i=0;i<words.length;i++){
            map.put(words[i], i);
        }
        for (int i=0;i<words.length;i++){
            String s=new StringBuilder(words[i]).reverse().toString();
            for (int j=0;j<s.length();j++){

            }
        }
        return lists;
    }

    public boolean isPalindromePairs(String s){
        for (int i=0;i<s.length()/2;i++){
            if (s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode336 l=new LeetCode336();
        System.out.println(l.palindromePairs(new String[]{"abcd","dcba","lls","s","sssll"}));
    }
}
