package dataStructure.array;

/**
 * @Author ROKG
 * @Description 快速排序
 * @Date: Created in 下午3:52 2018/4/1
 * @Modified By: O(nlog2n)
 */
public class QuickSort {

    public void quickSort(int a[],int low,int high) {
        if(low<high){
            int temp=getMiddle(a,low,high);
            quickSort(a,low,temp-1);
            quickSort(a,temp+1,high);
        }
    }

    public int getMiddle(int a[],int low,int high) {
        int key=a[low];
        while (low<high){
            while (low<high&&a[high]>=key){
                high--;
            }
            a[low]=a[high];
            while (low<high&&a[low]<=key){
                low++;
            }
            a[high]=a[low];
        }
        a[low]=key;
        return low;
    }

    public static void main(String[] args) {
        QuickSort s=new QuickSort();
        int[] a={2,4,6,1,1};
        s.quickSort(a,0,a.length-1);
        Base.print(a);
        System.out.println();
    }
}
