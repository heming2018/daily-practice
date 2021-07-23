package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author heming1
 * @date 2021/7/24 12:29 上午
 * @description TODO
 */
public class LC15_threeSum {

    public static void main(String[] args) {
        System.out.println(new LC15_threeSum().threeSum(new int[]{-4, -1, -1, 0, 1, 2}).size());
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);

//        List<List<Integer>> set = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // 判断和前一位一样不一样，如果一样，不重复寻找
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int twoSum = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (twoSum == nums[left] + nums[right]) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (twoSum > nums[left] + nums[right]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}