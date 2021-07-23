package interview;

import java.util.Arrays;

/**
 * @author heming1
 * @date 2021/7/23 12:11 下午
 * @description 一个int类型的列表，无相同大小的数，请处理成奇数下标大于两边偶数下标的列表
 * e.g. [2,5,30,4,1,57,32] -> [2,30,4,5,1,57,32]
 * [57,5,30,4,1,2,32]
 * [5,57,30,4,1,2,32]
 */
public class JiGtOu {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 30, 4, 1, 57, 32};
//        int[] nums = new int[]{5, 2};
        solution(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println("");
        Arrays.asList(1,2,3);

    }

    static void solution(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        if (nums.length == 2) {
            if (nums[1] < nums[0]) {
                swap(nums, 0, 1);
            }
            return;
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (i % 2 != 0) {
                // 奇数
                if (nums[i] < nums[i - 1]) {
                    swap(nums, i - 1, i);
                }
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }


}