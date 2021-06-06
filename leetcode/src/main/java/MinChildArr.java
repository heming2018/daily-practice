import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming1
 * @date 2021/6/5 12:02 上午
 * @description TODO
 */
public class MinChildArr {
    private static final Logger logger = LoggerFactory.getLogger(MinChildArr.class);

    public static void main(String[] args) {
        System.out.println(getMinChildArrNum(new int[]{3,2,1}, 4));
    }

    public static int getMinChildArrNum(int[] arr, int n) {
        int size = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= arr.length - size; j++) {
                int sum = 0;
                for (int k = j; k < j + size; k++) {
                    sum = arr[k] + sum;
                }
                if (sum >= n) {
                    return size;
                }
            }
            size++;
        }
        return 0;
    }

}