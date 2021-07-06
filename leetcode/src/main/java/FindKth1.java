/**
 * @author heming1
 * @date 2021/7/5 1:20 下午
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 * 给定一个整数数组a,同时给定它的大小n和要找的K(1<=K<=n)，请返回第K大的数(包括重复的元素，不用去重)，保证答案存在。
 * 输入：[1,3,5,2,2], 5, 3
 *
 * 返回值：
 */
public class FindKth1 {

    public int findKth(int[] a, int n, int K) {
        // write code here
        int target = n - K;

        return find(a, target);
    }

    private int find(int[] a, int target) {

        int left = 0;
        int right = a.length - 1;

        int res = findIndex(a, a[left], left, right);

        while (res != target) {
            if (res < target) {
                left = res + 1;
                res = findIndex(a, a[left], left, right);
            } else {
                right = res - 1;
                res = findIndex(a, a[left], left, right);
            }
        }
        return a[res];
    }

    private int findIndex(int[] a, int num, int left, int right) {

        while (left < right) {
            while (left < right && a[right] >= num) {
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] <= num) {
                left++;
            }
            a[right] = a[left];
        }
        a[left] = num;
        return left;
    }


}