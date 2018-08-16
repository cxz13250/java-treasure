package dataStructure.array;

/**
 * @Author ROKG
 * @Description 快速排序 O(nlog2n) 不稳定
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

    public void quickSort2(int a[],int l,int r){
        if (l>r){
            return;
        }
        int temp=a[l];
        int i=l,j=r;
        while (i<j){
            while (i<j&&a[j]>=temp){
                j--;
            }
            a[i]=a[j];
            while (i<j&&a[i]<=temp){
                i++;
            }
            a[j]=a[i];
        }
        a[i]=temp;
        quickSort2(a,l,i-1);
        quickSort2(a,i+1,r);
    }

    public static void main(String[] args) {
        QuickSort s=new QuickSort();
        int[] a={2,4,6,1,1};
        s.quickSort2(a,0,a.length-1);
        Base.print(a);
        System.out.println();
    }
}
