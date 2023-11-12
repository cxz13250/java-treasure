package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。给出数字到字母的映射如下（与电话按键相同）。1 不对应任何字母。
 * @Date: Created in 下午10:58 2018/4/16
 * @Modified By:
 */
public class LeetCode17 {


    Character[] c2={'a','b','c'};
    Character[] c3={'d','e','f'};
    Character[] c4={'g','h','i'};
    Character[] c5={'j','k','l'};
    Character[] c6={'m','n','o'};
    Character[] c7={'p','q','r','s'};
    Character[] c8={'t','u','v'};
    Character[] c9={'w','x','y','z'};

    HashMap<Integer,Character[]> map=new HashMap<Integer, Character[]>(){
        {
            put(2,c2);
            put(3,c3);
            put(4,c4);
            put(5,c5);
            put(6,c6);
            put(7,c7);
            put(8,c8);
            put(9,c9);
        }
    };

    List<String> result=new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        StringBuilder sb=new StringBuilder();
        if(digits.length()==0){
            return result;
        }
        toPhoneNumber(digits,sb);
        return result;
    }

    public void toPhoneNumber(String digits,StringBuilder sb){
        if(digits.isEmpty()){
            result.add(sb.toString());
            return;
        }
        Character[] temp=map.get(digits.charAt(0)-'0');
        for(Character c:temp){
            sb.append(c);
            toPhoneNumber(digits.substring(1),sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        String nums="23";
        LeetCode17 l=new LeetCode17();
        System.out.println(l.letterCombinations(nums));
    }
}
