package leetcode;


/**
 * @author heming1
 * @date 2021/7/19 4:24 下午
 * @description 912. 排序数组
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * https://leetcode-cn.com/problems/sort-an-array/
 * e.g. nums = [5,2,3,1]
 * [5,2,3,1],[1,2,3,1],[1,2,3,5]
 * l: 0,1,2,3
 * r: 3,
 *
 */
public class LC912_sortArray {

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,3,1};
        sortArray(nums);
    }

    public static int[] sortArray(int[] nums) {

        qSort(nums, 0, nums.length - 1);

        return nums;
    }

    private static void qSort(int[] nums, int left, int right) {
        int start = left;
        int end = right;
        int curr = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= curr) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= curr) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = curr;
        if (left - start > 1) {
            qSort(nums, start, left - 1);
        }
        if (end - right > 1) {
            qSort(nums, right + 1, end);
        }
    }


}