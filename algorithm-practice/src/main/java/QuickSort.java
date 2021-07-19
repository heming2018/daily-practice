import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author heming1
 * @date 2021/6/21 5:02 下午
 * @description TODO
 */
public class QuickSort {
    private static final Logger logger = LoggerFactory.getLogger(QuickSort.class);

    public static void main(String[] args) {

    }


    /**
     * 3456789
     *
     * @param a
     * @param start
     * @param end
     */
    void quickSort(int[] a, int start, int end) {
        if (a.length < 0) {
            return;
        }
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int temp = a[left];
        while (left < right) {
            while (left < right && a[right] >= temp) {
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] <= temp) {
                left++;
            }
            a[right] = a[left];
        }
        a[left] = temp;
//        System.out.println(Arrays.toString(a));
        quickSort(a, start, left - 1);
        quickSort(a, left + 1, end);
    }


    void qSort(int[] a, int left, int right) {
        int temp = a[left];
        while (left < right) {
            while (left < right && a[right] >= temp) {
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] <= temp) {
                right--;
            }
            a[right] = a[left];
        }
        a[left] = temp;
        qSort(a, 0, left - 1);
        qSort(a, left + 1, right);
    }

}