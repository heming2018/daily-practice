package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heming1
 * @date 2021/7/24 5:23 下午
 * @description 229. 求众数 II
 * https://leetcode-cn.com/problems/majority-element-ii/
 *
 * 给定一个大小为n的整数数组，找出其中所有出现超过n/3次的元素。
 * 进阶：尝试设计时间复杂度为O(n)、空间复杂度为O(1)的算法解决此问题。
 *
 */
public class LC229_majorityElement {

    public static void main(String[] args) {
        System.out.println(new LC229_majorityElement().majorityElement(new int[]{2,1,1,3,1,4,5,6}));
    }

    public List<Integer> majorityElement(int[] nums) {
        int major0 = nums[0];
        int cut0 = 0;
        int major1 = nums[0];
        int cut1 = 0;

        for (int num : nums) {
            if (major0 == num) {
                cut0++;
                continue;
            }
            if (major1 == num) {
                cut1++;
                continue;
            }
            if (cut0 == 0) {
                major0 = num;
                cut0++;
                continue;
            }
            if (cut1 == 0) {
                major1 = num;
                cut1++;
                continue;
            }
            cut0--;
            cut1--;
        }
        cut0 = 0;
        cut1 = 0;
        for (int num : nums) {
            if (num == major0) {
                cut0++;
            }
            if (num == major1) {
                cut1++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (cut0 > nums.length / 3) {
            res.add(major0);
        }
        if (cut1 > nums.length / 3 && major0 != major1) {
            res.add(major1);
        }
        return res;
    }

}