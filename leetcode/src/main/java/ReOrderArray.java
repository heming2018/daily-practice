/**
 * @author heming
 * @date 2019/11/13 15:52
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    /**
     * 1,2,6,4,5,6,7
     * 0 0
     */
    public static void main(String[] args) {
        reOrderArray1(new int[]{1, 2, 6, 4, 5, 6, 7});
    }

    /**
     * 每次发现偶数，就将其移到数组的最后一位
     *
     * @param array
     */
    public static void reOrderArray(int[] array) {
        int count = 0;
        int index = 0;
        while (count < array.length) {
            count++;

            if (array[index] % 2 == 0) {
                int curr = array[index];
                for (int j = index; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = curr;

            } else {
                index++;
            }
        }
        System.out.println(array);
    }

    /**
     * 从左往右数，将两个奇数之间的连续偶数与第二个奇数交换位置˚
     */
    public static void reOrderArray1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] % 2 == 0) {
                int j = i;
                // 判断后一位还是不是偶数
                while (array[j + 1] % 2 == 0) {
                    j++;
                    // 如果最后一位都是偶数了，则退出循环
                    if (j == array.length - 1) {
                        return;
                    }
                }

                int temp = array[j + 1];
                for (int k = j + 1; k > i; k--) {
                    array[k] = array[k - 1];
                }
                array[i] = temp;
            }
        }
    }
}