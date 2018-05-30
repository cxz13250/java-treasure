package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。返回 s 所有可能的分割方案。
 * @Date: Created in 下午7:23 2018/5/29
 * @Modified By:
 */
public class LeetCode131 {

    List<List<String>> result=new ArrayList<>();

    public List<List<String>> partition(String s) {
        List<String> strings=new ArrayList<>();
        check(s,0,strings);
        return result;
    }

    public void check(String s,int index,List<String> list){
        if (index==s.length()){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=index+1;i<=s.length();i++){
            String temp=s.substring(index,i);
            if (isPalindrome(temp)){
                list.add(temp);
                check(s,i,list);
                list.remove(list.size()-1);
            }
        }

    }

    public boolean isPalindrome(String s){
        int left=0,right=s.length()-1;
        while (left<right){
            if (s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode131 l=new LeetCode131();
        System.out.println(l.partition("aab"));
    }
}
