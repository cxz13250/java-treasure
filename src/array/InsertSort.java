package array;

/**
 * @Author ROKG
 * @Description 直接插入排序
 * @Date: Created in 下午3:51 2018/4/1
 * @Modified By:
 */
public class InsertSort {

    public void insertSort(int[] a){
        for(int i=1;i<a.length;i++){
            int j;
            int temp=a[i];
            for(j=i;j>0&&a[j-1]>temp;j--){
                a[j]=a[j-1];
            }
            a[j]=temp;
        }
    }

    public static void main(String[] args) {
        InsertSort s=new InsertSort();
        int[] a={123,23,22,45,34,89,35,72};
        s.insertSort(a);
        Base.print(a);
    }
}
