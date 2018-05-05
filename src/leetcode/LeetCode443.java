package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一组字符，使用原地算法将其压缩。压缩后的长度必须始终小于或等于原数组长度。
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。在完成原地修改输入数组后，返回数组的新长度。
 * @Date: Created in 下午1:23 2018/5/3
 * @Modified By:
 */
public class LeetCode443 {

    public static int compress(char[] chars) {
        int sum=1;
        char temp=chars[0];
        int count;
        List<Character> characters=new ArrayList<>();
        characters.add(temp);
        for(int i=1;i<chars.length;i++){
            count=1;
            while (i<chars.length&&chars[i]==temp){
                count++;
                i++;
            }
            if(count>0){
                sum+=String.valueOf(count).length();
                for(int j=0;j<String.valueOf(count).length();j++){
                    characters.add(String.valueOf(count).charAt(j));
                }
            }
            if(i>=chars.length){
                break;
            }
            temp=chars[i];
            characters.add(temp);
            sum++;
        }
        for(int i=0;i<characters.size();i++){
            chars[i]=characters.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        char[] cc={'a','a','b','b','c','c','c'};
        System.out.println(compress(cc));
    }
}
