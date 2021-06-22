import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming1
 * @date 2021/6/18 2:21 上午
 * @description TODO
 */
public class MySort {
    private static final Logger logger = LoggerFactory.getLogger(MySort.class);

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1, 4};
        MySort(arr);
    }

    /**
     * 21345
     *
     * @param arr
     * @return
     */
    public static int[] MySort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
        return arr;
    }
}