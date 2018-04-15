package array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午7:09 2018/4/5
 * @Modified By:
 */
public class BucketSort {

    public int[] bucketSort(int[] arr){

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        //桶数
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }
        //将每个元素放入桶
        for(int i = 0; i < arr.length; i++){
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }
        //对每个桶进行排序
        for(int i = 0; i < bucketArr.size(); i++){
            Collections.sort(bucketArr.get(i));
        }
        int result[]=new int[arr.length];
        int i=0;
        for(ArrayList list:bucketArr){
            for(int j=0;j<list.size();j++){
                result[i]=(Integer)list.get(j);
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a={123,23,22,45,34,89,35,72};
        BucketSort b=new BucketSort();
        Base.print(b.bucketSort(a));
    }
}
