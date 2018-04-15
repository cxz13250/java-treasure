package array;

/**
 * @Author ROKG
 * @Description 堆排序
 * @Date: Created in 下午3:52 2018/4/1
 * @Modified By:
 */
public class HeapSort {

    public void heapSort(int a[]){
        for(int i=0;i<a.length;i++){
            generate(a,a.length-i-1);
            Base.swap(a,0,a.length-i-1);
        }
    }

    public void generate(int[] a,int last){
        for(int i=(last-1)/2;i>=0;i--){
            int parent=i;
            int large=2*i+1;
            while (large<=last) {
                if(large<last){
                    if (a[large] < a[large + 1]) {
                        large = large + 1;
                    }
                }
                if (a[parent] < a[large]) {
                    Base.swap(a, parent, large);
                }else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        HeapSort s=new HeapSort();
        int[] a={123,23,22,45,34,89,35,72};
        s.heapSort(a);
        Base.print(a);
    }
}
