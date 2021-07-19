import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NC22 合并两个有序的数组
 *
 * 描述
 * 给出一个整数数组A和有序的整数数组B，请将数组B合并到数组A中，变成一个有序的升序数组
 * 注意：
 * 1.可以假设A数组有足够的空间存放B数组的元素，A和B中初始的元素数目分别为m和n，A的数组空间大小为m+n
 * 2.不要返回合并的数组，返回是空的，将数组B的数据合并到A里面就好了
 * 3.A数组在【0，m-1】的范围也是有序的
 */
public class MergeArr {
    private static final Logger logger = LoggerFactory.getLogger(MergeArr.class);

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, index = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[index--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }
    }
}