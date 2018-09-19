package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ROKG
 * @Description 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * @Date: Created in 2018/9/19
 * @Modified By:
 */
public class LeetCode763 {

    public static List<Integer> partitionLabels(String S) {
        List<Integer> list=new ArrayList<>();
        char[] cc=S.toCharArray();
        int[] count=new int[26];
        for (char c:cc){
            count[c-'a']++;
        }
        int start=0,end=0;
        while (end<cc.length){
            Set<Character> set=new HashSet<>();
            set.add(cc[start]);
            if (--count[cc[start]-'a']==0){
                list.add(1);
                start++;
                end++;
                continue;
            }
            for (int i=start+1;i<cc.length;i++){
                count[cc[i]-'a']--;
                boolean remain=false;
                for (char c:set){
                    if (count[c-'a']>0){
                        remain=true;
                        break;
                    }
                }
                if (!remain){
                    end=i+1;
                    list.add(end-start);
                    break;
                }else {
                    if (!set.contains(cc[i])){
                        set.add(cc[i]);
                    }
                }
            }
            start=end;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
