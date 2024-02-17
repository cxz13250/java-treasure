package leetcode2;

/**
 * @Author ROKG
 * @Description 数组中的第K个最大元素
 * @Date: Created in 上午11:03 2024/2/17
 * @Modified By:
 */
public class Leet215_KthLargestElement {

    // 堆排序
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        generateMaxHeap(nums, nums.length);
        for (int i = nums.length -1; i >= nums.length - k + 1; --i) {
            swap(nums, 0 , i);
            length --;
            modifyMaxHeap(nums, length,  0);
        }
        return nums[0];
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

    // 桶排序
    public int findKthLargest2(int[] nums, int k) {
        // -10^4 <= nums[i] <= 10^4
        int[] buckets = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i] + 10000]++;
        }
        for (int i = 20000; i >= 0; i--) {
            k = k - buckets[i];
            if (k <= 0) {
                return i - 10000;
            }
        }
        return 0;
    }
}
