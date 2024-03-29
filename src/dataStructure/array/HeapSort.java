package dataStructure.array;

/**
 * @Author ROKG
 * @Description 堆排序 O(nlog2n) 不稳定
 * @Date: Created in 下午3:52 2018/4/1
 * @Modified By:
 */
public class HeapSort {

    public void heapSort(int a[]) {
        int length = a.length;
        generateMaxHeap(a, length);
        for (int i = a.length - 1; i >= 0; i--) {
            // 下沉操作，把当前最大元素挪到后面去
            Base.swap(a, 0, i);
            length --;
            modifyMaxHeap(a, length, 0);
        }
    }

    // 生成最大堆
    private void generateMaxHeap(int[] nums, int length) {
        for (int i = (length) / 2; i >= 0; --i) {
            modifyMaxHeap(nums, length, i);
        }
    }

    private void modifyMaxHeap(int[] nums, int length, int i) {
        int parent = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < length && nums[left] > nums[parent]) {
            parent = left;
        }
        if (right < length && nums[right] > nums[parent]) {
            parent = right;
        }
        // 需要调整节点，继续往上调整
        if (parent != i) {
            swap(nums, parent, i);
            modifyMaxHeap(nums, length, parent);
        }
        // 不需要调整
    }

    public void swap(int a[],int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static void main(String[] args) {
        HeapSort s = new HeapSort();
        int[] a = {123, 23, 22, 45, 34, 89, 35, 72};
        s.heapSort(a);
        Base.print(a);
    }
}
