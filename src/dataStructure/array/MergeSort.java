package dataStructure.array;

/**
 * @Author ROKG
 * @Description 归并排序 O(nlog2n) 稳定
 * @Date: Created in 2018/8/16
 * @Modified By:
 */
public class MergeSort {

    public int[] mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length-1);
        return arr;
    }

    public void mergeSort(int[] arr,int start,int end){
        if (start<end){
            int mid=start+(end-start)/2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,start,mid,end);
        }
    }

    public void merge(int[] arr,int start,int mid,int end){
        int i=start,j=mid+1;
        int k=0;
        int[] temp=new int[end-start+1];
        while (i<=mid&&j<=end){
            if (arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }else {
                temp[k++]=arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }
        for (i = 0; i < k; i++) {
            arr[start + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        MergeSort s=new MergeSort();
        int[] a={123,23,22,45,34,89,35,72};
        s.mergeSort(a);
        Base.print(a);
    }
}
