package array;

/**
 * @Author ROKG
 * @Description 简单选择排序
 * @Date: Created in 下午3:51 2018/4/1
 * @Modified By:
 */
public class SelectSort {

    public void selectSort(int[] a){
        for(int i=0;i<a.length;i++){
            int k=i;
            for(int j=i+1;j<a.length;j++){
                if(a[k]>a[j]){
                    k=j;
                }
            }
            Base.swap(a,k,i);
        }
    }

    public static void main(String[] args) {
        SelectSort s=new SelectSort();
        int[] a={123,23,22,45,34,89,35,72};
        s.selectSort(a);
        Base.print(a);
    }
}
