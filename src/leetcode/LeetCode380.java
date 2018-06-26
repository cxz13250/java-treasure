package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author ROKG
 * @Description 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 * @Date: Created in 上午9:42 2018/6/18
 * @Modified By: *
 */
public class LeetCode380 {

    int lenth=0;
    int[] nums=new int[1000000];
    Map<Integer,Integer> position=new HashMap<>();
    Random random=new Random();

    /** Initialize your data structure here. */
    public LeetCode380() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (position.containsKey(val)){
            return false;
        }
        position.put(val,lenth);
        nums[lenth++]=val;
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!position.containsKey(val)){
            return false;
        }
        int temp=position.get(val);
        if (temp!=lenth-1){
            position.put(nums[lenth-1],temp);
            int swp=nums[temp];
            nums[temp]=nums[lenth-1];
            nums[lenth-1]=temp;
        }
        lenth--;
        position.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index=random.nextInt(lenth);
        return nums[index];
    }
}
