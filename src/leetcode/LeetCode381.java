package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 * 注意: 允许出现重复元素。
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 * @Date: Created in 下午10:42 2018/7/27
 * @Modified By:
 */
public class LeetCode381 {

    static class RandomizedCollection {

        int lenth=0;
        int[] nums=new int[1000000];
        Map<Integer,List<Integer>> position=new HashMap<>();
        Random random=new Random();

        /** Initialize your data structure here. */
        public RandomizedCollection() {

        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            List<Integer> list=position.getOrDefault(val,new ArrayList<>());
            list.add(lenth);
            nums[lenth++]=val;
            position.put(val,list);
            if (list.size()>=2) {
                return false;
            }else {
                return true;
            }
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if (!position.containsKey(val)){
                return false;
            }
            List<Integer> list=position.get(val);
            if (list.size()==0){
                return false;
            }
            int pos=list.get(list.size()-1);
            int temp=nums[lenth-1];
            List<Integer> tempList=position.get(temp);
            Collections.sort(tempList);
            tempList.remove(tempList.size()-1);
            tempList.add(pos);
            nums[pos]=temp;
            lenth--;
            TreeSet<Integer> set=new TreeSet<>();
            list.remove(list.size()-1);
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            int index=random.nextInt(lenth);
            return nums[index];
        }
    }

    public static void main(String[] args) {
        RandomizedCollection r=new RandomizedCollection();
        System.out.println(r.insert(10));
        System.out.println(r.insert(10));
        System.out.println(r.insert(20));
        System.out.println(r.insert(20));
        System.out.println(r.insert(30));
        System.out.println(r.insert(30));
        System.out.println(r.remove(10));
        System.out.println(r.remove(10));
        System.out.println(r.remove(30));
        System.out.println(r.remove(30));
        System.out.println(r.getRandom());
        System.out.println(r.getRandom());
        System.out.println(r.getRandom());
        System.out.println(r.getRandom());
        System.out.println(r.getRandom());
        System.out.println(r.getRandom());
        System.out.println(r.getRandom());
        System.out.println(r.getRandom());
        System.out.println(r.getRandom());
        System.out.println(r.getRandom());

    }
}
