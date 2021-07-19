import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * @author heming1
 * @date 2021/7/19 1:35 上午
 * @description NC41 最长无重复子数组
 * https://www.nowcoder.com/practice/b56799ebfd684fb394bd315e89324fb4?tpId=188&tags=&title=&difficulty=0&judgeStatus=0&rp=1
 * 给定一个数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
 * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
 */
public class NC41_maxLength {
    /**
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength (int[] arr) {
        // write code here
        if (arr == null) {
            return 0;
        }
        if (arr.length <= 1) {
            return arr.length;
        }

        Set<Integer> set = new HashSet<>();
        int l = 0, r = 0, res = 1;
        while (l <= r && r < arr.length) {
            while (set.contains(arr[r])) {
                set.remove(arr[l]);
                l++;
            }
            set.add(arr[r]);
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}