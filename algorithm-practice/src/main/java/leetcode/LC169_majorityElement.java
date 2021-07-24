package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author heming1
 * @date 2021/7/24 4:34 下午
 * @description 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * https://leetcode-cn.com/problems/majority-element/
 */
public class LC169_majorityElement {

    public static void main(String[] args) {
        System.out.println(new LC169_majorityElement().majorityElement2(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    /**
     * 摩尔投票
     */
    public int majorityElement2(int[] nums) {
        int major = nums[0];
        int cut = 0;
        for (int num : nums) {
            if (cut == 0) {
                major = num;
            }
            if (major == num) {
                cut++;
            } else {
                cut--;
            }
        }
        return major;
    }

    /**
     * 返回n/2位置的数
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    /**
     * map解法
     */
    public int majorityElement0(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        int res = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                res = entry.getKey();
                return res;
            }
        }
        return res;
    }
}