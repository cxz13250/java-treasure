package array;

/**
 * @Author ROKG
 * @Description 希尔排序
 * @Date: Created in 下午3:52 2018/4/1
 * @Modified By:
 */
public class ShellSort {

    public void shellSort(int[] a){
        int index=a.length/2;
        while (index>1){
            shellInertSort(a,index);
            index=index/2;
        }
    }

    public void shellInertSort(int[] a,int index){
        for(int i=index;i<a.length;i++){
            if(a[i]>a[i-index]) {
                int j;
                int temp = a[i];
                for (j = i; j > index && a[j - index] > temp; j = j - index) {
                    a[j] = a[j - index];
                }
                a[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        SelectSort s=new SelectSort();
        int[] a={123,23,22,45,34,89,35,72};
        s.selectSort(a);
        Base.print(a);
    }
}
