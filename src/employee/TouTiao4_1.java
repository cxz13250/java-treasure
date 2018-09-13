package employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author ROKG
 * @Description 给定一个字符串找出其中不含重复字符的最长子串长度
 * @Date: Created in 上午9:27 2018/9/9
 * @Modified By:
 */
public class TouTiao4_1 {

    public static int check(String s){
        Map<Character,Integer> map=new HashMap<>();
        int max=0;
        int temp=0;
        int start=0;
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (!map.containsKey(c)){
                map.put(c,i);
                temp++;
            }else {
                max=Math.max(temp,max);
                int last=map.get(c);
                for (int j=start;j<last;j++){
                    map.remove(s.charAt(j));
                }
                start=last+1;
                temp=i-last;
                map.put(c,i);
            }
        }
        max=Math.max(temp,max);
        return max;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(check(sc.next()));
    }
}
