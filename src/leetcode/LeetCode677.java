package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 实现一个 MapSum 类里的两个方法，insert 和 sum。
 * 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
 * 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
 * @Date: Created in 2018/8/23
 * @Modified By:
 */
public class LeetCode677 {

    Map<String, Integer> map = new HashMap<>();

    public LeetCode677() {

    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int res=0;
        for (String s:map.keySet()){
            if (s.startsWith(prefix)){
                res+=map.get(s);
            }
        }
        return res;
    }
}
