/**
 * @author heming1
 * @date 2021/7/16 3:25 下午
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * <p>
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4 2
 * 解释: 9 出现在 nums 中并且下标为 4
 */
public class Search {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int index = left + (right - left) / 2;
            if (nums[index] == target) {
                return index;
            } else if (nums[index] < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(5 / 2);
    }

}
