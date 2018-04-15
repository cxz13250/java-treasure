package array;

/**
 * @Author ROKG
 * @Description 冒泡排序
 * @Date: Created in 下午3:52 2018/4/1
 * @Modified By:
 */
public class BubbleSort {

    public void bubbleSort(int[] a){
        boolean flag=false;
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    Base.swap(a,j,j+1);
                    flag=true;
                }
            }
            if(!flag){
                break;
            }else {
                flag=false;
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort s=new BubbleSort();
        int[] a={123,23,22,45,34,89,35,72};
        s.bubbleSort(a);
        Base.print(a);
    }
}
