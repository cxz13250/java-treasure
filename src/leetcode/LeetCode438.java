package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * @Date: Created in 下午3:26 2018/5/15
 * @Modified By:
 */
public class LeetCode438 {

    public List<Integer> findAnagrams(String s, String p) {
        int[] nums=new int[26];
        for (int i=0;i<p.length();i++){
            nums[p.charAt(i)-'a']++;
        }
        List<Integer> integers=new ArrayList<>();
        for (int i=0;i<=s.length()-p.length();i++){
            if (check(s,i,i+p.length(),Arrays.copyOf(nums,nums.length))){
                integers.add(i);
            }
        }
        return integers;
    }

    public boolean check(String s,int i,int j,int[] nums){
        for (int l=i;l<j;l++){
            nums[s.charAt(l)-'a']--;
        }
        for (int l=0;l<nums.length;l++){
            if (nums[l]!=0){
                return false;
            }
        }
        return true;
    }
}
