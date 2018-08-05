package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ROKG
 * @Description 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...",
 * "c" 对应 "-.-.", 等等。
 * @Date: Created in 上午1:07 2018/7/29
 * @Modified By:
 */
public class LeetCode804 {

    String[] dict={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set=new HashSet<>();
        for (String s:words){
            StringBuilder sb=new StringBuilder();
            for (char c:s.toCharArray()){
                sb.append(dict[c-'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
