package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午11:26 2020/5/20
 * @Modified By:
 */
public class LeetCode1371 {

    public static int findTheLongestSubstring(String s) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int state = 0x0;
        int res=0;
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c == 'a'){
                state ^= (1 << 0);
            }else if (c == 'e'){
                state ^= (1 << 1);
            }else if (c == 'i'){
                state ^= (1 << 2);
            }else if (c == 'o'){
                state ^= (1 << 3);
            }else if (c == 'u'){
                state ^= (1 << 4);
            }
            if (map.containsKey(state)){
                res = Math.max(res, i - map.get(state));
            }else{
                map.put(state, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findTheLongestSubstring("eleetminicoworoep"));
    }
}
