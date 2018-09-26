package leetcode;

import java.util.TreeMap;

/**
 * @Author ROKG
 * @Description 给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
 * 返回 A 的任意排列，使其相对于 B 的优势最大化。
 * @Date: Created in 2018/9/26
 * @Modified By:
 */
public class LeetCode870 {

    public static int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for (int i:A){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for (int i=0;i<B.length;i++){
            Integer key=map.higherKey(B[i]);
            if (key==null) {
                key=map.firstKey();
            }
            A[i] = key;
            map.put(key, map.get(key)-1);
            if (map.get(key)==0){
                map.remove(key);
            }
        }
        return A;
    }

    public static void main(String[] args) {
        advantageCount(new int[]{2,0,4,1,2}, new int[]{1,3,0,0,2});
    }
}
