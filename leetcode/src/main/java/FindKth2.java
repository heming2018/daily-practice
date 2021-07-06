import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming1
 * @date 2021/7/6 6:36 下午
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class FindKth2 {
    public int findKthLargest(int[] nums, int k) {
        int targetIndex = nums.length - k;

        return find(nums, targetIndex);
    }
    private int find(int[] nums, int targetIndex) {

        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        int res = findIndex(nums, nums[leftIndex], leftIndex, rightIndex);

        while (targetIndex != res) {
            if (res < targetIndex) {
                leftIndex = res + 1;
                res = findIndex(nums, nums[leftIndex], leftIndex, rightIndex);
            } else {
                rightIndex = res - 1;
                res = findIndex(nums, nums[leftIndex], leftIndex, rightIndex);
            }
        }
        return nums[res];

    }
    private int findIndex(int[] nums, int targetNum, int leftIndex, int rightIndex) {
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && nums[rightIndex] >= targetNum) {
                rightIndex--;
            }
            nums[leftIndex] = nums[rightIndex];

            while (leftIndex < rightIndex && nums[leftIndex] <= targetNum){
                leftIndex++;
            }
            nums[rightIndex] = nums[leftIndex];
        }
        nums[leftIndex] = targetNum;
        return leftIndex;
    }

}