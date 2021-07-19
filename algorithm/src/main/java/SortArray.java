/**
 * @author heming1
 * @date 2021/7/11 11:29 下午
 * @description 排序数组
 * 给你一个整数数组 nums，请你将该数组升序排列（快速排序）。
 */
public class SortArray {

    public int[] sortArray1(int[] nums) {
        if (nums == null) {
            return null;
        }
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > curr) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = curr;
        }
        return nums;
    }

    public int[] sortArray2(int[] nums) {
        qSort(nums, 0, nums.length - 1);
        return nums;
    }

    void qSort(int[] nums, int start, int end) {
        int left = start;
        int right = end;
        int target = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= target) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= target) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = target;

        if (left - start > 1) {
            qSort(nums, start, left - 1);
        }
        if (end - right > 1) {
            qSort(nums, right + 1, end);
        }

    }


}