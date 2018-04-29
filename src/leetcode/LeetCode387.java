package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * @Date: Created in 下午2:07 2018/4/28
 * @Modified By:
 */
public class LeetCode387 {

    public static int firstUniqChar(String s) {
        Map<Character,Integer> map=new HashMap<>(26);
        char[] cc=s.toCharArray();
        if(cc.length==1){
            return 0;
        }
        for(int i=0;i<cc.length;i++){
            if(map.containsKey(cc[i])){
                map.put(cc[i],-1);
            }else {
                map.put(cc[i],i);
            }
        }
        int result=-1;
        for(Integer integer:map.values()){
            if(integer!=-1){
                if(result==-1||result>integer){
                    result=integer;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str="leetcode";
        System.out.println(firstUniqChar(str));
    }
}
