package leetcode;

/**
 * @author heming1
 * @date 2021/7/26 12:39 上午
 * @description 88. 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/submissions/
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 */
public class LC88_merge {

    public static void main(String[] args) {
        int[] arr = new int[]{0};
        new LC88_merge().merge1(arr, 0, new int[]{1}, 1);
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();

        int i = 0;
        int j = 0;
        System.out.println("i++ = " + (i++));
        System.out.println("++j = " + (++j));
    }

    /**
     * 简单写法
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            return;
        }
        int i = m - 1, j = n - 1, index = m + n - 1;

        while (i >= 0 && j >= 0) {
            nums1[index--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (i >= 0) {
            nums1[index--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }
    }

    // 自己写法，比较复杂
    public void merge0(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            return;
        }
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (k >= 0) {
            if (i < 0) {
                nums1[k] = nums2[j];
                j--;
            } else if (j < 0) {
                nums1[k] = nums1[i];
                i--;
            } else if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }
}