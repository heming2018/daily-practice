import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming1
 * @date 2021/6/6 5:06 下午
 * @description 1.给定一个正值整数，例 1233421
 * 2.交换任意位置，不限次数，可以得到一个大于给定整数的新整数，例：3321421
 * 3.编写一个程序，输出步骤2换位后所得数字中最小的一个，例：1234123
 * 4.如果找不到，输出原值
 * 5.运行下列两个testcase：1889823210，16643264321。给出答案
 */
public class MinOriginalNum {
    private static final Logger logger = LoggerFactory.getLogger(MinOriginalNum.class);

    public static void main(String[] args) {
        long n = 16643264321L;
//        System.out.println(Integer.MAX_VALUE);
        // 1889823210
        // 1889830122
        // 16643264321
        // 16643612234
        long res = get(1234567);
        System.out.println(res);
    }

    private static long get(long n) {
        String s = String.valueOf(n);
        int[] arr = new int[s.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.charAt(i) - '0';
        }

        int rightThanLeftIndex = -1;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] - arr[i - 1] > 0) {
                int temp = arr[i - 1];
                arr[i - 1] = arr[i];
                arr[i] = temp;
                rightThanLeftIndex = i;
                break;
            }
        }
        if (rightThanLeftIndex == -1) {
            return n;
        }

        if (rightThanLeftIndex == arr.length - 1) {
            return arr2Long(arr);
        }
        int end = arr.length - 1;

        sort(arr, rightThanLeftIndex, end);
        return arr2Long(arr);
    }

    private static void sort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int curr = arr[i];
            int j = i - 1;
            for (; j >= left && arr[j] > curr; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j] = curr;
        }
    }

    private static long arr2Long(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return Long.parseLong(sb.toString());
    }


}