package employee;

/**
 * @Author ROKG
 * @Description 一个数组有正有负，如何找出其中累加和最大的子数组
 * @Date: Created in 下午11:41 2018/8/21
 * @Modified By:
 */
public class Greedy {

    public int getMaxArr(int[] arr){
        int sum=0;
        int max=0;
        for (int i:arr){
            sum+=i;
            if (sum>max){
                max=sum;
            }
            if (sum<0){
                sum=0;
            }
        }
        return max;
    }
}
