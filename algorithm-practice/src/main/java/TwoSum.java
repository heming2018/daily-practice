import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * @author heming1
 * @date 2021/7/6 11:48 下午
 * @description TODO
 */
public class TwoSum {
    private static final Logger logger = LoggerFactory.getLogger(TwoSum.class);

    public int[] twoSum(int[] nums, int target) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get((target - nums[i])), i};
            }
            map.put(nums[i], i);
        }
        return null;

    }
}