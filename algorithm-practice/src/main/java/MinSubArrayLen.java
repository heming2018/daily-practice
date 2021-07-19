import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming1
 * @date 2021/6/5 12:02 上午
 * @description 力扣（LeetCode）209. 长度最小的子数组
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class MinSubArrayLen {
    private static final Logger logger = LoggerFactory.getLogger(MinSubArrayLen.class);

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(15, new int[]{1,2,3,4,5}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        if (nums[0] >= target) {
            return 1;
        }

        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (; right < nums.length; right++) {
            sum += nums[right];
            if (sum >= target) {
                for (; left <= right && sum - nums[left] >= target; left++) {
                    sum -= nums[left];
                }
                res = Math.min(res, right - left + 1);
            }
        }

        if (sum < target) {
            return 0;
        }

        return res;
    }

}