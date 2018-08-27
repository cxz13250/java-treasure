package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 * @Date: Created in 2018/8/23
 * @Modified By: *
 */
public class LeetCode336 {

    // 将所有单词进入map，记录下每个单词的下标
    // 对于单词word[i],先将其逆序得到s，存在两种情况，第一种：存在下标j使得s中j左边子串为回文串，map中存在右边子串
    // 第二种：存在下标j是的j右边子串为回文串，map中存在左边子串
    // 如"abcdd","cba","ddcb"中,"abcdd"逆序得到"ddcba",可得j=2时,左子串"dd"为回文串,右子串"cba"存在;j=4时,右子串"a"为回文串,左子串"ddcb"存在
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>(16);
        for (int i=0;i<words.length;i++){
            map.put(words[i], i);
        }
        for (int i=0;i<words.length;i++){
            String s=new StringBuilder(words[i]).reverse().toString();
            int len=words[i].length();
            for (int j=0;j<=s.length();j++){
                String left=s.substring(0,j),right=s.substring(j);
                if (map.containsKey(left)&&isPalindromePairs(right)&&map.get(left)!=i&&len>=j){
                    List<Integer> list=new ArrayList<>();
                    list.add(map.get(left));
                    list.add(i);
                    res.add(list);
                }
                if (map.containsKey(right)&&isPalindromePairs(left)&&map.get(right)!=i&&len>len-j){
                    List<Integer> list=new ArrayList<>();
                    list.add(i);
                    list.add(map.get(right));
                    res.add(list);
                }
            }
        }
        return res;
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
