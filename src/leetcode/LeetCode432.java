package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

/**
 * @Author ROKG
 * @Description 实现一个数据结构支持以下操作：
 * Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。
 * Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否者使一个存在的 key 值减一。如果这个 key 不存在，这个函数不做任何事情。key 保证不为空字符串。
 * GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串""。
 * GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。
 * 挑战：以 O(1) 的时间复杂度实现所有操作。
 * @Date: Created in 下午5:14 2018/5/16
 * @Modified By: *
 */
public class LeetCode432 {

    class AllOne{

        TreeMap<Integer,HashSet<String>> treeMap;
        HashMap<String,Integer> index;

        /** Initialize your data structure here. */
        public AllOne() {
            treeMap=new TreeMap<>();
            index=new HashMap<>();
        }

        /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
        public void inc(String key) {
            if (this.index.containsKey(key)){
                int temp=index.get(key);
                index.put(key,index.get(key)+1);
                treeMap.get(temp).remove(key);
                if (treeMap.get(temp).size()==0){
                    treeMap.remove(temp);
                }
                if (!treeMap.containsKey(temp+1)){
                    treeMap.put(temp+1,new HashSet<>());
                }
                this.treeMap.get(temp+1).add(key);
            }else {
                this.index.put(key,1);
                if (!this.treeMap.containsKey(1)){
                    this.treeMap.put(1,new HashSet<>());
                }
                this.treeMap.get(1).add(key);
            }
        }

        /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
        public void dec(String key) {
            if (index.containsKey(key)){
                int temp=index.get(key);
                if (temp==1){
                    index.remove(key);
                }else {
                    this.index.put(key, temp - 1);
                    if (!treeMap.containsKey(temp-1)){
                        treeMap.put(temp-1,new HashSet<>());
                    }
                    treeMap.get(temp-1).add(key);
                }
                this.treeMap.get(temp).remove(key);
                if (treeMap.get(temp).size()==0){
                    this.treeMap.remove(temp);
                }
            }
        }

        /** Returns one of the keys with maximal value. */
        public String getMaxKey() {
            if (index.size()==0){
                return "";
            }
            return this.treeMap.get(this.treeMap.lastKey()).iterator().next();
        }

        /** Returns one of the keys with Minimal value. */
        public String getMinKey() {
            if (index.size()==0){
                return "";
            }
            return this.treeMap.get(this.treeMap.firstKey()).iterator().next();
        }
    }
}
