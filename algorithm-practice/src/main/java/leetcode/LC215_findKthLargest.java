package leetcode;

/**
 * @author heming1
 * @date 2021/7/20 5:53 下午
 * @description 215. 数组中的第K个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 */
public class LC215_findKthLargest {

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{2,1}, 2));
    }
    /**
     * [2,1]
     * [1,2]
     * 2
     */
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null) {
            return -1;
        }

        int target = nums.length - k;

        int left = 0;
        int right = nums.length - 1;

        int index = findIndex(nums, left, right);

        while (index != target) {
            if (target > index) {
                left = index + 1;
                index = findIndex(nums, left, right);
            } else {
                right = index - 1;
                index = findIndex(nums, left, right);
            }
        }
        return nums[index];
    }



    private static int findIndex(int[] nums, int l, int r) {
        int curr = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= curr) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] <= curr) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = curr;
        return l;
    }

}