package array;

/**
 * @Author ROKG
 * @Description 二分查找 复杂度O(log2n)
 * @Date: Created in 下午11:22 2018/4/1
 * @Modified By:
 */
public class BinarySearch {

    /**
     * 递归实现二分查找某个元素
     * @param a
     * @param left
     * @param right
     * @return
     */
    public int binarySearch(int arr[],int a,int left,int right){
        if(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==a){
                return mid+1;
            }
            else if(arr[mid]>a) {
                return binarySearch(arr,a,left,mid-1);
            }else {
                return binarySearch(arr,a,mid+1,right);
            }
        }
        return -1;
    }

    /**
     * 非递归二分查找某个元素
     * @param arr
     * @return
     */
    public int binarySearch(int[] arr,int a){
        int left=0;
        int right=arr.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==a){
                return mid+1;
            }else if(arr[mid]>a){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch s=new BinarySearch();
        int arr[]={1,2,3,4,5,6,7,8,9};
        System.out.println("递归二分查找"+s.binarySearch(arr,7,0,arr.length));
        System.out.println("非递归二分查找"+s.binarySearch(arr,7));
    }
}
