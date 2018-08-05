package leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get 和 put。
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，它应该在插入新项目之前，使最不经常使用的项目无效。
 * 在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，最近最少使用的键将被去除。
 * 进阶：你是否可以在 O(1) 时间复杂度内执行两项操作？
 * @Date: Created in 下午12:01 2018/7/28
 * @Modified By:
 */
public class LeetCode460 {

    class LFUCache {

        Map<Integer,Integer> values;
        Map<Integer,Integer> counts;
        Map<Integer,LinkedHashSet<Integer>> lists;
        int max=0;
        int len=0;
        int min=-1;

        public LFUCache(int capacity) {
            max=capacity;
            values=new HashMap<>(capacity);
            counts=new HashMap<>(capacity);
            lists=new HashMap<>();
            lists.put(1,new LinkedHashSet<>());

        }

        public int get(int key) {
            if(!values.containsKey(key)) {
                return -1;
            }
            int count=counts.get(key);
            counts.put(key,count+1);
            lists.get(count).remove(key);
            if (count==min&&lists.get(count).size()==0){
                min++;
            }
            if (!lists.containsKey(count+1)){
                lists.put(count+1,new LinkedHashSet<>());
            }
            lists.get(count+1).add(key);
            return values.get(key);
        }

        public void put(int key, int value) {
            if (max<=0){
                return;
            }
            if (values.containsKey(key)) {
                values.put(key, value);
                get(key);
                return;
            }
            if (len>=max){
                int temp=lists.get(min).iterator().next();
                lists.get(min).remove(temp);
                values.remove(temp);
            }
            values.put(key,value);
            counts.put(key,1);
            min=1;
            lists.get(1).add(key);
            len++;
        }
    }
}
