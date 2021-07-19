import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heming1
 * @date 2021/6/18 5:02 下午
 * @description
 * 给定一个数组，找出其中最小的K个数。
 * 例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。如果K>数组的长度，那么返回一个空的数组
 */
public class GetLeastNumbers {
    private static final Logger logger = LoggerFactory.getLogger(GetLeastNumbers.class);

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (k > input.length) {
            return new ArrayList<>();
        }

        input  = sort(input);

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }

        return list;
    }

    private int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int j = i - 1;
            while (j >= 0 && curr < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j+1] = curr;
        }
        return arr;
    }
}