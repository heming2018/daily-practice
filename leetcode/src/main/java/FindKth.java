import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming1
 * @date 2021/7/5 1:20 下午
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 * 给定一个整数数组a,同时给定它的大小n和要找的K(1<=K<=n)，请返回第K大的数(包括重复的元素，不用去重)，保证答案存在。
 * 输入：[1,3,5,2,2], 5, 3
 * 返回值：
 */
public class FindKth {
    private static final Logger logger = LoggerFactory.getLogger(FindKth.class);

    /**
     * 寻找第K大，就是寻找第n-K小的数，从0开始计算
     */
    public int findKth(int[] a, int n, int K) {
        int target = n - K;

        sort(a, target);

        if (target == n - 1) {
            return a[n - 1];
        }

        for (int i = target + 1; i < a.length; i++) {
            int curr = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > curr) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = curr;
        }

        for (int i = 0; i <= target; i++) {
            if (i == target) {
                return a[i];
            }
        }
        return -1;

    }

    /**
     * 排序前target+1个数字
     */
    private void sort(int[] a, int target) {
        for (int i = 1; i <= target; i++) {
            int j = i - 1;
            int curr = a[i];
            while (j >= 0 && a[j] > curr) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = curr;
        }
    }


}