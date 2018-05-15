package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ROKG
 * @Description 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * @Date: Created in 下午3:08 2018/5/15
 * @Modified By:
 */
public class LeetCode345 {

    public String reverseVowels(String s) {
        Set<Character> set=new HashSet<>();
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        char[] cc=s.toCharArray();
        int left=0;
        int right=s.length()-1;
        while (left<right){
            while (left<right&&(!set.contains(s.charAt(left)))){
                left++;
            }
            while (left<right&&(!set.contains(s.charAt(right)))){
                right--;
            }
            if (left>=right){
                break;
            }
            char temp=cc[left];
            cc[left]=cc[right];
            cc[right]=temp;
            left++;
            right--;
        }
        return new String(cc);
    }
}
